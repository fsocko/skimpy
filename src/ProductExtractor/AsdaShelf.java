package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AsdaShelf implements Runnable {
	
	private String url;
	private ThreadControl tc;
	private String categoryname;
	
	public AsdaShelf(String url, ThreadControl tc, String categoryname)
	{
		this.url = url;
		this.tc = tc;
		this.categoryname = categoryname;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url); 
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_24);
			HtmlPage page = webClient.getPage(url);
			webClient.waitForBackgroundJavaScript(50000);
			HtmlElement shelves = (HtmlElement)page.getBody().getOneHtmlElementByAttribute("ul", "class", "menu_shelf").getFirstElementChild();
			Iterator<DomElement> itr = shelves.getChildElements().iterator();
			while (itr.hasNext()) {
				HtmlElement temp = (HtmlElement)itr.next();
				String cat = temp.asText();
				String productPage = temp.getFirstElementChild().getAttribute("href");
				Thread t = new Thread(new AsdaProducts(AsdaScraper.rootUrl + productPage, tc, categoryname, cat));
				AsdaScraper.gridpages.add(t);
				//tc.addThread(t);
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
