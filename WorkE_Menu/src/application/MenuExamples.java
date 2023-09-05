package application;
	
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MenuExamples extends Application {
	
	@Override
	
	public void start(Stage primaryStage) throws Exception{
		try {
			primaryStage.setTitle("Menu");
			
			Menu fileMenu = new Menu("_File");
			MenuItem newItem = new MenuItem("New...");
			newItem.setOnAction(e-> System.out.println("Creating a New File"));
			
			fileMenu.getItems().add(newItem);
			fileMenu.getItems().add(new MenuItem("Open"));
			fileMenu.getItems().add(new MenuItem("Close"));
			fileMenu.getItems().add(new SeparatorMenuItem());
			fileMenu.getItems().add(new MenuItem("Exit"));
			
			Menu editMenu = new Menu("_Edit");
			editMenu.getItems().add(new MenuItem("Copy"));
			editMenu.getItems().add(new MenuItem("Cut"));
			editMenu.getItems().add(new MenuItem("Save Project"));
			MenuItem closeItem = new MenuItem("Close Project");
			closeItem.setDisable(true);
			editMenu.getItems().add(closeItem);
			
			
			Menu viewMenu = new Menu("View");
			CheckMenuItem statusBar = new CheckMenuItem("Status Bar");
			
			CheckMenuItem tools = new CheckMenuItem("Tools");
			tools.setSelected(true);
			viewMenu.getItems().addAll(statusBar, tools);
			
			statusBar.setOnAction(e-> {
				if(statusBar.isSelected())
				{
					System.out.println("Status Bar is Checked");
				}
				else
				{
					System.out.println("Status Bar is Unchecked");
				}
				
			});
			
			Menu gender = new Menu("Gender");
			RadioMenuItem male = new RadioMenuItem("Male");
			RadioMenuItem female = new RadioMenuItem("Female");
			RadioMenuItem undisclosed = new RadioMenuItem("Undisclosed");
			
			ToggleGroup one =new ToggleGroup();
			male.setToggleGroup(one);
			female.setToggleGroup(one);
			undisclosed.setToggleGroup(one);
			
			gender.getItems().addAll(male,female,undisclosed);
			
			
			
			MenuBar menuBar = new MenuBar();
			
			menuBar.getMenus().addAll(fileMenu,editMenu,viewMenu,gender);
			
			
			BorderPane layout = new BorderPane();
			layout.setTop(menuBar);
			
			Scene scene = new Scene(layout,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
