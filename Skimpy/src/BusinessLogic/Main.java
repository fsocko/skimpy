package BusinessLogic;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author ruaraidh
 *
 */
/**
 * 
 * Main class that brings all the other classes together. Clutch up!
 *
 */
public class Main{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * TODO: add a MealPlanner to the Person that will associate with. 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		/********************************************************************************************************************************
		 * 																																*
		 * 														USER SET UP																*
		 *																																* 
		 *******************************************************************************************************************************/
		
		Scanner sc = new Scanner(System.in);
  	
//    	Person user = new Person(ID, userName, email, age, height, weight, gender, exercise, null);
    	Person user = new Person(5, "TestUser", "test123@test.com", 14, 165, 60, 'F', 1, null);
		/********************************************************************************************************************************
		 * 																																*
		 * 													  		MEALS																*
		 *																																* 
		 ********************************************************************************************************************************/
    	//FoodDB
    	
    	DBConnect fget = new DBConnect("food_db");
    	fget.getFoodData("fooditems");
    	

    }
}