package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class GridLayout extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10,10,10,10));
			grid.setVgap(20);
			grid.setHgap(10);
			
			Label user = new Label("Username :");
			GridPane.setConstraints(user,0,0);
			user.setFont(Font.font("Cambria",18));
			
			TextField name = new TextField("ANKIT");
			GridPane.setConstraints(name,1,0);
			
			Label course = new Label("Course :");
			
			GridPane.setConstraints(course,0,1);
			
			TextField coursename = new TextField("CMPSC221");
			GridPane.setConstraints(coursename,1,1);
			
			Label pass = new Label("Password :");
			GridPane.setConstraints(pass,0,2);
			
			PasswordField passfld = new PasswordField();
			passfld.setPromptText("password");
			GridPane.setConstraints(passfld,1,2);
			
			Button sumbitbtn = new Button("Log In");
			GridPane.setConstraints(sumbitbtn,0,3);
			
			grid.getChildren().addAll(user, name, course, coursename, pass, passfld,sumbitbtn);
			Scene scene = new Scene(grid,300,400);
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
