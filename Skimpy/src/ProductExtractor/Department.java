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

class Department
{
	public String name;
	public String departmentURL;

	public Department(String name, String url)
	{
		this.name = name;
		this.departmentURL = url;
	}

	public String toString()
	{
		return this.name + ": " + this.departmentURL;
	}

	public List<String> getCategoryURLs(Document doc)
	{
		List<String> allCategories = new ArrayList<String>();

		Elements categories = doc.select("#superDeptItems .column ul.first li");
		for (Element category : categories)
		{
			String a = category.select("a").attr("href");
			allCategories.add(a);
		}
		return allCategories;		
	}
}