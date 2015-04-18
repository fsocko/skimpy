package ProductExtractor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;

public class AsdaScraper {
	
	public static ArrayList<String> products;
	private static final String[] urls = {"http://groceries.asda.com/asda-webstore/landing/home.shtml#/cat/1215135760597",
			"http://groceries.asda.com/asda-webstore/landing/home.shtml#/cat/1215337189632",
			"http://groceries.asda.com/asda-webstore/landing/home.shtml#/cat/1215338621416",
			"http://groceries.asda.com/asda-webstore/landing/home.shtml#/cat/1215135760614"};
	public static final String rootUrl = "http://groceries.asda.com/asda-webstore/landing/home.shtml";
	
	public static void runScraper(int maxthreads) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		java.util.logging.Logger.getLogger("org.apache").setLevel(Level.OFF);
		ThreadControl tc = new ThreadControl(maxthreads);
		try {
			products = new ArrayList<String>();
			for (String s: urls) {
				Thread t = new Thread(new AsdaDepartment(s, tc));
				//Thread t = new Thread(new AsdaAisle("http://groceries.asda.com/asda-webstore/landing/home.shtml#/dept/1215338747245", tc));
				tc.addThread(t);
			}
			tc.run();
			System.out.println("\nDone");
			java.util.Collections.sort(products);
		    int i = 0;
		    PrintWriter writer = new PrintWriter("data/asda.txt");
		    for (String s: products) {
		    	System.out.println(i + ":> " + s);
		    	writer.println(s);
		    	i++;
		    }
		    writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		if (args.length < 1) {
			System.out.println("The format required is <maxthreads>");
			return;
		}
		try {
			int max = Integer.parseInt(args[0]);
			if (max <= 0) {
				System.out.println("Positive Integer required");
				return;
			}
			runScraper(max);
		} catch (Exception e) {
			System.out.println("Positive Integer required");
			return;
		}
	}

}
