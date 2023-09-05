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

public class update extends Application {

    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Dropdown List");
		
    	Label tag = new Label("Enter Employee by ID:");
        TextField employeeid = new TextField();
		ChoiceBox<String> droplist = new ChoiceBox<>();
		HBox hbox = new HBox(10);
		hbox.setPadding(new Insets(30,30,30,30));
		hbox.getChildren().addAll(tag,employeeid);
		droplist.getItems().addAll("First Name", "Last Name", "Start Date",
				 "Start Salary", "Employee Contract Signed(Y/N)", "Social Security Number", "Birth Date", "Phone Number", 
				 "Name of Person to Call in an Emergency", "Phone of Person to Call in an Emergency");
		Button btnorder = new Button("Replace");
		
	
		VBox vbox = new VBox(10);
		vbox.setPadding(new Insets(30,30,30,30));
		vbox.getChildren().addAll(hbox,droplist, btnorder);
		
		
		
		btnorder.setOnAction(e-> update(droplist, employeeid.getText()));
		
		Scene scene = new Scene(vbox,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
    }
public void update(ChoiceBox<String> list , String sid) {
		
	int id = Integer.parseInt(sid);
		
		if(list.getValue() == "First Name" )
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New first Name:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateFirstName(id,name.getText());
            		a.close();
            });
            a.showAndWait();
            
		}
		else if(list.getValue() == "Last Name") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Last Name:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateLastName(id,name.getText());
            		a.close();
            });
            
            a.showAndWait();
           
		}
		else if(list.getValue() == "Start Date")
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Start Date:");
			DatePicker name = new DatePicker();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            b.setOnAction(e-> {
            	updateStartDate(id,name.getValue());
            		a.close();
            });
            a.setTitle(list.getValue());
            a.showAndWait();
            
		}
		else if(list.getValue() == "Birth Date")
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Birth Date:");
			DatePicker name = new DatePicker();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateBirthDate(id,name.getValue());
            		a.close();
            });
            a.showAndWait();
           
		}
		else if(list.getValue() == "Start Salary") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Start Salary:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateStartSalary(id,name.getText());
            		a.close();
            });
            a.showAndWait();
            
		}
		else if(list.getValue() == "Social Security Number") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New SSN:");
			PasswordField name = new PasswordField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateSSN(id,name.getText());
            		a.close();
            });
            a.showAndWait();
            
		}
		else if(list.getValue() == "Phone Number") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Phone Number:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updatePhoneNumber(id,name.getText());
            		a.close();
            });
            a.showAndWait();
            
		}
		else if(list.getValue() == "Phone of Person to Call in an Emergency") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Phone of Person to Call in an Emergency:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updatePhoneNumberEmergency(id,name.getText());
            		a.close();
            });
            a.showAndWait();
            
		}
		else if(list.getValue() == "Name of Person to Call in an Emergency") 
		{
			Stage a = new Stage();
			Label old = new Label("Enter the New Name of Person to Call in an Emergency:");
			TextField name = new TextField();
			name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateNameEmergency(id,name.getText());
            		a.close();
            });
            
            a.showAndWait();
            
		}
		else if(list.getValue() == "Employee Contract Signed(Y/N)") 
		{
			Stage a = new Stage();
			Label old = new Label("Select if contract is signed:");
			CheckBox name = new CheckBox();
			//name.setPromptText(list.getValue());
			Button b = new Button("Update");
	        HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(30,30,30,30));
			hbox.getChildren().addAll(old,name);
			VBox vbox= new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(hbox,b);
			Scene s= new Scene(vbox,400,400);
            a.setScene(s);
            a.setTitle(list.getValue());
            b.setOnAction(e-> {
            	updateECS(id,name.isSelected());
            		a.close();
            });
            a.showAndWait();
            
		}
	}

public void updateECS(int id, boolean name)
{
	char a = 'N';
	if(name == true)
	{
		a='Y';
	}
	 String sql = "Update XYZemployees set contract_signed = ? where id = ? ";
	 System.out.println(id);
	 System.out.println(a);
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, String.valueOf(a)); 
            pstmt.setInt(2, id); 
            pstmt.executeUpdate();
            UpdateSuccess();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
}
	public void updateFirstName(int id, String name)
	{
		 String sql = "Update XYZemployees set first_name = ? where id = ? ";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setString(1, name);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateLastName(int id, String name)
	{
		 String sql = "Update XYZemployees set last_name = ? where id = ? ";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setString(1, name);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateStartDate(int id, LocalDate name)
	{
		 String sql = "Update XYZemployees set start_date = ? where id = ? ";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setDate(1, java.sql.Date.valueOf(name));
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateBirthDate(int id, LocalDate name)
	{
		 String sql = "Update XYZemployees set birth_date = ? where id = ? ";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setDate(1, java.sql.Date.valueOf(name));
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateStartSalary(int id, String name)
	{
		double number = Double.parseDouble(name);
		
		 String sql = "Update XYZemployees set start_salary = ? where id = ? ";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setDouble(1,number);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateSSN(int id, String name)
	{
		int number = Integer.parseInt(name);
		 String sql = "Update XYZemployees set ssn = ? where id = ?";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setInt(1, number);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updatePhoneNumber(int id, String name)
	{
		int number = Integer.parseInt(name);
		 String sql = "Update XYZemployees set phone_number = ? where id = ?";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setInt(1, number);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updatePhoneNumberEmergency(int id, String name)
	{
		int number = Integer.parseInt(name);
		 String sql = "Update XYZemployees set emg_contact_number = ? where id = ?";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setInt(1, number);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	public void updateNameEmergency(int id, String name)
	{
		 String sql = "Update XYZemployees set emg_contact_name = ? where id = ?";
		 
	        try (Connection conn = this.connect();
	                PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(2, id);
	            pstmt.setString(1, name);
	            pstmt.executeUpdate();
	            UpdateSuccess();
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void UpdateSuccess()
	{
		Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Update Information");
        alert.setHeaderText(null);
        alert.setContentText("Update successful!");

        alert.showAndWait();
	}

	private Connection connect() {
	    // MySQL connection string
	    String url = "jdbc:mysql://localhost:3306/XYZCompany_db";
	    String user = "root";
	    String password = "ankitg489";
	    
	    Connection conn = null;
	    try {
	        conn = DriverManager.getConnection(url, user, password);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return conn;
	}	

    public static void main(String[] args) {
        launch(args);
    }
}
