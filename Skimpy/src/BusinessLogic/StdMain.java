//@author: FPS
package BusinessLogic;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

public class StdMain extends HttpServlet{
	

	
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
						//toDB.pushFoodN(foodItem, table);
					}
					
					i++;
				}
	}
}