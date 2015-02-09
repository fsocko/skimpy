/**
 * @author Ruaraidh, FPS
 */
package BusinessLogic;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.*;

public class DBConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBConnect() //db is the name of the database.
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Skimpy", "root", "");
			st = (Statement) con.createStatement();
		}catch(Exception ex){
			System.out.println("Error:"+ex );
		}
	}

	public Food getFoodData(String ID){ //table is the name of the table within the database db
		try{
			rs = st.executeQuery("select * FROM fooditems WHERE ID=" +  ID);
			System.out.println("Records from Database");

			Food item = new Food(rs.getString("Name"),
									rs.getString("Units"),
									rs.getInt("Amount"),
									rs.getDouble("Serving"),
									rs.getDouble("tesco_price"),
									rs.getDouble("asda_price"),
									rs.getDouble("Calories"),
									rs.getDouble("Protein"),
									rs.getDouble("Carbs"),
									rs.getDouble("Sugars"),
									rs.getDouble("Fat"),
									rs.getDouble("Saturates"),
									rs.getDouble("Fibre"),
									rs.getDouble("Salt"));
			return item;
			
		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
	}
		
	public void getUserData(String ID){
		try{
			System.out.println("Records from Database");
			rs = st.executeQuery("select * FROM user_info WHERE ID=" + ID);
			while (rs.next()){
				String userName = rs.getString("UserName");
				String userEmail = rs.getString("UserEmail");
				int age = rs.getInt("Age");
				float weight = rs.getFloat("Weight");
				String gender = rs.getString("Gender");
				float exercise = rs.getFloat("Exercise");
				
				System.out.println(ID + userName + userEmail + age + weight + gender + exercise);
			}
	
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
		
	public void pushUser(Person user){
		try{
			String query = "INSERT INTO `user_info`(`UserName`, `UserEmail`, `Age`, `Height`, `Weight`, `Gender`, `Exercise`) VALUES ('" + 
							user.getName() +  "', '" + user.getEmail() + "', "  +
							user.getAge() + ", " + user.getHeight() + ", " + user.getWeight() + ", '" + user.getGender() + "', " + 
							user.getExercise() + ")";
			st.executeUpdate(query);
			System.out.println("Pushes to Database");
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
