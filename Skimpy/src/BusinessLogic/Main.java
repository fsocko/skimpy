package BusinessLogic;
import java.util.ArrayList;
import java.util.Scanner;
//Ade was here
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
    	Person user = new Person("FPSTeste", "teste123@teste.com", 16, 162, 21, 'M', 1, null);
		/********************************************************************************************************************************
		 * 																																*
		 * 													  		MEALS																*
		 *																																* 
		 ********************************************************************************************************************************/
    	//FoodDB
    	
    	DBConnect fget = new DBConnect("food_db");
    	fget.getFoodData("fooditems");
    	
    	fget = new DBConnect("user");
    	fget.getUserData("user_info");

    }
}