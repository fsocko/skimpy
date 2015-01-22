import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.select.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class DepartmentSpider
{
	public String departmentURL;

	public DepartmentSpider(String rootURL)
	{
		this.departmentURL = rootURL;
	}

	public List<Document> getAllDepartmentWebsites()
	{
		return null;
	}

	public List<Product> extractProducts(Document website)
	{
		List<Product> allProducts = new ArrayList<Product>();

		Elements productsOnPage = website.select("ul.products.grid li");
		for (Element product : productsOnPage)
		{
			String productName = product.select("h2").text();
			String productURL = product.select("a").attr("href");
			Product p = new Product(productName, productURL);
			allProducts.add(p);
		}

		return allProducts;
	}

}