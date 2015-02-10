package BusinessLogic;

import java.io.*;
import java.util.regex.*;

public class SpiderToDB {
	
	//Read a record in a particular place in a file. - Sequential search for line number.
	 public String readRecord(int recNum) //Indexes from 1 to match line numbers.
    { 
		 String record = "No Record Found!";
		 String file = "data/tesco.txt";

		 try{
			 
			 FileInputStream fs= new FileInputStream(file);
			 BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			 for(int i = 1; i<recNum +1; i++)
			 {
			   record = br.readLine();
			 }
			 fs.close(); 
		 }

        catch (IOException ex) {
                 ex.printStackTrace();
                 System.out.println("could not open File.");
                 }

		 return record;
		 
    }
	 
	 
	 public int findCommas(String record, int commaNum) //takes record, the number of the comma we want to find. Index from 0 
	 {
		int j = 0;
		int commaPos = -1;
		System.out.println(commaNum); 
		
		 for(int i = 1; (i < record.length()+1); i++)
		 {
			 if(record.substring((i-1), i).equals(","))
			 {
				 System.out.println("found comma " +(j) + ", Position: " +(i-1) );
				 j++;
				 commaPos = (i-1);
			 }	
			 if((j-1) == commaNum && (commaPos > -1))
			 {System.out.println("Found the comma!."); commaPos = (i-1); break;}
			 
			 if(i == record.length())
			 {System.out.println("Comma number " +commaNum + " not found."); commaPos = -99; }
			 
		 }	 	 
		 return commaPos; //returns position of comma number commaNum in a record, index from 0
	 }
	 
	 
	 public void formatRecord(String record)
	 {
	 /*RecordFormat:
	Shop ID,
	Name | mass,
	Price,
	(Price / Unit),
	Food cat
	*/
		 String id = record.substring(0, 9);
		 String name = "n";
		 String mass = "m";
		 double price = 1;
		 double pricePU = 1;
		 String foodCat = "fc";
		 
		 System.out.println(id + " ## " + name + mass + price + pricePU + foodCat);
		 
	 }

}
