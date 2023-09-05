package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	
	Button button;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			
			
			button = new Button();
			button.setText("Click me");
			
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			
			
			
			Scene scene = new Scene(layout,600,400);
			primaryStage.setTitle("WHY");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
