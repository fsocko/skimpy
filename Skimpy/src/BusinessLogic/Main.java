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
		
//		int ID = 2;
//		System.out.println("Please enter your name:");
//		String userName = sc.nextLine();
//		System.out.println("Please enter your email:");
//		String email = sc.nextLine();
//		System.out.println("Please enter your age:");
//    	int age = Integer.parseInt(sc.nextLine());
//    	System.out.println("Please enter your height:");
//    	double height = Double.parseDouble(sc.nextLine());
//    	System.out.println("Please enter your weight:");
//    	double weight = Double.parseDouble(sc.nextLine());
//    	System.out.println("Please enter your gender:");
//    	char gender = sc.nextLine().charAt(0);
//    	System.out.println("Please enter your exercise:");
//    	int exercise = Integer.parseInt(sc.nextLine());
//    	
//    	Person user = new Person(ID, userName, email, age, height, weight, gender, exercise, null);
    	Person user = new Person(5, "TestUser", "test123@test.com", 14, 165, 60, 'F', 1, null);
		/********************************************************************************************************************************
		 * 																																*
		 * 													  		MEALS																*
		 *																																* 
		 ********************************************************************************************************************************/
    	System.out.println("Hey " + user.getName() + "! Let's create a MealPlan.");

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
    }
}