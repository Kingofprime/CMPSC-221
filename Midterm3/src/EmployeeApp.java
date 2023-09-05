import java.sql.*;

public class EmployeeApp {

	public static void main(String[] args) throws SQLException {
		showSalaries();
		increaseSalaries("Pittsburgh", 20);
		System.out.println("\n After Update \n");
		showSalaries();
	}
	
	public static void increaseSalaries(String location, double percentIncrease) 
	{
	    try (
	        // Open a connection to the database.
	        Connection connection = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/midtermDB", "root", "ankitg489")) {

	        // Prepare a call to the stored procedure. The placeholders are represented by '?'.
	        CallableStatement cstmt = connection.prepareCall("{call increase_salaries_for_location(?, ?)}");

	        // Set the value for the first placeholder (1) as the 'location' parameter.
	        cstmt.setString(1, location);

	        // Set the value for the second placeholder (2) as the 'percentIncrease' parameter.
	        cstmt.setDouble(2, percentIncrease);

	        // Execute the update operation. This will run the stored procedure and update the data in the database.
	        cstmt.executeUpdate();

	    } catch (SQLException ex) {
	        // Print any SQL exceptions that occur during this process.
	        ex.printStackTrace();
	    }
	}

	
	public static void showSalaries() 
    {
        try {
            // Create a connection to the database.
            // You'll need to replace these values with your actual database connection info
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/midtermDB", "root", "ankitg489");

            // Create a statement
            Statement stmt = connection.createStatement();
            ResultSet myRs = null;
            // Write the SQL query

            System.out.println("\n Showing Salary data\n");
            
            String sql = "Select name, position, salary, location from employeeTB ";
            
            myRs = stmt.executeQuery(sql);
            
            while (myRs.next()) {
                // Print the details of each employee
                System.out.println(
                        myRs.getString("name") + ", " +
                        myRs.getString("position") + ", " +
                        myRs.getString("salary") + ","+
                        myRs.getString("location")
                );
            }
            
            // Don't forget to close the connections
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
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
