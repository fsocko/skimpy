//@Author: FPS

package BusinessLogic;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.*;


public class SpiderToDB {
//TODO: Sort out NullPointer Exception, see error log.
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
	 
	 
	 public int findColon(String record, int colonNum)//does what commaPos does, except for semicolons. 
	 {
		int j = 0;
		int colonPos = -1;
		
		 for(int i = 1; (i < record.length()+1); i++)
		 {
			 if(record.substring((i-1), i).equals(";"))//found colon
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
	 
	 

	 
	 public double toDouble(String input) //custom parseDouble method
	 {
		 if(! (input.equals(null) | input.equals("")))
		 {
			 double result = -1.0;
			 result = Double.parseDouble((input));
			 return result;
		 }
		 else{return -1.0;}
	 }
	 
	 public int toInt(String input) //custom parseDouble method
	 {
		 
		 if(! (input.equals(null) | input.equals("")))
		 {	 
			 int result = -1;
			 result = Integer.parseInt((input).trim());
			 return result;
		 }	 
		 else{return -1;}
	 }


	 
	//TODO: SAINS marker
	//Formats data scraped from Sainsbury's for pushing to DB
		 public DBFood formatSains(String record)
		 {
			 if(record.contains("; ;"))
			 {return null;}
			 //ShopID, name, price, PPU, PPUUnit, foodcat
			 
			 
			 String shopID = record.substring(0, findColon(record, 0));
			 String name = record.substring(findColon(record, 0)+2, findColon(record, 1)); 
			 String massAndUnit = name;
			 
			 int e = massAndUnit.length();
			 while(massAndUnit.length() > 0) //iterate through name backwards. Find space.
			 {
				 if(massAndUnit.substring(e-1, e).equals(" "))
				 {massAndUnit = massAndUnit.substring(e, massAndUnit.length());break;}
				 
				 else{if(e == 0){break;}}
				 e--;
				 
				 //TODO: this can sometimes return an empty string, which causes an exception.
			 }
			 String mass = " ";
			 String unit = " ";
			 Pattern p = Pattern.compile("(\\d*\\.?\\d+)\\s?(\\w+)");
			 Matcher m = p.matcher(massAndUnit);
			 if(m.find())
			 {
			     mass = m.group(1).trim();
			 	 unit = m.group(2).trim(); // the unit is 100g, not 600 g
			 }
			 else{mass = "-1"; unit = massAndUnit;} //This happens if we haven't found a unit
			 double massD = toDouble(mass);
			 
			 String price = record.substring(findColon(record, 1), findColon(record, 2));
			 String stripChars = price.replaceAll("[^.0-9]","");
			 price = stripChars;
			 double priceD = toDouble(stripChars);
			 
			 String pricePU = record.substring(findColon(record, 2), findColon(record, 3));
			 String PPUPrice = "-1";
			 String PPUUnit = "-1";
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
			 stripChars = PPUPrice.replaceAll("[^.0-9]","");
			 double PPUPriceD = toDouble(stripChars);
			 
			 String foodCat = record.substring(findColon(record, 3)+2, record.length());
			 String spaceSlash = foodCat.replaceAll("-"," ");
			 foodCat = spaceSlash;


			 System.out.println("ShopID:" + shopID + "\nName:" + name + "\nMass:" + mass  
			+ "\nUnit:" +unit + "\nPrice:" + price +"\nPrice PU:" + PPUPriceD
			+"\nFoodCat:" + foodCat);
			 
			 
	//to DBFood object
					//fieldName followed by D means the field was converted to a Double. ShopID is a STRING!
			 		//public DBFood(String shopID, String name, double mass, String unit, double price, double pricePU, String PPUUnit, String foodCat)
					
			 //if none of the fields are null
			 DBFood currentRec = new DBFood(shopID, name, massD, unit, priceD, PPUPriceD, null, foodCat); //pass a null instead of PPUUnit 
			 return currentRec; //return object ready for pushingtoDB
			 
			 //else{return null;}
		 }

		 public void pushSainsToDB(int recNum)
		 {
			 DBConnect dbPush = new DBConnect("food_db");
			 dbPush.pushFood(formatSains(readRecord(sainsPath, recNum)), "sains_scraped"); 
		 }
	 
	 
	 
	 
}//EOF
