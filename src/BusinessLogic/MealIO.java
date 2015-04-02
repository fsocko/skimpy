package BusinessLogic;

import java.io.*;
import java.util.ArrayList;

public class MealIO {

	
	public void writeMeal(Meal fMeal)
	{
		//Record Format:
		//meal.toString();
		
		String record = "";
		String name = fMeal.getName();
		name = name.replaceAll(";",",").trim();	//the only thing that will really break the file is ; or \n
		name = name.replaceAll("\n","");
		StringBuffer ingRecord = new StringBuffer();
		
		ArrayList<Food> ingredients = new ArrayList<Food>();
		ingredients = fMeal.getIngredients();
		
		for(int i = 0; i<ingredients.size(); i++)
		{
			 Food foodLookup = ingredients.get(i); 
			 ingRecord.append(foodLookup.getDBID() + "/");
			 ingRecord.append(foodLookup.getSupermarket() + ";");
		}
		record = name + ";" + ingRecord + "\n";
	    
		try{
			  BufferedWriter bw = new BufferedWriter(new FileWriter("data/meals.txt", true));
		      bw.write(record); 
		      bw.flush();
		      bw.close();
		      System.out.print("Writing meal to file...");
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException Occured" + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("IOException Occured" + e.getMessage());
		}
		 System.out.print("Done");
	}
	
	
	//reads all meals in the file, outputs them to arrayList which is then formatted.
	public ArrayList readFile()
	    { 
			 
		 	ArrayList meals = new ArrayList();
			 
			 FileInputStream fs = null;
			 try
			 { 
				 SpiderToDB std = new SpiderToDB();
				 fs= new FileInputStream("data/meals.txt");
				 BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				 
				 for(int i = 0; i<std.countLines("data/meals.txt"); i++)
				 {
				   meals.add(br.readLine());
				 }
				 br.close();
			 }
			 catch(FileNotFoundException F)
			 { System.out.println("IOexception while reading.");}
			 
			 catch (IOException e)
	         {
	             e.printStackTrace();
	             System.out.println("could not read file.");
	         }   
			 
			 finally 
			 {
			     if (fs != null)
			     {
			    	 try
			    	 {
			    		 fs.close();
			    	 }
			    	 catch(IOException e2)
			    	 { System.out.println("IOException while closing.");}
			     }	     	     
			 }
			 //output: Record formatted into array list.
			 //Each array entry is a record. for example:
			 //readFile<Food>.get(2) == "name;food;food;food;"
			 return meals;	 
	    }
		
	
	
}
