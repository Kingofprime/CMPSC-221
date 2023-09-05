import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * Example of a CLOB (Character Large Object)
 * Type of BLOB  is: .txt file.
 *
 */

public class WriteClobExample {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		FileReader input = null;
		
		try {
			//1. Get a connection
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Prepare statement
			String sql = "update employees set resume=? where email='carey.jones@psu.edu'";
			myStmt = myConn.prepareStatement(sql);
			
			//3. Set parameters for resume file name
			File theResumeFile = new File("resume.txt");
			input = new FileReader(theResumeFile);
			myStmt.setCharacterStream(1, input);
			
			System.out.println("Reading input file: " + theResumeFile.getAbsolutePath());
			
			//4. Execute statement 
			System.out.println("\n Storing resume in database: " + theResumeFile);
			System.out.println(sql);
			
			myStmt.executeUpdate();
			
			System.out.println("\n Completed successfully");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (input != null) {
				input.close();
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
