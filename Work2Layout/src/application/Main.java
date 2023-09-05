package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Button b1;
			b1 = new Button("click me");
			primaryStage.setTitle("Testing alert");
			
			b1.setOnAction(r-> Box.show("Welcome to compsc 221", "asad"));
			StackPane layout = new StackPane();
			
			layout.getChildren().add(b1);
			Scene scene = new Scene(layout, 300,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
