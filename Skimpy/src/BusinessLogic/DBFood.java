//author: FPS
//TODO: Roo, please merge my food class into food so it works. I need this object whenever I push food items to DB

package BusinessLogic;

public class DBFood {

	private String shopID;
	private String name;
	private double mass;
	private String unit;
	private double price;
	private double pricePU;
	private String PPUUnit;
	private String foodCat; 

	public DBFood(String shopID, String name, double mass, String unit, double price, double pricePU, String PPUUnit, String foodCat)
	{

			this.shopID = shopID;
			this.name = name;
			this.mass = mass;
			this.unit = unit;
			this.price = price;
			this.pricePU = pricePU;
			this.PPUUnit = PPUUnit;
			this.foodCat = foodCat;
	       
	}


	
	
}//EOF
