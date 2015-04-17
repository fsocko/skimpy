package BusinessLogic;

import javax.servlet.http.HttpServlet;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 *  @author Ruaraidh
 */

public class Person extends HttpServlet{
	/**
	 * This class will add users to the database or create person objects from the database.
	 */
	private int ID;
	private String name;
	private String email;
	private String password; //needs encripting
	private Date dob;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private int exercise;
	private MealPlanner mealplan;
	GDA macros = null;
	/**
	 * Creates a Person with the desired attributes.
	 * @param name user's name.
	 * @param age user's age.
	 * @param height user's height in cm.
	 * @param weight user's weight in kg.
	 * @param gender user's gender M being male and F being female.
	 * @param exercise user's exercise per week:\n 
	 * 0 = Desk job with little exercise\n
	 * 1 = 1-3hrs/week of light exercise\n
	 * 2 = 3-5hrs/week of moderate exercise\n
	 * 3 = 5-6hrs/week of strenuous exercise\n
	 * 4 = 7-21hrs/week of strenuous exercise/work
	*/
	
	public Person(String name, String email, String password, Date dob, double height, double weight, char gender, int exercise){
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.age = setAge(dob);
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.exercise = exercise;
		
		//DBConnect connect = new DBConnect();
    	//connect.pushUser(this);
		macros = new GDA(this);
	}
	
	public void resetMacros(){
		macros = new GDA(this);
	}
	
	public String decodeEx(int exercise){
		String s = null;
		if(exercise == 1)
			s ="Desk job with little exercise";
	    //1-3hrs/week of light this.exercise
	    if(exercise == 2)
	      s = "1-3hrs/week of light exercise";
	    //3-5hrs/week of moderate this.exercise
	    if(exercise == 3)
	      s = "3-5hrs/week of moderate exercise";
	    //5-6hrs/week of strenuous this.exercise
	    if(exercise == 4)
	      s = "5-6hrs/week of strenuous exercise";
	    //7-21hrs/week of strenuous this.exercise/work
	    if(exercise == 5)
	      s = "7-21hrs/week of strenuous exercise/work";
		return s;
	}
	
	public int setAge(Date dob){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dob);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - cal.get(Calendar.YEAR);  
		if (today.get(Calendar.MONTH) < cal.get(Calendar.MONTH)) {
		  age--;  
		} else if (today.get(Calendar.MONTH) == cal.get(Calendar.MONTH)
		    && today.get(Calendar.DAY_OF_MONTH) < cal.get(Calendar.DAY_OF_MONTH)) {
		  age--;  
		}
		return age;
	}
	
	public String getDay(Date dob){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dob);  
		return String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
	}
	public String getMonth(Date dob){
		String monthString = null;
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dob);  
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month);
		switch (month) {
	        case 1:  monthString = "Jan";       break;
	        case 2:  monthString = "Feb";      break;
	        case 3:  monthString = "Mar";         break;
	        case 4:  monthString = "Apr";         break;
	        case 5:  monthString = "May";           break;
	        case 6:  monthString = "Jun";          break;
	        case 7:  monthString = "Jul";          break;
	        case 8:  monthString = "Aug";        break;
	        case 9:  monthString = "Sep";     break;
	        case 10: monthString = "Oct";       break;
	        case 11: monthString = "Nov";      break;
	        case 12: monthString = "Dec";      break;
	    }
		
		return monthString;	
	}
	public int getMonthNo(Date dob){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dob);  
		return cal.get(Calendar.MONTH);
	}
	public String getYear(Date dob){
		Calendar cal = Calendar.getInstance();  
		cal.setTime(dob);  
		return String.valueOf(cal.get(Calendar.YEAR));
	}
	
	public String getGenderDisp(char c){
		if(c == 'M'){
			return "Male";
		}
		else{
			return "Female";
		}
	}
	
	public static String heightToFoot(double cm){
		String s = "";
		double feet = Format.round(cm/30.48, 0);
		double inches = Format.round((cm/2.54) - ((int)feet * 12),0);
		
		s = String.valueOf((int)feet) + "'" + String.valueOf((int)inches) + "\"";
		return s;
	}
	
	public void setMealplan(MealPlanner mealplan){
		this.mealplan = mealplan;
	}
	

	public String toString(){
		String s ="Name: " + name +
				"\nBirthday: " + dob + 
				"\nHeight: " + height + " cm" +
				"\nWeight: " + weight + " kg" +
				"\nGender: " + gender + 
				"\nExercise: " + exercise; 
		return s;
	}
	
	//getters: might not need all of them? ID?
	public int getID(){
		return this.ID;
	}
	public String getEmail(){
		return this.email;
	}
	public String getName(){
		return name;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	public Date getDob(){
		return dob;
	}
	public int getAge(){
		return age;
	}
	public double getHeight(){
		return height;
	}
	public double getWeight(){
		return weight;
	}
	public char getGender(){
		return gender;
	}
	public int getExercise(){
		return exercise;
	}
	public String getExerciseDisplay(){
		return decodeEx(exercise);
	}
	public MealPlanner getMealplan(){
		return mealplan;
	}
	public GDA getMacros(){
		return macros;
	}
	

	//use these setters if user changes age weight etc.
	public void setID(int ID){
		this.ID = ID;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDob(Date dob){
		this.dob = dob;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public void setWeight(double weight){
		this.weight = weight;
	}
	public void setGender(char gender){
		this.gender = gender;
	}
	public void setExercise(int exercise){
		this.exercise = exercise;
	}
	public void setPassword(String password){
		this.password = password;
	}


	
}
