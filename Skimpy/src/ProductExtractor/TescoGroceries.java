import java.lang.Thread;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.select.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class TescoGroceries
{
	public static void main(String[] args)
	{
		TescoGroceries tesco = new TescoGroceries();

		String rootURL = "http://www.tesco.com/groceries";
		Document doc = tesco.getHTML(rootURL);

		List<Department> departments = tesco.listDepartments(doc).subList(0,4);
		for (Department d : departments)
		{
			Document depHTML = tesco.getHTML(d.departmentURL);
			List<String> categories = d.getCategoryURLs(depHTML);
			for (String cat : categories)
			{
				Document departmentRootPage = tesco.getHTML(cat);
				DepartmentSpider ds = new DepartmentSpider(cat);
				List <Product> products = ds.extractProducts(departmentRootPage);
				System.out.println("Got " + products.size() + " products");

				Product test = products.get(2);
				System.out.println("Product test\n" + test.name + "\n" + test.url + "\n");
			}
		}
	}

	public Document getHTML(String url)
	{
		URL obj;
		HttpURLConnection conn;
		int responseCode;
		BufferedReader inBuff;
		String inputLine;
		StringBuffer response;

		try
		{
			obj = new URL(url);
			conn = (HttpURLConnection)obj.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			responseCode = conn.getResponseCode();

			System.out.println("GET: " + url);
			System.out.println("Response code: " + responseCode);

			inBuff = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	
			response = new StringBuffer();

			while ((inputLine = inBuff.readLine()) != null)
			{
				response.append(inputLine);
			}
			inBuff.close();
		}
		catch (MalformedURLException mal)
		{
			return null;
		}
		catch (IOException ioe)
		{
			return null;
		}


		Document html = Jsoup.parse(response.toString());
		return html;
	}

	private List<Department> listDepartments(Document doc)
	{
		List<Department> allDepartments = new ArrayList<Department>();

		Elements departments = doc.select("#secondaryNav ul li");
		for (Element department : departments)
		{
			String name = department.select("a").text();
			String a = department.select("a").attr("href");
			Department dep = new Department(name, a);
			allDepartments.add(dep);
		}
		return allDepartments;
	}
}