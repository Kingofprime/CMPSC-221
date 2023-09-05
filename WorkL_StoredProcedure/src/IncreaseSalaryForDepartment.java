import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * Test calling stored procedure with IN parameters
 * 
 * **/

public class IncreaseSalaryForDepartment {
	
public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			String theDepartment = "Legal";
			int theIncreaseAmount = 10000;
			
			//Show salaries BEFORE
			System.out.println("Salaries BEFORE \n");
			showSalaries(myConn, theDepartment);
			
			//Prepare the stored procedure call
			myStmt = myConn.prepareCall( " {call increase_salaries_for_department (?, ?) } " );
			
			//Set the parameter
			myStmt.setString(1, theDepartment);
			myStmt.setDouble(2, theIncreaseAmount);
			
			//Call stored procedures
			System.out.println( 
					"\n\nCalling stored procedures. increase_salaries_for_department ('" + theDepartment + "', " + theIncreaseAmount + ")");
			
			myStmt.executeQuery();
			System.out.println("Finished calling stored procedure");
			
			//Show salaries AFTER
			System.out.println("\n\n Salaries AFTER \n");
			showSalaries(myConn, theDepartment);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close(myConn, myStmt, null);
			
		}
	}

	private static void showSalaries( Connection myConn, String theDepartment) throws SQLException 
	{
	
		PreparedStatement myStmt = null;
		ResultSet myRs = null; 	
		
		try {
			
			//Prepare statement
			myStmt = myConn
					.prepareStatement("select * from employees where department=?");
			
			myStmt.setString(1, theDepartment);
			
			//Execute SQL query
			myRs = myStmt.executeQuery();
			
			//Process the result set
					
			while (myRs.next()) {
				String theLastName = myRs.getString("last_name");
				String theFirstName = myRs.getString("first_name");
				double theSalary = myRs.getDouble("salary");
				String department = myRs.getString("department");
					
				System.out.printf("%s, %s, %s, %.2f\n", theLastName, theFirstName, department, theSalary);
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			close (myStmt, myRs);
		}
	
	}

 	private static void close (Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException{
			
			 if (myRs != null)
			 {
				myRs.close();
			  }
	 
	 		if (myStmt != null)
			{
				myStmt.close();
			}
			
			if (myConn != null)
			{
				myConn.close();
			}
 	}
 
 	private static void close (Statement myStmt, ResultSet myRs) throws SQLException{
		
	 close(null, myStmt, myRs);
 	}

}
