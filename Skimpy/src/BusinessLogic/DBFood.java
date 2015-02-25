//author: FPS
//TODO: Roo, please merge my food class into food so it works. I need this object whenever I push food items to DB

package BusinessLogic;

import javax.servlet.http.HttpServlet;

public class DBFood extends HttpServlet{

	
	private String shopID;
	private String name;
	private double mass;
	private String unit;
	private double price;
	private double pricePU;
	private String PPUUnit;
	private String foodCat;
	private char supermarket;
	private double calories;
	private double proteins;
	private double carbs;
	private double sugars;
	private double fats;
	private double saturates;
	private double fibre;
	private double salt;
	
	public DBFood(String shopID, String name, double mass, String unit,
			double price, double pricePU, String pPUUnit, String foodCat,
			char supermarket, double calories, double proteins, double carbs,
			double sugars, double fats, double saturates, double fibre,
			double salt) {
		super();
		this.shopID = shopID;
		this.name = name;
		this.mass = mass;
		this.unit = unit;
		this.price = price;
		this.pricePU = pricePU;
		PPUUnit = pPUUnit;
		this.foodCat = foodCat;
		this.supermarket = supermarket;
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturates = saturates;
		this.fibre = fibre;
		this.salt = salt;
	}

	public String getShopID() {
		return shopID;
	}

	public String getName() {
		return name;
	}

	public double getMass() {
		return mass;
	}

	public String getUnit() {
		return unit;
	}

	public double getPrice() {
		return price;
	}

	public double getPricePU() {
		return pricePU;
	}

	public String getPPUUnit() {
		return PPUUnit;
	}

	public String getFoodCat() {
		return foodCat;
	}

	public char getSupermarket() {
		return supermarket;
	}

	public double getCalories() {
		return calories;
	}

	public double getProteins() {
		return proteins;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getSugars() {
		return sugars;
	}

	public double getFats() {
		return fats;
	}

	public double getSaturates() {
		return saturates;
	}

	public double getFibre() {
		return fibre;
	}

	public double getSalt() {
		return salt;
	}

	@Override
	public String toString() {
		return "DBFood [shopID=" + shopID + ", name=" + name + ", mass=" + mass
				+ ", unit=" + unit + ", price=" + price + ", pricePU="
				+ pricePU + ", PPUUnit=" + PPUUnit + ", foodCat=" + foodCat
				+ ", supermarket=" + supermarket + ", calories=" + calories
				+ ", proteins=" + proteins + ", carbs=" + carbs + ", sugars="
				+ sugars + ", fats=" + fats + ", saturates=" + saturates
				+ ", fibre=" + fibre + ", salt=" + salt + "]";
	}

	
	
	
}//EOF