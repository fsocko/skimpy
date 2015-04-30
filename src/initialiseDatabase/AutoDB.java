//@Author: Filip Socko
//Utility for automatically initialising the database.
//Some code modified from http://www.tutorialspoint.com/jdbc
package initialiseDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLogic.DBConnect;
import BusinessLogic.Food;
import BusinessLogic.SpiderToDB;

import com.mysql.jdbc.*;

public class AutoDB {

    // initDB();// initialise DB using contents from default init file.
    // initTable('a'); initialise Asda table.
    // initTable('s'); sainsbury's
    // initTable('t'); tesco
    // initTable('u'); user_info

    // JDBC driver name and database URL
    static final String localHost = "jdbc:mysql://localhost/";
    // Database credentials
    static final String user = "root";
    static final String pass = "";
    
    // This array stores names of tables.
    static final String[] tableNames = { "asda", "sains", "tesco", "user_info" };

    // initialise a table in skimpy database.
    // a for ASDA
    // s for Sainsbury's
    // t for Tesco
    // u for user_info
    
    public void initTable(char dTable) {
	// these Arrays contain the filepath of SQL files used as
	// templates for initialising the tables. they produce
	// empty, initialised tables when run.
	
	final String[] SQLFiles = { "SQLFiles/initDB/asdaInit.sql",
		"SQLFiles/initDB/sainsInit.sql",
		"SQLFiles/initDB/tescoInit.sql", "SQLFiles/initDB/userInit.sql" };

	String SQLPath = null; // filepath of input SQL file
	String tableName = null; // name of table to drop and initialise

	switch (dTable) {
	case 'a':
	    SQLPath = SQLFiles[0];
	    tableName = tableNames[0];
	    break;

	case 's':
	    SQLPath = SQLFiles[1];
	    tableName = tableNames[1];
	    break;

	case 't':
	    SQLPath = SQLFiles[2];
	    tableName = tableNames[2];
	    break;

	case 'u':
	    SQLPath = SQLFiles[3];
	    tableName = tableNames[3];
	    break;

	default:
	    System.out.println("Invalid input.");
	    System.exit(0);
	    break;
	}

	Connection conn = null;
	Statement stmt = null;

	try {
	    // Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    // Connect to skimpy DB
	    System.out.print("Selecting database...");
	    conn = null;

	    conn = DriverManager.getConnection("jdbc:mysql://localhost/skimpy",
		    user, pass);
	    System.out.print("Done\n");

	    // Execute a query - Drop Table
	    stmt = conn.createStatement();

	    String dropT = "DROP TABLE IF EXISTS " + tableName + ";";
	    System.out.print("Dropping " + tableName + " if it exists...");
	    stmt.executeUpdate(dropT);
	    System.out.print("Done\n");

	    // initialise selected table from SQL
	    System.out.print("Creating table, " + tableName
		    + " as defined in \"" + SQLPath + "\":  ...");

	    // Setup scriptRunner class to add all tables as read from an
	    // SQL template

	    File file = new File(SQLPath);
	    FileReader fr = new FileReader(file);
	    AutoDBScriptRunner sr = new AutoDBScriptRunner(conn, false, true);
	    sr.runScript(fr);
	    System.out.print("\nDone. Database initialised with no errors.\n");

	} catch (SQLException se) {
	    System.out
		    .println("Sorry, there is a problem with the SQL server.\n\n");
	    se.printStackTrace();
	} catch (Exception e) {
	    System.out.println("Sorry, the following exception occurred:\n\n");
	    e.printStackTrace();
	} finally {
	    if (conn != null) {
		System.out.print("Closing original Connection to " + localHost
			+ "...");
		try {
		    conn.close();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		System.out.print("Done\n");

	    }
	}
    }

    // initialise Skimpy DB with default SQL file
    public void initDB() {
	initDB("skimpy", "SQLFiles/initDB/initDB.sql");
    }

    // initialise Skimpy DB with selected SQL file.
    public void initDB(String SQLfilePath) {
	// Initialise as skimpy by default. pass a String with a different
	// DBname for testing.
	initDB("skimpy", SQLfilePath);
    }

    public void initDB(String DBName, String SQLPath) {
	Connection conn = null;
	Statement stmt = null;
	try {
	    // Register JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");

	    // Open a connection
	    System.out.print("Connecting to " + localHost + " ...");
	    conn = DriverManager.getConnection(localHost, user, pass);
	    System.out.print("Done\n");

	    // Execute a query - Drop Database
	    stmt = conn.createStatement();

	    String drop = "DROP DATABASE IF EXISTS " + DBName + ";";
	    System.out
		    .print("Dropping " + DBName + " database if it exists...");
	    stmt.executeUpdate(drop);
	    System.out.print("Done\n");

	    // Create Skimpy test DB
	    System.out.print("Creating database: " + DBName + " ...");
	    String add = "CREATE DATABASE " + DBName + ";";
	    stmt.executeUpdate(add);
	    System.out.print("Done\n");

	    // Close original conn
	} catch (SQLException se) {
	    System.out
		    .println("Sorry, there is a problem with the SQL server.\n\n");
	    se.printStackTrace();
	} catch (Exception e) {
	    System.out.println("Sorry, the following exception occurred:\n\n");
	    e.printStackTrace();
	} finally {
	    try {
		if (conn != null)
		    System.out.print("Closing original Connection to "
			    + localHost + "...");
		conn.close();
		System.out.print("Done\n");
	    } catch (SQLException se) {
		se.printStackTrace();
	    }

	    // Select database
	    System.out.print("Selecting " + DBName + " database...");
	    conn = null;
	    try {
		conn = DriverManager.getConnection("jdbc:mysql://localhost/"
			+ DBName, user, pass);
		System.out.print("Done\n");

		// Setup scriptRunner class to add all tables as read from an
		// SQL template
		System.out.print("Adding tables as defined in " + SQLPath
			+ "...\n\n");
		File file = new File(SQLPath);
		// if the default SQL file is not in data
		file.createNewFile();
		FileReader fr = new FileReader(file);
		AutoDBScriptRunner sr = new AutoDBScriptRunner(conn, false,
			true);
		sr.runScript(fr);
		System.out
			.print("\nDone. Database initialised with no errors.\n");

	    } catch (SQLException se) {
		se.printStackTrace();
	    } catch (Exception e) {
		e.printStackTrace();
	    } finally {

		try {
		    if (stmt != null)
			conn.close();
		} catch (SQLException se) {
		}// do nothing
		try {
		    if (conn != null)
			conn.close();
		} catch (SQLException se) {
		    se.printStackTrace();
		}
	    }
	}
    }

    // Menu for setting up pushing to database. This method selects the correct path and tablename
    public void pushToDB(char sm) 
    {
	 String tescoPath = "data/tesco.txt";
	 String sainsPath = "data/sains.txt";
	 String asdaPath = "data/asda.txt";

		switch (sm) 
		{
		case 'a':
		    System.out.print("Pushing ASDA data...");
		    executePush(asdaPath, "asda");
		    System.out.println("Done\n");
		    break;
		case 's':
		    System.out.print("Pushing Sainsbury's data...");
		    executePush(sainsPath, "sains");
		    System.out.println("Done\n");
		    break;
		case 't':
		    System.out.print("Pushing Tesco data...");
		    executePush(tescoPath, "tesco");
		    System.out.println("Done\n");
		    break;
		default:
		    System.out.println("Invalid input.\n");
		    break;

		}
	    }
  
    	//push data from scraper files to database. This method creates the connection and pushes
	public void executePush(String path, String table)
	{
		SpiderToDB std = new SpiderToDB();
		DBConnect toDB = new DBConnect();
		ArrayList Items = new ArrayList(std.readAllRecords(path));
		System.out.println("Formatting ArrayList records and pushing to DB...\n");
		
		int i = 1;
		int t = std.countLines(path);
		while(i < t)
		{
			Food foodItem = std.formatRecord(path, Items.get(i).toString().trim());	
			if(foodItem != null)
			{
				toDB.pushFood(foodItem, table);				
				progBar((10*(i*100)/(t*10)));
			}
			       
			i++;
		}
	}
		//Modified this method by Nakkaya.com. It displays a progressbar.
		public static void progBar(int percent)
		{
		    StringBuilder bar = new StringBuilder("[");

		    for(int i = 0; i < 50; i++){
		        if( i < (percent/2)){
		            bar.append("=");
		        }else if( i == (percent/2)){
		            bar.append(">");
		        }else{
		            bar.append(" ");
		        }
		    }

		    bar.append("]   " + percent + "%     ");
		    System.out.print("\r" + bar.toString());
		}
}
