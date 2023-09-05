package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import javafx.application.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;


public class retrive extends Application {
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
			
			Label search = new Label("Search for Employee using ID:");
			TextField id = new TextField();
			id.setPromptText("I.D");
			Button b = new Button("Search");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(search,id);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			
			
			
			
			b.setOnAction(e-> {
				try {
					SearchId(id.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			// Layout Pane
			VBox layout = new VBox();
	        layout.getChildren().addAll( topLabel, tableView , vbox);
						
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
		PreparedStatement myStmt = null;
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
			 String sql = "SELECT * FROM XYZemployees WHERE id = ?";
		        myStmt = myConn.prepareStatement(sql);
		        myStmt.setString(1, id);
            myRs = myStmt.executeQuery();			
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
                break;
            case "last_name":
                column.setText("Last Name");
                break;
            case "first_name":
                column.setText("First Name");
                break;
            case "start_date":
                column.setText("Start Date");
                break;
            case "start_salary":
                column.setText("Start Salary");
                break;
            case "contract_signed":
                column.setText("Contract Signed");
                break;
            case "ssn":
                column.setText("Social Security Number");
                break;
            case "birth_date":
                column.setText("Birth Date");
                break;
            case "phone_number":
                column.setText("Phone Number");
                break;
            case "emg_contact_name":
                column.setText("Emergency Contact Name");
                break;
            case "emg_contact_number":
                column.setText("Emergency Contact Number");
                break;
           default: 
                	column.setText(myRs.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                         column.setMinWidth(100);
                    break;
            }
			column.setCellValueFactory(new PropertyValueFactory<>(myRs.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
			//column.setCellValueFactory(new PropertyValueFactory<>("startSalary"));

			tableView.getColumns().add(column);
		}
		
		//Filling up tableView with data
        tableView.setItems(dbData);		
	}
	
	//extracting data from ResulSet to ArrayList
	private ArrayList<Person> dataBaseArrayList(ResultSet resultSet) throws SQLException 
	{
	    ArrayList<Person> data = new ArrayList<>();
	    while (resultSet.next()) {
	        Person person = new Person();
	        person.setId(resultSet.getInt("id"));
	        person.setLast_name(resultSet.getString("last_name"));
	        person.setFirst_name(resultSet.getString("first_name"));
	        person.setStart_date(resultSet.getDate("start_date").toLocalDate());
	        person.setStart_salary(resultSet.getDouble("start_salary"));
	        // Assuming the contract_signed column in your database is a char or similar
	        person.setContract_signed(resultSet.getString("contract_signed").charAt(0));
	        // Assuming the following fields are integers in your database
	        person.setSsn(resultSet.getInt("ssn"));
	        if (resultSet.getDate("birth_date") != null) {
	            person.setBirth_date(resultSet.getDate("birth_date").toLocalDate());
	        }
	        person.setPhone_number(resultSet.getInt("phone_number"));
	        // Assuming you have added these methods in the Person class for emergency contact details
	        person.setEmg_contact_name(resultSet.getString("emg_contact_name"));
	        person.setEmg_contact_number(resultSet.getInt("emg_contact_number"));
	        
	        data.add(person);
	    }
	    return data;
	}
	public void SearchId(String id) throws ClassNotFoundException, 
	SQLException, FileNotFoundException, IOException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
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
			 String sql = "SELECT * FROM XYZemployees WHERE id = ?";
		        myStmt = myConn.prepareStatement(sql);
		        myStmt.setString(1, id);
            myRs = myStmt.executeQuery();			
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
                break;
            case "last_name":
                column.setText("Last Name");
                break;
            case "first_name":
                column.setText("First Name");
                break;
            case "start_date":
                column.setText("Start Date");
                break;
            case "start_salary":
                column.setText("Start Salary");
                break;
            case "contract_signed":
                column.setText("Contract Signed");
                break;
            case "ssn":
                column.setText("Social Security Number");
                break;
            case "birth_date":
                column.setText("Birth Date");
                break;
            case "phone_number":
                column.setText("Phone Number");
                break;
            case "emg_contact_name":
                column.setText("Emergency Contact Name");
                break;
            case "emg_contact_number":
                column.setText("Emergency Contact Number");
                break;
           default: 
                	column.setText(myRs.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                         column.setMinWidth(100);
                    break;
            }
			column.setCellValueFactory(new PropertyValueFactory<>(myRs.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
			//column.setCellValueFactory(new PropertyValueFactory<>("startSalary"));

			tableView.getColumns().add(column);
		}
		
		//Filling up tableView with data
        tableView.setItems(dbData);		
	}
}
