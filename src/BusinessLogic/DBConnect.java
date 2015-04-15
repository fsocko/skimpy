/**
 * @author Ruaraidh, FPS, Greg
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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.json.JSONArray;
import org.json.JSONObject;

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
		try 
		{
			st.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		try {
				con.close();
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}

	
	public Food pullFood(String table, String ID)

	{
		openCon();
		Food returnedFood = null;
		try{
			
			String query = "select * FROM " + table + " WHERE ID=" + ID + ";";
//			System.out.println(query);
			rs = st.executeQuery(query);
			
			int DBID = -1;
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
				DBID = rs.getInt("ID");
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
			returnedFood = new Food(DBID, shopID, name, mass, unit, price, PPUPrice, PPUUnit,
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
	
	public Person pullUser(String ID)
	{
		openCon();
		try{
			Person user = null;
			boolean foundUser = false;
			System.out.println("Records from Database");
			rs = st.executeQuery("select * FROM user_info WHERE ID=" + ID);
			while (rs.next()){
				foundUser = true;
				String userName = rs.getString("UserName");
				String userEmail = rs.getString("UserEmail");
			    Date dob = rs.getDate("DateOfBirth");
				double weight = rs.getFloat("Weight");
				double height = rs.getFloat("Height");
				char gender = rs.getString("Gender").charAt(0);
				int exercise = rs.getInt("Exercise");
				
				user = new Person(userName, userEmail, "", dob, weight, height, gender, exercise);
			}
			if(foundUser){
				return user;
			}
			return null;
	
		} catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		finally 
		{
			closeCon();
		}
	}
		

	public void pushUser(Person user){
		try{
			String query = "INSERT INTO user_info (UserName, UserEmail, UserPassword, DateOfBirth, Height, Weight, Gender, Exercise)"
					+ "VALUES (\"" + 
							user.getName() +  "\", \"" + user.getEmail() + "\", \"" + user.getPassword() + "\", \""  +
							new java.sql.Date(user.getDob().getTime()) + "\", " + user.getHeight() + ", " + user.getWeight() + ", \"" + user.getGender() + "\", " + 
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

	public void recommend(String val, String coloumn)
	{
		openCon();
		try{
			 String query = "SELECT * FROM fooditems WHERE " + coloumn + " LIKE '" + val + "';";
		 
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
	
	public List<Food> productSearch(String phrase) {
		List<Food> results = new ArrayList<Food>();
		
		String[] words = phrase.split("\\s");
		String regexpPhrase = "";
		for (int i = 0; i < words.length - 1; i++) {
			regexpPhrase += words[i] + ".*";
		}
		regexpPhrase += words[words.length - 1];
		
		String tQuery = String.format(
			"SELECT DISTINCT * FROM tesco WHERE Name REGEXP ' %s | %s$' AND FoodCat2 REGEXP '%s' AND PPUUnit NOT LIKE 'NULL'",
			regexpPhrase, regexpPhrase, regexpPhrase);
		String sQuery = String.format(
			"SELECT DISTINCT * FROM sains WHERE Name REGEXP ' %s | %s$' AND FoodCat2 REGEXP '%s'",
			regexpPhrase, regexpPhrase, regexpPhrase);
		String query = tQuery + " UNION " + sQuery + " ORDER BY Price ASC";
		
		String moreGeneralQuery_1 = String.format(
			"SELECT DISTINCT * FROM tesco WHERE Name REGEXP ' %s | %s$' AND PPUUnit NOT LIKE 'NULL'",
			regexpPhrase, regexpPhrase);
		String moreGeneralQuery_2 = String.format(
			"SELECT DISTINCT * FROM sains WHERE Name REGEXP ' %s | %s$'",
			regexpPhrase, regexpPhrase);
		String moreGeneralQuery = moreGeneralQuery_1 + " UNION " + moreGeneralQuery_2
				+ " ORDER BY Price ASC";
		
		try {
			openCon();
			rs = st.executeQuery(query);
			if (rs.next()) {
				do {
					Food temp = new Food(
							rs.getInt("ID"),
							rs.getString("shopID"),
							rs.getString("Name"),
							rs.getDouble("Mass"),
							rs.getString("Unit"),
							rs.getDouble("Price"),
							rs.getDouble("PPUPrice"),
							rs.getString("PPUUnit"),
							rs.getString("FoodCat"),
							rs.getString("FoodCat2"),
							rs.getString("SuperMarket"),
							rs.getDouble("Calories"),
							rs.getDouble("Proteins"),
							rs.getDouble("Carbs"),
							rs.getDouble("Sugars"),
							rs.getDouble("Fats"),
							rs.getDouble("Saturates"),
							rs.getDouble("Fibre"),
							rs.getDouble("Salt"));
					
					results.add(temp);
				} while (rs.next());
			}
			else {
				rs = st.executeQuery(moreGeneralQuery);
				while (rs.next()) {
					Food temp = new Food(
							rs.getInt("ID"),
							rs.getString("shopID"),
							rs.getString("Name"),
							rs.getDouble("Mass"),
							rs.getString("Unit"),
							rs.getDouble("Price"),
							rs.getDouble("PPUPrice"),
							rs.getString("PPUUnit"),
							rs.getString("FoodCat"),
							rs.getString("FoodCat2"),
							rs.getString("SuperMarket"),
							rs.getDouble("Calories"),
							rs.getDouble("Proteins"),
							rs.getDouble("Carbs"),
							rs.getDouble("Sugars"),
							rs.getDouble("Fats"),
							rs.getDouble("Saturates"),
							rs.getDouble("Fibre"),
							rs.getDouble("Salt"));
					
					results.add(temp);
				}
			}
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		finally {
			closeCon();
		}
		return results;
	}
	
	public String fullSearch(String phrase) {
		JSONArray results = new JSONArray();
		
		String[] words = phrase.split("\\s");
		String regexpPhrase = "";
		for (int i = 0; i < words.length - 1; i++) {
			regexpPhrase += words[i] + ".*";
		}
		regexpPhrase += words[words.length - 1];
		
		String query = String.format("SELECT DISTINCT * FROM tesco WHERE Name REGEXP ' %s | %s$' AND PPUUnit NOT LIKE 'NULL' "
				+ "UNION "
				+ "SELECT DISTINCT * FROM sains WHERE Name REGEXP ' %s | %s$' ORDER BY Price ASC",
				regexpPhrase, regexpPhrase, regexpPhrase, regexpPhrase);
		
		/*String tQuery = String.format(
			"SELECT DISTINCT * FROM tesco WHERE Name REGEXP ' %s | %s$' AND FoodCat2 REGEXP '%s' AND PPUUnit NOT LIKE 'NULL'",
			regexpPhrase, regexpPhrase, regexpPhrase);
		String sQuery = String.format(
			"SELECT DISTINCT * FROM sains WHERE Name REGEXP ' %s | %s$' AND FoodCat2 REGEXP '%s'",
			regexpPhrase, regexpPhrase, regexpPhrase);
		String query = tQuery + " UNION " + sQuery + " ORDER BY Price ASC LIMIT 50";
		
		String moreGeneralQuery_1 = String.format(
			"SELECT DISTINCT * FROM tesco WHERE Name REGEXP ' %s | %s$' AND PPUUnit NOT LIKE 'NULL'",
			regexpPhrase, regexpPhrase);
		String moreGeneralQuery_2 = String.format(
			"SELECT DISTINCT * FROM sains WHERE Name REGEXP ' %s | %s$'",
			regexpPhrase, regexpPhrase);
		String moreGeneralQuery = moreGeneralQuery_1 + " UNION " + moreGeneralQuery_2
				+ " ORDER BY Price ASC LIMIT 50";
		*/
		try {
			openCon();
			rs = st.executeQuery(query);
			while (rs.next()) {
					JSONObject temp = new JSONObject();
					temp.put("name", rs.getString("Name").trim());
					temp.put("price", rs.getDouble("Price"));
					temp.put("shopID", rs.getString("ShopID").trim());
					temp.put("supermarket", rs.getString("SuperMarket"));
					temp.put("shelf", rs.getString("FoodCat2").trim());
					
					results.put(temp);
			}
			/*else {
				rs = st.executeQuery(moreGeneralQuery);
				while (rs.next()) {
					results.put(rs.getString(3).trim());
				}
			}*/
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		finally {
			closeCon();
		}
		return results.toString();
	}
	
	public String refinedSearch(String phrase, String[] categories) {
		JSONArray results = new JSONArray();
		
		String[] words = phrase.split("\\s");
		String regexpPhrase = "";
		for (int i = 0; i < words.length - 1; i++) {
			regexpPhrase += words[i] + ".*";
		}
		regexpPhrase += words[words.length - 1];
		
		String tQuery = "SELECT DISTINCT * FROM tesco WHERE ";
		String sQuery = "SELECT DISTINCT * FROM sains WHERE ";
		
		for (int i = 0; i < categories.length - 1; i++) {
			tQuery += String.format("PPUPrice NOT LIKE 'NULL' AND Name REGEXP ' %s | %s$' AND FoodCat2 LIKE '%s' OR ",
					regexpPhrase, regexpPhrase, categories[i]);
			sQuery += String.format("Name REGEXP ' %s | %s$' AND FoodCat2 LIKE '%s' OR ",
					regexpPhrase, regexpPhrase, categories[i]);
		}
		
		tQuery += String.format("PPUPrice NOT LIKE 'NULL' AND Name REGEXP ' %s | %s$' AND FoodCat2 LIKE '%s'",
				regexpPhrase, regexpPhrase, categories[categories.length - 1]);
		sQuery += String.format("Name REGEXP ' %s | %s$' AND FoodCat2 LIKE '%s' ",
				regexpPhrase, regexpPhrase, categories[categories.length - 1]);
		
		String query = tQuery + " UNION " + sQuery + " ORDER BY Price ASC";
		
		try {
			openCon();
			rs = st.executeQuery(query);
			while (rs.next()) {
				JSONObject temp = new JSONObject();
				temp.put("name", rs.getString("Name").trim());
				temp.put("price", rs.getDouble("Price"));
				temp.put("shopID", rs.getString("ShopID").trim());
				temp.put("supermarket", rs.getString("SuperMarket"));
				temp.put("shelf", rs.getString("FoodCat2").trim());
				
				results.put(temp);
			}
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		finally {
			closeCon();
		}
		
		return results.toString();
	}
	
	public String categorySearch(String phrase) {
		JSONArray results = new JSONArray();
		
		String[] words = phrase.split("\\s");
		String regexpPhrase = "";
		for (int i = 0; i < words.length - 1; i++) {
			regexpPhrase += words[i] + ".*";
		}
		regexpPhrase += words[words.length - 1];
		
		String tCatQuery = String.format(
				"SELECT FoodCat2 FROM tesco WHERE Name IN (SELECT Name FROM tesco WHERE Name REGEXP ' %s | %s$'AND PPUUnit NOT LIKE 'NULL') GROUP BY FoodCat ORDER BY COUNT(DISTINCT Name) DESC",
				regexpPhrase, regexpPhrase);
		String sainsCatQuery = String.format(
				"SELECT FoodCat2 FROM sains WHERE Name IN (SELECT Name FROM tesco WHERE Name REGEXP  '%s | %s$'AND PPUUnit NOT LIKE 'NULL') GROUP BY FoodCat ORDER BY COUNT(DISTINCT Name) DESC",
				regexpPhrase, regexpPhrase);
		
		try {
			openCon();
			rs = st.executeQuery(tCatQuery);
			while (rs.next()) {
				results.put(rs.getString(1).trim());
			}
			
			rs = st.executeQuery(sainsCatQuery);
			while (rs.next()) {
				results.put(rs.getString(1).trim());
			}
		}
		catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
		finally {
			closeCon();
		}
		
		return results.toString();
	}
}
