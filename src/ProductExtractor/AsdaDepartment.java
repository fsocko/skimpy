//@author Lee

package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * Class to read a department page and get the urls for the Aisle pages
 */
public class AsdaDepartment implements Runnable {
	
	private String url;
	
	public AsdaDepartment(String url) {
		this.url = url;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url); 
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(50000);
			String[] urlSplit = url.split("/");
			String id = urlSplit[urlSplit.length - 1];
			HtmlElement divtest = (HtmlElement)page.getBody().getOneHtmlElementByAttribute("div", "id", id);
			Iterator<DomElement> itr = divtest.getChildElements().iterator();
			while (itr.hasNext()) {
				DomElement temp = itr.next();
				if (!(temp.asText().toLowerCase().contains("free from") || temp.asText().toLowerCase().contains("special offers") || temp.asText().toLowerCase().contains("world foods"))) {
					String productPage = temp.getFirstElementChild().getAttribute("href");
					Thread t = new Thread(new AsdaAisle(AsdaScraper.rootUrl + productPage));
					AsdaScraper.aisles.add(t);
				}
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
