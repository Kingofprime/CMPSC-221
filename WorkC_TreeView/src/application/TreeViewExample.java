package application;
	
import javafx.application.Application;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.*;


public class TreeViewExample extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.setTitle("Tree View Example");
			
			TreeView<String> tree = new TreeView<>();
			
			TreeItem<String> root, drinks, fast_food,deserts, salads;
			root = new TreeItem<>();
			//root.setExpanded(true);
			
			drinks = makeBranch("Drink",root);
			makeBranch("Pepsi",drinks);
			makeBranch("Coke",drinks);
			makeBranch("Fanta",drinks);
			makeBranch("Sprite",drinks);
			makeBranch("Water",drinks);
			makeBranch("Mountain Dew",drinks);
			
			
			fast_food = makeBranch("Fast Food",root);
			makeBranch("Burger",fast_food);
			makeBranch("Pizza",fast_food);
			makeBranch("Burito",fast_food);
			makeBranch("Wings",fast_food);
			makeBranch("Sandwich",fast_food);
			
			deserts = makeBranch("deserts",root);
			makeBranch("Cake",deserts);
			makeBranch("Ice Cream",deserts);
			makeBranch("Pie",deserts);
			makeBranch("Cookies",deserts);
			makeBranch("Brownies",deserts);
			
			salads = makeBranch("salads",root);
			makeBranch("Veg",salads);
			makeBranch("Non Veg",salads);
			makeBranch("Ceasar",salads);
			makeBranch("Greek",salads);
			
			tree.setRoot(root);
			
			tree.setShowRoot(false);
			tree.getSelectionModel().selectedItemProperty().addListener(
					(prop,OldVal,newVal)->{
					if(OldVal != null)
					{
						System.out.println("Old Value:"+ OldVal.getValue());
					}
					System.out.println("New Value:"+ newVal.getValue());
					}
					);
			
			StackPane layout = new StackPane();
			layout.getChildren().add(tree);			
			
			Scene scene = new Scene(layout,400,400);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public TreeItem<String> makeBranch(String child, TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(child);
		//item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
}