//author: FPS

package BusinessLogic;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.*;

public class DBConnectDelta {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnectDelta(String db) //db is the name of the database. 
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ db, "root", "");
			st = (Statement) con.createStatement();
		}catch(Exception ex){
			System.out.println("Error:"+ex );
		}
	}
	
public void pushFood(DBFood food, String dataBaseName)//foodItems
{
		try{
			String query = "insert into " + dataBaseName +"(shopID, Name, Units, Mass, Price, PricePUnit, FoodCat)"
					+ " values(" + 
							food.getShopID() + ", '" + food.getName() + "', '" + food.getUnit() + "', "  +
							food.getMass() + ", " + food.getPrice() + ", '" + food.getPricePU() + "', '" + 
							food.getFoodCat() + "');";
			
			System.out.println(query);
			
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
					
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}

}//EOF