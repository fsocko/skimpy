package BusinessLogic;

import javax.servlet.http.HttpServlet;

/**
 * @author Lee and Ruaraidh
 */

/**
 * A class which tells you if you're higher or lower than the GDA values
 */
public class NutritionOptimisation extends HttpServlet{
	
	private Person user;
	private MealPlanner plan;
	
	public NutritionOptimisation(Person p, MealPlanner m){
		user = p;
		plan = m;
	}
	
	public int percent(){
		int percentage = 0;
		
		return percentage;
	}
	
	public String calorieInfo(int day){
		String message = "You are eating ";
		
		double userCalories = plan.totalCal(day);
		double recommendedCalories = user.getMacros().getCalories();
		
		double percent = (userCalories / recommendedCalories) * 100;
		
		if(percent > 110){
			message += percent + " of your daily Calories. This is too much.";
		} 
		else if (percent < 90) {
			message += percent + " of your daily Calories. This is too little.";
		}
		else{
			message += " the right amount of calories";
		}
		return message;
	}
	
	public String proteinInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String carbInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String sugarInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String fatInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String saturateInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String fibreInfo(int day){
		String message = "";
		
		return message;
	}
	
	public String saltInfo(int day){
		String message = "";
		
		return message;
	}







}
