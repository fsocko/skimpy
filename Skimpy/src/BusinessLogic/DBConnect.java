/**
 * @author Ruaraidh, FPS
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import com.mysql.jdbc.*;

public class DBConnect extends HttpServlet{
	private Connection con;
	private Statement st;
	private ResultSet rs;
	//default, no args goes to Skimpy
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
	
	//fairly sure this won't work since ID is saved as an int in SQLDB
	public Food getFoodData(String ID){
		try{
			rs = st.executeQuery("select * FROM fooditems WHERE ID=" + ID + ";");
			
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
		pushFood(food, "Skimpy");
	}
	
	public void pushFood(DBFood food, String table)
	{
		
		if(food != null)
		{
			try{
					String query = "insert into " + table +"(shopID, Name, Units, Mass, Price, PricePUnit, FoodCat)"
							+ " values(\" " + 
									food.getShopID() + "\", \"" + food.getName() + "\", \"" + food.getUnit() + "\", "  +
									food.getMass() + ", " + food.getPrice() + ", \"" + food.getPricePU() + "\", \"" + 
									food.getFoodCat() + "\");";
					
					
					st.executeUpdate(query);
					System.out.println("Pushes to Database\n\n");
							
					
				}catch(Exception ex){
					System.out.println(ex);
				}
			}
		}
		
	//Push food object with nutrition data to DB
	public void pushFoodN(DBFood food, String table)
	{
		if(food != null)
		{
			try{
					
					String query = "insert into " + table +"(shopID, Name, Unit, Mass, Price, PPUPrice, PPUUnit, FoodCat, Calories, Proteins, Carbs, Sugars, Fats, Saturates, Salt, Fibre)"
							+ " values(\" " + food.getShopID() + "\", \"" + food.getName() + "\", \"" + food.getUnit() + "\", \"" + food.getMass()  + "\", \"" + food.getPrice() + "\", \"" + food.getPricePU() + "\", \"" + food.getPPUUnit() + "\", \"" + food.getFoodCat() + "\", \"" + food.getCalories() + "\", \"" + food.getProteins() + "\", \"" + food.getCarbs() + "\", \"" + food.getSugars() + "\", \"" + food.getFats() + "\", \"" + food.getSaturates() + "\", \"" + food.getSalt() + "\", \"" + food.getFibre()+ "\");";
					
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
			String query = "INSERT INTO user_info (UserName, UserEmail, Age, Height, Weight, Gender, Exercise)"
					+ "VALUES (\"" + 
							user.getName() +  "\", \"" + user.getEmail() + "\", "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() + ", \"" + user.getGender() + "\", " + 
							user.getExercise() + ")";
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void pushPortionSizes(String foodCat, String item, int mass, String unit){
		try{
			String query = "INSERT INTO food_db (FoodCat, Item, Mass, Unit)VALUES (\"" + 
							foodCat +  "\", \"" + item + "\", "  + mass + ", " + unit  + ")";
			st.executeUpdate(query);
			System.out.println("Pushed Portion Sizes");
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void getPortionSizes(String itemSearch){
		try{
			System.out.println("Records from Database:");
			rs = st.executeQuery("select * FROM user_info WHERE item=" + itemSearch);
			while (rs.next()){
				String foodCat = rs.getString("FoodCat");
				String item = rs.getString("Item");
				int mass = rs.getInt("Mass");
				String unit = rs.getString("Unit");
				
				System.out.println("Food Cat: "  + foodCat + 
									"\nItem: " + item + 
									"\nMass: " + mass + 
									"\nUnit: " + unit);
			}
	
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void search(String qu){
		try{
			 String query ="SELECT * FROM sains_scraped WHERE name LIKE '%" + qu + " %';";
		 
		     ResultSet rs = st.executeQuery(query);
		     String temp = "";
		     String name = "";
		     boolean found = false;
		     while (rs.next()) {
		    	 found = true;
		    	 temp = name;
		    	 name = rs.getString("name");
		    	 if(!temp.equals(name)){
		    		 System.out.println(name+"  ");
		    	 }
		     }
		     if(!found){
		    	 System.out.println("No results for query: " + qu);
		     }
		     System.out.println();
			 
		} catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public void recommend(String val, String coloumn){
		try{
			 String query ="SELECT * FROM fooditems WHERE " + coloumn + " LIKE '" + val + "';";
		 
		     ResultSet rs = st.executeQuery(query);
		     String temp = "";
		     String name = "";
		     boolean found = false;
		     while (rs.next()) {
		    	 found = true;
		    	 temp = name;
		    	 name = rs.getString("name");
		    	 if(!temp.equals(name)){
		    		 System.out.println(name+"  ");
		    	 }
		     }
		     if(!found){
		    	 System.out.println("No results for query: " + val);
		     }
		     System.out.println();
			 
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

}