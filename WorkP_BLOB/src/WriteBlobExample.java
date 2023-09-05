import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * 
 * Example of a BLOB (Binary Large Object)
 * Types of BLOBS are: PDF, JPEG, JPG, PNG, etc.
 *
 */

public class WriteBlobExample {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		FileInputStream input = null;
		FileInputStream inputImage = null;
		
		try {
			
			//1. Get a connection
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Prepare statement
			String sql = "update employees set resume=?, image=? where email='carey.jones@psu.edu'";
			myStmt = myConn.prepareStatement(sql);
			
			//3. Set parameters for resume file name
			File theResumeFile = new File("resume_file.pdf");
			File theImageFile = new File("photo.jpg");
			
			input = new FileInputStream(theResumeFile);
			inputImage = new FileInputStream(theImageFile);
			
			myStmt.setBinaryStream(1, input);
			myStmt.setBinaryStream(2, inputImage);
			
			System.out.println("Reading input file: " + theResumeFile.getAbsolutePath());
			System.out.println("Reading input file: " + theImageFile.getAbsolutePath());
			
			//4. Execute statement 
			System.out.println("\n Storing resume in database: " + theResumeFile);
			System.out.println("\n Storing image in database: " + theImageFile);
			
			myStmt.executeUpdate();
			
			System.out.println("\n Completed successfully");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (input != null)
			{
				input.close();
			}
			
			if (inputImage != null)
			{
				inputImage.close();
			}
			
			
			close(myConn, myStmt);
		}
	}
	
	private static void close(Connection myConn, Statement myStmt) 
			throws SQLException {
		
		if(myStmt != null) {
			myStmt.close();
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

}
