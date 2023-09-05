package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;


public class EmployeeView extends Application {
	private TableView<Person> tableView = new TableView<>();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
		try {
			
			primaryStage.setTitle("Employee Data");
			
	    	Label topLabel = new Label();
			topLabel.setStyle("-fx-font: 28 arial;");
			topLabel.setPadding(new Insets(10, 10, 10, 10));
			topLabel.setText("Employee Records");
			
			//Show window
			buildData();
			
			// Layout Pane
			VBox layout = new VBox();
	        layout.getChildren().addAll( topLabel, tableView );
						
	        Scene scene = new Scene(layout, 700, 600);
	        primaryStage.setScene(scene);
	        primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildData() throws ClassNotFoundException, 
	SQLException, FileNotFoundException, IOException {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//1. Load the properties file
			Properties props = new Properties();
			props.load(new FileInputStream("demo.properties"));
			
			//2. Read the props
			String theUser = props.getProperty("username");
			String thePassword = props.getProperty("password");
			String theUrl = props.getProperty("dbUrl");
			
			
			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theUrl);
			System.out.println("User: " + theUser);
			
			//3. Get a connection
			myConn = DriverManager.getConnection(theUrl, theUser, thePassword);
			
			System.out.println("Database connection successful! \n");
			
			//4. Create a statement
			myStmt = myConn.createStatement();
			
			//5. Execute SQL query
			myRs = myStmt.executeQuery("SELECT * FROM employees");
			
			PreparedStatement preparedStatement = myConn.prepareStatement("select * from employees");
            myRs = preparedStatement.executeQuery();			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			
		}
		
		ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(myRs));

        //Giving readable names to columns
        for(int i=0 ; i<myRs.getMetaData().getColumnCount(); i++) {
            TableColumn column = new TableColumn<>();
            switch (myRs.getMetaData().getColumnName(i+1)) {
                case "id":
                   column.setText("Employee ID");
                   column.setMinWidth(40);
                   break;    
                case "last_name":
                    column.setText("Last Name");
                    column.setMinWidth(100);
                    break;
                case "first_name":
                    column.setText("First Name");
                    column.setMinWidth(100);
                    break;
                case "email":
                    column.setText("Email");
                    column.setMinWidth(170);
                    break;
                case "department":
                    column.setText("Department");
                    column.setMinWidth(100);
                    break;
                case "salary":
                    column.setText("Salary");
                    column.setMinWidth(100);
                    break;
                default: column.setText(myRs.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                         column.setMinWidth(100);
                    break;
            }
			column.setCellValueFactory(new PropertyValueFactory<>(myRs.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
            tableView.getColumns().add(column);
		}
		
		//Filling up tableView with data
        tableView.setItems(dbData);		
	}
	
	//extracting data from ResulSet to ArrayList
	private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Person> data =  new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setLast_name(resultSet.getString("last_name"));
            person.setFirst_name(resultSet.getString("first_name"));
            person.setEmail(resultSet.getString("email"));
            person.setDepartment(resultSet.getString("department"));
            person.setSalary(resultSet.getDouble("salary"));
            
            data.add(person);
        }
        return data;
    }
	
}
