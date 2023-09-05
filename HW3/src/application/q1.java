// This is the main package of the application
package application;

// Importing required classes from JavaFX library
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.geometry.*;

// The main class of the application extends the Application class of JavaFX
public class q1 extends Application {

    // The start method is the main entry point for all JavaFX applications
	@Override
	public void start(Stage primaryStage) {
		try {
            // Setting the title of the window
			primaryStage.setTitle("Pizza Cost");

            // Creating checkbox controls for various pizza toppings
			CheckBox box1 = new CheckBox("Extra Cheese");
			CheckBox box2 = new CheckBox("Green Pepper");
			CheckBox box3 = new CheckBox("Pepperoni");
			CheckBox box4 = new CheckBox("Onion");
			CheckBox box5 = new CheckBox("Sausage");
			CheckBox box6 = new CheckBox("Anchovies");
			
            // Creating first vertical box, adding first group of checkboxes
			VBox vbox1 = new VBox(10);
			vbox1.setPadding(new Insets(10,30,10,30));
			vbox1.getChildren().addAll(box1,box3,box5);
			
            // Creating second vertical box, adding second group of checkboxes
			VBox vbox2 = new VBox(10);
			vbox2.setPadding(new Insets(10,30,10,30));
			vbox2.getChildren().addAll(box2,box4,box6);
			
            // Creating horizontal box, adding both vertical boxes
			HBox hbox = new HBox(10);
			hbox.setPadding(new Insets(10,30,10,30));
			hbox.getChildren().addAll(vbox1,vbox2);
			hbox.setAlignment(Pos.TOP_CENTER);

            // Creating label for displaying pizza cost
			Label label = new Label("Pizza Cost: $10.00");
			
			label.setFont(Font.font("Cambria", 20));

            // Creating the final vertical box, adding horizontal box and the label
			VBox f = new VBox(10);
			f.setPadding(new Insets(0,30,30,30));
			f.getChildren().addAll(hbox, label);
			f.setAlignment(Pos.TOP_CENTER);
			
            // Creating a scene with the final vertical box and setting it to the stage
			Scene scene = new Scene(f,450,200);
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
