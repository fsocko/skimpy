package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AsdaDepartment implements Runnable {
	
	private String url;
	private ThreadControl tc;
	
	public AsdaDepartment(String url, ThreadControl tc) {
		this.url = url;
		this.tc = tc;
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
					System.out.println(temp.asText());
					String productPage = temp.getFirstElementChild().getAttribute("href");
					Thread t = new Thread(new AsdaAisle(AsdaScraper.rootUrl + productPage, tc));
					tc.addThread(t);
				}
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
