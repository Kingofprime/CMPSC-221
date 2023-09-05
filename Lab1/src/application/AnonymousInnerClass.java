
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AnonymousInnerClass extends Application  {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			
			button = new Button();
			button.setText("Click me");
			
			button.setOnAction(new  EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event)
				{
					System.out.println("Button Clicked");
				}
			});
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			
			
			
			Scene scene = new Scene(layout,600,400);
			primaryStage.setTitle("Welcome to CMPSC 221");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

