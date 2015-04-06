//@author Lee

package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * A class to get the products from an individual category
 */
public class GetProducts implements Runnable {
	
	private String url;
	private ThreadControl tc;
	private String categoryname;
	
	public GetProducts(String url, ThreadControl tc, String categoryname) {
		this.url = url;
		this.tc = tc;
		this.categoryname = categoryname;
	}

	@Override
	public void run() {
		try {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		HtmlPage page = webClient.getPage(url);
		int pageNo = 1;
		boolean nextPage = true;
		while (nextPage) {
			HtmlElement gridProducts = page.getBody().getOneHtmlElementByAttribute("ul", "class", "productLister gridView");
			Iterator<DomElement> itr = gridProducts.getChildElements().iterator();
		    while (itr.hasNext()) {
			    String[] cat = url.split("/");
		    	if (SainsburysScraper.getNutrition) {
				    HtmlElement temp = (HtmlElement)itr.next();
				    String prodUrl = temp.getOneHtmlElementByAttribute("div", "class", "productNameAndPromotions").getFirstElementChild().getFirstElementChild().getAttribute("href");
					Thread t = new Thread(new ReadProductPage(prodUrl, tc, cat[cat.length - 1], categoryname));
					tc.addThread(t);
		    	} else {
				    HtmlElement temp = (HtmlElement)itr.next();
				    //HtmlElement productData = temp.getOneHtmlElementByAttribute("li", "class", "gridItem");
				    String productString = "";
				    String prodUrl = temp.getOneHtmlElementByAttribute("div", "class", "productNameAndPromotions").getFirstElementChild().getFirstElementChild().getAttribute("href");
				    productString += prodUrl;
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
				    productString += ";" + cat[cat.length - 1];
				    productString = productString.replace("\n", "").replace("\r", "") + ";";
				    SainsburysScraper.products.add(productString);
		    	}
		    }
		    try {
		    	HtmlElement next = (HtmlElement)page.getBody().getOneHtmlElementByAttribute("li", "class", "next").getFirstElementChild();
		    	String newUrl = next.getAttribute("href");
		    	System.out.println(Thread.currentThread().getName() + ":> " + url + " page " + pageNo);
		    	pageNo++;
		    	page = webClient.getPage(newUrl);
		    } catch (Exception e) {
		    	e.getMessage();
		    	nextPage = false;
		    }
		}
		webClient.closeAllWindows();
		} catch (Exception e) {
			
		}
	    
	}

}
