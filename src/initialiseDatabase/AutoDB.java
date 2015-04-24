//@Author: FPS
package initialiseDatabase;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;


//@Author: FPS
//Utility for automatically initialising the database.
//Some code modified from http://www.tutorialspoint.com/jdbc
public class AutoDB
{
	public static void main(String[] args) 
	{

	}
	// JDBC driver name and database URL
	   static final String localHost = "jdbc:mysql://localhost/";
	   //  Database credentials
	   static final String user = "root";
	   static final String pass = "";
	   
	   public void initialiseDB(String SQLfilePath)
	   {
		   //Initialise as skimpy by default. pass a String with a different DBname for testing. 
		   initialiseDB("skimpy", SQLfilePath);
	   }
	   
	   public void initialiseDB(String DBName, String SQLPath) 
	   {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //Open a connection
	      System.out.print("Connecting to " + localHost + " ...");
	      conn = DriverManager.getConnection(localHost, user, pass);
	      System.out.print("Done\n");
	      
	      //Execute a query - Drop Database
	      stmt = conn.createStatement();
	      
	      String drop = "DROP DATABASE IF EXISTS " +DBName +";";
	      System.out.print("Dropping " +DBName+ " database if it exists...");
	      stmt.executeUpdate(drop);
	      System.out.print("Done\n");
	      
	      //Create Skimpy test DB
	      System.out.print("Creating database: "+ DBName +" ...");
	      String add = "CREATE DATABASE "+DBName+ ";";
	      stmt.executeUpdate(add);
	      System.out.print("Done\n");
	      
	      //Close original conn
	   	  }
		   catch(SQLException se)
		   {	System.out.println("Sorry, there is a problem with the SQL server.\n\n");
			   se.printStackTrace();}
		   catch(Exception e)
		   {	System.out.println("Sorry, the following exception occurred:\n\n");
			   e.printStackTrace();
		   }
			   finally{
			      try{
			         if(conn!=null)
			        	 System.out.print("Closing original Connection to "+ localHost + "...");
			        	 conn.close();
			        	 System.out.print("Done\n");
				      }catch(SQLException se)
				      {
				         se.printStackTrace();
				      }
			      
 
		 //Select database
		 System.out.print("Selecting "+DBName+ " database...");
		 conn = null;
		 try{
			 conn = DriverManager.getConnection("jdbc:mysql://localhost/" + DBName, user, pass);
			 System.out.print("Done\n");

	      //Setup scriptRunner class to add all tables as read from an SQL template
	      System.out.print("Adding tables as defined in " +SQLPath+"...\n\n");
	      File file = new File(SQLPath); //TODO:This is the line to change 
	      //if the default SQL file is not in data
	      file.createNewFile();
	      FileReader fr = new FileReader(file);
	      AutoDBScriptRunner sr = new AutoDBScriptRunner(conn, false, true);
	      sr.runScript(fr);
	      System.out.print("\nDone. Database initialised with no errors.\n");
	      
	      
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	}
  }
}


