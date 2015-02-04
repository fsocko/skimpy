package BusinessLogic;
import java.io.*;
/**
 *
 * @author fps
 */
/**
 * EXPLAIN BREIFLY WHAT THE CLASS DOES
 * A class that will access the Food information. BLah BLah
 *
 */
public class FileAccess 
{
	/**
	 * EXPLAIN IN MORE DETAIL WHAT THE CLASS DOES
	 * Using an .raf file storing Food this class will find a food and return information about it's
	 * use by date.
	 */
    public int headerL = 0;
    
    
    /*public void initRaf()
    {
        try {
                RandomAccessFile raf = new RandomAccessFile("/home/ruaraidh/Documents/CS3024/src/FoodStorageTable.raf", "r");
                //TODO: read header
            } 

        catch (IOException ex) {
                 ex.printStackTrace();
                 System.out.println("could not open File.");
                 }
    
    }
    */
    
    //Get a line from the file with a known ID
    /**
     * DONT DOCUMENT THIS
   */
    public String getRecordByID(String id)
    {
        String rec = "No Data.";
        
        if(!(id.equals("")))
        {
        try {    
                 RandomAccessFile raf = new RandomAccessFile("/home/ruaraidh/Documents/CS3024/src/FoodStorageTable.raf", "r");
                 raf.seek(headerL);
                 while(!(rec.contains("*"+id)) && (raf.getFilePointer() < raf.length()) && !(rec.contains("$$")))
                 {
                     rec = raf.readLine();
                 }
                 raf.close(); //Not sure if we need another .close() after catch, too sleepy to check
                 return rec;

            }
             

        catch (IOException ex) {
                 ex.printStackTrace();
                 System.out.println("could not open File.");
                 return rec;
                 }
        }
        return rec;
    }
    
    //get the ID from a captured record
    /**
     * DONT DOCUMENT THIS
  
     */
    public String getIdFromRec(String rec)
    {
        String id = "No Data.";
        int pound1 = 1;//1 pos after asterisk
        int pound2 = 6;//hard coded, first pound will always be @ pos 6

        if((rec.substring(0,1)+"").equals("*") && (rec.substring(6,7)+"").equals("#")) //This is a validation check to make sure ID is read correctly
        {
            id = rec.substring(pound1, pound2);
        }
        return id;
    }
    
    //find the position of the 1st, 2nd 3rd, etc. delimiter in a record.
    /**
     * DONT DOCUMENT THIS
     * 
     */
    private int findDelimPos(String rec, int pound)
    {
        int delimPos;
        int poundCount = 0;
        char[] recArr = rec.toCharArray();
        int i = 0;
        
        while(poundCount < pound)
        {
            if((recArr[i]+"").equals("#"))
            {
                poundCount++;
            }
            i++;
            if(i == recArr.length)
            {
                return -1; 
            }
        }

        delimPos = i;
        return delimPos;
        
    }
    
    //get Name from a captured record
    /**
     * DONT DOCUMENT THIS

     */
    public String getNameFromRec(String rec)
    {
        String name = "No Data.";
        int pound1 = 7;//hard coded, first pound will always be @ pos 6
        int pound2 = findDelimPos(rec, 2)-1;
        if(pound2 > -1) //This is a validation check to make sure there is a delimiter.
        {
            name = rec.substring(pound1, pound2);
            return name;
        }
        
        return name;
    }
    
    //get shelf life in room temp
    /**
     * DOCUMENT THIS
     * Calculates the Food use by date when stored at room temperature.
     * @param rec
     * @return The Food use by date at room temperature.
     */
    public int getRoomD(String rec)
   {
        int roomD = -1;
        int pound1 = findDelimPos(rec, 2);
        int pound2 = findDelimPos(rec, 3)-1;
        if((pound1 > -1) && (pound2 > -1)) //This is a validation check to make sure there is a delimiter.
        {
             roomD = Integer.parseInt(rec.substring(pound1, pound2));
        }
        return roomD;
   }
   
    /**
     * DOCUMENT THIS
     * Calculates the Food use by date when stored in the fridge.
     * @param rec
     * @return The Food use by date in the fridge.
     */
    public int getFridgeD(String rec)
   {
        int fridgeD = -1;
        int pound1 = findDelimPos(rec, 3);
        int pound2 = findDelimPos(rec, 4)-1;
        if((pound1 > -1) && (pound2 > -1)) //This is a validation check to make sure there is a delimiter.
        {
             fridgeD = Integer.parseInt(rec.substring(pound1, pound2));

        }
        return fridgeD;
       
   }
    /**
     * DOCUMENT THIS
     * Calculates the Food use by date when stored in the freezer.
     * @param rec
     * @return The Food use by date in the freezer.
     */
   public int getFreezerD(String rec)
   {
      int freezerD = -1;
        int pound1 = findDelimPos(rec, 4);
        int pound2 = findDelimPos(rec, 5)-1;
        
        if((pound1 > -1) && (pound2 > -1)) //This is a validation check to make sure there is a delimiter.
        {
             freezerD = Integer.parseInt(rec.substring(pound1, pound2));

        }
        return freezerD;
   }
   
    
} //end of class
