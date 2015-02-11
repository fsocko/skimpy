package BusinessLogic;

import java.io.*;
import java.util.regex.*;

public class SpiderToDB {//TODO: Despite all efforts, it will not fail gracefully. It fucking crashes.
	
	//Read a record in a particular place in a file. - Sequential search for line number.
	 public String readRecord(int recNum) //Indexes from 0
    { 
		 String record = "No Record Found!";
		 String file = "data/tesco.txt";
		 
		 FileInputStream fs = null;
		 try
		 {
			 
			 fs= new FileInputStream(file);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			 for(int i = 0; i<recNum; i++)
			 {
			   record = br.readLine();
			 }
		 }
		 
		 catch(FileNotFoundException F)
		 { System.out.println("IOexception while reading.");}
		 
		 catch (IOException e)
         {
             e.printStackTrace();
             record = "error";
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
		 return record;	 
    }
	 
	 
	 public int findComma(String record, int commaNum) //takes record, the number of the comma we want to find. Index from 0 
	 {
		int j = 0;
		int commaPos = -1;
		
		 for(int i = 1; (i < record.length()+1); i++)
		 {
			 if(record.substring((i-1), i).equals(","))
			 {
				 j++;
				 commaPos = (i-1);
			 }	
			 if((j-1) == commaNum && (commaPos > -1))
			 {commaPos = (i-1); break;}
			 
			 if(i == record.length())
			 {commaPos = -99; }
			 
		 }	 	 
		 return commaPos; //returns position of comma number commaNum in a record, index from 0
	 }
	 

	 
	 public double toDouble(String input) //custom parseDouble method
	 {
		 double result = -1.0;
		 result = Double.parseDouble((input));
		 return result;	 
	 }
	 
	 public int toInt(String input) //custom parseDouble method
	 {
		 int result = -1;
		 result = Integer.parseInt((input).trim());
		 return result;	 
	 }
	 
	 
	 
	 public DBFood formatRecord(String record) //takes relevant field, moves it to a string, formats the string, converts the strings to appropriate filetypes, pushes the filetypes to a DBfoodObject
	 {

		 String stripChars = "-1";
		 String id = record.substring(0, findComma(record, 0));
		 
		 if(! id.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d"))
		 {System.out.println("invalid ID"); id = "error!";}
		 
		 String name = record.substring(findComma(record, 0)+2, findComma(record, 1));
		 //EXPERIMENTAL MASS REGEX
		 String mass = " ";
		 String unit = " ";
		 Pattern p = Pattern.compile("(\\d*\\.?\\d+)\\s?(\\w+)");
		 Matcher m = p.matcher(name);
		 if(m.find())
		 {
		     mass = m.group(1).trim();
		 	 unit = m.group(2).trim();
		 }
		 //This sometimes returns e.g. "4 muffins" rather than 250G, but we can just erase those??
		 else{mass = "-1"; unit = "Unknown Unit.";} //This happens if we haven't found a unit
		 
		 String price = record.substring(findComma(record, 1), findComma(record, 2));
		 String pricePU = record.substring(findComma(record, 2), findComma(record, 3));
		 String foodCat = record.substring(findComma(record, 3)+2, record.length());
		 
		 //Strip all but numbers from price and PPU
		 stripChars = "-1";
		 stripChars = price.replaceAll("[^.0-9]","");
		 price = stripChars;
		 stripChars = pricePU.replaceAll("[^.0-9]","");
		 pricePU = stripChars;
		 int shopID = toInt(id);
		 double massD = toDouble(mass);
		 double pricePUD = toDouble(pricePU);
		 double priceD = toDouble(price);
		 
		 
		 		 System.out.println(id);
		 		System.out.println(name);
				 System.out.println(mass);
				 System.out.println(unit);
				 System.out.println(price);
				 System.out.println(pricePU);
				 System.out.println(foodCat);
				 
//to DBFood object
				 
				DBFood currentRec = new DBFood(shopID, name, massD, unit, priceD, pricePUD, foodCat); 
				return currentRec; //return object ready for pushingtoDB
	 }
	 
	
	/*public boolean recordInvalid(DBFood foodValid)
	{
		boolean valid = false;
		
		if(foodValid.getID() | foodValid.getName() | foodValid.getMass())
		
		return valid;
		
	}*/
	 
	 public void pushFoodToDB(int recNum)
	 {
		 
		 DBConnectDelta dbPush = new DBConnectDelta("food_db");
		 
		 dbPush.pushFood(formatRecord(readRecord(recNum)), "scraped_food");
		 System.out.println("Fucking A! We pushed to DB");
	 }
	 
	 
}
