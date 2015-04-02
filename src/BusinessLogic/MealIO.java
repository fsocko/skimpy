package BusinessLogic;

import java.io.*;
import java.util.ArrayList;

public class MealIO {
	
	//TODO: ID must be in Food object, otherwise we can't look up foods when saving a meal plan
	public String formatMeal(Meal fMeal)
	{
		//Write Format:
		//mealName;DBID;DBID;DBID;\n
		
		String record = "";
		String name = "";
		name = fMeal.getName();
		StringBuffer ingRecord = new StringBuffer();
		
		ArrayList<Food> ingredients = new ArrayList<Food>();
		ingredients = fMeal.getIngredients();
		
		for(int i = 0; i<ingredients.size(); i++)
		{
			 Food foodLookup = ingredients.get(i);
			 foodLookup.getDBID();
			 ingRecord.append(foodLookup.getDBID()+";");
		}
		record = name + ";" + ingRecord + "\n";
		return record;
	}
	
	//TODO: incorporate formatMeal into this method before try block
	public void writeMeal(Meal fMeal)
	{
		//Record Format:
		//mealName;DBID;DBID;DBID;\n
		
		String record = "";
		String name = fMeal.getName();
		StringBuffer ingRecord = new StringBuffer();
		
		ArrayList<Food> ingredients = new ArrayList<Food>();
		ingredients = fMeal.getIngredients();
		
		for(int i = 0; i<ingredients.size(); i++)
		{
			 Food foodLookup = ingredients.get(i);
			 foodLookup.getDBID();
			 ingRecord.append(foodLookup.getDBID()+";");
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
	
	public void readMeal()
	{}
	

}
