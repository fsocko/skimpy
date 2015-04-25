package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * Class to read Aisle page and get the urls for the Shelf pages
 */
public class AsdaAisle implements Runnable {
	
	private String url;
	
	public AsdaAisle(String url) {
		this.url = url;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url); 
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(50000);
			HtmlElement shelves = (HtmlElement)page.getBody().getOneHtmlElementByAttribute("ul", "class", "menu_aisles").getFirstElementChild();
			Iterator<DomElement> itr = shelves.getChildElements().iterator();
			while (itr.hasNext()) {
				DomElement temp = itr.next();
				String categoryname = temp.asText();
				String productPage = temp.getFirstElementChild().getAttribute("href");
				Thread t = new Thread(new AsdaShelf(AsdaScraper.rootUrl + productPage, categoryname));
				AsdaScraper.shelves.add(t);
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
