package application;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.Date;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.DatePicker;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class XYZCompany_CreateView extends Application {

   /* private Connection connect() {
        // MySQL connection string
        String url = "jdbc:mysql://localhost:3306/XYZCompany_db";
        String user = "root";
        String password = "";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertEmployee(String firstName, String lastName) {
        String sql = "INSERT INTO XYZemployees(first_name, last_name) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    @Override
    public void start(Stage primaryStage) {
    	GridPane layout = new GridPane();
		
		//format to fit all prompt boxes/text (makes each column a certain size)
	     for (int i = 0; i < 3; i++) {
	         ColumnConstraints column = new ColumnConstraints(175);
	         layout.getColumnConstraints().add(column);
	     }
	     
	    //adds a slight gap inbetween each column
		layout.setPadding(new Insets(10,10,10,10));
		layout.setVgap(5);
		layout.setHgap(5);
		
		//notify user they are in the create menu
		Label createNotice = new Label("Enter new employee information");

		
		//Fields/Labels for each necessary information prompt with formating
		Label labelEmployeeID = new Label("Employee ID:");
		GridPane.setConstraints(labelEmployeeID, 0, 1);
		
		Label labelPersonalInfo = new Label("Employee Personal Information:");
		GridPane.setConstraints(labelPersonalInfo, 0, 2);
		
		Label labelEmgInfo = new Label("Emergency Contact Information:");
		GridPane.setConstraints(labelEmgInfo, 0, 6);
		
		TextField createEmployeeID = new TextField();
		GridPane.setConstraints(createEmployeeID, 0, 1);
		GridPane.setHalignment(createEmployeeID, HPos.RIGHT);
		createEmployeeID.setPromptText("Employee ID");
		createEmployeeID.setMaxWidth(100);
		
		TextField createFirstName = new TextField();
		GridPane.setConstraints(createFirstName, 0, 3);
		createFirstName.setPromptText("First Name");
		createFirstName.setMinWidth(175);
		
		TextField createLastName = new TextField();
		GridPane.setConstraints(createLastName, 1, 3);
		createLastName.setPromptText("Last Name");
		createLastName.setMinWidth(175);
		
		DatePicker createStartDate = new DatePicker();
		GridPane.setConstraints(createStartDate, 0, 5);
		createStartDate.setPromptText("Start Date");
		createStartDate.setMinWidth(175);
		
		TextField createStartSalary = new TextField();
		GridPane.setConstraints(createStartSalary, 1, 5);
		createStartSalary.setPromptText("Start Salary");
		createStartSalary.setMinWidth(175);
		
		CheckBox createSigned = new CheckBox("Employee Contract Signed?");
		GridPane.setConstraints(createSigned, 1, 1);
		
		PasswordField createSSN = new PasswordField();
		GridPane.setConstraints(createSSN, 1, 4);
		createSSN.setPromptText("Social Security Number");
		createSSN.setMinWidth(175);
		
		DatePicker createBirthDate = new DatePicker();
		GridPane.setConstraints(createBirthDate, 2, 3);
		createBirthDate.setPromptText("Birth Date");
		createBirthDate.setMinWidth(175);
		
		TextField createPhoneNum = new TextField();
		GridPane.setConstraints(createPhoneNum, 0, 4);
		createPhoneNum.setPromptText("Phone Number");
		createPhoneNum.setMinWidth(175);
		
		TextField createEmgName = new TextField();
		GridPane.setConstraints(createEmgName, 0, 7);
		createEmgName.setPromptText("Contact Name");
		createEmgName.setMinWidth(175);
		
		TextField createEmgNum = new TextField();
		GridPane.setConstraints(createEmgNum, 1, 7);
		createEmgNum.setMinWidth(175);
		createEmgNum.setPromptText("Contact Number");
		
		//button that will send the input information to the database
		Button createButton = new Button("Create");
		GridPane.setConstraints(createButton, 0, 8);
		
		
		Button backButton = new Button("Cancel");
		GridPane.setConstraints(backButton, 0, 8);
		GridPane.setHalignment(backButton, HPos.CENTER);
		
		createButton.setOnAction(c -> {
			try {
				createData(createSigned.isSelected(), createEmployeeID.getText(), 
						createFirstName.getText(), createLastName.getText(), createStartDate.getValue(), 
						createStartSalary.getText(), createSSN.getText(), createBirthDate.getValue(), 
						createPhoneNum.getText(), createEmgName.getText(), createEmgNum.getText());
			} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//backButton.setOnAction(e -> primaryStage.setScene(Main));
		
		VBox fieldLayout = new VBox(10);
		layout.getChildren().addAll(createEmployeeID, createFirstName, createLastName, createStartDate, 
								    createStartSalary, createSigned, createSSN, createBirthDate, createPhoneNum,
								    createEmgName, createEmgNum, createButton, backButton, labelEmployeeID,
								    labelPersonalInfo, labelEmgInfo);
		
		fieldLayout.getChildren().addAll(createNotice, layout);
		layout.setAlignment(Pos.TOP_CENTER);
		fieldLayout.setAlignment(Pos.TOP_CENTER);

		Scene XYZCreate = new Scene(fieldLayout, 700, 300);
		
		primaryStage.setScene(XYZCreate);
		primaryStage.show();
    }
    
    public static void createData(boolean isSigned, String ID, String first_name, String last_name, LocalDate start_date,
			   String start_salary, String SSN, LocalDate birth_date, String phoneNum, String emgName,
			   String emgNum) throws ClassNotFoundException, SQLException, IOException, ParseException{

		
		    	//variable to pass into sql for "contract Signed"
		char signed = 'N';
		if(isSigned == true) {
		signed = 'Y';
		}
		
		
		//standard JBDC connection stuff
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
		//1. load the properties file
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		//2. read the properties
		String theUser = props.getProperty("username");
		String thePassword = props.getProperty("password");
		String theUrl = props.getProperty("dbUrl");
		
		System.out.println("Connection to database...");
		System.out.println("Database URL: " + theUrl);
		System.out.println("User:" + theUser);
		
		//3. get Connection
		myConn = DriverManager.getConnection(theUrl, theUser, thePassword);
		System.out.println("Database connection succesfull! \n");
		
		//4. Create a statement to pass all values filled in (NOTE: CREATE A METHOD TO DETECT IF A FIELD IS EMPTY)
		myStmt = myConn.prepareStatement("insert into XYZemployees "
								   + "(id, last_name, first_name, start_date, start_salary, contract_signed, "
								   + "ssn, birth_date, phone_number, emg_contact_name, emg_contact_number)"
								   + "values"
								   + "(?,?,?,?,?,?,?,?,?,?,?)");
		
		//5. Execute SQL Query (Insert a new employee
		System.out.println("Inserting a new employee to database \n");
		
		myStmt.setInt(1, Integer.parseInt(ID));
		myStmt.setString(2, last_name);
		myStmt.setString(3, first_name);
		myStmt.setObject(4, start_date);
		myStmt.setDouble(5, Double.parseDouble(start_salary));
		myStmt.setString(6, String.valueOf(signed));
		myStmt.setInt(7, Integer.parseInt(SSN));
		myStmt.setObject(8, birth_date);
		myStmt.setInt(9, Integer.parseInt(phoneNum));
		myStmt.setString(10, emgName);
		myStmt.setInt(11, Integer.parseInt(emgNum));
		
		//7. Execute 
		myStmt.execute();
		System.out.println("Sucessfull\n");
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Successful!");

        alert.showAndWait();
		}
		catch(Exception exc) {
		exc.printStackTrace();
		}
		finally {
		close(myConn, myStmt, myRs);
		}
		}
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs) throws SQLException{
		if(myRs != null)
			myRs.close();
		
		if(myStmt != null)
			myStmt.close();
		
		if(myConn != null)
			myConn.close();
	}	

    public static void main(String[] args) {
        launch(args);
    }
}