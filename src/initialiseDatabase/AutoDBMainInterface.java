//@Author: FPS
//A class for automatically setting up the SQL database.
//Runs a menu interface with options:
//A: initialise the database.
//B: Push scraper data from files to the DB.

package initialiseDatabase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import BusinessLogic.DBConnect;
import BusinessLogic.Food;
import BusinessLogic.SpiderToDB;

//Class for initialising the Database and running scrapers
public class AutoDBMainInterface {

    public static void main(String[] args) 
    {
	pushToDBMenu();
	DBInitMenu();
    }

    // Menu for setting up pushing to database
    public static void pushToDBMenu() {
	SpiderToDB std = new SpiderToDB();
	AutoDB adb = new AutoDB();

	try {
	    InputStreamReader cin = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(cin);
	    System.out.println("This script will initialise product tables,\nparse scraper data and push results to the DB.");
	    
	    System.out.println("Continue? (y/n)");
	    char continueInit = br.readLine().trim().toLowerCase().charAt(0);
	    switch (continueInit) {
	    case 'n':
		System.out.println("Push to DB cancelled.\n");
		System.exit(0);
		break;

	    case 'y':
		System.out.println("Select Supermarket to parse from.\nDefault is all supermarkets. (c to cancel)");
		System.out.println("['a' for ASDA, 's' for Sainsbury's, 't' for Tesco]");
		String supermarket = br.readLine().trim().toLowerCase();
		if (supermarket.toLowerCase().substring(0, 1).equals("c")) {
		    System.out.println("Cancel");
		    System.exit(0);
		    break;

		}
		if (supermarket.equals("")) {
		    System.out.println("Initialising all product tables.");
		    adb.initTable('a');
		    adb.initTable('s');
		    adb.initTable('t');
		   
		    System.out.println("Parsing and pushing all available data.");
		    System.out.print("Pushing ASDA data...");
		    adb.pushToDB('a');
		    System.out.print("Done\n");
		    System.out.print("Pushing Sainsbury's data...");
		    adb.pushToDB('s');
		    System.out.print("Done\n");
		    System.out.print("Pushing Tesco data...");
		    adb.pushToDB('t');
		    System.out.print("Done\n");
		    System.out.println("Pushed data from all supermarkets successfully.");
		    break;
		}
		char sm = supermarket.toLowerCase().charAt(0);
		switch (sm) {
		case 'a':
		    System.out.print("Pushing ASDA data...");
		    adb.initTable('a');
		    adb.pushToDB('a');
		    System.out.print("Done\n");
		    break;
		case 's':
		    System.out.print("Pushing Sainsbury's data...");
		    adb.initTable('s');
		    adb.pushToDB('s');
		    System.out.print("Done\n");
		    break;
		case 't':
		    System.out.print("Pushing Tesco data...");
		    adb.initTable('t');
		    adb.pushToDB('t');
		    System.out.print("Done\n");
		    break;
		default:
		    System.out.println("Invalid input.\n");
		    pushToDBMenu();
		    break;

		}
	    }
	} catch (IOException e) {
	    System.out.println("Sorry, an IOException Occured. \n\n"
		    + e.getMessage());
	}
    }

    // initialise the database using an existing SQL file.
    public static void DBInitMenu() {
	try {
	    InputStreamReader cin = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(cin);
	    System.out
		    .println("This script will drop the selected database if it exists, then initialise the selected database with values in the selected SQL file.");
	    System.out.println("Continue? (y/n)");
	    char continueInit = br.readLine().trim().toLowerCase().charAt(0);
	    switch (continueInit) {
	    case 'n':
		System.out.println("Database initialisation cancelled.\n");
		pushToDBMenu();
		break;
	    case 'y':
		System.out
			.println("Enter database name, default is \"skimpy\" (c to cancel)");
		System.out
			.println("Note: the database must be \"skimpy\" for business logic to function correctly. __");
		String DBName = br.readLine();
		if (DBName.trim().toLowerCase().equals("c")) {
		    System.out.println("Cancel.");
		    System.exit(0);
		    break;
		}
		if (DBName.trim().equals("")) {
		    System.out.println("Default database name.");
		    DBName = "skimpy";
		}

		System.out
			.println("Enter path of SQL file to use as your new database, "
				+ DBName + "(c to cancel)");
		System.out
			.println("Default is: \"\\SQLFiles\\database\\initDB.sql\" __ \n");
		String SQLPath = br.readLine();
		System.out.println(SQLPath);
		if (DBName.trim().toLowerCase().substring(0, 1).equals("c")) {
		    System.out.println("Cancel.");
		    System.exit(0);
		    break;
		}
		if (SQLPath.trim().equals("")) {
		    System.out.println("Default SQL path.");
		    SQLPath = "SQLFiles/database/initDB.sql";
		}
		AutoDB atb = new AutoDB();
		atb.initDB(DBName, SQLPath);
	    default:
		System.out.println("Invalid input.\n");
		DBInitMenu();
		break;

	    }
	} catch (IOException e) {
	    System.out.println("Sorry, an IOException Occured. \n\n"
		    + e.getMessage());
	}
    }
    
    public static void DBTableInitMenu() {
    	try {
    		while (true) {
				AutoDB adb = new AutoDB();
				InputStreamReader cin = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(cin);
				System.out.println("Which table would you like to initialize? Only first character will be read.");
				System.out.println("[a = asda, s = sains, t = tesco, u = user, q = exit]");
				char userInput = br.readLine().toLowerCase().charAt(0);
				switch (userInput) {
				case 'q':
					System.exit(0);
					break;
				case 'a':
					adb.initTable('a');
					break;
				case 's':
					adb.initTable('s');
					break;
				case 't':
					adb.initTable('t');
					break;
				case 'u':
					adb.initTable('u');
					break;
				}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}