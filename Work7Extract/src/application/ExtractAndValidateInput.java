package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class ExtractAndValidateInput extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			primaryStage.setTitle("Inpput Validation");
			
			TextField data = new TextField();
			Button submit = new Button("Click");
			
			
			//submit.setOnAction(e-> System.out.println(data.getText()));
			
			submit.setOnAction(e-> validate(data));
			
			
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(data, submit);
			
			Scene scene = new Scene(vbox, 400, 400);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void validate(TextField test)
	{
		try {
			int result = Integer.parseInt(test.getText());
			System.out.println("Your Input is valid : "+ result);
		}
		catch(NumberFormatException e){
			System.out.println("Invalid input");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
