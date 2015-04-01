//@author Lee

package ProductExtractor;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/*
 * A class to get the second layer of categories from the first layer of categories.
 */
public class GetCategories implements Runnable {
	
	private String url;
	private ThreadControl tc;
	
	public GetCategories(String url, ThreadControl tc) {
		this.url = url;
		this.tc = tc;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + ":> " + url);
			WebClient webClient = new WebClient(BrowserVersion.CHROME);
			HtmlPage page = webClient.getPage(url);
			HtmlElement categories = page.getBody().getOneHtmlElementByAttribute("ul", "class", "categories departments");
			Iterator<DomElement> itr = categories.getChildElements().iterator();
			while (itr.hasNext()) {
				HtmlElement temp = (HtmlElement)itr.next();
				String newurl = temp.getFirstElementChild().getAttribute("href");
				String categoryname = temp.getFirstElementChild().asText();
				Thread t = new Thread(new GetSecondCategories(newurl, tc, categoryname));
				tc.addThread(t);
			}
			webClient.closeAllWindows();
		} catch (Exception e) {
			
		}
	}

}
