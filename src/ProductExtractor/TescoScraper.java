package ProductExtractor;

import java.util.List;

import org.jsoup.nodes.Document;

public class TescoScraper {

	public static void main(String[] args) {
		TescoSpider tesco = new TescoSpider();
		
		Document tescoRootPage = tesco.getHTML(tesco.rootPageURL);
		System.out.println(tesco.getDocumentTitle(tescoRootPage) + System.lineSeparator());
		
		List<Department> tescoDepartments = tesco.listDepartments().subList(0, 3);
		for (Department t : tescoDepartments) {
			List<Category> categories = tesco.listCategories(t.url);
			for (Category c : categories) {
				List<Shelf> shelves = tesco.listShelves(c.url);
				for (Shelf s : shelves) {
					TescoProductExtractor tpex = new TescoProductExtractor(s.url, s.name);
					tpex.extract(s.url);
				}
			}
		}
	}
}