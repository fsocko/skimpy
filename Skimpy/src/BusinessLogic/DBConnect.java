//author: Ruaraidh, FPS

package BusinessLogic;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.*;


public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect(String db) //db is the name of the database.
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ db, "root", "");
			st = (Statement) con.createStatement();
		}catch(Exception ex){
			System.out.println("Error:"+ex );
		}
	}

	public void getFoodData(String table){ //table is the name of the table within the database db
		try{
			String query = "select * FROM " + table + ";";
			rs = st.executeQuery(query);
			System.out.println("Records from Database");
			while (rs.next()){
				int ID = rs.getInt("ID");
				String name = rs.getString("Name");
				String units = rs.getString("Units");
				int amount = rs.getInt("Amount");
				double serving = rs.getDouble("Serving");
				double price = rs.getDouble("Price");
				double calories = rs.getDouble("Calories");
				double protein = rs.getDouble("Protein");
				double carbs = rs.getDouble("Carbs");
				double sugars = rs.getDouble("Sugars");
				double fats = rs.getDouble("Fat");
				double saturates = rs.getDouble("Saturates");
				double fibre = rs.getDouble("Fibre");
				double salt = rs.getDouble("Salt");
				
				System.out.println( "Name: " + name + "Units " + units + " Amount: " + amount + " Serving " + serving + " Price " + price + " Calories " + calories + " Protein "+ protein + "Carbs " +carbs + "Sugars " +sugars + " Farts " +fats + " Saturates "+ saturates +" Fibre " + fibre + " Salt " + salt);
			}
	
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	
	public void getUserData(String table){
		try{
			String query = "select * FROM " + table + ";";
			System.out.println("Records from Database");
			rs = st.executeQuery(query);
			while (rs.next()){
			
				String ID = rs.getString("userID");
				String userName = rs.getString("UserName");
				String userEmail = rs.getString("UserEmail");
				int age = rs.getInt("Age");
				float weight = rs.getFloat("Weight");
				String gender = rs.getString("Gender");
				float exercise = rs.getFloat("Exercise");
				
				System.out.println(ID + userName + userEmail + age + weight + gender + exercise);
			}
	
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
		
	public void pushUser(Person user){
		try{
			String query = "insert into  User_Info (UserId, UserName,UserEmail, Age, Height, Weight, Gender, Exercise) values (" + 
							user.getName() + ", '" + user.getName() + "', '" + user.getEmail() + "', "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() + ", '" + user.getGender() + "', " + 
							user.getExercise() + ");";
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
			while (rs.next()){
				String name = rs.getString("UserName");
				String age = rs.getString("Age");
				String email = rs.getString("UserEmail");
				System.out.println("User name: "+ name+ ", User age: "+age+", User e-mail: "+email);
			}
					
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
