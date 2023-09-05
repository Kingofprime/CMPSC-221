import java.sql.*;
public class JDBCReadData {

	public static void main(String[] args) throws SQLException {
		showSalaries();
		increaseSalaries("Pittsburgh", 20);
		showSalaries();
		
	}
	public static void increaseSalaries(String location, double percentIncrease) 
	{
		try (Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/midtermDB", "root", "ankitg489")) {

			CallableStatement cstmt = connection.prepareCall("{call increase_salaries_for_location(?, ?)}");
			cstmt.setString(1, location);
			cstmt.setDouble(2, percentIncrease);
			cstmt.executeUpdate();

		} catch (SQLException ex) {
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
            
            String sql1 = "Select name, position, salary, location from employeeTB ";
            
            myRs = stmt.executeQuery(sql1);
            
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
}
