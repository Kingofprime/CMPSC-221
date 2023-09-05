import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
				
		
		try {
			
			//1. Load the properties file
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));
			//props.load(new FileInputStream("C:\\Users\\rkl5137\\Documents\\CMPSC_221\\workspace\\WorkR_PropertiesConfiguration\\demo.properties"));
			
			
			//2. Read the props
			String theUser = props.getProperty("username");
			String thePassword = props.getProperty("password");
			String theUrl = props.getProperty("dbUrl");
			
			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theUrl);
			System.out.println("User: " + theUser + "\n\n");
			
			
			
			//3. Get a connection
			myConn = DriverManager.getConnection(theUrl, theUser, thePassword);
			
			//4. Create a statement
			myStmt = myConn.createStatement();
			
			//5. Execute SQL Query
			myRs = myStmt.executeQuery("select * from employees");
			
			//6. Process the result set
			while (myRs.next()) {
				System.out.println(
						
						myRs.getString("last_name") + ", " +
						myRs.getString("first_name")
						
						);
			}			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			
			close(myConn, myStmt, myRs);			
		}
	}
	
	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}
}
