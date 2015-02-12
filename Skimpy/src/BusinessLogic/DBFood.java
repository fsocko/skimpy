//author: FPS
//TODO: Roo, please merge my food class into food so it works. I need this object whenever I push food items to DB

package BusinessLogic;

public class DBFood {

	private int shopID;
	private String name;
	private double mass;
	private String unit;
	private double price;
	private double pricePU;
	private String foodCat; 

	public DBFood(int shopID, String name, double mass, String unit, double price, double pricePU, String foodCat)
	{

			this.shopID = shopID;
			this.name = name;
			this.mass = mass;
			this.unit = unit;
			this.price = price;
			this.pricePU = pricePU;
			this.foodCat = foodCat;
	       
	}


	public int getShopID() {
		return shopID;
	}

	public void setShopID(int shopID) {
		this.shopID = shopID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPricePU() {
		return pricePU;
	}

	public void setPricePU(double pricePU) {
		this.pricePU = pricePU;
	}

	public String getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}
	
}//EOF
