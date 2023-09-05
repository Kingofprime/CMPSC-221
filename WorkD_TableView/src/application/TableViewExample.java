package application;
	
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;


public class TableViewExample extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			
			primaryStage.setTitle("Table View");
			TableView<Data> table = new TableView<>();
			
			TableColumn<Data, String> istColumn = new TableColumn<>("Name");
			istColumn.setMinWidth(150);
			istColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			
			TableColumn<Data, Double> secColumn = new TableColumn<>("Price");
			secColumn.setMinWidth(100);
			secColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
			
			TableColumn<Data, Integer> thrColumn = new TableColumn<>("Quantity");
			thrColumn.setMinWidth(100);
			thrColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
			
			table.setItems( getData() );
			table.getColumns().addAll(istColumn, secColumn, thrColumn);
			
			StackPane layout = new StackPane();
			layout.getChildren().add(table);
			
			Scene scene = new Scene(layout, 500, 600);
			primaryStage.setScene(scene);
			primaryStage.show();			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ObservableList<Data> getData() {
		
		ObservableList<Data> data_list = FXCollections.observableArrayList();
		
		data_list.add(new Data("Milk", 66.99, 7));
		data_list.add(new Data("Water", 25.60, 200));
		data_list.add(new Data("Honey", 150.99, 65));
		data_list.add(new Data("Sugar", 10.20, 60));
		data_list.add(new Data("Salt", 8.99, 5));
		data_list.add(new Data("Bread", 1.66, 3));
		data_list.add(new Data("Soda", 25.60, 200));
		data_list.add(new Data("Peanut", 1.50, 6));
		data_list.add(new Data("Candy", 10.20, 1360));
		data_list.add(new Data("Rice", 53.50, 20));
		
		return data_list;
		
	}
	
	
}
