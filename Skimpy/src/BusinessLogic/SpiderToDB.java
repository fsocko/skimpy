//@Author: FPS

package BusinessLogic;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

import javax.servlet.http.HttpServlet;


public class SpiderToDB extends HttpServlet{
//TODO: Strip " from DBFood, it fucks with the SQL syntax

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

		 
		//Sequential will be slightly faster than arrayList method
		 public String readRecord(String file, int recNum)
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
		 double result = -1.69;
		 
		 //TODO:make sure we can handle upper case null too
		 if(!(input.equals(null) | input.equals("") | input.contains("null") | input.matches("\\d+")))
		 {
			 input = input.replaceAll("[^.0-9]","").trim();
			 result =  Double.parseDouble((input).trim());
		 }
		 return result;
	 }
	 

	 	//Takes a record string, returns a food object. You probably want to read a record with readRecord(int)
	 	//As long as the files are fairly consistent, it should be robust enough to work with all supermarkets
		 public DBFood formatRecord(String record)
		 {
//Parse Strings via findColon			 
			
				 String shopID = record.substring(0, findColon(record, 0));
				 String name = record.substring(findColon(record, 0), findColon(record, 1));
				 
				 String mass;
				 String unit;
				 String price = record.substring(findColon(record, 1), findColon(record, 2));
				 String pricePU = record.substring(findColon(record, 2), findColon(record, 3));
				 String PPUPrice;
				 String PPUUnit;
				 String foodCat = record.substring(findColon(record, 3), findColon(record, 4));
//Nutrition				 
				 String calories = record.substring(findColon(record, 4), findColon(record, 5));
				 String proteins = record.substring(findColon(record, 5), findColon(record, 6));
				 String carbs = record.substring(findColon(record, 6), findColon(record, 7));
				 String sugars = record.substring(findColon(record, 7), findColon(record, 8));
				 String fats = record.substring(findColon(record, 8), findColon(record, 9));
				 String saturates = record.substring(findColon(record, 9), findColon(record, 10));
				 String fibre = record.substring(findColon(record, 10), findColon(record, 11));
				 String salt = record.substring(findColon(record, 11), findColon(record, 12));
				 
	//ShopID---------NO CHANGE			 
	//Name-----------NO CHANGE		
				 name = name.replaceAll(";"," ");
	//Mass, Unit
				 mass = formatMassUnit(name, true); //return mass true returns mass
				 unit = formatMassUnit(name, false); //return mass false returns unit
	//Price			 		 
				 price = price.replaceAll("[^.0-9]",""); //strip all but numbers from price.
	//PPUPrice			
				 PPUPrice = formatPPU(pricePU, true); //return pricePU is true, so it returns price
				 PPUUnit = formatPPU(pricePU, false);
				 PPUUnit = PPUUnit.replaceAll(";","");
	
	//foodCat		 
				 foodCat = foodCat.replaceAll("[-]"," "); //specifically for the sainsbury data
				 foodCat = foodCat.replaceAll(";"," ");
				 
	//Calories---------NO CHANGE
	//Proteins---------NO CHANGE
	//Carbs------------NO CHANGE
	//Sugars-----------NO CHANGE
	//Fats-------------NO CHANGE
	//Saturates--------NO CHANGE
	//Salts------------NO CHANGE
	//Fibre------------NO CHANGE
	

				DBFood currentRec = new DBFood(shopID, name, toDouble(mass), unit, toDouble(price), toDouble(PPUPrice), PPUUnit, foodCat, toDouble(calories), toDouble(proteins), toDouble(carbs), toDouble(sugars), toDouble(fats), toDouble(saturates), toDouble(fibre), toDouble(salt)); 
				return currentRec;
				 
			 
		 }
		 
		 //HERE BE DRAGONS
		  
		 public String getMass(String field) //mass number returned as String. eg. 400
		 {
			 return formatMassUnit(field, true);
			 
		 }
		 
		 public String getMassUnit(String field) //unit of the previous mass e.g. g
		 {
			 return formatMassUnit(field, false);
			 
		 }
		 
		 public String getPPUPrice(String field) //price per unit e.g. 2.31
		 {
			 return formatPPU(field, true);
			 
		 }
		 
		 public String getPPUUnit(String field) //unit of the price per unit e.g. 100g
		 {
			 return formatPPU(field, false);
			 
		 }
		

		 
		 public String formatMassUnit(String name, boolean returnMass)
		 {
			 String massAndUnit = name;
			 int e = massAndUnit.length();
			 while(e>1) //iterate through name backwards. Find space.
			 {
				 if(massAndUnit.substring(e-1, e).equals(" "))
				 {massAndUnit = massAndUnit.substring(e, massAndUnit.length());break;}
				 
				 else{
					 	if(e == 0)
					 	{
					 		massAndUnit = "NULL";
					 		break;
					 	}
					 }
				 e--;
				 
			 }
			 String mass = "null";
			 String unit = "null";
			 Pattern p = Pattern.compile("(\\d*\\.?\\d+)\\s?(\\w+)"); //this finds a mass+unit pattern eg 400g
			 Matcher m = p.matcher(massAndUnit);
			 if(m.find())
			 {
			     mass = m.group(1).trim(); // mass is 400
			 	 unit = m.group(2).trim(); // the unit is "g"
			 }
			 else{mass = "-1.0"; unit = "NULL";} //This happens if we haven't found a unit
			 
			 //If there are any delimiters, we strip them from all fields
			 mass = mass.trim().replaceAll(";","");
			 unit = unit.trim().replaceAll(";",""); 
			 if(returnMass == true)
			 {
				 return mass;
			 }	 
			 else
			 {
				 if(returnMass == false)
				 {
					return unit; 
				 }	 
			 }
			 return "NULL";
		 }
		
		 public String formatPPU(String pricePU, boolean returnPrice)
		 {
			
			 String PPUPrice = "-1";
			 String PPUUnit = "-1";
			 int e = pricePU.length();
			 while(pricePU.length() > 1) //iterate through name backwards. Find Slash.
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
			 
			 PPUPrice = PPUPrice.replaceAll("[^.0-9]","");
			 PPUUnit = PPUUnit.trim();
			 
			 if(returnPrice == true)
			 {
				 return PPUPrice;
			 }	 
			 else
			 {
				 if(returnPrice == false)
				 {
					return PPUUnit; 
				 }	 
			 }
			 return "NULL";
			 
		 }
		  
}//EOF