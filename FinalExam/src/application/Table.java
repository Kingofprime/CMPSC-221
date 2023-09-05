package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Table extends Application {
	private  static TableView<Person> tableView = new TableView<>();
	
	private static boolean columnsInitialized = false;
	@Override
	public  void start(Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException  {
		try {
			
			
			
			primaryStage.setTitle("Table View Sample");
			Label tLabel = new Label("Address Book");
			tLabel.setFont(Font.font("Cambria", 20));
			TextField fname = new TextField();
			fname.setPromptText("First Name");
			TextField bname = new TextField();
			bname.setPromptText("Back Name");
			TextField email = new TextField();
			email.setPromptText("Email");
			Button b = new Button("Add");
			HBox hbox = new HBox(10);
			
			hbox.getChildren().addAll(fname,bname,email, b);

			buildData();
			b.setOnAction(e -> {});
			tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

			// Main Layout
			VBox layout = new VBox(10);
			layout.getChildren().addAll(tLabel, tableView, hbox);
			layout.setPadding(new Insets(10, 10, 10, 10));

			Scene scene = new Scene(layout, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void buildData() throws ClassNotFoundException, 
	SQLException, FileNotFoundException, IOException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = connect();
			String  sql = "SELECT * FROM contactTB";
			  myStmt = myConn.prepareStatement(sql);
		        myRs = myStmt.executeQuery();			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
		  if (!columnsInitialized) {
		        initializeColumns(myRs);
		        columnsInitialized = true;
		    }
		  ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(myRs));
		  tableView.setItems(dbData);		
		  close(myConn, myStmt, myRs);
		}
	}
 public static void initializeColumns(ResultSet myRs) throws SQLException {
		

        //Giving readable names to columns
        for(int i=0 ; i<myRs.getMetaData().getColumnCount(); i++) {
            TableColumn column = new TableColumn<>();
            switch (myRs.getMetaData().getColumnName(i+1)) {
            case "last_name":
                column.setText("Last Name");
                break;
            case "first_name":
                column.setText("First Name");
                break;
            case "Email":
                column.setText("Email");
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
		
		
        
	}
	
	//extracting data from ResulSet to ArrayList
	private static ArrayList<Person> dataBaseArrayList(ResultSet resultSet) throws SQLException 
	{
	    ArrayList<Person> data = new ArrayList<>();
	    while (resultSet.next()) {
	        Person person = new Person();
	        person.setLast_name(resultSet.getString("last_name"));
	        person.setFirst_name(resultSet.getString("first_name"));
	        person.setEmail(resultSet.getString("Email"));
	        
	        data.add(person);
	    }
	    return data;
	}
	
	private static Connection connect() throws FileNotFoundException, IOException {
	    // MySQL connection string
    	Properties props = new Properties();
		props.load(new FileInputStream("FinalExam.properties"));
		String theUser = props.getProperty("username");
		String thePassword = props.getProperty("password");
		String theUrl = props.getProperty("dbUrl");
	    
		System.out.println("Connecting to database...");
		System.out.println("Database URL: " + theUrl);
		System.out.println("User: " + theUser);
	    Connection conn = null;
	    try {
	    	conn = DriverManager.getConnection(theUrl, theUser, thePassword);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return conn;
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