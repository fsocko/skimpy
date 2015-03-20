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
	
	public static void main(String[] args) {
		
		//test search
		search("cheese");
		
		
    }
	
	public static void examineRecord(String path, String table, int record)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect();
		System.out.println(std.readRecord(path, record));
		Food foodItem = std.formatRecord(std.readRecord(path, record));
		if(foodItem != null)
		{
			System.out.println(foodItem.toString());
			toDB.pushFood(foodItem, table);
		}		
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
	
	public static void pushToDB(String path, String db, String table)
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
	
	public static String pullFromDB(String table, int ID)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect pullDB = new DBConnect();
		return pullDB.pullFood(table, ID).toString();
	
	}
	
	public static void search(String query)
	{
		DBConnect s = new DBConnect();
		ArrayList<Integer> searchResults = s.search("tesco", query);
		System.out.println("Items which contain the query \" " + query+ "\" are the following:\n");
		int j = 0;
		while (j < searchResults.size()) 
		{
			System.out.println(pullFromDB("tesco", searchResults.get(j)));
			j++;
		}
		
	}
	
}
