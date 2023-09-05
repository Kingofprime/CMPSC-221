
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class EventHandlingAssignment extends Application implements EventHandler<ActionEvent> {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			
			button = new Button();
			button.setText("First Button");
			
			button.setOnAction(this);
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			
			
			
			Scene scene = new Scene(layout,600,400);
			primaryStage.setTitle("Assignment One on Event Handling");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == button)
			System.out.println("Welcome to the First World");
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

