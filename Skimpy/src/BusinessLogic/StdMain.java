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
				
				for(int i = 1; i<21948; i++)
				{
					
					try{
					
					std.pushSainsToDB(i);
					}
					finally{
						i++;
					}
				}
				
		
		
	}
}
