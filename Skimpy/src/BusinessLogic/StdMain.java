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
				
				i = 1;
				while(i < std.countLines(std.tescoPath))
				{
					System.out.println("\n i is:" + i + "\n");
					DBFood tescoTest = std.formatRecord(std.readRecord(std.tescoPath, i));
					i++;
				}
				i=1;
				
				
				*/
				
				long A = (System.currentTimeMillis()/1000);
				System.out.println("Timer started.");
				
				System.out.println("\n\n\n SAINSBURY'S STARTS HERE -------------------------------------------------------------------------------- \n\n\n");
				
				ArrayList allRecs = std.readAllRecords(std.sainsPath);
				
				long B = (System.currentTimeMillis()/1000) - A;
				System.out.println("Time To Complete Generating ArrayList in minutes:" +B);
				
				for (i = 0; i < allRecs.size(); i++)	
				{
					System.out.println("\nRecord Number:" + i + "\n"); 
					DBFood sainsTest = std.formatRecord(allRecs.get(i).toString());
					 
				}
				
					
				long C = (System.currentTimeMillis()/1000) - A;
				System.out.println("Total time in minutes: " + B/60);
				//old way takes about 20min

				
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
