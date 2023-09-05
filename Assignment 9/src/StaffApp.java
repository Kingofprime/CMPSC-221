import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * 
 * Example of a BLOB (Binary Large Object)
 * Types of BLOBS are: PDF, JPEG, JPG, PNG, etc.
 *
 */

public class StaffApp {
	
	public static void addImage(String image, String office) {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/blobdb";
		String user = "root";		
		String pass = "ankitg489";
		
		FileInputStream inputImage = null;
		
		try {
			
			//1. Get a connection
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Prepare statement
			String sql = "update staffTB set  image=? where office='"+office+"'";
			myStmt = myConn.prepareStatement(sql);
			
			//3. Set parameters for resume file name
			File theImageFile = new File(image);
			
			
			inputImage = new FileInputStream(theImageFile);
			
			myStmt.setBinaryStream(1, inputImage);
		
			
			System.out.println("Reading input file: " + theImageFile.getAbsolutePath());
			
			//4. Execute statement 
			
			System.out.println("\n Storing image in database: " + theImageFile);
			
			myStmt.executeUpdate();
			
			System.out.println("\n Completed successfully");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	
	}
	
	public static void getImage(String office) {
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/blobdb";
		String user = "root";		
		String pass = "ankitg489";
		
		InputStream input = null;
		FileOutputStream output = null;
		
		try {
			//1. Get a connection to the database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Execute statement
			myStmt = myConn.createStatement();
			String sql = "select image from stafftb where office='"+office+"'";
			myRs = myStmt.executeQuery(sql);
			
			//3. Setup a handle to the file
			File theFile = new File("images.jpg");
			output = new FileOutputStream(theFile); 
			
			if (myRs.next()) {
				
				input = myRs.getBinaryStream("image");
				System.out.println("Reading image from database... ");
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
	}

	public static void main(String[] args) throws Exception {
		
		addImage("brandywine.png","brandywine");
		System.out.println("\n\n\n");
		addImage("monaca.png","monaca");
		System.out.println("\n\n\n");
		addImage("pittsburgh.jpg","pittsburgh");
		System.out.println("\n\n\n");
		addImage("state_college.jpg","state college");
		System.out.println("\n\n\n");
		getImage("brandywine");
		
	}
	

}
