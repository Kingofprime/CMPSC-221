package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class ChoiceBoxE extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Dropdown List");
			
			
			ChoiceBox<String> droplist = new ChoiceBox<>();
			ChoiceBox<Integer> numlist = new ChoiceBox<>();
			
			
			droplist.getItems().add("January");
			droplist.getItems().add("Feb");
			droplist.getItems().add("March");
			droplist.getItems().add("April");
			droplist.getItems().addAll("May","June","July","August");
			
			droplist.setValue("May");
			
			
			numlist.getItems().addAll(100,200,300,400,500);
			
			Button btnorder = new Button("Extract");
			
			btnorder.setOnAction(e-> extract(droplist));
			
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(droplist, btnorder, numlist);
			
			Scene scene = new Scene(vbox,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void extract(ChoiceBox<String> list) {
		
		System.out.println(list.getValue());
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
