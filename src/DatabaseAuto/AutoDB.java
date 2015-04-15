package DatabaseAuto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;


//@Author: FPS
//Utility for automatically initialising the database.
//Some code modified from http://www.tutorialspoint.com/jdbc
public class AutoDB
{
	 // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   
	   public void dropDB() 
	   {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.print("Connecting to " + DB_URL + "...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.print("Done\n");
	      
	      //STEP 4: Execute a query - Drop Database
	      stmt = conn.createStatement();
	      
	      String drop = "DROP DATABASE IF EXISTS skimpy_test;";
	      System.out.print("Dropping skimpy_test database if it exists...");
	      stmt.executeUpdate(drop);
	      System.out.print("Done\n");
	      
	      //STEP 5: Create Skimpy test DB
	      System.out.print("creating skimpy_test database...");
	      String add = "";
	      stmt.executeUpdate(add);
	      System.out.print("Done\n");
	      
	      
	      
	      //STEP 6: Setup scriptRunner class to add all tables as read from an SQL template
	      System.out.print("Adding tables as defined in data/skimpy_T.sql...");
	      File file = new File("data/skimpy_T.sql");
	      file.createNewFile();
	      FileReader fr = new FileReader(file);
	      ScriptRunner sr = new ScriptRunner(conn, false, true);
	      sr.runScript(fr);
	      System.out.print("Done\n");
	      
	      
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


