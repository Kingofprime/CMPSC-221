package application;

import javafx.geometry.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;

public class Box {
	
	public static void show(String title, String message) {
		
		Stage window = new Stage();
		window.setTitle(title);
		window.setMinHeight(200);
		window.setMinWidth(500);
		
		window.initModality(Modality.APPLICATION_MODAL);
		
		Label label = new Label(message);
		
		Button button = new Button("Close");
		
		button.setOnAction(e-> window.close());
		VBox layout = new VBox(10);
		
		layout.getChildren().addAll(label, button);
		layout.setAlignment(Pos.CENTER);
		
		//Display Window
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}

}
