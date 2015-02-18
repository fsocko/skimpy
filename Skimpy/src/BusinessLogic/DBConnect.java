/**
 * @author Ruaraidh, FPS
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.*;

public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	//@alinauyazina: I'm getting an SQL error: too many connections. Could you have a look and fix the DBConnect and pushFood methods?
	public DBConnect()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Skimpy", "root", "");
			st = (Statement) con.createStatement();
		}catch(Exception ex){
			System.out.println("Error:"+ex );
			
		}
	}
	
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
	
	public Food getFoodData(String ID){
		try{
			rs = st.executeQuery("select * FROM fooditems WHERE ID=" + ID);
			
			String name = null;
			String units = null;
			int amount = 0;
			double serving = 0;
			double tescoPrice = 0;
			double asdaPrice = 0;
			double calories = 0;
			double protein = 0;
			double carbs = 0;
			double sugars = 0;
			double fats = 0;
			double saturates = 0;
			double fibre = 0;
			double salt = 0;	
			
			while (rs.next()){
				name = rs.getString("Name");
				units = rs.getString("Units");
				amount = rs.getInt("Amount");
				serving = rs.getDouble("Serving");
				tescoPrice = rs.getDouble("tesco_price");
				asdaPrice = rs.getDouble("asda_price");
				calories = rs.getDouble("Calories");
				protein = rs.getDouble("Protein");
				carbs = rs.getDouble("Carbs");
				sugars = rs.getDouble("Sugars");
				fats = rs.getDouble("Fat");
				saturates = rs.getDouble("Saturates");
				fibre = rs.getDouble("Fibre");
				salt = rs.getDouble("Salt");		
			}
			
			Food item = new Food(name, units, amount, serving, tescoPrice, asdaPrice, calories, protein, carbs, sugars, fats, saturates, fibre, salt);
			return item;
		
		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
	
	
	public void pushFood(DBFood food)
	{
		pushFood(food, "skimpy");
	}
	
	public void pushFood(DBFood food, String dataBaseName)
	{
		
		if(food != null)
		{
			try{
					
					String query = "insert into " + dataBaseName +"(shopID, Name, Units, Mass, Price, PricePUnit, FoodCat)"
							+ " values( '" + 
									food.getShopID() + "', '" + food.getName() + "', '" + food.getUnit() + "', "  +
									food.getMass() + ", " + food.getPrice() + ", '" + food.getPricePU() + "', '" + 
									food.getFoodCat() + "');";
					
					
					st.executeUpdate(query);
					System.out.println("Pushes to Database\n\n");
							
					
				}catch(Exception ex){
					System.out.println(ex);
				}
			}
		}
		
		
		
	public void getUserData(String ID){
		try{
			System.out.println("Records from Database");
			rs = st.executeQuery("select * FROM user_info WHERE ID=" + ID);
			while (rs.next()){
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
			String query = "INSERT INTO `user_info`(`UserName`, `UserEmail`, `Age`, `Height`, `Weight`, `Gender`, `Exercise`) "
					+ "VALUES ('" + 
							user.getName() +  "', '" + user.getEmail() + "', "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() + ", '" + user.getGender() + "', " + 
							user.getExercise() + ")";
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

}
