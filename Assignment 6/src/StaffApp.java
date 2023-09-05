import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StaffApp {

    public static void main(String[] args) throws SQLException {

        // Initialize database connection and statement variables
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        // Database URL, username and password
        String dbUrl = "jdbc:mysql://localhost:3306/assignmentdb";
        String user = "root";
        String pass = "ankitg489";

        try {
            // Establish the connection with the database
            myConn = DriverManager.getConnection(dbUrl, user, pass);

            // Create a statement to execute SQL commands
            myStmt = myConn.createStatement();

            // Insert new staff members into the database
            System.out.println("Inserting a new staff member to the database \n");

            
            // Execute insert SQL statements and get number of rows affected
            int rowsAffected = myStmt.executeUpdate(
                    "INSERT INTO staffTB " +
                    "(Name, Position, Office, Age, `Start Date`, salary) " +"VALUES " +
                    "('Richard Lomotey', 'Assoc Professor', 'Monaca', 40, '2015-06-01', '$50,000')"
            );

            int rowsAffected2 = myStmt.executeUpdate(
                    "INSERT INTO staffTB " +
                    "(Name, Position, Office, Age, `Start Date`, salary) " +"VALUES " +
                    "('Ashu Kumar', 'Instructor', 'Pittsburgh', 42, '2016-01-15', '$90,000')"
            );

            int rowsAffected3 = myStmt.executeUpdate(
                    "INSERT INTO staffTB " +
                    "(Name, Position, Office, Age, `Start Date`, salary) " +"VALUES " +
                    "('Steven Doe', 'Instructor', 'Brandywine', 37, '2011-07-20', '$120,000')"
            );

            int rowsAffected4= myStmt.executeUpdate(
                    "INSERT INTO staffTB " +
                    "(Name, Position, Office, Age, `Start Date`, salary) " +"VALUES " +
                    "('Carey Kwadzo', 'DAA', 'State College', 47, '2021-03-15', '$300,000')"
            );

            // Execute a SQL query to fetch all employees, ordered by their names
            myRs = myStmt.executeQuery("SELECT * FROM staffTB ORDER BY NAME ");

            // Process the result set
            while (myRs.next()) {
                // Print the details of each employee
                System.out.println(
                        myRs.getString("Name") + ", " +
                        myRs.getString("Position") + ", " +
                        myRs.getString("Office") + ", " +
                        myRs.getString("Age") + ", " +
                        myRs.getString("Start Date") + ", " +
                        myRs.getString("salary")
                );
            }

            System.out.println("\n Write another code that prints the name and salary of staff who are older than 30 years. \n");
            
            // Execute a SQL query to fetch employees who are older than 30 years
            myRs = myStmt.executeQuery("SELECT `Name`, `salary` "+ "FROM `staffTB` "+ "WHERE `Age` > 30;");
            
            // Process the result set
            while (myRs.next()) {
                // Print the name and salary of each qualifying employee
                System.out.println(
                        myRs.getString("Name") + ", " +
                        myRs.getString("salary")
                );
            }
            updateStevenDoe();
            deleteAshtonCox();
        } catch (Exception exc) {
            // Print any error messages that occur during execution
            exc.printStackTrace();
        } finally {
            // Close the resources
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

    public static void updateStevenDoe() 
    {
        try {
            // Create a connection to the database.
            // You'll need to replace these values with your actual database connection info
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/assignmentdb", "root", "ankitg489");

            // Create a statement
            Statement stmt = connection.createStatement();
            ResultSet myRs = null;
            // Write the SQL query
            String sql = "UPDATE stafftb SET position = 'Adjunct Professor', age = 38, salary = '$150,000' WHERE name = 'Steven Doe'";

            // Execute the query
            stmt.executeUpdate(sql);
            
            System.out.println("\n Editing the Steven Doe data\n");
            
            String sql1 = "Select * from stafftb where name ='Steven Doe'";
            
            myRs = stmt.executeQuery(sql1);
            
            while (myRs.next()) {
                // Print the details of each employee
                System.out.println(
                        myRs.getString("Name") + ", " +
                        myRs.getString("Position") + ", " +
                        myRs.getString("Office") + ", " +
                        myRs.getString("Age") + ", " +
                        myRs.getString("Start Date") + ", " +
                        myRs.getString("salary")
                );
            }
            
            // Don't forget to close the connections
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteAshtonCox() {
        try {
            // Create a connection to the database.
            // You'll need to replace these values with your actual database connection info
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/assignmentdb", "root", "ankitg489");

            // Create a statement
            Statement stmt = connection.createStatement();
            ResultSet myRs = null;

            // Write the SQL query
            String sql = "DELETE FROM stafftb WHERE name = 'Ashton Cox'";

            // Execute the query
            stmt.executeUpdate(sql);
            System.out.println("\n Deleting the Ashton Cox data\n");
            
            String sql1 = "Select * from stafftb";
            
            myRs = stmt.executeQuery(sql1);
            
            while (myRs.next()) {
                // Print the details of each employee
                System.out.println(
                        myRs.getString("Name") + ", " +
                        myRs.getString("Position") + ", " +
                        myRs.getString("Office") + ", " +
                        myRs.getString("Age") + ", " +
                        myRs.getString("Start Date") + ", " +
                        myRs.getString("salary")
                );
            }
            
            // Don't forget to close the connections

            // Don't forget to close the connections
            stmt.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



