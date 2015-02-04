package BusinessLogic;
/**
 * @author Lee
 */

/**
 * A class which tells you if you're higher or lower than the GDA values
 */
public class NutritionOptimisation {
	
	/**
	 * Returns the total nutritional values.
	 * @param nutritionalValues An array of the nutritional values for each of the food item.
	 * @return The total nutritional values.
	 */
	
	//NOT USED
	public static double[] totalNutrition(double[][] nutritionalValues) {
		double[] totalValues = new double[nutritionalValues[0].length];
		for (int i = 0; i < nutritionalValues.length; i++) {
			for (int j = 0; j < nutritionalValues[i].length; j++) {
				totalValues[j] += nutritionalValues[i][j];
			}
		}
		
		return totalValues;
	}
	
	/**
	 * Returns a string detailing which nutritional values are higher or lower, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower
	 */
	public static String compareCalories(Person p, MealPlanner m) {
		String result = "";
		GDA userGDA = new GDA(p);
		double max = userGDA.getCalories() + 0.1 * userGDA.getCalories();
		double min = userGDA.getCalories() - 0.1 * userGDA.getCalories();
		for (int i = 0; i < 7; i++) {
			if (m.totalCal(i) < min)
				result += "According to the GDA, you are eating too litte on " + MealPlanner.getDay(i) + ". You are eating: " +    m.totalCal(i) + " and should be trying to eat at least " + String.format("%.2f", min) + "\n";
			else if (m.totalCal(i) > max) 
				result += "According to the GDA, you are eating too much on " + MealPlanner.getDay(i) + ". You are eating: " +    m.totalCal(i) + " and should be trying to cut down to " + String.format("%.2f", max) + "\n";
			else
				result += "According to the GDA, you are eating the right amount of calories on " + MealPlanner.getDay(i) + ".\n";
//			System.out.println("MAX: " + userGDA.toKcal(max) + " MIN: " + userGDA.toKcal(min) + " TOTAL: " + userGDA.toKcal(m.totalCal(i)));
		}
		
		
		return result;
	}
	
	/**
	 * Returns a string detailing which nutritional values are higher or lower for a week, within 10% either way lower or higher
	 * @param values The total nutritional values of the foods
	 * @param gdaValues The recommended daily values of the person
	 * @param descriptions The names of the GDA values, eg. Calories
	 * @return A string detailing which nutritional values are higher or lower for a week
	 */
	public static String compareToGDAWeek(Person p, MealPlanner m) {

		String result = "";
		GDA userGDA = new GDA(p);
		int total = 0;
		
		double max = 7 * (userGDA.getCalories() + 0.1 * userGDA.getCalories());
		double min = 7 * (userGDA.getCalories() - 0.1 * userGDA.getCalories());
		for (int i = 0; i < 7; i++) {
			total += m.totalCal(i);
		}
		double save = (1 - (min / total)) *100;
		System.out.println("");
		if (total < min)
			result = "According to the GDA, You are not eating enough in a week. You might have to spend more money. You are eating " + total + " and you should try and eat at least " + String.format("%.2f",min) + ".";
		
		else if(total > min)
			result = "According to the GDA, You are eating too much in a week. You could save money. You are eating " + total + " and you should try to cut down to at least " + String.format("%.2f",min) + "." +
					"\nBy cutting down you could save up to " + String.format("%.2f",save) + "% in price.";
		else
			result = "According to the GDA, Your calorie intake is good.";
		return result;
	}

}
