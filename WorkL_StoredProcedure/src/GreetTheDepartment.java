import java.sql.*;

/** 
 * Test calling stored procedure with INOUT parameters
 * 
 * **/

public class GreetTheDepartment {

	public static void main(String[] args) throws Exception {
		
		Connection myConn = null;
		CallableStatement myStmt = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		try {
			// Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			String theDepartment = "IT";
			
			//Prepare the stored procedure call
			myStmt = myConn.prepareCall( " {call greet_the_department(?)} " );
			
			//Set the parameters
			myStmt.registerOutParameter(1, Types.VARCHAR);
			myStmt.setString(1, theDepartment);
			
			//Call stored procedures
			System.out.println( " Calling stored procedure. greet_the_department(' " + theDepartment + " ')  " );
			myStmt.execute();
			System.out.println("Finished calling stored procedure");
			
			//Get the value of the INOUT parameter
			String theResult = myStmt.getString(1);
			
			System.out.println("\nThe result = " + theResult);
			
			
			
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
