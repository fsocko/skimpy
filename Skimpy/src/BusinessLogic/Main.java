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
		
		DBConnect con = new DBConnect();
		con.search("sains", "apple");
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
	
	public static String pullFromDB(String table, int ID)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect pullDB = new DBConnect();
		return pullDB.pullFood(table, ID).toString();
	
	}
	
	
	
}
