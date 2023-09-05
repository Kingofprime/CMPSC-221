import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataBasicInfo {

	public static void main(String[] args) throws SQLException {
		
		Connection myConn = null;
		
		String dbUrl = "jdbc:mysql://localhost:3306/employees_db";
		String user = "root";		
		String pass = "ankitg489";
		
		try {
			
			//1. Get a connection to database
			myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//2. Get metadata
			DatabaseMetaData databaseMetaData = myConn.getMetaData();
			
			//3. Display info about JDBC Driver
			System.out.println(
					"JDBC Driver Name: " + databaseMetaData.getDriverName()
					);
			
			System.out.println(
					"JDBC Driver Version: " + databaseMetaData.getDriverVersion()
					);
			
			System.out.println(
					"JDBC Driver Major Version: " + databaseMetaData.getDriverMajorVersion()
					);
			
			System.out.println(
					"JDBC Driver Minor Version: " + databaseMetaData.getDriverMinorVersion()
					);
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			
			if (myConn != null) {
				myConn.close();
			}
			
		}

	}

}
