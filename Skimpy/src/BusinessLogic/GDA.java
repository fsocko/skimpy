package BusinessLogic;

import javax.servlet.http.HttpServlet;

/**
 * 
 * @author ruaraidh
 *
 */
/**
 * 
 * A representation of what nutrients a user needs each day.
 *
 */
public class GDA extends HttpServlet{
	/**
	 * This class will be used to check if a user's meal plan is balanced and healthy for them.
	 */
	private double calories;
	private double protein;
	private double carbs;
	private double sugars;
	private double fat;
	private double saturates;
	private double fibre;
	private double salt;
	/**
	 * Constructs the GDA model for a user. Calculates each as a ratio of calories and converts to grams.
	 * @param p takes in a user.
	 */
	//this will just work out ratios from the calories, need to  use toGrams() to convert and round
	public GDA(Person p){
		calories = findTDEE(p);
		protein = 0.022 * calories;
		carbs = 0.118 * calories;
		sugars = 0.043 * calories;
		fat = 0.037 * calories;
		saturates = 0.011 * calories;
		fibre = 0.011 * calories;
		salt = 0.003 * calories;
	}
	
	public double[] getGDA() {
		double[] values = {calories, protein, carbs, sugars, fat, saturates, fibre, salt};
		return values;
	}
	
	/**
	 * Represents the GDA as a string.
	 */
	public String toString(){
		String s = "Calories: " + toKcal(calories) + " kcal" +
				"\nProtien: " + toGrams(protein) + " g" +
				"\nCarbohydrates: " + toGrams(carbs) + " g" +
				"\nSugars: " + toGrams(sugars) + " g" +
				"\nFat: " + toGrams(fat) + " g" +
				"\nSaturates: " + toGrams(saturates) + " g" +
				"\nFibre: " + toGrams(fibre) + " g" +
				"\nSalt: " + toGrams(salt) +  " g";
		return s;
	}
	/**
	 * Calculates the user's Body Mass Ration (B.M.R).
	 * This is a calculation that works with attributes from Person class.
	 * After B.M.R is calculate then depending on the user's exercise level the calories consumed
	 * in a day is calculated.
	 * @param p Takes in a person.
	 * @return The amount of calories a Person consumes in a day.
	 */
	//work out persons total daily expendature of enenergy
	public double findTDEE(Person p){
		double BMR;
		double TDEE = 0;
		if(p.getGender() == 'M')
			BMR = 66 + (13.70 * p.getWeight()) + (5.00 * p.getHeight()) - (6.8 * p.getAge());
		else
			BMR = 655 + (9.6 * p.getWeight()) + (1.8 * p.getHeight()) - (4.7 * p.getAge());
		//desk job with little exercise
		if(p.getExercise() == 1)
			TDEE = 1.2 * BMR;
		//1-3hrs/week of light exercise
		if(p.getExercise() == 2)
			TDEE = 1.375 * BMR;
		//3-5hrs/week of moderate exercise
		if(p.getExercise() == 3)
			TDEE = 1.55 * BMR;
		//5-6hrs/week of strenuous exercise
		if(p.getExercise() == 4)
			TDEE = 1.725 * BMR;
		//7-21hrs/week of strenuous exercise/work
		if(p.getExercise() == 5)
			TDEE = 1.9 * BMR;
		return TDEE;
	}
	/**
	 * Formats the ratios from calories to convert them to grams then round them to 2 decimal places.
	 * @param x The ratio of calories that needs to be formatted.
	 * @return The formatted version.
	 */
	//converts and rounds to 2 decimal place
	public double toGrams(double x){
		double sum = x*0.25;
		int multiplier = 100;
		sum = Math.round(sum * multiplier)/ (double)multiplier;
		return sum;
	}
	/**
	 * Formats the calories to round to 2 decimal places.
	 * @param x
	 * @return The rounded result.
	 */
	//converts and rounds to 2 decimal place
	public double toKcal(double x){
		int multiplier = 100;
		return Math.round(x * multiplier)/ (double)multiplier;
	}

	public double getCalories() {
		return calories;
	}

	public double getProtein() {
		return protein;
	}

	public double getCarbs() {
		return carbs;
	}

	public double getSugars() {
		return sugars;
	}

	public double getFat() {
		return fat;
	}

	public double getSaturates() {
		return saturates;
	}

	public double getFibre() {
		return fibre;
	}

	public double getSalt() {
		return salt;
	}
}
