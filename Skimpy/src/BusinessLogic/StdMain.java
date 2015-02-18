//@author: FPS
package BusinessLogic;

import java.util.ArrayList;

//this file will run the methods I am currently working on, so I only need a single line in the master main method. 

public class StdMain {
	
	public static void testMethods()
	{
		

		
		//SpiderToDB:
				SpiderToDB std = new SpiderToDB();
				int i = 1;
/*
				
				DBConnect tescoPush = new DBConnect("food_DB");
				ArrayList tescoItems = new ArrayList(std.readAllRecords(std.tescoPath));
				
				i = 1;
				while(i < std.countLines(std.tescoPath))
				{
					System.out.println("\n i is:" + i + "\n");
					DBFood tescoTest = std.formatRecord(tescoItems.get(i).toString().trim());
					tescoPush.pushFood(tescoTest, "tesco_scraped");
					
					i++;
				}
				i=1;
				
				
		*/	
			
				DBConnect sainsPush = new DBConnect("food_DB");
				
				System.out.println("\n\n\n SAINSBURY'S STARTS HERE -------------------------------------------------------------------------------- \n\n\n");
				
				ArrayList allRecs = std.readAllRecords(std.sainsPath);
				
				for (i = 0; i < allRecs.size(); i++)	
				{
					System.out.println("\nRecord Number:" + i + "\n");
					DBFood sainsTest = std.formatRecord(allRecs.get(i).toString());
					sainsPush.pushFood(sainsTest, "sains_scraped");
					 
				}
				
					


				
	
			/*
				i = 1;
				while(i < std.countLines(std.asdaPath))
				{
					System.out.println("\n i is:" + i + "\n");
					System.out.println(std.readRecord(std.asdaPath, i));
					DBFood tescoTest = std.formatRecord(std.readRecord(std.asdaPath, i));
					i++;
				}
				
				*/
				

	}
}