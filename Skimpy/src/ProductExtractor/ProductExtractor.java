package ProductExtractor;

import org.jsoup.nodes.Document;

class ProductExtractor
{
	public static void main(String[] args)
	{
		AsdaSpider asda = new AsdaSpider();
		SainsburysSpider snsbry = new SainsburysSpider();
		TescoSpider tesco = new TescoSpider();
		
		// Connect to ASDA
		Document asdaRootPage = asda.getHTML(asda.rootPageURL);
		System.out.println(asda.getDocumentTitle(asdaRootPage) + System.lineSeparator());
		
		// Connect to Tesco
		Document tescoRootPage = tesco.getHTML(tesco.rootPageURL);
		System.out.println(tesco.getDocumentTitle(tescoRootPage) + System.lineSeparator());
		
		// Connect to Sainsbury's
		Document snsbryRootPage = snsbry.getHTML(snsbry.rootPageURL);
		System.out.println(snsbry.getDocumentTitle(snsbryRootPage) + System.lineSeparator());
	}
}