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
				
		//Connect run  = new DBConnect();
		//run.search("bread");

		
//TODO: Not touch this-FPS

		
		//Scraper Output to DB
		SpiderToDB path = new SpiderToDB();
		StdMain run = new StdMain();
		
		System.out.println(path.asdaPath);
		run.pushToDB(path.asdaPath, "food_db","asda_scraped");	
		System.out.println(path.sainsPath);
		run.pushToDB(path.sainsPath, "food_db","sains_scraped");
		System.out.println(path.tescoPath);
		run.pushToDB(path.tescoPath, "food_db","tesco_scraped");
	


		//PortionSizes
		
		StdMain portions = new StdMain(); 
		portions.portionSizeToDB("food_db", "portion_sizes");
		
    }
}


