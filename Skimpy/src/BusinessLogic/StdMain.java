//@author: FPS
package BusinessLogic;

//this file will run the methods I am currently working on, so I only need a single line in the master main method. 

public class StdMain {
	
	public static void testMethods()
	{
		

		
		//SpiderToDB:
				SpiderToDB std = new SpiderToDB();
				
				
			/*	
				for(int i = 0; i<2835; i++)
				{
					
					try{
					System.out.println("i is:  " +(i+1));
					std.pushTescoToDB(i+1);
					}
					finally{
						i++;
					}
				}
				*/
				
				System.out.println(std.readRecord(std.sainsPath, 7) + "\n");
				std.formatSains(std.readRecord(std.sainsPath, 7));
		
		
	}
}
