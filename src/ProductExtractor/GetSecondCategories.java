//@author Lee

package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * A class to get the product pages from the second layer of categories, unless a second layer
 * does not exist, in which it's already a product page
 */
public class GetSecondCategories implements Runnable {
	
	private String url;
	private ThreadControl tc;
	private String categoryname;
	
	public GetSecondCategories(String url, ThreadControl tc, String categoryname) {
		this.url = url;
		this.tc = tc;
		this.categoryname = categoryname;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			WebClient webClient = new WebClient(BrowserVersion.CHROME);
			HtmlPage page = webClient.getPage(url);
			try {
				HtmlElement aisles = page.getBody().getOneHtmlElementByAttribute("ul", "class", "categories aisles");
				Iterator<DomElement> itr = aisles.getChildElements().iterator();
				while (itr.hasNext()) {
					HtmlElement temp = (HtmlElement)itr.next();
					if (!temp.asText().contains("All") && !temp.asText().contains("Special")) {
						String newurl = temp.getFirstElementChild().getAttribute("href");
						Thread t = new Thread(new GetProducts(newurl, tc, categoryname));
						tc.addThread(t);
						//SainsburysScraper.getProducts(webClient, newurl);
					}
				}
			} catch (Exception e) {
				Thread t = new Thread(new GetProducts(url, tc, categoryname));
				tc.addThread(t);
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			
		}
	}

}
