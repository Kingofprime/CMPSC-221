// This is the main package of the application
package application;

// Importing required classes from JavaFX library
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

// The main class of the application extends the Application class of JavaFX
public class q2 extends Application {

    // The start method is the main entry point for all JavaFX applications
    @Override
    public void start(Stage primaryStage) {
        try {
            // Setting the title of the window
            primaryStage.setTitle("Country Names for Ch...");

            // Creating a label for displaying the title of the choice box
            Label label = new Label("Choice Box Demo for Country Names");

            // Creating a choice box (drop-down list) and adding country names to it
            ChoiceBox<String> droplist = new ChoiceBox<>();
            droplist.getItems().addAll("India","Brazil","Bermuda","Sweden","New Zealand","Pakistan","Australia","Afghanistan","South Africa");

            // Creating a vertical box, aligning it to top left, and adding the label to it
            VBox vbox = new VBox(); 
            vbox.setAlignment(Pos.TOP_LEFT);
            vbox.getChildren().add(label);
            vbox.setPadding(new Insets(5,0,0,0));

            // Creating a horizontal box, aligning it to top left, and adding the choice box to it
            HBox hbox = new HBox();
            hbox.setAlignment(Pos.TOP_LEFT);
            hbox.getChildren().add(droplist);
            hbox.setPadding(new Insets(0,0,0,50));

            // Adding the horizontal box to the vertical box
            vbox.getChildren().add(hbox);

            // Creating a scene with the vertical box and setting it to the stage
            Scene scene = new Scene(vbox,300,200);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch(Exception e) {
            // Printing the stack trace for any exception
            e.printStackTrace();
        }
    }

    // The main method, it launches the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
