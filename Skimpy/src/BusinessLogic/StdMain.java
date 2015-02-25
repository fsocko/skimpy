//@author: FPS
package BusinessLogic;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public class StdMain extends HttpServlet{
	
	public static void pushTesco(String db, String table)
	{
		SpiderToDB std = new SpiderToDB();
		int i = 1;
		DBConnect tescoPush = new DBConnect(db);		
		ArrayList tescoItems = new ArrayList(std.readAllRecords(std.tescoPath));
		
		i = 1;
		while(i < std.countLines(std.tescoPath))
		{
			System.out.println("\n i is:" + i + "\n");
			DBFood tescoTest = std.formatRecord(tescoItems.get(i).toString().trim());
			
			if(tescoTest != null)
			{tescoTest.toString();}
			
			tescoPush.pushFoodN(tescoTest, table);
			
			i++;
		}
		i=1;
		
	}
	
	public static void pushSains(String db, String table)
	{
				SpiderToDB std = new SpiderToDB();
				int i = 1;

				DBConnect sainsPush = new DBConnect(db);
				ArrayList sainsItems = new ArrayList(std.readAllRecords(std.sainsPath));
				
				i = 1;
				while(i < std.countLines(std.sainsPath))
				{
					System.out.println("\n i is:" + i + "\n");
					DBFood sainsTest = std.formatRecord(sainsItems.get(i).toString().trim());
					
					if(sainsTest != null)
					{
						sainsTest.toString();
						sainsPush.pushFoodN(sainsTest, table);
					}
					
					i++;
				}

//calls the methods to run 				
			pushTesco("food_db", "tesco_scraped");
			pushSains("food_db", "sains_scraped");
				
	}
}
