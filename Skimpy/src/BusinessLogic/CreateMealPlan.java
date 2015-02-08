package BusinessLogic;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateMealPlan {
	
	
	public static MealPlanner create(){
		
		//moved this here for now so that we can make meals from database
		DBConnect connection = new DBConnect();
    	connection.getFoodData();
    	

//		Food ID1 = new Food(1, "Coco Pops", "g", 800, 30, 1.92, 175.0, 6.0, 32.0, 17.0, 3.0, 1.5, 0.6, 0.35);
//		Food ID2 = new Food(2, "Tesco Pure British Semi Skimmed Milk", "l", 1, 0.125, 1.00, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
//		Food ID3 = new Food(3, "Tesco British Chicken Breast", "breasts", 3, 3, 3.33, 510, 0.0, 90.0, 0.0, 5.4, 1.5, 0.0, 0.9);
//		Food ID4 = new Food(4, "Tesco Brocoli", "g", 335, 100, 0.49, 38, 2.8, 7, 0, 1.8, 0.5, 2.6, 0.3);
//		Food ID5 = new Food(5, "Brown Rice", "g", 1000, 75, 1.75, 265, 2.2, 17.25, 1.0, 2.1, 0.6, 1.35, 0);
//		Food ID6 = new Food(6, "Tesco 2 Boneless Salmon Fillets", "fillets", 2, 2, 3.33, 430, 40, 0, 0, 28.8, 2.6, 0, 0.3);
//		Food ID7 = new Food(7, "Tesco Baby Spinach", "g", 240, 50, 1.5, 11.5, 1.45, 1.8, 0.8, 0.4, 0, 1.1, 0.1);
//		Food ID8 = new Food(8, "Tesco Finest Wood Fired 12\" Ham Mushroom & Mascarpone Pizza", "pizza", 1, 1, 5.00, 1012, 49.2, 119, 11.8, 35.4, 16.6, 10, 5.6);
//		Food ID9 = new Food(9, "Tesco Tomatoes On The Vine Loose", "Tomatoes", 7, 1, 0.77, 16, 0.6, 2.5, 2.5, 0.2, 0, 0.8, 0.1);
//		Food ID10 = new Food(10, "Bread", "Slices", 20, 2, 1.00, 176, 8, 30.2, 3.2, 1.4, 0.4, 5.4, 0.72);
//		Food ID11 = new Food(11, "Cathedral City Mature Cheddar", "g", 350, 50, 4.00, 208, 12.7, 0.05, 0.05, 17.45, 10.85, 0, 0.35);
//		
//    	Food ID1 = 
//		Food ID2 = 
//		Food ID3 = 
//		Food ID4 = 
//		Food ID5 = 
//		Food ID6 = 
//		Food ID7 = 
//		Food ID8 =
//		Food ID9 = 
//		Food ID10 = 
//		Food ID11 = 
    	
		ArrayList<Food> ing1B = new ArrayList<Food>();
    	ArrayList<Food> ing1L = new ArrayList<Food>();
    	ArrayList<Food> ing1D = new ArrayList<Food>();
    	ArrayList<Food> ing2D = new ArrayList<Food>();
    	ArrayList<Food> ing3D = new ArrayList<Food>();
    	
    	//Breakfast
//    	ing1B.add(ID1);
//    	ing1B.add(ID2);
//    	//Lunch
//    	ing1L.add(ID9);
//    	ing1L.add(ID10);
//    	ing1L.add(ID11);
//    	//Chicken Dinner
//    	ing1D.add(ID3);
//    	ing1D.add(ID4);
//    	ing1D.add(ID5);
//    	//Pizza Dinner
//    	ing2D.add(ID8);
//    	//Salmon Dinner
//    	ing3D.add(ID6);
//    	ing3D.add(ID7);
//    	ing3D.add(ID5);
    	
    	Meal meal1B = new Meal("Coco Pops", ing1B);
       	Meal meal1L = new Meal("Cheese and Tomato Sandwich", ing1L);
    	Meal meal1D	= new Meal("Chicken Dinner", ing1D);
    	Meal meal2D = new Meal("Pizza Dinner", ing2D);
    	Meal meal3D = new Meal("Salmon Dinner", ing3D);      
    		
    	MealPlanner plan = new MealPlanner();
    		
    	plan.add(meal1B, "Mon", "Breakfast");
    	plan.add(meal1B, "Tue", "Breakfast");
    	plan.add(meal1B, "Wed", "Breakfast");
    	plan.add(meal1B, "Thu", "Breakfast");
    	plan.add(meal1B, "Fri", "Breakfast");
    	plan.add(meal1B, "Sat", "Breakfast");
    	plan.add(meal1B, "Sun", "Breakfast");
    	
    	plan.add(meal1L, "Mon", "Lunch");
    	plan.add(meal1L, "Tue", "Lunch");
    	plan.add(meal1L, "Wed", "Lunch");
    	plan.add(meal1L, "Thu", "Lunch");
    	plan.add(meal1L, "Fri", "Lunch");
    	plan.add(meal1L, "Sat", "Lunch");
    	plan.add(meal1L, "Sun", "Lunch");
    	
    	plan.add(meal1D, "Mon", "Dinner");
    	plan.add(meal1D, "Tue", "Dinner");
    	plan.add(meal1D, "Wed", "Dinner");
    	plan.add(meal2D, "Thu", "Dinner");
    	plan.add(meal3D, "Fri", "Dinner");
    	plan.add(meal3D, "Sat", "Dinner");
    	plan.add(meal3D, "Sun", "Dinner");
    	
    	ArrayList<ArrayList<Food>> shoppingList = new ArrayList<ArrayList<Food>>();
    	shoppingList.add(ing1B);
    	shoppingList.add(ing1L);
    	shoppingList.add(ing1D);
    	shoppingList.add(ing2D);
    	shoppingList.add(ing3D);
    	plan.setShoppingList(shoppingList);
    	
    	double price = totalPrice(shoppingList);
    	plan.setPrice(price);
    	
    	return plan;   	
	}
	public static double totalPrice(ArrayList<ArrayList<Food>> list){
		double result = 0;
		for(int i = 0; i < 5; i++){
			for(Food f : list.get(i)){
				result += f.getPrice();
			}
		}
		return result;
	}
}
