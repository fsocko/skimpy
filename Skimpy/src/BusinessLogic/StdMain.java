//@author: FPS
package BusinessLogic;

//this file will run the methods I am currently working on, so I only need a single line in the master main method. 

public class StdMain {
	
	public static void testMethods()
	{
		

		
		//SpiderToDB:
				SpiderToDB std = new SpiderToDB();
				
				for(int i = 1; i<300; i++)
				{
					DBFood tescoTest = std.formatSains(std.readRecord(std.tescoPath, i));
					System.out.println(tescoTest.toString() +" ");
				}	
	/*			
				for(int i = 1; i<21948; i++)
				{
					
					try{
					
					std.pushSainsToDB(i);
					}
					finally{
						i++;
					}
				}
				
		*/
		
	}
}
