package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;



public class comboboxe extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Combo Box Example");
			
			ComboBox<String> list = new ComboBox<>();
			list.getItems().addAll("Milk", "Honey" , "Sugar", "Bread");
			list.setPromptText("Shopping List");
			list.setOnAction(e->System.out.println(list.getValue()));
			Button btn = new Button("Submit");
			btn.setOnAction(e->System.out.println(list.getValue()));
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(list,btn);
			
			
			
			Scene scene = new Scene(vbox,400,400);
			
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
