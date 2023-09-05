import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertData {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";
		String pass = "ankitg489";
		
		try {
			
			//1. Get a connection to the database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Create a statement
			myStmt = myConn.createStatement();
			
			
			//3. Execute SQL Query (Insert a new employee)
			System.out.println("Inserting a new employee to database \n");
			
			int rowsAffected = myStmt.executeUpdate(
					"insert into employees " +
					"(last_name, first_name, email, department, salary) " +
					"values " +
					"( 'Lee', 'Bruce', 'bruce.lee@psu.edu', 'HR', 43000.00)"
					);
			
			int rowsAffected2 = myStmt.executeUpdate(
					"insert into employees " +
					"(last_name, first_name, email, department, salary) " +
					"values " +
					"( 'Chan', 'Jackie', 'jackie.chan@psu.edu', 'IT', 500000.00)"
					);
			
			//4. Verify this step by getting a list of employees
			myRs = myStmt.executeQuery("select * from employees order by last_name");
			
			//5. Process the result set
			while( myRs.next() )
			{
				System.out.println(
						
						myRs.getString("last_name") + ", " +
						myRs.getString("first_name")  + ", " +
						myRs.getString("email")	+ ", " +
						myRs.getString("department")
						
						);
			}
			
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
		finally {
			
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

}
