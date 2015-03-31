package ProductExtractor;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.List;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public abstract class WebSpider {
	public String rootPageURL;

	public Document getHTML(String url) {
		String charset = StandardCharsets.UTF_8.name();

		HttpURLConnection connection;
		int responseCode;
		
		BufferedReader inBuff;
		String inLine;
		StringBuffer responseContent;

		try {
			connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setRequestProperty("Accept-Charset", charset);

			responseCode = connection.getResponseCode();

			System.out.println("GET: " + url + " (" + responseCode + ")");

			inBuff = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			responseContent = new StringBuffer();

			while ((inLine = inBuff.readLine()) != null) {
				responseContent.append(inLine);
			}
			inBuff.close();
		}
		catch (MalformedURLException mal) {
			mal.printStackTrace();
			return null;
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
		}

		Document html = Jsoup.parse(responseContent.toString());
		return html;
	}

	public String getDocumentTitle(Document html) {
		return html.select("title").text();
	}
	
	public abstract List<Department> listDepartments();
}