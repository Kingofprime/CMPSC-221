import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateData {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";
		String pass = "ankitg489";

		try {
			//Get a connection
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//Create a statement
			myStmt = myConn.createStatement();
			
			// Call helper method to display the employee's information
			System.out.println("BEFORE THE UPDATE...");
			displayEmployeeInformation(myConn, "Bruce", "Lee");
			
			//UPDATE the employee
			System.out.println("\n EXECUTING THE UPDATE FOR: Bruce Lee \n");
			
			int rowsAffected = myStmt.executeUpdate(
					"update employees " +
					//"set email='b.lee@psu.edu' " +
					"set salary=550000.00 " +
					"where last_name='Lee' and first_name='Bruce'"					
					);
			
			// Call helper method to display the employee's information
			System.out.println("ATER THE UPDATE...");
			displayEmployeeInformation(myConn, "Bruce", "Lee");
			
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
			//Prepare statement
			myStmt = myConn
					.prepareStatement("select last_name, first_name, email, salary from employees where first_name=? and last_name=?");
			
			myStmt.setString(1, firstName);
			myStmt.setString(2, lastName);
			
			//Execute SQL query
			myRs = myStmt.executeQuery();
			
			//Process result set
			while (myRs.next())
			{
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				String email = myRs.getString("email");
				double salary = myRs.getDouble("salary");
				
				System.out.printf("%s %s, %s %.2f", theFirstName, theLastName, email, salary);
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
		close (null, myStmt, myRs);
	}
	
	

}
