package BusinessLogic;

import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.http.HttpServlet;

public class CreateMealPlan extends HttpServlet{
	
	
	public static MealPlanner create(){ 
		
		//moved this here for now so that we can make meals from database
		DBConnect connection = new DBConnect();
    	
    	Food ID1 = connection.pullFood("tesco", "1");
    	Food ID2 = connection.pullFood("tesco", "2");
    	Food ID3 = connection.pullFood("tesco", "3");
    	Food ID4 = connection.pullFood("tesco", "4");
    	Food ID5 = connection.pullFood("tesco", "5");
    	Food ID6 = connection.pullFood("tesco", "6");
    	Food ID7 = connection.pullFood("tesco", "7");
    	Food ID8 = connection.pullFood("tesco", "8");
    	Food ID9 = connection.pullFood("tesco", "9");
    	Food ID10 = connection.pullFood("tesco", "10");
    	Food ID11 = connection.pullFood("tesco", "11");
    	
		ArrayList<Food> ing1B = new ArrayList<Food>();
    	ArrayList<Food> ing1L = new ArrayList<Food>();
    	ArrayList<Food> ing1D = new ArrayList<Food>();
    	ArrayList<Food> ing2D = new ArrayList<Food>();
    	ArrayList<Food> ing3D = new ArrayList<Food>();
    	
    	//Breakfast
    	ing1B.add(ID1);
    	ing1B.add(ID2);
    	//Lunch
    	ing1L.add(ID9);
    	ing1L.add(ID10);
    	ing1L.add(ID11);
    	//Chicken Dinner
    	ing1D.add(ID3);
    	ing1D.add(ID4);
    	ing1D.add(ID5);
    	//Pizza Dinner
    	ing2D.add(ID8);
    	//Salmon Dinner
    	ing3D.add(ID6);
    	ing3D.add(ID7);
    	ing3D.add(ID5);
    	
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
    	
    	double price = totalPrice(shoppingList); //tescoPrice
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
