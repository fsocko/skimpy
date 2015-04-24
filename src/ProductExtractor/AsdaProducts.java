//@author Lee

package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * Class to read the product list pages and get the product page urls
 */
public class AsdaProducts implements Runnable {
	
	private String url;
	private String categoryname;
	private String cat;
	
	public AsdaProducts(String url, String categoryname, String cat) {
		this.url = url;
		this.categoryname = categoryname;
		this.cat = cat;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(50000);
			HtmlElement gridProducts = page.getBody().getOneHtmlElementByAttribute("div", "id", "listings");
			Iterator<DomElement> itr = gridProducts.getChildElements().iterator();
			while (itr.hasNext()) {
				HtmlElement temp = (HtmlElement)itr.next();
				String prodUrl = temp.getOneHtmlElementByAttribute("span", "id", "productTitle").getFirstElementChild().getAttribute("href");
				Thread t = new Thread(new AsdaProductPage(AsdaScraper.rootUrl + prodUrl, categoryname, cat));
				AsdaScraper.productpages.add(t);
			}
			Iterator<DomElement> pageCount = page.getBody().getOneHtmlElementByAttribute("p", "class", "itemCount ").getChildElements().iterator();
			pageCount.next();
			int items = Integer.parseInt(pageCount.next().asText().replaceAll("[^0-9]", ""));
			int pages = (items / 60) + 1;
			for (int pageno = 1; pageno < pages; pageno++) {
				if (pageno < pages) {
					String[] urlsplit = url.split("/");				
					urlsplit[urlsplit.length - 2] = "" + (pageno + 1);
					String newurl = String.join("/", urlsplit);
					getProducts(newurl, cat);
				}
				
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getProducts(String url, String cat) {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(50000);
			HtmlElement gridProducts = page.getBody().getOneHtmlElementByAttribute("div", "id", "listings");
			Iterator<DomElement> itr = gridProducts.getChildElements().iterator();
			while (itr.hasNext()) {
				HtmlElement temp = (HtmlElement)itr.next();
				String prodUrl = temp.getOneHtmlElementByAttribute("span", "id", "productTitle").getFirstElementChild().getAttribute("href");
				Thread t = new Thread(new AsdaProductPage(AsdaScraper.rootUrl + prodUrl, categoryname, cat));
				AsdaScraper.productpages.add(t);
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
