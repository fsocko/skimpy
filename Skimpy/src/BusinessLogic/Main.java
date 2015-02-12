package BusinessLogic;
import java.util.ArrayList;
/**
 * @author ruaraidh
 */
/**
 * Main class that brings all the other classes together.
 */
public class Main{
	/**
	 * Will create a Person object, Food and the create a MealPlanner and add the Food.
	 * @param args
	 */
	
	public static void main(String[] args) {
		
	
		
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
		
		System.out.println(std.readRecord(std.sainsPath, 2));
		std.formatSains(std.readRecord(std.sainsPath, 2));
		
		
		
    }
}
