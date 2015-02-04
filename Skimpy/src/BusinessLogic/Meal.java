package BusinessLogic;
import java.util.ArrayList;
/**
 *
 * @author ruaraidh
 *
 */
/**
 *  Represents a Meal
 *
 */
public class Meal {
	/**
	 * Will be used in creating a MealPlanner . Then can be compared to the user's GDA.
	 */
	private String name;
	private ArrayList<Food> ingredients;
	/**
	 * Constructs a default Meal.
	 * @param name The Meal name.
	 * @param ingredients The Food needed to make the Meal.
	 */
	public Meal(String name, ArrayList<Food> ingredients){
		this.name = name;
		this.ingredients = new ArrayList<Food>();
		for(Food f : ingredients){
			this.ingredients.add(f);
		}
	}	
	/**
	 * Displays the Meal as a String
	 */
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		
		for(Food f : ingredients){
			result.append("\n* " + f.getName());
		}
		
		String s = "Meal Name: " + name +
				"\nIngredients: " + result.toString();
		return s;
	}
	/**
	 * Allows a Food to be added as an ingredient.
	 * @param f
	 */
	public void add(Food f){
		ingredients.add(f);
	}
	public double mealPrice(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getPrice();
		}
		return result;
	}
	/**
	 * Retrieves the total calories for that meal.
	 * @return The total calories of the meal.
	 */
	public double mealCal(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getCalories();
		}
		return result;
	}
	
	public double mealProt(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getProtein();
		}
		return result;
	}
	public double mealCarb(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getCarbs();
		}
		return result;
	}
	public double mealSugar(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getSugars();
		}
		return result;
	}
	public double mealFat(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getFat();
		}
		return result;
	}
	public double mealSat(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getSaturates();
		}
		return result;
	}
	public double mealFibr(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getFibre();
		}
		return result;
	}
	public double mealSalt(){
		double result = 0;
		for(Food f : ingredients){
			result += f.getSalt();
		}
		return result;
	}
	
	/**
	 * Gets the name of the Meal.
	 * @return The name of the Meal.
	 */
	public String getName(){
		return this.name;
	}
	public ArrayList<Food> getIngredients() {
		return ingredients;
	}
	
}
