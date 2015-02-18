//@author: FPS
package BusinessLogic;

//this file will run the methods I am currently working on, so I only need a single line in the master main method. 

public class StdMain {
	
	public static void testMethods()
	{
		

		
		//SpiderToDB:
				SpiderToDB std = new SpiderToDB();
				System.out.println(std.countLines(std.tescoPath));
				
				
				int i = 1;
				while(i < std.countLines(std.tescoPath))
				{
					System.out.println("\n i is:" + i + "\n");
					System.out.println(std.readRecord(std.tescoPath, i));
					DBFood tescoTest = std.formatRecord(std.readRecord(std.tescoPath, i));
					i++;
				}
				i=1;
				
				
				while(i < std.countLines(std.sainsPath))
				{
					System.out.println("\n i is:" + i + "\n");
					System.out.println(std.readRecord(std.sainsPath, i));
					DBFood sainsTest = std.formatRecord(std.readRecord(std.sainsPath, i));
					i++;
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
