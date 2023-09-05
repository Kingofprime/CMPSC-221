package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class Main extends Application {
	
	Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			
			window = primaryStage; 
			
			Button b1;
			
		b1 = new Button("close");
		window.setTitle("welcome");
		
		//window.setOnCloseRequest(r-> closeProgram());
		
		window.setOnCloseRequest(e-> {
			
			e.consume();
			closeProgram();
			
		});
		
		b1.setOnAction(r-> closeProgram() );
		
		StackPane layout = new StackPane();
		layout.getChildren().add(b1);
		Scene scene = new Scene(layout,300,300);
		window.setScene(scene);
		window.show();
			
			
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeProgram() {
		
		Boolean ans = Box.show("welcome", "are you sure you wwant to show");
		if (ans)
			window.close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
