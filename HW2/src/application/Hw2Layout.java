package application;
	


import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class Hw2Layout extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Welcome");
			
			// Create buttons
			Button b1 = new Button("Top Button");
			Button b2 = new Button("Left Button");
			Button b3 = new Button("Right Button");
			Button b4 = new Button("Center Button");
			Button b5 = new Button("Bottom Button");

			// Create a BorderPane
			BorderPane pane = new BorderPane();
			pane.setPadding(new Insets(5, 0, 10, 0)); // Set padding for the entire pane

			// Set the top button and align it to the top center
			pane.setTop(b1);
			BorderPane.setAlignment(b1, Pos.TOP_CENTER);

			// Set the left button and add margin for spacing
			pane.setLeft(b2);
			BorderPane.setMargin(b2, new Insets(5, 0, 0, 0));

			// Set the right button and add margin for spacing
			pane.setRight(b3);
			BorderPane.setMargin(b3, new Insets(5, 0, 0, 0));

			// Set the center button
			pane.setCenter(b4);

			// Set the bottom button and align it to the top center
			pane.setBottom(b5);
			BorderPane.setAlignment(b5, Pos.TOP_CENTER);

			// Create the scene with the pane and set it on the stage
			Scene scene = new Scene(pane, 300, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
