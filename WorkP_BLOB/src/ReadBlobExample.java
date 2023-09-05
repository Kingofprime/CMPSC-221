import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadBlobExample {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		InputStream input = null;
		FileOutputStream output = null;
		
		try {
			//1. Get a connection to the database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Execute statement
			myStmt = myConn.createStatement();
			String sql = "select resume from employees where email='carey.jones@psu.edu'";
			String sql_image = "select image from employees where email='carey.jones@psu.edu'";
			myRs = myStmt.executeQuery(sql);
			
			//3. Setup a handle to the file
			File theFile = new File("resume_file_from_db.pdf");
			//File theFile = new File("photo_file_from_db.jpg");
			output = new FileOutputStream(theFile); 
			
			if (myRs.next()) {
				
				input = myRs.getBinaryStream("resume");
				System.out.println("Reading resume from database... ");
				System.out.println(sql);
				
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
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
			
			close (myConn, myStmt, myRs);
		}
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) 
			throws SQLException {
		
		if(myRs != null) {
			myRs.close();
		}
		
		if(myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

}
