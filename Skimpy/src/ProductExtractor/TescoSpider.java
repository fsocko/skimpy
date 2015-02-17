package ProductExtractor;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
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
		
		for (Element sh: shelvesNodes) {
			String name = sh.select("a").text();
			String link = sh.select("a").attr("href");
			Shelf shelf = new Shelf(link, name);
			allShelves.add(shelf);
		}
		return allShelves;
	}
	
	public List<Product> listProducts(String productsGridURL, String categoryName) {
		List<Product> allProducts = new ArrayList<Product>();
		List<String> productURLs = new ArrayList<String>();
		
		Elements productsNodes = this.getHTML(productsGridURL).select("div.productLists ul li");
		for (Element p : productsNodes) {
			
			String url = p.select("a").attr("href");
			Pattern r = Pattern.compile("^/groceries");
			Matcher m = r.matcher(url);
			if (m.find()) {
				productURLs.add("http://www.tesco.com" + p.select("a").attr("href"));
			}
		}
		
		for (String productURL : productURLs) {
			Document productPage = this.getHTML(productURL);
			String productName = productPage.select("h1").text();
			String price;
			String pricePerUnit;
			
			Pattern pattern = Pattern.compile("id=(\\d+)");
			Matcher matcher = pattern.matcher(productURL);
			matcher.find();
			String foundId = matcher.group().substring(3);
			
			try {
				price = productPage.select("span.linePrice").first().text();
			}
			catch (NullPointerException npe) {
				price = productPage.select("span.linePrice").text();
			}
			
			try {
				pricePerUnit = productPage.select("span.linePriceAbbr").first().text();
			}
			catch (NullPointerException npe) {
				pricePerUnit = productPage.select("span.linePriceAbbr").text();
			}
			
			Product prod = new Product(foundId, productName, productURL, price, pricePerUnit, categoryName);
			allProducts.add(prod);
		}
		
		return allProducts;
	}
}
