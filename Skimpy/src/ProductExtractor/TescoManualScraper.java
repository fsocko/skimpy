package ProductExtractor;

import java.util.List;

import org.jsoup.nodes.Document;

public class TescoManualScraper {

	public static void main(String[] args) {
		TescoSpider tesco = new TescoSpider();
		
		Document tescoRootPage = tesco.getHTML(tesco.rootPageURL);
		System.out.println(tesco.getDocumentTitle(tescoRootPage) + System.lineSeparator());
		
		/*
		 * The department to be scraped can be specified here.
		 */
		Department chosenDept = tesco.listDepartments().get(0);
		List<Category> categories = tesco.listCategories(chosenDept.url);
		for (Category c : categories) {
			List<Shelf> shelves = tesco.listShelves(c.url);
			for (Shelf s : shelves) {
				TescoProductExtractor tpex = new TescoProductExtractor(s.url, c.name, s.name);
				tpex.extract(s.url);
			}
		}
	}

}
