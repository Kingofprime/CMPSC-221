package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.geometry.*;



public class CheckBoxes extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("checkBOxes");
			
			CheckBox box1 = new CheckBox("Pizza");
			CheckBox box2 = new CheckBox("Burger");
			
			
			box2.setSelected(true);
			
			Button btn = new Button("order");
			btn.setOnAction(e-> extract(box1,box2));
			
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(box1,box2,btn);
			
			
			Scene scene = new Scene(vbox,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void extract(CheckBox b1, CheckBox b2) {
		if (b1.isSelected())
			System.out.println("Customer is Pizza");
		if (b2.isSelected())
			System.out.println("Customer is Burger");
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
