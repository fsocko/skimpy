/**
 * @author Ruaraidh, FPS
 */
package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
		}
		catch(Exception ex)
		{
			System.out.println("Error:"+ex );
		}
	}
	
	public void closeConnections()
	{
		try 
		{
			rs.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			st.close();
		} 
		catch (SQLException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
				con.close();
			} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	public Food pullFood(String table, int ID)
	{
		Food returnedFood = null;
		try{
			
			String query = "select * FROM " + table + " WHERE ID=" + ID + ";";
			System.out.println(query);
			rs = st.executeQuery(query);
			
			String shopID = null;
			String name = null;
			double mass = -1;
			String unit = null;
			double price = -1;
			double PPUPrice = -1;
			String PPUUnit = null;
			String foodCat = null;
			String foodCat2 = null;
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
				shopID = rs.getString("shopID");
				name = rs.getString("Name");
				unit = rs.getString("Units");
				mass = rs.getDouble("Mass");
				price = rs.getDouble("Price");
				PPUPrice = rs.getDouble("PPUPrice");
				PPUUnit = rs.getString("PPUUnit");
				foodCat = rs.getString("FoodCat");
				foodCat2 = rs.getString("FoodCat2");
				supermarket = rs.getString("SuperMarket");
				calories = rs.getDouble("Calories");
				proteins = rs.getDouble("Proteins");
				carbs = rs.getDouble("Carbs");
				sugars = rs.getDouble("Sugars");
				fats = rs.getDouble("Fats");
				saturates = rs.getDouble("Saturates");
				salt = rs.getDouble("Salt");
				fibre = rs.getDouble("Fibre");
				}
			returnedFood = new Food(shopID, name, mass, unit, price, PPUPrice, PPUUnit,
									foodCat, foodCat2, supermarket, calories, proteins, carbs, sugars,
									fats, saturates, fibre, salt);	
			
		} 
		catch(Exception ex) 
		{
			System.out.println("Error:"+ex );	
		}	
		//close connections.
		finally 
		{
			closeConnections();
		}

		return returnedFood;	
	}	
		
	//Push food object with nutrition data to DB
	public void pushFood(Food food, String tableName)
	{
		if(food != null)
		{
			try{
				String query = "insert into " + tableName 
								+ "(shopID, Name, Unit, Mass, Price, PPUPrice, PPUUnit, FoodCat, FoodCat2, Supermarket,"
								+ " Calories, Proteins, Carbs, Sugars, Fats, Saturates, Salt, Fibre)"
								+ " values(\" " + food.getShopID() + "\", \"" + food.getName() + "\", \"" 
								+ food.getUnit() + "\", \"" + food.getMass()  + "\", \"" + food.getPrice() 
								+ "\", \"" + food.getPricePU() + "\", \"" + food.getPPUUnit() + "\", \"" 
								+ food.getFoodCat() + "\", \"" + food.getFoodCat2() + "\", \"" + food.getSupermarket() + "\", \"" 
								+ food.getCalories() + "\", \"" + food.getProteins() + "\", \"" 
								+ food.getCarbs() + "\", \"" + food.getSugars() + "\", \"" 
								+ food.getFats() + "\", \"" + food.getSaturates() + "\", \"" 
								+ food.getSalt() + "\", \"" + food.getFibre()+ "\");";

				st.executeUpdate(query);
				System.out.println("Pushes to Database\n\n");
							
			} catch(Exception ex){
					System.out.println(ex);
			}
			finally 
			{
				closeConnections();
			}
		}
	}
	
	public void pullUser(String ID)
	{
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
	
		} catch(Exception ex){
			System.out.println(ex);
		}
		finally 
		{
			closeConnections();
		}
	}
		
	public void pushUser(Person user)
	{
		try{
			String query = "INSERT INTO \"user_info\" (\"UserName\", \"UserEmail\", \"Age\", \"Height\","
							+ " \"Weight\", \"Gender\", \"Exercise\")"+ "VALUES (\"" 
							+ user.getName() +  "\", \"" + user.getEmail() + "\", "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() 
							+ ", \"" + user.getGender() + "\", " + user.getExercise() + ")";
			
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
		} catch(Exception ex){
			System.out.println(ex);
		}
	}

	public void pushPortionSizes(String table, String foodCat, String item, double mass, String unit)
	{
		try{
			String query = "INSERT INTO "+ table +" (FoodCat, Item, Mass, Unit) VALUES (\"" + 
							foodCat +  "\", \"" + item + "\", \""  + mass + "\", \"" + unit  + "\");";
			
			System.out.println(query);
			st.executeUpdate(query);
			System.out.println("Pushed Portion Sizes");
			
		} catch(Exception ex){
			System.out.println(ex);
		}
		finally 
		{
			closeConnections();
		}
	}
	public void pullPortionSizes(String itemSearch)
	{
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
	
		} catch(Exception ex){
			System.out.println(ex);
		}
		finally 
		{
			closeConnections();
		}
	}
	public void search(String qu)
	{
		try{
			ArrayList<String> query = new ArrayList<String>();
			query.add("SELECT * FROM tesco WHERE Name = '" + qu + "';");
			query.add("SELECT * FROM tesco WHERE FoodCat = '" + qu + "';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 = '" + qu + "';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 = '" + qu + "';");
			query.add("SELECT * FROM tesco WHERE Name LIKE '% " + qu + " %';");
			query.add("SELECT * FROM tesco WHERE FoodCat LIKE '% " + qu + " %';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 LIKE '% " + qu + " %';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 LIKE '% " + qu + " %';");
			query.add("SELECT * FROM tesco WHERE Name LIKE '%" + qu + "%';");
			query.add("SELECT * FROM tesco WHERE FoodCat LIKE '%" + qu + "%';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 LIKE '%" + qu + "%';");
			query.add("SELECT * FROM tesco WHERE FoodCat2 LIKE '%" + qu + "%';");
			
			Map<String, Integer> resultsHash = new HashMap<String, Integer>();
			ArrayList<String> results = new ArrayList<String>();
			String temp = "";
		    String name = "";
			for(String q: query){
				ResultSet rs = st.executeQuery(q);
			    while (rs.next()) {

			    	temp = name;
			    	name = rs.getString("Name");
			    	//stops duplicates
			    	if(!temp.equals(name)){
			    		results.add(name);
//			    		System.out.println(name);
			    	}
			    }
			   
			    
			    System.out.println();
			}
			
			
			Set<String> mySet = new HashSet<String>(results);
			for(String s: mySet){
				resultsHash.put(s, Collections.frequency(results, s));
			}
	
			
			List<Entry<String, Integer>> sortedRes = new ArrayList<Entry<String, Integer>>();
			sortedRes = entriesSortedByValues(resultsHash);
			System.out.println(sortedRes);
//			for (Map.Entry<String,Integer> entry : sortedRes) {
//			    if (entry.getValue() == 1) {
//			        System.out.println(entry);
//			    }
//			}
		} catch(Exception ex){
			System.out.println(ex);
		}
//		finally 
//		{
//			closeConnections();
//		}
	}
	static <K,V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K,V> map) {
	
		List<Entry<K,V>> sortedEntries = new ArrayList<Entry<K,V>>(map.entrySet());
	
		Collections.sort(sortedEntries, new Comparator<Entry<K,V>>() {@Override public int compare(Entry<K,V> e1, Entry<K,V> e2) 
			{
				return e2.getValue().compareTo(e1.getValue());
			}
	    });
	
		return sortedEntries;
	}
	
	public void recommend(String val, String coloumn)
	{
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
		finally 
		{
			closeConnections();
		}
	}
	
}
