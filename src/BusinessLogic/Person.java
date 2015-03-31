package BusinessLogic;

import javax.servlet.http.HttpServlet;

/**
 *  @author Ruaraidh
 */

public class Person extends HttpServlet{
	/**
	 * This class will add users to the database or create person objects from the database.
	 */
	private String ID;
	private String name;
	private String email;
	private String password; //needs encripting
	private int age;
	private double height;
	private double weight;
	private char gender;
	private int exercise;
	private MealPlanner mealplan;
	
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
	
	public Person(String name, String email, String password, int age, double height, double weight, char gender, int exercise){
		
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.exercise = exercise;	
		
		//DBConnect connect = new DBConnect();
    	//connect.pushUser(this);
	}
	
	public void setMealplan(MealPlanner mealplan){
		this.mealplan = mealplan;
	}

	public String toString(){
		String s ="Name: " + name +
				"\nAge: " + age + 
				"\nHeight: " + height + " cm" +
				"\nWeight: " + weight + " kg" +
				"\nGender: " + gender + 
				"\nExercise: " + exercise; 
		return s;
	}
	
	//getters: might not need all of them? ID?
	public String getID(){
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
	public MealPlanner getMealplan(){
		return mealplan;
	}

	//use these setters if user changes age weight etc.
	public void setName(String name){
		this.name = name;
	}
	public void setAge(int age){
		this.age = age;
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
