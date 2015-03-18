//@author: FPS
package BusinessLogic;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public class StdMain extends HttpServlet{
	

	public void examineRecord(String path, String db, String table, int record)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect(db);
		System.out.println(std.readRecord(path, record));
		DBFood foodItem = std.formatRecord(std.readRecord(path, record));
		
		if(foodItem != null)
		{
			System.out.println(foodItem.toString());
			toDB.pushFoodN(foodItem, table);
		}
		
		
	}
	
	
	public void portionSizeToDB(String db, String table)
	{
		
		SpiderToDB std = new SpiderToDB();
		DBConnect dbCon = new DBConnect("food_db");
		
		ArrayList portions = new ArrayList(std.readAllRecords(std.portionPath));
		
		int i = 1;
		while(i < std.countLines(std.portionPath))
		{
			System.out.println("\n i is:" + i + "\n");
			
			System.out.println(portions.get(i).toString().trim());
			PortionSize portion = std.parsePortion(portions.get(i).toString().trim());
			System.out.println(portion.toString());
			dbCon.pushPortionSizes("portion_sizes", portion.getFoodCat(), portion.getFoodItem(), portion.getMass(), portion.getUnit());
			
			//pushPortionSizes(String foodCat, String item, double mass, String unit)
				
			
			
			i++;
		}
		
		
	}
	
	
	
	
	
	public void pushToDB(String path, String db, String table)
	{
				SpiderToDB std = new SpiderToDB();


				DBConnect toDB = new DBConnect(db);
				ArrayList Items = new ArrayList(std.readAllRecords(path));
				
				int i = 1;
				while(i < std.countLines(path))
				{
					System.out.println("\n i is:" + i + "\n");

					DBFood foodItem = std.formatRecord(Items.get(i).toString().trim());
					
					if(foodItem != null)
					{
						System.out.println(foodItem.toString());
						toDB.pushFoodN(foodItem, table);
					}
					
					i++;
				}
	}
}