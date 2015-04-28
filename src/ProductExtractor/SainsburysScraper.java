//@author Lee

package ProductExtractor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;

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
	
	public static void runScraper(int maxthreads, boolean getnutrition) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		java.util.logging.Logger.getLogger("org.apache").setLevel(Level.OFF);
		ThreadControl tc = new ThreadControl(maxthreads);
		try {
			products = new ArrayList<String>();
			for (String s: urls) {
				Thread t = new Thread(new GetCategories(s, tc));
				tc.addThread(t);
			}
			getNutrition = getnutrition;
			tc.run();
			System.out.println("\nDone");
			java.util.Collections.sort(products);
		    int i = 0;
		    PrintWriter writer = new PrintWriter("data/sains.txt");
		    for (String s: products) {
		    	System.out.println(i + ":> " + s);
		    	writer.println(s);
		    	i++;
		    }
		    writer.close();
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
}
