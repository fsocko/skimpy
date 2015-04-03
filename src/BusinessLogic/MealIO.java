package BusinessLogic;

import java.io.*;
import java.util.ArrayList;

public class MealIO {

	//TODO: 
	
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
			 ingRecord.append(foodLookup.getDBID());
			 ingRecord.append(foodLookup.getSupermarket() + ";");
		}
		record = name + ";" + ingRecord + "\n";
	    
		try{
			  BufferedWriter bw = new BufferedWriter(new FileWriter("data/meals.txt", true));
		      bw.write(record); 
		      bw.flush();
		      bw.close();
		}
		catch (FileNotFoundException e) 
		{
			System.out.println("FileNotFoundException Occured" + e.getMessage());
		} 
		catch (IOException e) 
		{
			System.out.println("IOException Occured" + e.getMessage());
		}
		 System.out.print("Write Meal to file: Done\n");
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
			 return meals;	 //arrayList of food records
	    }
		
		//converts the text file, returns a meal object
		public ArrayList<Meal> formatMeal(ArrayList<String> readMeals) //todo: return meal
		{
			System.out.println("Check input: " + readMeals.toString());
			DBConnect con = new DBConnect();
			SpiderToDB std = new SpiderToDB();
			
			ArrayList<String> lookUp = new ArrayList();
			ArrayList<Meal> outMeals = new ArrayList();
			
			for(int i = 0; i<readMeals.size(); i++)//for each Meal
			{
				String record = readMeals.get(i);
				String name = "";
				int colNum = 0;
				int colPos = -1;

				for(int j = 1; j<record.length()+1; j++)//each ingredient
				{	
					if(record.substring((j-1),(j)).equals(";") && colNum <= 0)//if next char is a semiColon
					{
						name = record.substring(0, j-1);
						System.out.println(name);
						colNum ++;
						colPos = j;
					}
					else if(record.substring((j-1),(j)).equals(";") && colNum > 0)//these are the ingredients
					{
						String ingredient = record.substring(colPos, j-1);
						System.out.println(ingredient);
						lookUp.add(ingredient);
						colPos = j;
						colNum ++;
					}
				}
				for(int k = 0; i<lookUp.size(); i++)
				{
					String dbID = lookUp.get(i);
					String supermarket = dbID.substring(0, dbID.length()-1);
					
					if(supermarket.equals("A"))
					{supermarket = "asda";}
					else if(supermarket.equals("T"))
					{supermarket = "tesco";}
					else if(supermarket.equals("S"))
					{supermarket = "Sains";}
					
					Meal lookUpMeal =new Meal(name, createMeal(con.pullFood(dbID, supermarket)));
					outMeals.add(lookUpMeal);
					
					
				}	
				
				return outMeals;
			}	
			
			
			
	
		}
		
	
	
}
