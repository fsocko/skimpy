package ProductExtractor;

import java.util.ArrayList;
import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AsdaProductPage implements Runnable {
	
	private String url;
	private ThreadControl tc;
	private String cat;
	private String highercat;
	
	public AsdaProductPage(String url, ThreadControl tc, String cat, String highercat) {
		this.url = url;
		this.tc = tc;
		this.cat = cat;
		this.highercat = highercat;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			final HtmlPage page = webClient.getPage(url);
//			int retries = 50;
//			boolean loaded = false;
//			while (retries > 0 && !loaded) {
//				if (page.asXml().contains("<div id=\"itemDetails\">")) {
//					loaded = true;
//					System.out.println("Loaded");
//					System.out.println(retries);
//				}
//				webClient.waitForBackgroundJavaScript(1000);
//				retries--;
//			}
			webClient.waitForBackgroundJavaScript(50000);
			HtmlElement productSummary = page.getBody().getOneHtmlElementByAttribute("div", "id", "itemDetails");
			String productString = "";
		    productString += url;
		    try {
		    	String name = productSummary.getOneHtmlElementByAttribute("h1", "class", "prod-title").getTextContent();
		    	String weight = "";
		    	try {
		    		weight = productSummary.getOneHtmlElementByAttribute("span", "class", "weight").getTextContent();
		    	} catch (Exception e) {
		    		weight = "";
		    	}
		    	productString += ";" + name + " " + weight;
		    } catch (Exception e) {
		    	productString += ";null";
		    }
		    try {
			    productString += ";" + productSummary.getOneHtmlElementByAttribute("span", "class", "prod-price-inner").getTextContent();
		    } catch (Exception e) {
			  	productString += ";null";
			}
			try {
				productString += ";" + productSummary.getOneHtmlElementByAttribute("span", "class", "prod-quantity").asText().replace("per", "/");
			} catch (Exception e) {
			 	productString += ";null";
			}
			productString += ";" + highercat + ";" + cat;
			productString = productString.replace("\n", "").replace("\r", "");
			try {
		    Iterator<DomElement> nutritionTable = page.getBody().getOneHtmlElementByAttribute("table", "summary", "Nutritional Value").getChildElements().iterator();
		    ArrayList<HtmlElement> table = new ArrayList<HtmlElement>();
		    while (nutritionTable.hasNext()) {
		    	table.add((HtmlElement)nutritionTable.next());
		    }
		    ArrayList<ArrayList<String>> nutritionData = new ArrayList<ArrayList<String>>();
		    Iterator<HtmlElement> tableHead = table.get(0).getFirstElementChild().getHtmlElementDescendants().iterator();
		    ArrayList<String> headData = new ArrayList<String>();
		    while (tableHead.hasNext()) {
		    	headData.add(tableHead.next().getTextContent());
		    }
		    nutritionData.add(headData);
		    Iterator<DomElement> tableBody = table.get(1).getChildElements().iterator();
		    while (tableBody.hasNext()) {
		    	Iterator<DomElement> rowInfo = tableBody.next().getChildElements().iterator();
		    	ArrayList<String> rowData = new ArrayList<String>();
		    	while (rowInfo.hasNext()) {
		    		rowData.add(rowInfo.next().getTextContent());
		    	}
		    	if (rowData.size() < nutritionData.get(nutritionData.size() - 1).size() && !(rowData.get(0).toLowerCase().contains("reference"))) {
		    		rowData.add(0, nutritionData.get(nutritionData.size() - 1).get(0));
		    	}
		    	if (rowData.get(0).equals("")) {
		    		rowData.set(0, nutritionData.get(nutritionData.size() - 1).get(0));
		    	}
		    	if (!(rowData.get(0).toLowerCase().contains("reference"))) {
		    		nutritionData.add(rowData);
		    	}
		    }
		    int column = -1;
		    for (int i = 0; i < nutritionData.get(0).size(); i++) {
		    	if (nutritionData.get(0).get(i).toLowerCase().contains("100g") || nutritionData.get(0).get(i).toLowerCase().contains("100 g") || nutritionData.get(0).get(i).toLowerCase().contains("100ml") || nutritionData.get(0).get(i).toLowerCase().contains("100 ml")) {
		    		column = i;
		    	}
		    }
		    if (column == -1) {
		    	productString += ";null;null;null;null;null;null;null;null";
		    } else {
		    	boolean calories = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!calories && nutritionData.get(j).get(0).toLowerCase().contains("kcal")) {
		    			String energydata = nutritionData.get(j).get(0).toLowerCase();
		    			if (energydata.contains("/") && nutritionData.get(j).get(column).contains("/")) {
		    				String[] info = energydata.split("/");
		    				String[] data = nutritionData.get(j).get(column).split("/");
		    				for (int i = 0; i < info.length; i++) {
	    						if (info[i].contains("kcal")) {
			    					String number = data[i].replaceAll("[^0-9.]", "");
			    					if (number.equals("")) number = "0";
			    					productString += ";" + number;
			    					calories = true;
	    						}
	    					}
		    			}
		    			else {
			    			String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
	    					if (number.equals("")) number = "0";
	    					productString += ";" + number;
	    					calories = true;
		    			}
		    		}
		    		else if (!calories && nutritionData.get(j).get(0).toLowerCase().contains("energy")) {
		    			if (nutritionData.get(j).get(column).contains("kcal")) {
		    				String energydata = nutritionData.get(j).get(column);
		    				String[] temp;
		    				if (energydata.contains("(")) {
		    					temp = energydata.split("\\(");
		    				} else if (energydata.contains("/")) {
		    					temp = energydata.split("/"); 
		    				} else {
		    					temp = energydata.split(",");
		    				}
		    				if (temp.length == 1) {
		    					String number = temp[0].replaceAll("[^0-9.]", "");
		    					if (number.equals("")) number = "0";
		    					productString += ";" + number;
		    					calories = true;
		    				} else {
		    					for (String s: temp) {
		    						if (s.contains("kcal")) {
				    					String number = s.replaceAll("[^0-9.]", "");
				    					if (number.equals("")) number = "0";
				    					productString += ";" + number;
				    					calories = true;
		    						}
		    					}
		    				}
		    			}
		    		}
		    	}
		    	if (!calories) {
		    		productString += ";null";
		    	}
		    	
		    	boolean protein = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!protein && nutritionData.get(j).get(0).toLowerCase().contains("protein")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					protein = true;
		    		}
		    	}
		    	if (!protein) {
		    		productString += ";null";
		    	}
		    	
		    	boolean carbs = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!carbs && nutritionData.get(j).get(0).toLowerCase().contains("carbohydrate")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					carbs = true;
		    		}
		    	}
		    	if (!carbs) {
		    		productString += ";null";
		    	}
		    	
		    	boolean sugar = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!sugar && nutritionData.get(j).get(0).toLowerCase().contains("sugar")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					sugar = true;
		    		}
		    	}
		    	if (!sugar) {
		    		productString += ";null";
		    	}
		    	
		    	boolean fat = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!fat && nutritionData.get(j).get(0).toLowerCase().contains("fat")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					fat = true;
		    		}
		    	}
		    	if (!fat) {
		    		productString += ";null";
		    	}
		    	
		    	boolean saturate = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!saturate && nutritionData.get(j).get(0).toLowerCase().contains("saturate")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					saturate = true;
		    		}
		    	}
		    	if (!saturate) {
		    		productString += ";null";
		    	}
		    	
		    	boolean fibre = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!fibre && nutritionData.get(j).get(0).toLowerCase().contains("fibre")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					fibre = true;
		    		}
		    	}
		    	if (!fibre) {
		    		productString += ";null";
		    	}
		    	
		    	boolean salt = false;
		    	for (int j = 0; j < nutritionData.size(); j++) {
		    		if (!salt && nutritionData.get(j).get(0).toLowerCase().contains("salt")) {
    					String number = nutritionData.get(j).get(column).replaceAll("[^0-9.]", "");
    					if (number.equals("")) number = "0";
    					productString += ";" + number;
    					salt = true;
		    		}
		    	}
		    	if (!salt) {
		    		productString += ";null";
		    	}
		    }
			} catch (Exception e) {
				productString += ";null;null;null;null;null;null;null;null";
			}
//		    for (ArrayList<String> row: nutritionData) {
//		    	for (String col: row) {
//		    		System.out.print(col + "\t");
//		    	}
//		    	System.out.println();
//		    }
		    productString += ";";
		    AsdaScraper.products.add(productString);
		    webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
