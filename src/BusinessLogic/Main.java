package BusinessLogic;
import java.util.ArrayList;
import javax.servlet.http.HttpServlet;

/**
 * @author ruaraidh
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
	}
	
	public static Meal createMeal()
	{
		ArrayList<Food> ingredients = new ArrayList<Food>();
		ingredients.add(pullFromDB("tesco", "3057"));
		ingredients.add(pullFromDB("tesco", "3806"));
		ingredients.add(pullFromDB("tesco", "3897"));
		
		Meal currentMeal = new Meal("Tuna Dinner", ingredients);
		return currentMeal;
	}
	
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
		while(i < std.countLines(path)){
			System.out.println("\n i is:" + i + "\n");
			Food foodItem = std.formatRecord(Items.get(i).toString().trim());

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
