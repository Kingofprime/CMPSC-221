package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

// Main application class extending from JavaFX's Application class
public class AddressBookView extends Application {

    // Variables to hold text fields for user input
    TextField firstName, lastName, email, age;
    
    // TableView to display contact details
    TableView<Contact> table;

    
    // Start method which sets up the scene and starts the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        	
            // Creating a new label for the application
        	Label ab = new Label("Address Book");
        	ab.setFont(Font.font("Arial", 20));

            // Setting the title of the window (stage)
            primaryStage.setTitle("Table View Sample");
            
            // Initializing the TableView
            table = new TableView<>();

            // Creating and setting up various columns for the table
            TableColumn<Contact, String> firstNameColumn = new TableColumn<>("First Name");
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

            TableColumn<Contact, String> lastNameColumn = new TableColumn<>("Last Name");
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

            TableColumn<Contact, String> emailColumn = new TableColumn<>("Email");
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

            TableColumn<Contact, Integer> ageColumn = new TableColumn<>("Age");
            ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
            
            // Set column resize policy
            table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
            
            // Creating and setting up text fields for user input
            firstName = new TextField();
            firstName.setPromptText("First Name");
            firstName.setMinWidth(100);

            lastName = new TextField();
            lastName.setPromptText("Last Name");
            lastName.setMinWidth(100);

            email = new TextField();
            email.setPromptText("Email");
            email.setMinWidth(100);

            age = new TextField();
            age.setPromptText("Age");
            age.setMinWidth(100);

            // Creating and setting up the add button
            Button b = new Button("Add");
            b.setOnAction(e -> addData());

            // Creating and setting up a horizontal box to hold the text fields and button
            HBox hbox = new HBox();
            hbox.setSpacing(5);
            hbox.getChildren().addAll(firstName, lastName, email, age, b);

            // Populating the table with data
            table.setItems(getData());
            table.getColumns().addAll(firstNameColumn, lastNameColumn, emailColumn, ageColumn);

            // Creating and setting up the layout of the scene
            VBox layout = new VBox();
            layout.setPadding(new Insets(10,10,10,10));
            layout.setSpacing(5);
            layout.getChildren().addAll(ab, table, hbox);

            // Creating and setting the scene
            Scene scene = new Scene(layout, 700, 700);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to return a list of contact data
    public ObservableList<Contact> getData() {

        // Create a new observable list
        ObservableList<Contact> dataList = FXCollections.observableArrayList();

        // Add data to the list
        dataList.add(new Contact("Jacob","Smith","jacob.smith@example.com",1));
        dataList.add(new Contact("Isabella","Johnson","isabella.johnson@example.com",2));
        dataList.add(new Contact("Ethan","Williams","ethan.williams@example.com",3));
        dataList.add(new Contact("Emma","Jones","emma.jones@example.com",4));
        dataList.add(new Contact("Michael","Brown","michael.brown@example.com",5));

        // Return the list
        return dataList;
    }

    // Method to add data to the table
    public void addData() {

        // Create a new Contact object
        Contact data = new Contact();

        // Set the fields of the Contact object
        data.setFirstName(firstName.getText());
        data.setLastName(lastName.getText());
        data.setEmail(email.getText());

        // Validate age input
        String ageText = age.getText();
        if(!ageText.matches("\\d+")) // Check if the input is not numeric
        {
            // Show error dialog
            Stage a = new Stage();
            Label l = new Label("Enter Age as an Integer");
            Scene s= new Scene(l,200,200);
            a.setScene(s);
            a.setTitle("Error Dialog");
            a.showAndWait();
            return;
        }

        // Set the age
        data.setAge(Integer.parseInt(ageText));

        // Add the Contact object to the table
        table.getItems().add(data);

        // Clear the input fields
        firstName.clear();
        lastName.clear();
        email.clear();
        age.clear();
    }
 // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }

}
