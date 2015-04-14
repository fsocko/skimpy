package DatabaseAuto;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;

import javax.servlet.http.HttpServlet;

//@Author: FPS
//Utility for automatically initialising the database.


public class AutoDB 
{
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
		
	public void openCon()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Skimpy", "root", "");
			st = (Statement) con.createStatement();
		}
		catch(Exception ex)
		{
			System.out.println("Error:"+ex );
		}
		
	}
	
	public void closeCon()

	{
		try 
		{
			st.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		try {
				con.close();
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	//Check if a database called "skimpy" is found when connected to localhost
	//as root with no password. if it exists, its tables get dropped. Else, it is created.
	
	public boolean SkimpyExists()
	{
		boolean dbExists = false;
		String databaseName = null;
		try 
		{
			openCon();
			rs = con.getMetaData().getCatalogs();
			while (rs.next()) 
			{
				System.out.println(rs.getString(1));
			  if(rs.getString(1).trim().equals("skimpy"))
			  {
				  dbExists = true;
				  break; 
			  }	  
			}
			rs.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		finally
		{
			closeCon();
		}

		return dbExists;
				
	}
	
	
	public void createDB()
	{
		
	}
	
	
	public static void importTables()
	{
		
	}
	
	public static void populateDB()
	{
		
	}

}
