package ProductExtractor;

import java.lang.Thread;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

public class TescoProductExtractor implements Runnable {
	public static List<Product> allProducts;
	public String productPageURL;
	public String categoryName;

	TescoProductExtractor(String productPageURL, String categoryName) {
		this.productPageURL = productPageURL;
		this.categoryName = categoryName;
	}

	public void extract(String gridPageURL) {
		List<Thread> runningThreads = new ArrayList<Thread>();
		List<String> productURLs = new ArrayList<String>();
		allProducts = new ArrayList<Product>();
		
		Elements productsNodes = getHTML(gridPageURL).select("div.productLists ul li");
		for (Element p : productsNodes) {
			
			String url = p.select("a").attr("href");
			Pattern r = Pattern.compile("^/groceries");
			Matcher m = r.matcher(url);
			if (m.find()) {
				productURLs.add("http://www.tesco.com" + p.select("a").attr("href"));
			}
		}

		for (String productURL : productURLs) {
			Thread t = new Thread(new TescoProductExtractor(productURL, this.categoryName));
			runningThreads.add(t);
			t.start();
		}
		
		for (Thread t : runningThreads) {
			try {
				t.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public void run() {
		Document productPage = getHTML(this.productPageURL);
		String productName = productPage.select("h1").text();
		String price;
		String pricePerUnit;
		String[] nutriValues = new String[8];
		
		Pattern pattern = Pattern.compile("id=(\\d+)");
		Matcher matcher = pattern.matcher(productPageURL);
		matcher.find();
		String foundId = matcher.group().substring(3);
		
		try {
			price = productPage.select("span.linePrice").first().text().trim();
		}
		catch (NullPointerException npe) {
			price = productPage.select("span.linePrice").text().trim();
		}
		
		try {
			pricePerUnit = productPage.select("span.linePriceAbbr").first().text().trim();
		}
		catch (NullPointerException npe) {
			pricePerUnit = productPage.select("span.linePriceAbbr").text().trim();
		}
		
		Elements nutriTable = productPage.select("table tbody tr");
		for (Element row : nutriTable)
		{
			String rowHeader = row.select("th").text();
			if (rowHeader.matches("[Ee]nergy")) {
				pattern = Pattern.compile("(\\d+)\\s{0,1}[Kk]cal");
				matcher = pattern.matcher(row.select("td").first().text().trim());
				if (matcher.find()) {
					nutriValues[0] = matcher.group().replace("kcal", "");
				}
				else {
					nutriValues[0] = row.select("td").text();
				}
			}
			else if (rowHeader.matches("[Pp]rotein")) {
				nutriValues[1] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Cc]arbohydrates")) {
				nutriValues[2] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Ss]ugar[s]{0,1}")) {
				nutriValues[3] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Ff]at[s]{0,1}")) {
				nutriValues[4] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Ss]aturates")) {
				nutriValues[5] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Ff]ibre")) {
				nutriValues[6] = row.select("td").first().text().trim().replace("g", "");
			}
			else if (rowHeader.matches("[Ss]alt")) {
				nutriValues[7] = row.select("td").first().text().trim().replace("g", "");
			}
		}
				
		Product prod = new Product(foundId, productName, productPageURL, price, pricePerUnit, this.categoryName, nutriValues);
		
		writeToFile("data/tesco.txt", prod.toString());
	}

	public static synchronized void writeToFile(String filename, String product) {
		try
        {
            File oFile = new File(filename);
            if (!oFile.exists())
            {
                oFile.createNewFile();
            }
            if (oFile.canWrite())
            {
                BufferedWriter oWriter = new BufferedWriter(new FileWriter(filename, true));
                oWriter.write(product + System.lineSeparator());
                oWriter.close();
            }
        }
        catch (IOException ioe)
        {
        	ioe.printStackTrace();
        }
	}

	public static Document getHTML(String url)
	{
		URL obj;
		HttpURLConnection conn;
		BufferedReader inBuff;
		String inputLine;
		StringBuffer response;

		try
		{
			obj = new URL(url);
			conn = (HttpURLConnection)obj.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			System.out.println("GET " + url + System.lineSeparator());

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
			mal.printStackTrace();
			return null;
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return null;
		}

		Document html = Jsoup.parse(response.toString());
		return html;
	}
}