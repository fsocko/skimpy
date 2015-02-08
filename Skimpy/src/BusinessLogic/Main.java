package BusinessLogic;
import java.util.ArrayList;
/**
 * 
 * @author ruaraidh
 *
 */
/**
 * 
 * Main class that brings all the other classes together.
 *
 */
public class Main{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * TODO: add a MealPlanner to the Person that will associate with. 
	 * @param args
	 */
	
	public static void main(String[] args) {
		

		//User
		Person user = new Person("TestUser", "test123@test.com", 14, 165, 60, 'F', 1, null);
		//Person
    	MealPlanner plan = CreateMealPlan.create();
    	
		user.setPlan(plan);
		
		String dayResult = NutritionOptimisation.compareCalories(user, plan);
    	String weekResult = NutritionOptimisation.compareToGDAWeek(user, plan);
    	
    	System.out.println(dayResult);
    	System.out.println(weekResult);
    	
    	double priceD = plan.getPrice();
    	String price = String.format("%.2f", priceD);
    	System.out.println("Price: £" + price);
    	
    	ArrayList<Food> food = new ArrayList<Food>();
    	for (int i = 0; i < plan.getShoppingList().size(); i++) {
    		for (Food f: plan.getShoppingList().get(i)) {
    			food.add(f);
    		}
    	}
    	Food[] foodarray = food.toArray(new Food[food.size()]);
    	String[] shops = {"Tesco", "Asda"};
    	System.out.println("###################\nPrice Optimisation");
    	System.out.println("Cheapest Shop: " + shops[PriceOptimisation.cheapestShop(foodarray)]);
    	System.out.println("\nShopping lists such that you spend the minimum");
    	String[] temp = PriceOptimisation.minimumBudget(shops, foodarray);
    	for (String s : temp) {
    		System.out.println(s);
    	}
    	System.out.println("Price: " + PriceOptimisation.minimumBudget(foodarray));

		/********************************************************************************************************************************
		 * 																																*
		 * 														USER SET UP																*
		 *																																* 
		 *******************************************************************************************************************************/
		
	
  	
//    	Person user = new Person(ID, userName, email, age, height, weight, gender, exercise, null);
    	Person user1 = new Person("FPSTeste", "teste123@teste.com", 16, 162, 21, 'M', 1, null);
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
