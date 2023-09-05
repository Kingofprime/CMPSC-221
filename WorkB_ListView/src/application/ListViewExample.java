package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.collections.*;


public class ListViewExample extends Application {
	
	ListView<String> listview;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		try {
			primaryStage.setTitle("list View Example");
			
			listview= new ListView<String>();
			listview.getItems().addAll("Bike","Car","House","Jet","Pool","Jacuzi","RV","Train","Scooter","Hover board");
			
			listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			Button b = new Button("Submit");
			b.setOnAction(e->show());
			VBox vbox = new VBox(10);
			vbox.setPadding(new Insets(30,30,30,30));
			vbox.getChildren().addAll(listview,b);	
			
			
			
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
	
	private void show() {
		 ObservableList<String> list;
		 list = listview.getSelectionModel().getSelectedItems();
		 
		 for(String ab : list)
		 {
			 System.out.println(ab);
		 }
		 
		 
	}
	
}