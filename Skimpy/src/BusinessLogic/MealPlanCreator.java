package BusinessLogic;

import java.util.ArrayList;

public class MealPlanCreator {
	
	public static MealPlanner parseMealPlan(String[] mealNames, String[] mealIngs) {
		String[][] mealIngredients = new String[mealIngs.length][];
		for (int i = 0; i < mealNames.length; i++) {;
			String[] mealIng = mealIngs[i].split(";");
			for (int j = 0; j < mealIng.length; j++) {
				mealIng[j] = mealIng[j];
			}
			mealIngredients[i] = mealIng;
		}
		
		MealPlanner mealPlanner = new MealPlanner();
		DBConnect db = new DBConnect();
		String[] times = {"Breakfast", "Lunch", "Dinner"};
		String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		int time = 0;
		int day = 0;
		
		for (int i = 0; i < mealNames.length; i++) {
			ArrayList<Food> foods = new ArrayList<Food>();
			for (String s: mealIngredients[i]) {
				//you will need to use the pull food method in DBConnect
//				Food food = db.getFoodData("asda_scraped", s);
//				foods.add(food);
			}
			Meal meal = new Meal(mealNames[i], foods);
			mealPlanner.add(meal, days[day], times[time]);
			day++;
			if (day > 6) {
				day = 0;
				time++;
			}
		}
		
		return mealPlanner;
	}
	
	public static String parseRawData(String input) {
		String[] inputs = {"+", "%92", "%0D%0A"};
		String[] outputs = {" ", "'", "\n"};
		for (int i = 0; i < inputs.length; i++) {
			input = input.replace(inputs[i], outputs[i]);
		}
		return input;
	}

	public static void main(String[] args) {
		String url = "http://localhost:8080/Skimpy/ShoppingList.jsp?mealname=Coco+Pops&ingredients=New+line+test%0D%0AHere%92s+a+test&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Coco+Pops&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Cheese+and+Tomato+Sandwich&ingredients=+Your+ingredients&mealname=Chicken+Dinner&ingredients=+Your+&mealname=Chicken+Dinner&ingredients=+Your+ingredients&mealname=Chicken+Dinner&ingredients=+Your+ingredients&mealname=Pizza+Dinner&ingredients=+Your+ingredients&mealname=Salmon+Dinner&ingredients=+Your+ingredients&mealname=Salmon+Dinner&ingredients=+Your+ingredients&mealname=Salmon+Dinner&ingredients=+Your+ingredients";
		//parseMealPlan(url);
	}
}
