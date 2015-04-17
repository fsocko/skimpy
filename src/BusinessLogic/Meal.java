package BusinessLogic;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServlet;
/**
 *
 * @author ruaraidh, FPS
 *
 */
/**
 *  Represents a Meal
 *
 */
public class Meal extends HttpServlet{
	/**
	 * Will be used in creating a MealPlanner . Then can be compared to the user's GDA.
	 */
	private String name;
	private ArrayList<Food> ingredients;
	private ArrayList<Integer> masses;

	/**
	 * Constructs a default Meal.
	 * @param name The Meal name.
	 * @param ingredients The Food needed to make the Meal.
	 */
	public Meal(String name, ArrayList<Food> ingredients, ArrayList<Integer> masses)
	{
		this.name = name;
	
		this.ingredients = new ArrayList<Food>();
				for(Food f : ingredients)
		{
					this.ingredients.add(f);
		}		
		
		
		this.masses = new ArrayList<Integer>();
			for(Integer g : masses)
			{
					this.masses.add(g);
			}
				
	}	
	/**
	 * Displays the Meal as a String
	 */
	
	public String toString()
	{
		StringBuffer result = new StringBuffer();
		
		 for(int i = 0; i<ingredients.size(); i++)
		 {
			 Food foodLookup = ingredients.get(i);
			 result.append("\n* "+ foodLookup.getName());
		 }

		String s = "Meal Name: " + name +
				"\nIngredients: " + result.toString();
		
		s += "\nMeal Properties:\n"+ "\nMeal Price:" + mealPrice()+ "\nMeal Calories:"+ mealCal() +
		"\nMeal Proteins:" + mealProt() + "\nMeal Carbs:"+ mealCarb()+
		"\nMeal Sugar:" + mealSugar()+"\nMeal Fat:"+mealFat() 
		+"\nMeal Saturates:" + mealSat() +"\nMeal Fibre:"+mealFibr()+ 
		"\nMeal Salt:" + mealSalt();

		return s;
	}
	
	/**
	 * Allows a Food to be added as an ingredient.
	 * @param f
	 */
	public void add(Food f)
	{
		ingredients.add(f);
	}
	public double mealPrice()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getPrice();
		}
		return result;
	}
	
	
	/**
	 * Retrieves the total calories for that meal.
	 * @return The total calories of the meal.
	 */
	public double mealCal()
	{
		double result = 0;
		for(Food f : ingredients){
			result += f.getCalories();
		}
		return result;
	}
	
	public double mealProt()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getProteins();
		}
		return result;
	}
	public double mealCarb()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getCarbs();
		}
		return result;
	}
	public double mealSugar()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getSugars();
		}
		return result;
	}
	public double mealFat()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getFats();
		}
		return result;
	}
	public double mealSat()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getSaturates();
		}
		return result;
	}
	public double mealFibr()
	{
		double result = 0;
		for(Food f : ingredients)
		{
			result += f.getFibre();
		}
		return result;
	}
	public double mealSalt()
	{
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
	public String getName()
	{
		return this.name;
	}
	public ArrayList<Food> getIngredients()
	{
		return ingredients;
	}
	
	public ArrayList<Integer> getMasses()
	{
		return masses;
	}
}
