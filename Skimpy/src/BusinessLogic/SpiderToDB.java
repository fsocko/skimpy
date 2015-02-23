//@Author: FPS

package BusinessLogic;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

import javax.servlet.http.HttpServlet;


public class SpiderToDB extends HttpServlet{
//TODO: Strip " ' " from DBFood, it fucks with the SQL syntax
//TODO: sort out this error: Data source rejected establishment of connection,  message from server: "Too many connections"
// Convert to SQL?
	

	 //Use these strings when selecting file, it's easier.
	 String tescoPath = "data/tesco.txt";
	 String sainsPath = "data/sains.txt";
	 String asdaPath = "data/asda.txt";
	 

		 public int countLines(String inputFile) //Most of this method written by a very helpful chap called Yashwant Chavan.  
		 {
		  int lines = 0;
		  try {
		   File file = new File(inputFile);
		   LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
		   lineNumberReader.skip(Long.MAX_VALUE);
		   lines = lineNumberReader.getLineNumber();
		   lineNumberReader.close();
		   
		  } catch (FileNotFoundException e) {
		   System.out.println("FileNotFoundException Occured" 
		     + e.getMessage());
		  } catch (IOException e) {
		   System.out.println("IOException Occured" + e.getMessage());
		  }

		  return lines;

		 }

		 
	
	 public String readRecord(String file, int recNum) //Indexes from 1!
    { 
		 ArrayList allRec = readAllRecords(file);
		 return(allRec.get(recNum).toString().trim());

    }
	 
	 //creates array list of all records. The list can then be traversed.
	 //Takes about 2min, but it beats the 20mins or so in a sequential search.
	 public ArrayList readAllRecords(String file)
	    { 
			 
		 	ArrayList allRec = new ArrayList();
			 
			 FileInputStream fs = null;
			 try
			 { 
				 fs= new FileInputStream(file);
				 BufferedReader br = new BufferedReader(new InputStreamReader(fs));
				 for(int i = 0; i<countLines(file); i++)
				 {
				   allRec.add(br.readLine());
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
			 return allRec;	 
	    }
	 
	 
	 
	 //takes record output from readRecord(int), the number of the comma we want to find. Index from 0
	 public int findComma(String record, int commaNum) 
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
		 return commaPos;
	 }
	 
	 
	//takes record output from readRecord(int), the number of the colon we want to find. Index from 0
	 public int findColon(String record, int colonNum)
	 {
		int j = 0;
		int colonPos = -1;
		
		 for(int i = 1; (i < record.length()+1); i++)
		 {
			 if(record.substring((i-1), i).equals(";"))//found a colon
			 {
				 j++;
				 colonPos = (i-1);
			 }	
			 if((j-1) == colonNum && (colonPos > -1))
			 {colonPos = (i-1); break;} //found the colon we are looking for
			 
			 if(i == record.length()) //didn't find the colon
			 {colonPos = -99; break; }
			 
		 }	 	 
		 return colonPos; //returns position of semi-colon number colonNum in a record, index from 0
	 }
	 
	 

	 //Custom methods for parsing strings to Double and to Int
	 public double toDouble(String input)
	 {
		 if(! (input.equals(null) | input.equals("")))
		 {
			 double result = -1.0;
			 result = Double.parseDouble((input));
			 return result;
		 }
		 else{return -1.0;}
	 }
	 
	 public int toInt(String input)
	 {
		 
		 if(! (input.equals(null) | input.equals("")))
		 {	 
			 int result = -1;
			 result = Integer.parseInt((input).trim());
			 return result;
		 }	 
		 else{return -1;}
	 }

	 	//Takes a record string, returns a food object. You probably want to read a record with readRecord(int)
	 	//As long as the files are fairly consistent, it should be robust enough to work with all supermarkets
		 public DBFood formatRecord(String record)
		 {
			 if(record.contains("; ;"))
			 {return null;}

			 String shopID = record.substring(0, findColon(record, 0));
			 String name = record.substring(findColon(record, 0), findColon(record, 1)); 
			 String massAndUnit = name;
			 
			 int e = massAndUnit.length();
			 while(e>0) //iterate through name backwards. Find space.
			 {
				 if(massAndUnit.substring(e-1, e).equals(" "))
				 {massAndUnit = massAndUnit.substring(e, massAndUnit.length());break;}
				 
				 else{
					 	if(e == 0)
					 	{
					 		massAndUnit = "No mass found.";
					 		break;
					 	}
					 }
				 e--;
				 
			 }
			 String mass = " ";
			 String unit = " ";
			 Pattern p = Pattern.compile("(\\d*\\.?\\d+)\\s?(\\w+)"); //this finds a mass+unit pattern eg 400g
			 Matcher m = p.matcher(massAndUnit);
			 if(m.find())
			 {
			     mass = m.group(1).trim();
			 	 unit = m.group(2).trim(); // the unit is 100g, not 600 g
			 }
			 else{mass = "-1"; unit = massAndUnit;} //This happens if we haven't found a unit
			 double massD = toDouble(mass);
			 
			 String price = record.substring(findColon(record, 1), findColon(record, 2));
			 String stripChars = price.replaceAll("[^.0-9]",""); //strip all but numbers from price.
			 price = stripChars;
			 double priceD = toDouble(stripChars);
			 
			 String pricePU = record.substring(findColon(record, 2), findColon(record, 3));
			 String PPUPrice = "-1";
			 String PPUUnit = "-1"; //not used yet, but depending on how PPU will work with @ruaraidhmacarflane 's code
			 //find slash, separate price per unit from the actual unit the price is measured in.
			 //e.g. GBP 2 / 100g gives "2" (i.e. PPUPrice) and "100g" (i.e. PPUUnit) 
			 //e.g. GBP 1.6 / 100ml gives "1.6" (i.e. PPUPrice) and "100ml" (i.e. PPUUnit)
			 e = pricePU.length();
			 while(pricePU.length() > 0) //iterate through name backwards. Find Slash.
			 {
				 if(pricePU.substring(e-1, e).equals("/"))
				 {
					 PPUPrice = pricePU.substring(0, e);
					 PPUUnit = pricePU.substring(e, pricePU.length());
					break;
				 }
				 else{if(e == 0){break;}}	 	 

				 e--;
			 }
			 
			 stripChars = "-1";
			 stripChars = PPUPrice.replaceAll("[^.0-9]",""); //strip all characters but numbers
			 double PPUPriceD = toDouble(stripChars);
			 
			 String foodCat = record.substring(findColon(record, 3), record.length());
			 String spaceSlash = foodCat.replaceAll("[-]"," "); //specifically for the sainsbury data
			 foodCat = spaceSlash;
			 
			 //If there are any delimiters, we strip them from all fields
			 shopID = shopID.replaceAll(";","");
			 name = name.trim().replaceAll(";","");
			 mass = mass.trim().replaceAll(";","");
			 unit = unit.trim().replaceAll(";","");
			 //not price
			 //not PPU
			 foodCat = foodCat.trim().replaceAll(";","");
			 
			 System.out.println("ShopID:" + shopID + "\nName:" + name + "\nMass:" + mass  
			+ "\nUnit:" +unit + "\nPrice:" + price +"\nPrice PU:" + PPUPriceD
			+"\nFoodCat:" + foodCat);
			 
			 
	//to DBFood object
					//fieldName followed by D means the field was converted to a Double. ShopID is a STRING!
			 		//public DBFood(String shopID, String name, double mass, String unit, double price, double pricePU, String PPUUnit, String foodCat)
					
			//pass a null instead of PPUUnit, we are not using PPUUnit in the DB. The code is there, but I need to check with team how PPU unit will work.
			 DBFood currentRec = new DBFood(shopID, name, massD, unit, priceD, PPUPriceD, null, foodCat); 
			 return currentRec; //return object ready for pushingtoDB
			 
		 }
		 
		 //push a particular record to the DB
		 public void pushSainsToDB(int recNum)
		 {
			 DBConnect dbPush = new DBConnect("food_db");
			 dbPush.pushFood(formatRecord(readRecord(sainsPath, recNum)), "sains_scraped"); 
		 }
	 
	 
	 
}//EOF