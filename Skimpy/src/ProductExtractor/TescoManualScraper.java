package ProductExtractor;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Document;

public class TescoManualScraper {

	public static void main(String[] args) {
		TescoSpider tesco = new TescoSpider();
		
		Document tescoRootPage = tesco.getHTML(tesco.rootPageURL);
		System.out.println(tesco.getDocumentTitle(tescoRootPage) + System.lineSeparator());
		
		Department chosenDept = tesco.listDepartments().get(0);
		// int total = tesco.listCategories(chosenDept.url).size();
		List<Category> categories = tesco.listCategories(chosenDept.url); //.subList(7, total);
		for (Category c : categories) {
			List<Shelf> shelves = tesco.listShelves(c.url);
			for (Shelf s : shelves) {
				TescoProductExtractor tpex = new TescoProductExtractor(s.url, c.name, s.name);
				try {
					tpex.extract(s.url);
				} catch (IOException ioe) {
					try {
						// If it blocks, wait for ten seconds, then try again.
						System.out.println("An error occurred. Possibly 403.");
						Thread.sleep(10000);
						tpex.extract(s.url);
					} catch(InterruptedException i) {
						i.printStackTrace();
					}
					catch (IOException ioex) {
						ioex.printStackTrace();
					}
				}
			}
		}
	}

}
