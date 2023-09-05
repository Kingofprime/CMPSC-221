package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;

public class CSSExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("CSS Example");
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10) );
			grid.setVgap(10);
			grid.setHgap(10);
			
			Label user = new Label("username");
			GridPane.setConstraints(user,0,0);
			//user.setStyle("-fx-text-fill:darkturquoise");
			user.getStyleClass().add("passStyle");
			
			TextField name = new TextField("Ankit Gupta");
			GridPane.setConstraints(name,1,0);
			name.setId("nameStyle");
			//name.setStyle("-fx-text-fill:red");
			
			Label pass = new Label("password");
			GridPane.setConstraints(pass,0,1);
			
			TextField password = new TextField();
			password.setPromptText("Password");
			password.setId("nameStyle");
			GridPane.setConstraints(password,1,1);
			
			Button b = new Button("Log in");
			GridPane.setConstraints(b,1,2);
			
			
			grid.getChildren().addAll(user,name,pass,password,b);
			
			
			
			
			
			
			Scene scene = new Scene(grid,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
