import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDeleteData {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";
		String pass = "ankitg489";
		
		try {
			// Get a connection
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// Create a Statement
			myStmt = myConn.createStatement();
			
			// Call helper method to display the employee's information
			System.out.println("BEFORE THE DELETE...");
			displayEmployeeInformation(myConn, "Kevin", "Cotton");	
			
			//DELETE the employee
			System.out.println("\n DELETING THE EMPLOYEE: Kevin Cotton");
			
			int rowsAffected = myStmt.executeUpdate(
					"delete from employees " +
					"where last_name='Cotton' and first_name='Kevin'"
					);
			
			// Call helper method to display the employee's information
			System.out.println("ATER THE DELETE...");
			displayEmployeeInformation(myConn, "Kevin", "Cotton");	
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myConn, myStmt, myRs);
		}
		

	}
	
	private static void displayEmployeeInformation(Connection myConn, String firstName, String lastName)
	throws SQLException {
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("select last_name, first_name, email from employees where first_name=? and last_name=?");
			
			myStmt.setString(1, firstName);
			myStmt.setString(2, lastName);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();
			
			// Process result set
			boolean found = false;
			
			while (myRs.next())
			{
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				String email = myRs.getString("email");
				
				System.out.printf("%s %s, %s", theFirstName, theLastName, email);
				found = true;
				
			}
			
			if (!found) {
				System.out.println("Employee NOT FOUND: " + firstName + " " + lastName);
			}		
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException
	{
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
	
	private static void close(Statement myStmt, ResultSet myRs) throws SQLException
	{
		close(null, myStmt, myRs);
	}

}
