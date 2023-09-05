package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SwitchingScene extends Application {
	
	Scene scene1, scene2;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			Label label1= new Label("THis is scene 1");
			Button button1 = new Button("go to scene 2");
			button1.setOnAction(e-> primaryStage.setScene(scene2));
			
			VBox layout1 = new VBox(20);
			layout1.getChildren().addAll(label1, button1);
			
			 scene1 = new Scene(layout1, 500,500);
			 
			 Button button2 = new Button("Go back to scene 1");
			 button2.setOnAction(r-> primaryStage.setScene(scene1));
			 
			 StackPane layout2 = new StackPane();
			 layout2.getChildren().add(button2);
			 scene2 = new Scene(layout2,500,500);
			 //Display scene 1
				primaryStage.setScene(scene1);
				primaryStage.setTitle("Switching Scene");
				primaryStage.show();

			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
