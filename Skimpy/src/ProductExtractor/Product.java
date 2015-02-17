package ProductExtractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Product {
	public static String stdSeparator = "; ";
	public String id;
	public String name;
	public String category;
	public String url;
	public String price;
	public String pricePerUnit;

	public Product(String id, String name, String url, String ppi, String ppu, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
		
		Pattern r = Pattern.compile("^/groceries");
		Matcher m = r.matcher(url);
		if (m.find()) {
			this.url = "http://www.tesco.com" + url;
		}
		else {
			this.url = url;
		}
		
		this.price = ppi;
		
		this.pricePerUnit = ppu;
	}
	
	public String toString() {
		return this.id			 + stdSeparator
			 + this.name		 + stdSeparator
			 + this.price		 + stdSeparator
			 + this.pricePerUnit + stdSeparator
			 + this.category;
	}
}