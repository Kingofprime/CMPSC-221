
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class lambdaExpressions extends Application {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			
			button = new Button();
			button.setText("Click me");
			
			button.setOnAction(e->System.out.println("Button clicked Lambda"));
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			
			
			
			Scene scene = new Scene(layout,500,500);
			primaryStage.setTitle("Welcome to CMPSC 221");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

