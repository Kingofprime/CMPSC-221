import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatement {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";
		String pass = "ankitg489";
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			// 2. Prepare statement
			//myStmt = myConn.createStatement();
			myStmt = myConn.prepareStatement(
					"select * from employees where salary > ? and department=?"
					);
			
			// 3. Set the parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			// 4. Execute SQL query
			myRs = myStmt.executeQuery();
			
			// 5. Display the result set
			display (myRs);	
			
			/** 
			 * Reuse the prepared statement: salary > 25000, department = HR
			 * **/
			System.out.println(
					"\nResuse the prepared statement : salary > 25000, department = HR"
					);
			
			// 6. Set the parameters
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			// 7. Execute the SQL query
			myRs = myStmt.executeQuery();
			
			// 8. Display the result set
			display(myRs);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myConn, myStmt, myRs);			
		}

	}
	
	private static void display(ResultSet myRs) throws SQLException
	{
		while ( myRs.next() ) {
			String theLastName = myRs.getString("last_name");
			String theFirstName = myRs.getString("first_name");
			String theDepartment = myRs.getString("department");
			double theSalary = myRs.getDouble("salary");
			
			System.out.printf("%s, %s, %.2f, %s \n", theLastName, theFirstName, theSalary, theDepartment);
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

}
