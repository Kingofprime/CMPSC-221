import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ReadClobExample {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		Reader input = null;
		FileWriter output = null;
		
		try {
			//1. Get a connection
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
			
		
			
			//2. Execute statement
			myStmt = myConn.createStatement();
			String sql = "select resume from employees where id=1";
			myRs = myStmt.executeQuery(sql);
			
			//3. Setup a handle to the file
			File theFile = new File("resume_from_db.txt");
			output = new FileWriter(theFile);
			
			if (myRs.next()) {
				
				input = myRs.getCharacterStream("resume");
				System.out.println("Reading resume from database..." );
				System.out.println(sql);
				
				int theChar;
				while ((theChar = input.read()) > 0) {
					output.write(theChar);
				}
				
				System.out.println("\n Saved to file: " + theFile.getAbsolutePath());
				
				System.out.println("\n Completed successfully");
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (input != null) {
				input.close();
			}
			
			if (output != null) {
				output.close();
			}
			
			close(myConn, myStmt);			
		}
	}
	
	private static void close(Connection myConn, Statement myStmt)
			throws SQLException {

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

}
