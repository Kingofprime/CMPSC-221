package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;

// JavaFX application class
public class SecondView extends Application {
	
    // The start method is the main entry point for all JavaFX applications
	@Override
	public void start(Stage primaryStage) {
		try {
            // Set the title of the primary stage
			primaryStage.setTitle("");
			
			// Create a new TreeView
			TreeView<String> tree = new TreeView<>();
			
			// Declare TreeItems that will act as nodes
			TreeItem<String> root,Tutorials,WebTutorials,JavaTutorials;
			
			// Initialize the root node
			root = new TreeItem<>();
			root.setExpanded(true);
			
			// Create a "Tutorials" node under the root node
			Tutorials = makeBranch("Tutorials",root);
			
			// Set root of the tree
			tree.setRoot(root);
			
			// Create "Web Tutorials" and "Java Tutorials" nodes under the "Tutorials" node
			WebTutorials = makeBranch("Web Tutorials",Tutorials);
			makeBranch("HTML Tutorial",WebTutorials);
			makeBranch("HTML5 Tutorial",WebTutorials);
			makeBranch("CSS Tutorial",WebTutorials);
			makeBranch("SVG Tutorial",WebTutorials);
			
			JavaTutorials = makeBranch("Java Tutorials",Tutorials);
			makeBranch("Java language",JavaTutorials);
			makeBranch("Java Collections",JavaTutorials);
			makeBranch("Java Concurrency",JavaTutorials);
			
		    // Set root of the tree and don't show the root node
			tree.setRoot(root);
			tree.setShowRoot(false);
			
			// Create a new layout and add the tree to it
			StackPane layout = new StackPane();
			layout.getChildren().add(tree);
			
			// Create a new scene with the layout and set it to the primary stage
			Scene scene = new Scene(layout,300,250);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Method to create a new branch in the tree
	public TreeItem<String> makeBranch(String child,TreeItem<String> parent){
		TreeItem<String> item = new TreeItem<>(child);
		item.setExpanded(true);
		parent.getChildren().add(item);
		return item;
	}
	
	// Main method to launch the application
	public static void main(String[] args) {
		launch(args);
	}
}
