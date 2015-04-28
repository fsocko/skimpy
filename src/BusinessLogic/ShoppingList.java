
//@author Alina
package BusinessLogic;
import java.util.*;

import javax.servlet.http.HttpServlet;

public class ShoppingList extends HttpServlet {
	
	private Food item;
	private double weeklyMass; //mass of food item that is needed for a week
	HashMap<String, Food> shoppingList;
	HashMap<String, Double> amountList;
	HashMap<ArrayList<Food>, ArrayList<Double>> result;
	ArrayList<Food> foodList = new ArrayList<Food>();
 	ArrayList<Double> massList = new ArrayList<Double>();
	
	public HashMap<ArrayList<Food>, ArrayList<Double>> getShoppingList(String path, int userId){
		
		 XMLParser writeX = new XMLParser();
	 	 ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
	 	 ArrayList<Meal> meals = new ArrayList<Meal>();
	 	 shoppingList = new HashMap<String, Food>();
	 	 amountList = new HashMap<String, Double>();
	 	 result = new HashMap<ArrayList<Food>, ArrayList<Double>>();
	 	
	 	if(writeX.readMeals(path + "/meals.xml") != null){
	 		meals = writeX.readMeals(path + "/meals.xml");
	 	if(writeX.readMealPlans(path + "/mealplans.xml") != null){
	 	    readmeals = writeX.readMealPlans(path + "/mealplans.xml");
	 	   for(MealPlanner p: readmeals){
	 		  if (userId == p.getUserId()){
	 	         for(Meal m: meals){
			   
			        int count = 0;	
	    	 		for(int i=0; i<3; i++){
					for(int j =0; j< 7; j++){
						if(p.getMeal(j, i)!= null){
						
					 
					if(p.getMeal(j, i).getName().equals(m.getName())){
					   count ++;
					   
					   }else{
						   
					   }
						}
					}}
					   if (count > 0){
					      for (int x=0; x< m.getIngredients().size(); x++){
					    	weeklyMass = m.getMasses().get(x)/m.getServings()*count;
					    	
					    	if(shoppingList.containsKey(m.getIngredients().get(x).getShopID())){  
					    	  
					    		double existingMass = amountList.get(m.getIngredients().get(x).getShopID());
					    		double newMass = existingMass + weeklyMass;
					    		amountList.replace(m.getIngredients().get(x).getShopID(), weeklyMass, newMass);
					    	    
						   
					    	}else{
						   
						   shoppingList.put(m.getIngredients().get(x).getShopID(), m.getIngredients().get(x));
						   amountList.put(m.getIngredients().get(x).getShopID(), weeklyMass);
						   
					    	}
						 
					      }
					   }
					
					}
	 	         
	 	        
					}
	 		  
	 		  
	    		    }
	    	
	     }else{
	    	 return null;
	    	 
	     }}else{
	     return null;
	     }
		
	 	
     for (Map.Entry<String, Food> food: shoppingList.entrySet()){
 		
 	 	foodList.add(food.getValue()); }
 	 	
 	 for (Map.Entry<String, Double> mass: amountList.entrySet()){ 
 	     
 	 	 massList.add(mass.getValue()); }	
 		
 	 result.put(foodList, massList);
		return result;
		
	}
	
	
}
