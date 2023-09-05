package application;
	
import javafx.scene.control.*;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class menu extends Application {
	
	@Override
	
	public void start(Stage primaryStage) throws Exception{
		try {
			primaryStage.setTitle("Menu");
			
			Menu fileMenu = new Menu("_File");
			MenuItem newItem = new MenuItem("New");
			fileMenu.getItems().add(newItem);
			Image new1 = new Image("1.jpg"); 
			ImageView newImageView1 = new ImageView(new1);
			newImageView1.setFitHeight(16);
			newImageView1.setFitWidth(16); 
			newItem.setGraphic(newImageView1);
			MenuItem openItem = new MenuItem("Open");
			fileMenu.getItems().add(openItem);
			Image new2 = new Image("2.jpg"); 
			ImageView newImageView2 = new ImageView(new2);
			newImageView2.setFitHeight(16);
			newImageView2.setFitWidth(16); 
			openItem.setGraphic(newImageView2);
			
			MenuItem saveItem = new MenuItem("Save");
			fileMenu.getItems().add(saveItem);
			Image new3 = new Image("3.jpg"); 
			ImageView newImageView3 = new ImageView(new3);
			newImageView3.setFitHeight(16);
			newImageView3.setFitWidth(16); 
			saveItem.setGraphic(newImageView3);
			
			Menu saItem = new Menu("_Save as");
			fileMenu.getItems().add(saItem);
			Image new4 = new Image("4.jpg"); 
			ImageView newImageView4 = new ImageView(new4);
			newImageView4.setFitHeight(16);
			newImageView4.setFitWidth(16); 
			saItem.setGraphic(newImageView4);
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			Menu pItem = new Menu("_Print");
			fileMenu.getItems().add(pItem);
			Image new5 = new Image("5.jpg"); 
			ImageView newImageView5 = new ImageView(new5);
			newImageView5.setFitHeight(16);
			newImageView5.setFitWidth(16); 
			pItem.setGraphic(newImageView5);
			
			MenuItem fsocItem = new MenuItem("From scanner or camera");
			fileMenu.getItems().add(fsocItem);
			fsocItem.setDisable(true);
			Image new6 = new Image("6.jpg"); 
			ImageView newImageView6 = new ImageView(new6);
			newImageView6.setFitHeight(16);
			newImageView6.setFitWidth(16); 
			fsocItem.setGraphic(newImageView6);
			
			
			MenuItem sieItem = new MenuItem("Send in email");
			fileMenu.getItems().add(sieItem);
			Image new7 = new Image("7.jpg"); 
			ImageView newImageView7 = new ImageView(new7);
			newImageView7.setFitHeight(16);
			newImageView7.setFitWidth(16); 
			sieItem.setGraphic(newImageView7);
			
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			Menu sadbItem = new Menu("_Set as desktop background");
			fileMenu.getItems().add(sadbItem);
			Image new8 = new Image("8.jpg"); 
			ImageView newImageView8 = new ImageView(new8);
			newImageView8.setFitHeight(16);
			newImageView8.setFitWidth(16); 
			sadbItem.setGraphic(newImageView8);
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			MenuItem popItem = new MenuItem("Properties");
			fileMenu.getItems().add(popItem);
			Image new9 = new Image("9.jpg"); 
			ImageView newImageView9 = new ImageView(new9);
			newImageView9.setFitHeight(16);
			newImageView9.setFitWidth(16); 
			popItem.setGraphic(newImageView9);
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			MenuItem apItem = new MenuItem("About Paint");
			fileMenu.getItems().add(apItem);
			Image new10 = new Image("10.jpg"); 
			ImageView newImageView10 = new ImageView(new10);
			newImageView10.setFitHeight(16);
			newImageView10.setFitWidth(16); 
			apItem.setGraphic(newImageView10);
			
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			MenuItem eItem = new MenuItem("Exit");
			fileMenu.getItems().add(eItem);
			Image new11 = new Image("11.jpg"); 
			ImageView newImageView11 = new ImageView(new11);
			newImageView11.setFitHeight(16);
			newImageView11.setFitWidth(16); 
			eItem.setGraphic(newImageView11);
			
			fileMenu.getItems().add(new SeparatorMenuItem());
			
			Menu homeMenu = new Menu("_Home");
			Menu viewMenu = new Menu("_View");
			
			
			
			MenuBar menuBar = new MenuBar();
			menuBar.getMenus().addAll(fileMenu,homeMenu,viewMenu);
			
			
			BorderPane layout = new BorderPane();
			layout.setTop(menuBar);
			
			Scene scene = new Scene(layout,800,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
