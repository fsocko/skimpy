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
	
	public void openCon()
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
	
	public void closeCon()

	{
//		System.out.println("Trying to close all connections to DB.");

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
//		finally{System.out.println("Connections closed.");}		
	}

	
	public Food pullFood(String table, String ID)

	{
		openCon();
		Food returnedFood = null;
		try{
			
			String query = "select * FROM " + table + " WHERE ShopID=" + ID + ";";
//			System.out.println(query);
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
				unit = rs.getString("Unit");
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
			closeCon();
			}
			
			return returnedFood;
	}

	//Push food object with nutrition data to DB
	public void pushFood(Food food, String tableName)
	{	
		openCon();
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
				closeCon();
			}
		}
	}
	
	public void pullUser(String ID)
	{
		openCon();
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
			closeCon();
		}
	}
		

	public void pushUser(Person user){
		try{
			String query = "INSERT INTO user_info (UserName, UserEmail, UserPassword, Age, Height, Weight, Gender, Exercise)"
					+ "VALUES (\"" + 
							user.getName() +  "\", \"" + user.getEmail() + "\", \"" + user.getPassword() + "\", "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() + ", \"" + user.getGender() + "\", " + 
							user.getExercise() + ")";
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
		} catch(Exception ex){
			System.out.println(ex);
		}
	}
	//I think this is unused
	public void findCat(String qu){
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
		    	 if(!temp.equals(name))
		    	 {
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
	
	

	public void pushPortionSizes(String table, String foodCat, String item, double mass, String unit)
	{
		openCon();
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
			closeCon();
		}
	}

	public void pullPortionSizes(String itemSearch)
	{
		openCon();
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
			closeCon();
		}
	}

	public ArrayList<Food> search(String table, String qu)
	{
		openCon();
		try{
			ArrayList<String> query = new ArrayList<String>();
			//exact match
			for(int i = 0; i < 1; i++){
				query.add("SELECT * FROM " + table + " WHERE Name = '" + qu + "';");;
			}
			for(int i = 0; i < 1; i++){
				query.add("SELECT * FROM " + table + " WHERE FoodCat2 = '" + qu + "';");
			}
			for(int i = 0; i < 1; i++){
				query.add("SELECT * FROM " + table + " WHERE FoodCat = '" + qu + "';");
			}
			if(qu.contains(" ")){
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE Name LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat2 LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE Name LIKE '%" + qu + "%';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat LIKE '%" + qu + "%';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat2 LIKE '%" + qu + "%';");
				}
			}
			else{
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE Name LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat2 LIKE '% " + qu + " %';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE Name LIKE '%" + qu + "%';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat LIKE '%" + qu + "%';");
				}
				for(int i = 0; i < 1; i++){
					query.add("SELECT * FROM " + table + " WHERE FoodCat2 LIKE '%" + qu + "%';");
				}
			}	
			
			Map<String, Integer> resultsHash = new HashMap<String, Integer>();
			ArrayList<String> results = new ArrayList<String>();
			String temp = "";
		    String nameID = "";
			for(String q: query){
				ResultSet rs = st.executeQuery(q);
			    while (rs.next()) {

			    	temp = nameID;
			    	nameID = rs.getString("ShopID");
			    	//stops duplicates
			    	if(!temp.equals(nameID)){
			    		results.add(nameID);
			    	}
			    }
			}
			
			
			Set<String> mySet = new HashSet<String>(results);
			for(String s: mySet){
				resultsHash.put(s, Collections.frequency(results, s));
			}
			
			List<Entry<String, Integer>> sortedRes = new ArrayList<Entry<String, Integer>>();
			sortedRes = entriesSortedByValues(resultsHash);

			ArrayList<Food> foodArr = new ArrayList<>();
			for (Map.Entry<String,Integer> entry : sortedRes) {
			    foodArr.add(pullFood(table, entry.getKey()));
			    
			}
			return foodArr;

		} catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		finally 
		{
			closeCon();
		}
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
	
	public void getFoodCategories(){
		openCon();
		try{
			String supermarket = "portion_sizes";
			String query = "select * FROM " + supermarket + 
						" ORDER BY " + supermarket + ".`FoodCat` ASC;";
			rs = st.executeQuery(query);
			
			ArrayList<String> categories = new ArrayList<>();
			String temp = "";
			String cat = "";
			while(rs.next())
			{	
				cat = rs.getString("FoodCat");
//				System.out.println(cat);
//				System.out.println(temp);
//				
				if(!temp.equals(cat)){
					categories.add(cat);
				}	
				temp = cat;
			}
			temp = "";
			rs = st.executeQuery("SELECT * FROM " + supermarket + 
								" ORDER BY " + supermarket + ".`Item` ASC");
			for(String s: categories){
				System.out.println("> " + s);
				rs = st.executeQuery("SELECT * FROM " + supermarket + " WHERE FoodCat = '" + s + "'"
						+ " ORDER BY " + supermarket + ".`Item` ASC;");
				
				while(rs.next()){
					cat = rs.getString("Item");
					if(!temp.equals(cat)){
						System.out.println("\t * " + cat);
					}
					temp = cat;
				}
			}
			
		} 
		catch(Exception ex) 
		{
			System.out.println("Error:"+ex );	
		}	
		//close connections.
		finally 
		{
			closeCon();
		}	
	}
	
	public void DBmanip(){
		openCon();
		try{
			
			ArrayList<String> query = new ArrayList<String>();
			
			query.add("UPDATE tesco set FoodCat = LTRIM(RTRIM(FoodCat))");
			query.add("UPDATE asda set FoodCat = LTRIM(RTRIM(FoodCat))");
			query.add("UPDATE sains set FoodCat = LTRIM(RTRIM(FoodCat))");
			query.add("UPDATE tesco set FoodCat2 = LTRIM(RTRIM(FoodCat))");
			query.add("UPDATE asda set FoodCat2 = LTRIM(RTRIM(FoodCat))");
			query.add("UPDATE sains set FoodCat2 = LTRIM(RTRIM(FoodCat))");
			
			//Change Portion Categories
			query.add("UPDATE portion_sizes SET FoodCat = 'Bakery' WHERE FoodCat = 'Bakery Products';");
			query.add("UPDATE portion_sizes SET FoodCat = 'Cereals and Grains' WHERE FoodCat = 'Cereals and Other Grain Products';");
			
		//BAKERY
		/**TESCO**/
			
			//Baguettes
			query.add("UPDATE tesco SET FoodCat = 'Baguettes' WHERE "
					+ "FoodCat2 = 'Part Baked Bread';");
			
			//Change bread rolls & bagels to suit
			query.add("UPDATE tesco SET FoodCat = 'Rolls & Bagels' WHERE FoodCat = 'Bread Rolls & Bagels';");
			
			
		/**ASDA**/

			query.add("UPDATE asda SET FoodCat2 = FoodCat;");
			
			//Match Tesco Categories
			
			//Baguettes
			query.add("UPDATE asda SET FoodCat = 'Baguettes' WHERE "
				+ "FoodCat2 = 'Baguettes & Slices' OR "
				+ "FoodCat2 = 'Baguettes & Speciality Bread';");
			
			//Bread
			query.add("UPDATE asda SET FoodCat = 'Bread' WHERE "
				+ "FoodCat2 = 'Bread' OR "
				+ "FoodCat2 = 'Brown Bread' OR "
				+ "FoodCat2 = '50/50 Bread';");
			
			//Croissants, Brioche & Pain au Chocolat
			query.add("UPDATE asda SET FoodCat = 'Croissants, Brioche & Pain au Chocolat' WHERE "
				+ "FoodCat2 = 'Brioche' OR "
				+ "FoodCat2 = 'Croissants & Pain au Chocolat';");

			//Fresh Bakery
			query.add("UPDATE asda SET FoodCat = 'Fresh Bakery' AND FoodCat2 = 'Fresh Bread' WHERE "
					+ "FoodCat2 = 'In Store Bakery Bread';");
			query.add("UPDATE asda SET FoodCat = 'Fresh Bakery' AND FoodCat2 = 'Fresh Muffins & Pancakes' WHERE "
					+ "FoodCat2 = 'In Store Bakery Muffins & Pancakes';");
			query.add("UPDATE asda SET FoodCat = 'Fresh Bakery' AND FoodCat2 = 'Fresh Pastries & Brioche' WHERE "
					+ "FoodCat2 = 'In Store Bakery Pastries & Brioche';");
			query.add("UPDATE asda SET FoodCat = 'Fresh Bakery' AND FoodCat2 = 'Fresh Rolls & Bagels' WHERE "
					+ "FoodCat2 = 'Rolls & Bagels';");

			//Rolls & Bagels 
			query.add("UPDATE asda SET FoodCat = 'Roll & Bagels' WHERE "
				+ "FoodCat2 = 'Bagels' OR "
				+ "FoodCat2 = 'Bread Rolls' OR "
				+ "FoodCat2 = 'Rolls & Bagels';");
			
			//Tea Cakes, Fruit Loaves & Scones
			query.add("UPDATE asda SET FoodCat = 'Tea Cakes, Fruit Loaves & Scones' WHERE "
					+ "FoodCat2 = 'Fruit Loaves and Teacakes' OR "
					+ "FoodCat2 = 'Bread Rolls' OR "
					+ "FoodCat2 = 'Scones';");
			
			//Wraps, Pitta, Naan & Thins
			query.add("UPDATE asda SET FoodCat = 'Wraps, Pitta, Naan & Thins' WHERE "
					+ "FoodCat2 = 'Wraps' OR "
					+ "FoodCat2 = 'Pittas' OR "
					+ "FoodCat2 = 'Thin Pizza' OR "
					+ "FoodCat2 = 'Speciality Bread' OR "
					+ "FoodCat2 = 'Speciality Breads';");
		
			
		//CAKES
			
			//Crumpets, Muffins & Pancakes
			query.add("UPDATE asda SET FoodCat = 'Crumpets, Muffins & Pancakes' WHERE "
					+ "FoodCat2 = 'Crumpets and Muffins';");
			
			for(String s : query){
				st.executeUpdate(s);
			}
			
		} 
		catch(Exception ex) 
		{
			System.out.println("Error:"+ex );	
		}	
		//close connections.
		finally 
		{
			closeCon();
		}	
	}
	
	public void setPortCat(){
		openCon();
		try{
			ArrayList<String> query = new ArrayList<String>();
			
			//Bakery
			query.add("UPDATE tesco SET PortCat = 'Bakery' AND "
					+ "PortCat2 = 'Bagels, tea biscuits, scones, rolls, buns, croissants, tortillas, soft bread sticks, soft pretzels, corn bread' WHERE "
					
					+ "FoodCat = 'Baguettes' OR "
					+ "FoodCat = 'Bread' OR "
					+ "FoodCat = 'Croissants, Brioche & Pain au Chocolat' OR "
					+ "FoodCat = 'Rolls & Bagels' OR "
					+ "FoodCat = 'Tea Cakes, Fruit Loaves & Scones"
					+ "FoodCat = 'Wraps, Pitta, Naan & Thins' OR "
					
					+ "FoodCat2 = 'Free From Bread' OR "
					+ "FoodCat2 = 'Free From Tea Cakes, Fruit Loaves & Scones' OR "
					+ "FoodCat2 = 'Free From Wraps, Bagels, Pitta & Crumpets' OR "
					+ "FoodCat2 = 'Fresh Brown & Granary Bread' OR "
					+ "FoodCat2 = 'Fresh Croissants & Pastries' OR "
					+ "FoodCat2 = 'Fresh French Bread & Rolls' OR "
					+ "FoodCat2 = 'Fresh Organic Bakery' OR "
					+ "FoodCat2 = 'Fresh Speciality Bread' OR "
					+ "FoodCat2 = 'Fresh Tea Cakes & Scones' OR"
					+ "FoodCat2 = 'Fresh White Bread';");	
			
			query.add("UPDATE asda SET PortCat = 'Bakery' AND "
					+ "PortCat2 = 'Bagels, tea biscuits, scones, rolls, buns, croissants, tortillas, soft bread sticks, soft pretzels, corn bread' WHERE "
					
					+ "FoodCat = 'Baguettes' OR "
					+ "FoodCat = 'Bread' OR "
					+ "FoodCat = 'Croissants, Brioche & Pain au Chocolat' OR "
					+ "FoodCat = 'Rolls & Bagels' OR "
					+ "FoodCat = 'Tea Cakes, Fruit Loaves & Scones"
					+ "FoodCat = 'Wraps, Pitta, Naan & Thins' OR "
					
					+ "FoodCat2 = 'Fresh Bread' OR "
					+ "FoodCat2 = 'Fresh Rolls & Bagels';");
			
			// MED CAKE
//			+ "FoodCat = 'Crumpets, Muffins & Pancakes' OR "

			
				
			
			for(String s : query){
				st.executeUpdate(s);
			}
			
		} 
		catch(Exception ex) 
		{
			System.out.println("Error:"+ex );	
		}	
		//close connections.
		finally 
		{
			closeCon();
		}	
	}
	
	public void servingSizes(){
		openCon();
		try{
			ArrayList<String> query = new ArrayList<String>();
			
			
			for(String s : query){
				st.executeUpdate(s);
			}
			
		} 
		catch(Exception ex) 
		{
			System.out.println("Error:"+ex );	
		}	
		//close connections.
		finally 
		{
			closeCon();
		}	
	}
	
	public void recommend(String val, String coloumn)
	{
		openCon();
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
			closeCon();
		}
	}
	
}
