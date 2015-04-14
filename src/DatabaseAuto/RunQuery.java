package DatabaseAuto;

/**
 * @author FPS
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RunQuery{
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public RunQuery()
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

	public void runQuery(String runQuery)

	{
		openCon();
		try{
			
			String query = runQuery;
			System.out.println(query);
			rs = st.executeQuery(query);
			
			
			while(rs.next())
			{

			}


			} 
			catch(Exception ex) 
			{
			System.out.println("Error:"+ex );	
			}	
			//close connections.
			finally 
			{
			closeCon();
			}			
	}
	
	
}
