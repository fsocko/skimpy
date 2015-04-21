//@Author: FPS
package initialiseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class AutoDBMainInterface {

	public static void main(String[] args) 
	{
		DBInitMenu();
	}
	
	//parse data from web scrapers and push data to database
	public static void spidersToDB()
	{
		
		
	}
	//initialise the database using an existing SQL file.
	public static void DBInitMenu()
	{
		
		try {
			InputStreamReader cin = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(cin);
			System.out.println("This script will drop the selected database if it exists, then initialise the selected database with values in the selected SQL file.");
			System.out.println("Continue? (y/n)\n");
			char continueInit = br.readLine().trim().toLowerCase().charAt(0);
			switch(continueInit)
			{
				case 'n':
					System.out.println("Database initialisation cancelled.");
					System.exit(0);
					break;
				case 'y':
				
				System.out.println("Enter database name, default is \"skimpy\" __\n");
				String DBName = br.readLine();
				if(DBName.trim().equals(""))
				{
					System.out.println("Default database name.");
					DBName = "skimpy";	
				}

				System.out.println("Enter path of SQL file to use as your new database, " + DBName + " __");
				System.out.println("Default is: \"Skimpy/SQLFiles/database/initDB.sql\" \n");
				String SQLPath = br.readLine();
				if(SQLPath.trim().equals(""))
				{
					System.out.println("Default SQL path.");
					SQLPath = "SQLFiles/database/initDB.sql";	
				}
				
				AutoDB atb = new AutoDB();
				atb.initialiseDB(DBName, SQLPath);
				break;
				}
			}
			catch (IOException e)
			{
				System.out.println("Sorry, an IOException Occured. \n\n" + e.getMessage());
			}
	
	}
}