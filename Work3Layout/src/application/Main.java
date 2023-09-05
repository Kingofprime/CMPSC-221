package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			
			Button b1;
			b1= new Button("Click Me");
			
			primaryStage.setTitle("Welcome");
			
			b1.setOnAction(r-> {
				
				Boolean ans =  Box.show("Welcome","You want to delete");
				System.out.println(ans);
			});
			
			StackPane layout = new StackPane(); 
			
			layout.getChildren().add(b1);
			Scene scene = new Scene(layout,300,300);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
