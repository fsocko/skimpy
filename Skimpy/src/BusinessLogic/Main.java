package BusinessLogic;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
/**
 * @author ruaraidh
 */
/**
 * Main class that brings all the other classes together.
 */
public class Main extends HttpServlet{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * @param args
	 */
	
	public static void main(String[] args) {

		//this will open a class in which all your meal plan methods from main are now.
		//@ruaraidh I suggest we adopt this as standard practice for testing methods in the master branch.
		//It makes it easier to comment out other people's work which may or may not be needed.
			
		//Run meal plan methods
		//MealPlanMain testPlan = new MealPlanMain();
		//testPlan.testMealPlan();
		
		//Scraper Output to DB
		StdMain run = new StdMain(); 	
		run.pushTesco("food_db","tesco_scraped");	
		run.pushSains("food_db","sains_scraped");
    }
}


