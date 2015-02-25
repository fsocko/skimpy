//@author: FPS
package BusinessLogic;

import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

//this file will run the methods I am currently working on, so I only need a single line in the master main method. 

public class StdMain extends HttpServlet{
	
	public static void testMethods()
	{
		

		
		//SpiderToDB:
				SpiderToDB std = new SpiderToDB();
				int i = 1;

				/*
				DBConnect tescoPush = new DBConnect("food_db");
				
				ArrayList tescoItems = new ArrayList(std.readAllRecords(std.tescoPath));
				
				i = 1;
				while(i < std.countLines(std.tescoPath))
				{
					System.out.println("\n i is:" + i + "\n");
					DBFood tescoTest = std.formatRecord(tescoItems.get(i).toString().trim());
					
					if(tescoTest != null)
					{tescoTest.toString();}
					
					tescoPush.pushFoodN(tescoTest, "tesco_scraped");
					
					i++;
				}
				i=1;
				
				*/
				DBConnect sainsPush = new DBConnect("food_db");
				ArrayList sainsItems = new ArrayList(std.readAllRecords(std.sainsPath));
				
				i = 1;
				while(i < std.countLines(std.sainsPath))
				{
					System.out.println("\n i is:" + i + "\n");
					DBFood sainsTest = std.formatRecord(sainsItems.get(i).toString().trim());
					
					if(sainsTest != null)
					{
						sainsTest.toString();
						sainsPush.pushFoodN(sainsTest, "tesco_scraped");
					}
					
					
					i++;
				}
				i=1;
			
				

	}
}
