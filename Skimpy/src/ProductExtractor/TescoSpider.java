package ProductExtractor;

import java.util.List;
import java.util.ArrayList;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

public class TescoSpider extends WebSpider
{
	public TescoSpider() {
		this.rootPageURL = "http://www.tesco.com/groceries";
	}
	
	public List<Department> listDepartments() {
		List<Department> allDepartments = new ArrayList<Department>();
		
		Elements departmentsNodes = this.getHTML(this.rootPageURL).select("#secondaryNav ul li");
		for (Element d : departmentsNodes) {
			String name = d.select("a").text();
			String link = d.select("a").attr("href");
			Department dep = new Department(name, link);
			allDepartments.add(dep);
		}
		return allDepartments;
	}

	public List<Category> listCategories(String departmentURL) {
		List<Category> allCategories = new ArrayList<Category>();

		Elements categoriesNodes = this.getHTML(departmentURL).select("#superDeptItems div.column ul li");

		for (Element c : categoriesNodes) {
			String name = c.select("a").text();
			String link = c.select("a").attr("href");
			Category cat = new Category(name, link);
			allCategories.add(cat);
		}
		return allCategories;
	}
	
	public List<Shelf> listShelves(String categoryGridURL) {
		List<Shelf> allShelves = new ArrayList<Shelf>();
		
		Elements shelvesNodes = this.getHTML(categoryGridURL).select("#filterWidgetGrid ul.tertNav li");
		
		for (Element sh : shelvesNodes) {
			String name = sh.select("a").text();
			String link = sh.select("a").attr("href");
			Shelf shelf = new Shelf(link, name);
			allShelves.add(shelf);
			
			String nextPageURL = this.getHTML(link).select("div#multipleAdd div.pagination ul.clearfix li.nextWrap p.next").select("a").attr("href");
			while (!nextPageURL.equals("")) {
				allShelves.add(new Shelf(nextPageURL, name));
				nextPageURL = this.getHTML(nextPageURL).select("div#multipleAdd div.pagination ul.clearfix li.nextWrap p.next").select("a").attr("href");
			}
		}
		return allShelves;
	}
}
