import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/** 
 * Test calling stored procedure with OUT parameters
 * 
 * **/

public class GetCountForDepartment {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			String theDepartment = "HR";
			
			//Prepare the stored procedure call
			myStmt = myConn.prepareCall( " {call get_count_for_department(?, ?)} " );
			
			//Set the parameters
			myStmt.setString(1, theDepartment);
			myStmt.registerOutParameter(2, Types.INTEGER);
			
			//Call stored procedures
			System.out.println( " Calling stored procedure. get_count_for_department(' " + theDepartment + " ', ? )   " );
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			//Get the value of the OUT parameter
			int theCount = myStmt.getInt(2);
			
			System.out.println("\nThe count = " + theCount);
			
			
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			
			close (myConn, myStmt);
		}
		

	}
	
	private static void close (Connection myConn, Statement myStmt) throws SQLException{
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
