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

	public static void main(String[] args) {
		
		//test search
		//search("cheese");

		//DBConnect con = new DBConnect();
		//con.search("tesco","apple");
		
		SpiderToDB std = new SpiderToDB();
		pushPortionSizes();
		//pushToDB(std.tescoPath, "tesco");
		
		
		
    }
	
	public static void examineRecord(String path, String table, int record)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect();
		System.out.println(std.readRecord(path, record));
		Food foodItem = std.formatRecord(path, std.readRecord(path, record));
		if(foodItem != null)
		{
			System.out.println(foodItem.toString());
			toDB.pushFood(foodItem, table);
		}		
	}
	
	public static void pushPortionSizes()
	{
		
		SpiderToDB std = new SpiderToDB();
		DBConnect dbCon = new DBConnect();
		ArrayList portions = new ArrayList(std.readAllRecords(std.portionPath));
		
		int i = 1;
		while(i < std.countLines(std.portionPath))
		{
			System.out.println("\n i is:" + i + "\n");
			System.out.println(portions.get(i).toString().trim());
			PortionSize portion = std.parsePortion(portions.get(i).toString().trim());
			System.out.println(portion.toString());
			dbCon.pushPortionSizes(portion.getFoodCat(), portion.getFoodItem(), portion.getMass(), portion.getUnit());
			i++;
		}
		System.out.println("Done");
	}
	
	public static void pushToDB(String path, String table)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect();
		ArrayList Items = new ArrayList(std.readAllRecords(path));
		int i = 1;
		while(i < std.countLines(path)){
			System.out.println("\n i is:" + i + "\n");
			Food foodItem = std.formatRecord(path, Items.get(i).toString().trim());
			if(foodItem != null)
			{
				System.out.println(foodItem.toString());
				toDB.pushFood(foodItem, table);
			}
			i++;
		}
		System.out.println("Done");
	}
	
	public static String pullFromDB(String table, int ID)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect pullDB = new DBConnect();
		System.out.println("Done");
		return pullDB.pullFood(table, ID).toString();
	}
	
	public static void searchForID(String query)
	{
		DBConnect s = new DBConnect();
		ArrayList<Integer> searchResults = s.searchForID("tesco","name", query);
		System.out.println("Items which contain the query \" " + query+ "\" are the following:\n");
		int j = 0;
		while (j < searchResults.size()) 
		{
			System.out.println(pullFromDB("tesco", searchResults.get(j)));
			j++;
		}
		System.out.println("Done");
	}
	
}
