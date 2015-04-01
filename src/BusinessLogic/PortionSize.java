package BusinessLogic;

public class PortionSize {

	private String foodCat;
	private String foodItem;
	private double mass;
	private String unit;
	



	public PortionSize (String foodCat, String foodItem, double mass, String unit)
	{
	
		this.foodCat = foodCat;
		this.foodItem = foodItem;
		this.mass = mass;
		this.unit = unit;
		
	}




	public String getFoodCat() {
		return foodCat;
	}




	public void setFoodCat(String foodCat) {
		this.foodCat = foodCat;
	}




	public String getFoodItem() {
		return foodItem;
	}




	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
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




	@Override
	public String toString() {
		return "PortionSize [foodCat=" + foodCat + ", foodItem=" + foodItem
				+ ", mass=" + mass + ", unit=" + unit + "]";
	}


}