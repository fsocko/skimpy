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
	
	
	public Food getFoodDataN(String table, int ID){
		try{
			
			String query = "select * FROM " + table + "WHERE ID=" + ID + ";";
			System.out.println(query);
			rs = st.executeQuery(query);
			
			int ID = -1.69;
			String shopID = null;
			String name = null;
			double mass = -1;
			String unit = null;
			double price = -1;
			double pricePU = -1;
			String PPUUnit = null;
			String foodCat = null;
			String supermarket = "X";
			double calories = -1;
			double proteins = -1;
			double carbs = -1;
			double sugars = -1;
			double fats = -1;
			double saturates = -1;
			double fibre = -1;
			double salt = -1;
			
			while(rs.next())
			{
				
				ID = rs.getInt("ID");
				shopID = rs.getString("shopID");
				name = rs.getString("Name");
				unit = rs.getString("Units");
				mass = rs.getDouble("Mass");
				price = rs.getDouble("Price");
				PPUPrice = rs.getDouble("PPUPrice");
				PPUUnit = rs.getString("PPUUnit");
				foodCat = rs.getString("FoodCat");
				supermarket = rs.getChar("SuperMarket");
				calories = rs.getDouble("Calories");
				proteins = rs.getDouble("Proteins");
				carbs = rs.getDouble("Carbs");
				sugars = rs.getDouble("Sugars");
				fats = rs.getDouble("Fats");
				saturates = rs.getDouble("Saturates");
				salt = rs.getDouble("Salt");
				fibre = rs.getDouble("Fibre");
			}
			
		}
		
	}	
	
	public void pushFood(DBFood food)
	{
		pushFoodN(food, "skimpy");
	}
	
	
		
	//Push food object with nutrition data to DB
	public void pushFoodN(DBFood food, String dataBaseName)
	{
		if(food != null)
		{
			try{
					
					String query = "insert into " + dataBaseName +"(shopID, Name, Unit, Mass, Price, PPUPrice, PPUUnit, FoodCat, Supermarket, Calories, Proteins, Carbs, Sugars, Fats, Saturates, Salt, Fibre)"
							+ " values(\" " + food.getShopID() + "\", \"" + food.getName() + "\", \"" + food.getUnit() + "\", \"" + food.getMass()  + "\", \"" + food.getPrice() + "\", \"" + food.getPricePU() + "\", \"" + food.getPPUUnit() + "\", \"" + food.getFoodCat() + "\", \""  + food.getSupermarket() + "\", \"" + food.getCalories() + "\", \"" + food.getProteins() + "\", \"" + food.getCarbs() + "\", \"" + food.getSugars() + "\", \"" + food.getFats() + "\", \"" + food.getSaturates() + "\", \"" + food.getSalt() + "\", \"" + food.getFibre()+ "\");";
					System.out.println(query);
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
			String query = "INSERT INTO \"user_info\" (\"UserName\", \"UserEmail\", \"Age\", \"Height\", \"Weight\", \"Gender\", \"Exercise\")"
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

	public void pushPortionSizes(String table, String foodCat, String item, double mass, String unit){
		try{
			String query = "INSERT INTO "+ table +" (FoodCat, Item, Mass, Unit) VALUES (\"" + 
							foodCat +  "\", \"" + item + "\", \""  + mass + "\", \"" + unit  + "\");";
			System.out.println(query);
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
