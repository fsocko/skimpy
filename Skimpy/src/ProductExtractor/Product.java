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
	public String calories;
	public String protein;
	public String sugars;
	public String fats;
	public String saturates;
	public String salt;
	public String fibre;

	public Product(String id,
				   String name,
				   String url,
				   String ppi,
				   String ppu,
				   String category,
				   String[] nutritionValues) {
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
		this.price = (ppi == null ? "NULL" : ppi);		
		this.pricePerUnit = (ppu == null ? "NULL" : ppu);
		
		this.calories = (nutritionValues[0] == null ? "NULL" : nutritionValues[0]);
		this.protein = (nutritionValues[1] == null ? "NULL" : nutritionValues[1]);
		this.sugars = (nutritionValues[2] == null ? "NULL" : nutritionValues[2]);
		this.fats = (nutritionValues[3] == null ? "NULL" : nutritionValues[3]);
		this.saturates = (nutritionValues[4] == null ? "NULL" : nutritionValues[4]);
		this.salt = (nutritionValues[5] == null ? "NULL" : nutritionValues[5]);
		this.fibre = (nutritionValues[6] == null ? "NULL" : nutritionValues[6]);
	}
	
	public String toString() {
		return this.id			 + stdSeparator
			 + this.name		 + stdSeparator
			 + this.price		 + stdSeparator
			 + this.pricePerUnit + stdSeparator
			 + this.category	 + stdSeparator
			 + this.calories 	 + stdSeparator
			 + this.protein 	 + stdSeparator
			 + this.sugars 		 + stdSeparator
			 + this.fats		 + stdSeparator
			 + this.saturates	 + stdSeparator
			 + this.salt		 + stdSeparator
			 + this.fibre;
	}
}