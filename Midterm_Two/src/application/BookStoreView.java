package application;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookStoreView extends Application {

    TextField name, price, quantity;
    TableView<BookStore> table;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            primaryStage.setTitle("Book View Sample");

            BorderPane borderPane = new BorderPane();

          
            Label label = new Label("Book Store");
            label.setStyle("-fx-font-size: 20px;");

           
            table = new TableView<>();

            TableColumn<BookStore, String> nameColumn = new TableColumn<>("Name");
            nameColumn.setMinWidth(150);
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

            TableColumn<BookStore, Double> priceColumn = new TableColumn<>("Price");
            priceColumn.setMinWidth(150);
            priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

            TableColumn<BookStore, Integer> quantityColumn = new TableColumn<>("Quantity");
            quantityColumn.setMinWidth(150);
            quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

            TableColumn<BookStore, Double> subTotalColumn = new TableColumn<>("Sub Total");
            subTotalColumn.setMinWidth(100);
            subTotalColumn.setCellValueFactory(new PropertyValueFactory<>("subTotal"));

            table.setItems(getData());
            table.getColumns().addAll(nameColumn, priceColumn, quantityColumn, subTotalColumn);

           
            name = new TextField();
            name.setPromptText("Name");
            name.setMinWidth(100);

            price = new TextField();
            price.setPromptText("Price");
            price.setMinWidth(100);

            quantity = new TextField();
            quantity.setPromptText("Quantity");
            quantity.setMinWidth(100);

           

            Button Btn = new Button("Add");
            Btn.setOnAction(e -> addData());

            HBox inputBox = new HBox(10);
            inputBox.setPadding(new Insets(10));
            inputBox.getChildren().addAll(name, price, quantity, Btn);

            // Create the layout and add components
            VBox vbox = new VBox(10);
            vbox.getChildren().addAll(label, table, inputBox);
            vbox.setPadding(new Insets(0));

            borderPane.setTop(vbox);
            

           
            Scene scene = new Scene(borderPane, 700, 700);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ObservableList<BookStore> getData() {
        ObservableList<BookStore> dataList = FXCollections.observableArrayList();
        dataList.add(new BookStore("Notebook", 10, 12));
        dataList.add(new BookStore("Eraser", 20, 12));
        dataList.add(new BookStore("Pencil", 30,12));
        dataList.add(new BookStore("Pen", 40, 12));
        dataList.add(new BookStore("Glue", 50, 12));
        return dataList;
    }

    public void addData() {
        	BookStore data = new BookStore();
            String Name= name.getText();
            String priceText = price.getText();
            String quantityText = quantity.getText();
            if(!priceText.matches("\\d+(\\.\\d+)?") || !quantityText.matches("\\d+")) // Check if the input is not numeric
            {
                // Show error dialog
                Stage a = new Stage();
                Label l = new Label("Enter Quantity and Integer as a Number");
                Scene s= new Scene(l,200,200);
                a.setScene(s);
                a.setTitle("Error Dialog");
                a.showAndWait();
                return;
            }
            double Price = Double.parseDouble(price.getText());
            int Quantity = Integer.parseInt(quantity.getText());
            if(Price <=0 || Quantity <=0) // Check if the input are greater then zero
            {
                // Show error dialog
                Stage a = new Stage();
                Label l = new Label("Enter Quantity and Price greater then Zero");
                Scene s= new Scene(l,400,200);
                a.setScene(s);
                a.setTitle("Error Dialog");
                a.showAndWait();
                return;
            }
            if(Name == "") // Check if Name is empty or not
            {
            	// Show error dialog
                Stage a = new Stage();
                Label l = new Label("Enter Name");
                Scene s= new Scene(l,400,200);
                a.setScene(s);
                a.setTitle("Error Dialog");
                a.showAndWait();
                return;
            }
            data.setName(Name);
            data.setPrice(Price);
            data.setQuantity(Quantity);
            data.setSubTotal(Quantity,Price);
            table.getItems().add(data);
            Stage a = new Stage();
            Label l = new Label("Data Entered");
            Scene s= new Scene(l,200,200);
            a.setScene(s);
            a.setTitle("Error Dialog");
            a.showAndWait();
            name.clear();
            price.clear();
            quantity.clear();
           
        } 

}
