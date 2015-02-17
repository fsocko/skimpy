package ProductExtractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Category {
	public String name;
	public String url;

	public Category(String name, String url) {
		this.name = name;
		
		Pattern r = Pattern.compile("^/groceries");
		Matcher m = r.matcher(url);
		if (m.find()) {
			this.url = "http://www.tesco.com" + url;
		}
		else {
			this.url = url;
		}
	}

	public String toString() {
		return this.name + " " + this.url;
	}
}