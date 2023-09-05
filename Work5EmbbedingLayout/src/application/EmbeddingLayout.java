package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class EmbeddingLayout extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("Welcome");
			HBox hbox = new HBox();
			
			Button b1 = new Button("File");
			Button b2 = new Button("Delete");
			Button b3 = new Button("Edit");
			Button b4 = new Button("View");
			
			
			hbox.getChildren().addAll(b1,b2,b3,b4);
			
			VBox vbox = new VBox();
			Button b5 = new Button("I");
			Button b6 = new Button("Enjoy");
			Button b7 = new Button("Coding");
			Button b8 = new Button("JavaFX");
			
			vbox.getChildren().addAll(b5,b6,b7,b8);
			
			BorderPane pane = new BorderPane();
			
			pane.setTop(hbox);
			pane.setRight(vbox);
			
			Scene scene = new Scene(pane,300,300);
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
