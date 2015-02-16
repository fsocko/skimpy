//@Author: FPS

package BusinessLogic;

import java.io.*;
import java.util.regex.*;

public class SpiderToDB {//TODO: Despite all efforts, it will not fail gracefully. It crashes. It's not an issue now, but could cause problems down the line.

	 //TESCO: "data/tesco.txt"
	 //SAINSBURY's: "data/sainsburys.txt"
	 String tescoPath = "data/tesco.txt";
	 String sainsPath = "data/sains.txt";
	 //Use these strings when selecting file, it's easier.
	 
	//Read a record in a particular place in a file. - Sequential search for line number.
	 public String readRecord(String file, int recNum) //Indexes from 1!
    { 
		 
		 String record = "No Record Found!";
		 
		 FileInputStream fs = null;
		 try
		 { 
			 fs= new FileInputStream(file);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			 for(int i = 0; i<recNum; i++)
			 {
			   record = br.readLine();
			 }
			 br.close();
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

	 /*TODO: TESCO marker
	      
	*/

	 //Formats data scraped from tesco for pushing to DB
	 public DBFood formatTesco(String record) //takes relevant field, moves it to a string, formats the string, converts the strings to appropriate filetypes, pushes the filetypes to a DBfoodObject
	 {

		 String stripChars = "-1";
		 String shopID = record.substring(0, findComma(record, 0));
		 
		 if(! shopID.matches("\\d\\d\\d\\d\\d\\d\\d\\d\\d"))
		 {System.out.println("invalid ID"); shopID = "error!";}
		 
		 String name = record.substring(findComma(record, 0)+2, findComma(record, 1));
		 //EXPERIMENTAL TESCO MASS REGEX
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
		 double massD = toDouble(mass);
		 double pricePUD = toDouble(pricePU);
		 double priceD = toDouble(price);
		 
				 
//to DBFood object
				//fieldName followed by D means the field was converted to a Double. ShopID is a String!
				DBFood currentRec = new DBFood(shopID, name, massD, unit, priceD, pricePUD, foodCat); 
				return currentRec; //return object ready for pushingtoDB
	 }
	 
	 public void pushTescoToDB(int recNum)
	 {
		 
		 DBConnectDelta dbPush = new DBConnectDelta("food_db");
		 
		 dbPush.pushFood(formatTesco(readRecord(tescoPath, recNum)), "tesco_scraped");
		 System.out.println("Tesco Rec pushed to DB");
	 }
	 
	 
	/*TODO: SAINS marker

*/

	//Formats data scraped from Sainsbury's for pushing to DB
		 public void formatSains(String record) //TODO: make sure this returns a valid object
		 {

			 String stripChars = "-1";
			 String shopID = record.substring(0, findComma(record, 0));
			 
			 String name = record.substring(findComma(record, 0)+2, findComma(record, 1));
			 
			 String massAndUnit = record.substring(findComma(record, 1)+2, findComma(record, 2));
			 String unit = "";
		
			 String price = record.substring(findComma(record, 2)+2, findComma(record, 3));
			 
			 String pricePU = record.substring(findComma(record, 3)+2, findComma(record, 4));
			 
			/*
			 
			 //Strip all but numbers from price and PPU
			 stripChars = "-1";
			 stripChars = price.replaceAll("[^.0-9]","");
			 price = stripChars;
			 stripChars = pricePU.replaceAll("[^.0-9]","");
			 pricePU = stripChars;
			 //TODO: unit regex for PPU: selection 1 is number, / selection 2 unit
			 
			 */
			 
			 //TODO: replace foodCat - with " ";
			 String foodCat = record.substring(findComma(record, 4)+2, record.length());
			 
			 
			 
					
			 System.out.println("ShopID:" + shopID + "\nName:" + name + "\nMass&unit:" + massAndUnit + "\nUnit:" +unit + "\nPrice:" + price +"\nPrice PU:" + pricePU +"\nFoodCat:" + foodCat);
			 
	//to DBFood object
					//fieldName followed by D means the field was converted to a Double. ShopID is a STRING! 
					//DBFood currentRec = new DBFood(shopID, name, massD, unit, priceD, pricePUD, foodCat); 
					//return currentRec; //return object ready for pushingtoDB
		 }

	 
	 
	 
	 
	 
}//EOF
