import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
 * Test calling stored procedure with IN parameter
 * 
 * **/

public class GetEmployeesForDepartment {
	
public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			String theDepartment = "Legal";
			
			//Prepare the stored procedure call
			myStmt = myConn.prepareCall( " {call get_employees_for_department (?) } " );
			
			//Set the parameter
			myStmt.setString(1, theDepartment);
			
			//Call stored procedures
			System.out.println( " Calling stored procedure. get_employees_for_department(' " + theDepartment + " ')  " );
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			//Get the result set
			myRs = myStmt.getResultSet();
			
			//Display the result set
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
	//Process the result set
	
	try {
		
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

}
