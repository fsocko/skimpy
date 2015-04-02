/**@author: FPS, Ruaraidh*/
package BusinessLogic;
import javax.servlet.http.HttpServlet;

public class Food extends HttpServlet{

	private int DBID;
	private String shopID;
	private String name;
	private double mass;
	private String unit;
	private double price;
	private double pricePU;
	private String PPUUnit;
	private String foodCat;
	private String foodCat2;
	private String supermarket;
	private double calories;
	private double proteins;
	private double carbs;
	private double sugars;
	private double fats;
	private double saturates;
	private double fibre;
	private double salt;
	
	public Food(int DBID, String shopID, String name, double mass, String unit,
				double price, double pricePU, String pPUUnit, String foodCat, String foodCat2, String supermarket,
				double calories, double proteins, double carbs,
				double sugars, double fats, double saturates, double fibre,
				double salt) 
	{
		this.DBID = DBID;
		this.shopID = shopID;
		this.name = name;
		this.mass = mass;
		this.unit = unit;
		this.price = price;
		this.pricePU = pricePU;
		PPUUnit = pPUUnit;
		this.foodCat = foodCat;
		this.foodCat2 = foodCat2;
		this.supermarket = "x"; //TODO: add supermarket data to the DB
		this.calories = calories;
		this.proteins = proteins;
		this.carbs = carbs;
		this.sugars = sugars;
		this.fats = fats;
		this.saturates = saturates;
		this.fibre = fibre;
		this.salt = salt;
	}
	
	public int getDBID() {
		return DBID;
	}
	
	public String getShopID() {
		return shopID;
	}

	public void setShopID(String shopID) {
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

	public String getPPUUnit() {
		return PPUUnit;
	}

	public void setPPUUnit(String pPUUnit) {
		PPUUnit = pPUUnit;
	}

	public String getFoodCat() {
		return foodCat;
	}

	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}

	public String getFoodCat2() {
		return foodCat2;
	}

	public void setFoodCat2(String foodCat2) {
		this.foodCat2 = foodCat2;
	}

	public String getSupermarket() {
		return supermarket;
	}

	public void setSupermarket(String supermarket) {
		this.supermarket = supermarket;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getProteins() {
		return proteins;
	}

	public void setProteins(double proteins) {
		this.proteins = proteins;
	}

	public double getCarbs() {
		return carbs;
	}

	public void setCarbs(double carbs) {
		this.carbs = carbs;
	}

	public double getSugars() {
		return sugars;
	}

	public void setSugars(double sugars) {
		this.sugars = sugars;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}

	public double getSaturates() {
		return saturates;
	}

	public void setSaturates(double saturates) {
		this.saturates = saturates;
	}

	public double getFibre() {
		return fibre;
	}

	public void setFibre(double fibre) {
		this.fibre = fibre;
	}

	public double getSalt() {
		return salt;
	}

	public void setSalt(double salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Food [shopID=" + shopID + ", name=" + name + ", mass=" + mass
				+ ", unit=" + unit + ", price=" + price + ", pricePU="
				+ pricePU + ", PPUUnit=" + PPUUnit + ", foodCat=" + foodCat
				+ ", foodCat2=" + foodCat2 + ", supermarket=" + supermarket
				+ ", calories=" + calories + ", proteins=" + proteins
				+ ", carbs=" + carbs + ", sugars=" + sugars + ", fats=" + fats
				+ ", saturates=" + saturates + ", fibre=" + fibre + ", salt="
				+ salt + "]";
	}

	
}
