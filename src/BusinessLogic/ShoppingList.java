
//@author Alina
package BusinessLogic;
import java.util.*;

import javax.servlet.http.HttpServlet;

public class ShoppingList extends HttpServlet {
	
	private Food item;
	private double weeklyMass; //mass of food item that is needed for a week
	HashMap<Food, Double> shoppingList;
	
	public HashMap<Food, Double> getShoppingList(String path, int userId){
		
		 XMLParser writeX = new XMLParser();
	 	 ArrayList<MealPlanner> readmeals = new ArrayList<MealPlanner>();
	 	 ArrayList<Meal> meals = new ArrayList<Meal>();
	 	 shoppingList = new HashMap<Food, Double>();
	 	
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
						   
					   }System.out.println( p.getMeal(j, i).getName()+ count);
						}
					}}
					   if (count > 0){
					      for (int x=0; x< m.getIngredients().size(); x++){
					    	weeklyMass = m.getMasses().get(x)/m.getServings()*count;
					    	
					    	if(shoppingList.containsKey(m.getIngredients().get(x))){  
					    	  
					    		double existingMass = shoppingList.get(m.getIngredients().get(x));
					    		double newMass = existingMass + weeklyMass;
					    		shoppingList.replace(m.getIngredients().get(x), weeklyMass, newMass);
					    	    
					    		
						  
						   
						   
						   
					    	}else{
						   
						   shoppingList.put(m.getIngredients().get(x), weeklyMass);
						   
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
		
		return shoppingList;
		
	}
	
	
}
