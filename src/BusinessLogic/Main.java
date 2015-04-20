package BusinessLogic;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServlet;

/**
 * @author ruaraidh, FPS, Lee
 */
/**
 * Main class that brings all the other classes together.
 */
public class Main extends HttpServlet{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
			
		DBConnect con = new DBConnect();
		SpiderToDB std = new SpiderToDB();
		pushToDB(std.asdaPath, "asda");
		
		/*
		Person user = con.pullUser("35");
		
		user.setHeight(170.00);
		System.out.println(user.getID());
		con.updateUser(user);

		System.out.println(con.pullUser("35").getHeight());
		*/
				
	}
	
	public static void testXML() {
		XMLParser writeX = new XMLParser();
		ArrayList<Food> ing1 = new ArrayList<Food>();
		ing1.add(new Food(1290, "tesco", null, 0, null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0));
		ing1.add(new Food(1212, "tesco", null, 0, null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0));
		ArrayList<Food> ing2 = new ArrayList<Food>();
		ing2.add(new Food(120, "tesco", null, 0, null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0));
		ing2.add(new Food(340, "tesco", null, 0, null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0));
		ing2.add(new Food(109, "tesco", null, 0, null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0));
		ArrayList<Meal> meals = new ArrayList<Meal>();
//		meals.add(new Meal("Cereal", ing1));
//		meals.add(new Meal("Lunch", ing2));
//		meals.add(new Meal("Dinner", ing2));
		ArrayList<MealPlanner> mps = new ArrayList<MealPlanner>();
//		for (int i = 0; i < 2; i++) {
//		MealPlanner mp = new MealPlanner();
//		String[] dayValues = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//		String[] timeValues = {"Breakfast", "Lunch", "Dinner"};
//		for (String s: dayValues) {
//			int j = 0;
//			for (String t: timeValues) {
//				mp.add(meals.get(j), s, t);
//				j++;
//			}
//		}
//		mps.add(mp);
//		}
		//writeX.writeMealPlans(mps, getServletContext().getRealPath("") + "/meals.xml");
	}
	
	
//	public static Meal createMeal()
//	{
//		ArrayList<Food> ingredients = new ArrayList<Food>();
//		ingredients.add(pullFromDB("tesco", "3057"));
//		ingredients.add(pullFromDB("tesco", "3806"));
//		ingredients.add(pullFromDB("tesco", "3897"));
//		Meal currentMeal = new Meal("Tuna Dinner", ingredients);
//		return currentMeal;
//	}
	
	//Ruaraidh's test for search
	public static void printFoodListSearch(ArrayList<Food> list){
		for(Food f : list){
			System.out.println(f.getName());
		}

	}
	//return URL
	public static String getURL(Food input)
	{
		String supermarket = input.getSupermarket().trim();
		String shopID = input.getShopID().trim();
		String url = "";
		if(supermarket.toUpperCase().equals("T"))
		{url = "http://www.tesco.com/groceries/product/details/?id=";}
		else if(supermarket.toUpperCase().equals("S"))
		{url = "";}	
		else if(supermarket.toUpperCase().equals("A"))
		{url = "";}
		else{return null;}

		return url;
		
	}
	
	public static void portionSizeToDB(String db, String table)
	{
		
		SpiderToDB std = new SpiderToDB();
		DBConnect dbCon = new DBConnect();
		@SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList portions = new ArrayList(std.readAllRecords(std.portionPath));
		
		int i = 1;
		while(i < std.countLines(std.portionPath))
		{
			System.out.println("\n i is:" + i + "\n");
			System.out.println(portions.get(i).toString().trim());
			PortionSize portion = std.parsePortion(portions.get(i).toString().trim());
			System.out.println(portion.toString());
			dbCon.pushPortionSizes("portion_sizes", portion.getFoodCat(), portion.getFoodItem(), portion.getMass(), portion.getUnit());
			i++;
		}
	}
	

	public static void pushToDB(String path, String table)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect();
		ArrayList Items = new ArrayList(std.readAllRecords(path));
		
		int i = 1;
		int t = std.countLines(path);
		while(i < t){
			System.out.println("\n i is:" + i + "\n");
			Food foodItem = std.formatRecord(path, Items.get(i).toString().trim());

			if(foodItem != null)
			{
				System.out.println(foodItem.toString());
				toDB.pushFood(foodItem, table);
			}
			i++;
		}
	}
	
	public static Food pullFromDB(String table, String ID)
	{
		DBConnect pullDB = new DBConnect();
		return pullDB.pullFood(table, ID);
	}
	

}
