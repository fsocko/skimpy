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
	
	public boolean checkMacro(double macro){
		if(macro > 110 || macro < 90){
			return true;
		}
		return false;
	}
	
	public String percent(){
		int percentage = 100;
		int subtract = 0;
		
		
		double temp;
		
		for(int i = 0; i < 7; i++){
			temp = calorieInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = proteinInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = carbInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = sugarInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = fatInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = saturateInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = fibreInfo(i);
			if(checkMacro(temp))
				subtract++;
			temp = saltInfo(i);
			if(checkMacro(temp))
				subtract++;
		}
		int subtractPercent = subtract/49 * 100;
		percentage -= subtractPercent;
		
		
		
		if(percentage == 0){
			percentage = 1;
		}
		
		return String.valueOf(percentage);
	}
	
	public String message(){
		String message = "You are eating ";
		
		double percent = calorieInfo(0);
		
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
	
	public int calorieInfo(int day){
		double userAmount = plan.totalCal(day);
		double recommendedAmount = user.getMacros().getCalories();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int proteinInfo(int day){
		double userAmount = plan.totalProtein(day);
		double recommendedAmount = user.getMacros().getProtein();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int carbInfo(int day){
		double userAmount = plan.totalCarbs(day);
		double recommendedAmount = user.getMacros().getCarbs();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int sugarInfo(int day){
		double userAmount = plan.totalSugars(day);
		double recommendedAmount = user.getMacros().getSugars();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int fatInfo(int day){
		double userAmount = plan.totalFats(day);
		double recommendedAmount = user.getMacros().getFat();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int saturateInfo(int day){
		double userAmount = plan.totalSats(day);
		double recommendedAmount = user.getMacros().getSaturates();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int fibreInfo(int day){
		double userAmount = plan.totalFibre(day);
		double recommendedAmount = user.getMacros().getFibre();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public int saltInfo(int day){
		double userAmount = plan.totalSalt(day);
		double recommendedAmount = user.getMacros().getSalt();
		
		double percent = (userAmount / recommendedAmount) * 100;
		
		return (int)percent;
	}
	
	public void setPerson(Person p){
		user = p;
	}
	public void setMealPlan(MealPlanner m){
		plan = m;
	}

}
