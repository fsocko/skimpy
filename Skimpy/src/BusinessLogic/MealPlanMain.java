//@author: Ruaraidh

package BusinessLogic;

public class MealPlanMain {

	public static void testMealPlan()
	{
		
		//user creation
		Person user = new Person("Skimpy", "skimpy@skimpy.com", "password", 18, 30, 70, 'M', 0);
		
		
		
		//create test meal plan

    	MealPlanner plan = CreateMealPlan.create();
    	System.out.println(plan.toString());
		user.setMealplan(plan);
//		String dayResult = NutritionOptimisation.compareCalories(user, plan);
//    	String weekResult = NutritionOptimisation.compareToGDAWeek(user, plan);
//    	
//    	System.out.println(dayResult);
//    	System.out.println(weekResult);
//    	
//    	double priceD = plan.getPrice();
//    	String price = String.format("%.2f", priceD);
//    	System.out.println("Price: £" + price);
//    	
//    	ArrayList<Food> food = new ArrayList<Food>();
//    	for (int i = 0; i < plan.getShoppingList().size(); i++) {
//    		for (Food f: plan.getShoppingList().get(i)) {
//    			food.add(f);
//    		}
//    	}
//    	Food[] foodarray = food.toArray(new Food[food.size()]);
//    	String[] shops = {"Tesco", "Asda"};
//    	System.out.println("###################\nPrice Optimisation");
//    	System.out.println("Cheapest Shop: " + shops[PriceOptimisation.cheapestShop(foodarray)]);
//    	System.out.println("\nShopping lists such that you spend the minimum");
//    	String[] temp = PriceOptimisation.minimumBudget(shops, foodarray);
//    	for (String s : temp) {
//    		System.out.println(s);
//    	}
//    	System.out.println("Price: " + PriceOptimisation.minimumBudget(foodarray));

		
		
	}
	
	
}
