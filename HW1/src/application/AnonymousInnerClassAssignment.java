
package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class AnonymousInnerClassAssignment extends Application  {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			
			button = new Button();
			button.setText("Second Button");
			
			button.setOnAction(new  EventHandler<ActionEvent>() 
			{
				@Override
				public void handle(ActionEvent event)
				{
					System.out.println("Welcome to the Second World");
				}
			});
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			
			
			
			Scene scene = new Scene(layout,600,400);
			primaryStage.setTitle("Assignment One on Anonymous Inner Class");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}

