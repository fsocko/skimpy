package BusinessLogic;

import java.io.*;
import java.util.regex.*;

public class SpiderToDB {
	
	//Read a record in a particular place in a file. - Sequential search for line number.
	 public String readRecord(int recNum) //Indexes from 1 to match line number.
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
    

}
