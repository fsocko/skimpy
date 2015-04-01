//@author Lee

package ProductExtractor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * Main class for the Sainsbury's Scraper, only the main method is used.
 */
public class SainsburysScraper {
	
	final static String[] urls = {"http://www.sainsburys.co.uk/shop/gb/groceries/fruit-veg",
		"http://www.sainsburys.co.uk/shop/gb/groceries/meat-fish",
		"http://www.sainsburys.co.uk/shop/gb/groceries/dairy-eggs-chilled",
		"http://www.sainsburys.co.uk/shop/gb/groceries/bakery",
		"http://www.sainsburys.co.uk/shop/gb/groceries/frozen",
		"http://www.sainsburys.co.uk/shop/gb/groceries/food-cupboard",
		"http://www.sainsburys.co.uk/shop/gb/groceries/drinks"
	};
	public static ArrayList<String> products;
	public static boolean getNutrition = false;
	
	public static void getCategories(WebClient webClient, String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		System.out.println(url);
		HtmlPage page = webClient.getPage(url);
		HtmlElement categories = page.getBody().getOneHtmlElementByAttribute("ul", "class", "categories departments");
		Iterator<DomElement> itr = categories.getChildElements().iterator();
		while (itr.hasNext()) {
			HtmlElement temp = (HtmlElement)itr.next();
			String newurl = temp.getFirstElementChild().getAttribute("href");
			getSecondCategories(webClient, newurl);
		}
	}
	
	public static void getSecondCategories(WebClient webClient, String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		System.out.println(url);
		HtmlPage page = webClient.getPage(url);
		try {
			HtmlElement aisles = page.getBody().getOneHtmlElementByAttribute("ul", "class", "categories aisles");
			Iterator<DomElement> itr = aisles.getChildElements().iterator();
			while (itr.hasNext()) {
				HtmlElement temp = (HtmlElement)itr.next();
				if (!temp.asText().contains("All")) {
					String newurl = temp.getFirstElementChild().getAttribute("href");
					getProducts(webClient, newurl);
				}
			}
		} catch (Exception e) {
			getProducts(webClient, url);
		}
	}
	
	public static void getProducts(WebClient webClient, String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException	{
		HtmlPage page = webClient.getPage(url);
		int pageNo = 1;
		boolean nextPage = true;
		try {
		while (nextPage) {
			HtmlElement gridProducts = page.getBody().getOneHtmlElementByAttribute("ul", "class", "productLister gridView");
			Iterator<DomElement> itr = gridProducts.getChildElements().iterator();
		    while (itr.hasNext()) {
		    	HtmlElement temp = (HtmlElement)itr.next();
		    	//HtmlElement productData = temp.getOneHtmlElementByAttribute("li", "class", "gridItem");
		    	String productString = "";
		    	String[] urls = temp.getOneHtmlElementByAttribute("div", "class", "productNameAndPromotions").getFirstElementChild().getFirstElementChild().getAttribute("href").split("/");
		    	productString += urls[urls.length - 1];
		    	try {
		    	String name = temp.getOneHtmlElementByAttribute("div", "class", "productNameAndPromotions").getFirstElementChild().getFirstElementChild().asText();
		    	productString += ";" + name;
		    	} catch (Exception e) {
		    		productString += ";Name not found";
		    	}
		    	try {
		    	productString += ";" + temp.getOneHtmlElementByAttribute("p", "class", "pricePerUnit").getTextContent();
		    	} catch (Exception e) {
		    		productString += ";Price per unit not found";
		    	}
		    	try {
		    	productString += ";" + temp.getOneHtmlElementByAttribute("p", "class", "pricePerMeasure").asText();
		    	} catch (Exception e) {
		    		productString += ";Price per measure not found";
		    	}
		    	String[] cat = url.split("/");
		    	productString += ";" + cat[cat.length - 1];
		    	productString = productString.replace("\n", "").replace("\r", "");
		    	products.add(productString);
		    }
		    try {
		    	HtmlElement next = (HtmlElement)page.getBody().getOneHtmlElementByAttribute("lin", "class", "next").getFirstElementChild();
		    	String newUrl = next.getAttribute("href");
		    	System.out.println(Thread.currentThread().getName() + ":> " + url + " page " + pageNo);
		    	pageNo++;
		    	page = webClient.getPage(newUrl);
		    } catch (Exception e) {
		    	e.getMessage();
		    	nextPage = false;
		    }
		}
		} catch (Exception e) {
			
		}
	    
	}

	public static String readProductPage(WebClient webClient, String url) {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			final HtmlPage page = webClient.getPage(url);
		    Iterator<DomElement> nutritionTable = page.getBody().getOneHtmlElementByAttribute("table", "class", "nutritionTable").getChildElements().iterator();
		    String nutritionInfo = "{";
		    ArrayList<HtmlElement> table = new ArrayList<HtmlElement>();
		    while (nutritionTable.hasNext()) {
		    	table.add((HtmlElement)nutritionTable.next());
		    }
		    Iterator<HtmlElement> tableHead = table.get(0).getFirstElementChild().getHtmlElementDescendants().iterator();
		    while (tableHead.hasNext()) {
		    	nutritionInfo += tableHead.next().getTextContent() + ",";
		    }
	    	nutritionInfo = nutritionInfo.substring(0, nutritionInfo.length() - 1);
		    nutritionInfo += "\n";
		    Iterator<DomElement> tableBody = table.get(1).getChildElements().iterator();
		    while (tableBody.hasNext()) {
		    	Iterator<DomElement> rowInfo = tableBody.next().getChildElements().iterator();
		    	while (rowInfo.hasNext()) {
		    		nutritionInfo += rowInfo.next().getTextContent() + ",";
		    	}
		    	nutritionInfo = nutritionInfo.substring(0, nutritionInfo.length() - 1);
		    	nutritionInfo += "\n";
		    }
		    nutritionInfo += "}";
		    return nutritionInfo;
		} catch (Exception e) {
			
		}
		return "";
	}
	
	public static void runScraper(int maxthreads, boolean getnutrition) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		java.util.logging.Logger.getLogger("org.apache").setLevel(Level.OFF);
		ThreadControl tc = new ThreadControl(maxthreads);
		try {
			final WebClient webClient = new WebClient(BrowserVersion.CHROME);
			products = new ArrayList<String>();
			for (String s: urls) {
				Thread t = new Thread(new GetCategories(s, tc));
				tc.addThread(t);
			}
			getNutrition = getnutrition;
			tc.run();
			webClient.closeAllWindows();
			System.out.println("\nDone");
			java.util.Collections.sort(products);
		    int i = 0;
		    PrintWriter writer = new PrintWriter("data/sainsburys.txt");
		    for (String s: products) {
		    	System.out.println(i + ":> " + s);
		    	writer.println(s);
		    	i++;
		    }
		    writer.close();
		} catch (FailingHttpStatusCodeException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		} catch (IOException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		if (args.length < 2) {
			System.out.println("The format required is <maxthreads> <getnutrition>");
			return;
		}
		
		int maxthreads;
		boolean getnutrition;
		try {
			maxthreads = Integer.parseInt(args[0]);
			getnutrition = Boolean.parseBoolean(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		runScraper(maxthreads, getnutrition);
	}
	
	public static void mainold(String args[]) {
		int maxthreads = 15;
		boolean getnutrition = true;
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		java.util.logging.Logger.getLogger("org.apache").setLevel(Level.OFF);
		ThreadControl tc = new ThreadControl(maxthreads);
		try {
			final WebClient webClient = new WebClient(BrowserVersion.CHROME);
			products = new ArrayList<String>();
			for (String s: urls) {
				Thread t = new Thread(new GetCategories(s, tc));
				tc.addThread(t);
			}
			//Thread t = new Thread(new GetProducts("http://www.sainsburys.co.uk/shop/gb/groceries/meat-fish/sausages", tc));
			//Thread t = new Thread(new ReadProductPage("http://www.sainsburys.co.uk/shop/gb/groceries/lucozade-energy-orange-500ml", tc, "test"));
			//tc.addThread(t);
			getNutrition = getnutrition;
			tc.run();
			webClient.closeAllWindows();
			System.out.println("\nDone");
			java.util.Collections.sort(products);
		    int i = 0;
		    PrintWriter writer = new PrintWriter("data/sainsburys.txt");
		    for (String s: products) {
		    	System.out.println(i + ":> " + s);
		    	writer.println(s);
		    	i++;
		    }
		    writer.close();
		} catch (FailingHttpStatusCodeException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		} catch (IOException f) {
			// TODO Auto-generated catch block
			f.printStackTrace();
		}
	}
}
