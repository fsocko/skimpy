package BusinessLogic;
/**
 *  
 *  @author ruaraidh
 */
/**
 * Each person object represent attributes of a user. 
 *
 */
public class Person {
	
	/**
	 * This class will add users to the database or create person objects from the database.
	 */
	private int ID;
	private String name; 
	private String email;
	private int age;
	private double height;
	private double weight;
	private char gender;
	private int exercise;
	private MealPlanner plan;
	//TODO: Meal plan
	
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
	
	public Person(int ID, String name, String email, int age, double height, double weight, char gender, int exercise, MealPlanner plan){
		this.ID = ID;
		this.name = name;
		this.email = email;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.exercise = exercise;	
		this.plan = null;
		
		DBConnect connect = new DBConnect("User");
    	connect.setData(this);
	}
	
	public void addMealplan(MealPlanner meals){
		this.plan = meals;
	}
	
	

	/**
	 * A toString function to display a person object.
	 */
	public String toString(){
		String s ="Name: " + name +
				"\nAge: " + age + 
				"\nHeight: " + height + " cm" +
				"\nWeight: " + weight + " kg" +
				"\nGender: " + gender + 
				"\nExercise: " + exercise; 
		return s;
	}
	public int getID(){
		return this.ID;
	}
	public String getEmail(){
		return this.email;
	}
	/**
	 * Get the user's name.
	 * @return User's name.
	 */
	public String getName(){
		return name;
	}
	/**
	 * Get the user's age.
	 * @return User's age.
	 */
	public int getAge(){
		return age;
	}
	/**
	 * Get the user's height in cm.
	 * @return User's height in cm.
	 */
	public double getHeight(){
		return height;
	}
	/**
	 * Get the user's weight in kg.
	 * @return User's weight in kg.
	 */
	public double getWeight(){
		return weight;
	}
	/**
	 * Get the user's gender. 
	 * @return User's gender.
	 */
	public char getGender(){
		return gender;
	}
	/**
	 * Get the user's name.
	 * @return User's exercise per week.
	 */
	public int getExercise(){
		return exercise;
	}
	
	public MealPlanner getMealplan(){
		return plan;
	}

	/**
	 * Sets the user's name. If the user wishes to change it.
	 * @param name The user's new name.
	 */
	//use these setters if user changes age weight etc.
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * Sets the user's age. If the user wishes to change it.
	 * @param age The user's new age.
	 */
	public void setAge(int age){
		this.age = age;
	}
	/**
	 * Sets the user's height. If the user wishes to change it.
	 * @param height The user's new height.
	 */
	public void setHeight(double height){
		this.height = height;
	}
	/**
	 * Sets the user's weight. If the user wishes to change it.
	 * @param weight The user's new weight.
	 */
	public void setWeight(double weight){
		this.weight = weight;
	}
	/**
	 * Sets the user's gender. If the user wishes to change it.
	 * @param gender The user's new gender.
	 */
	public void setGender(char gender){
		this.gender = gender;
	}
	/**
	 * Sets the user's exercise level. If the user wishes to change it.
	 * @param exercise The user's new exercise level.
	 */
	public void setExercise(int exercise){
		this.exercise = exercise;
	}
	public void setPlan(MealPlanner plan){
		this.plan = plan;
	}
}
