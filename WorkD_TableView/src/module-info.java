module WorkD_TableView {
	
	requires javafx.controls;
	
	exports application;
	
	opens application to javafx.graphics, javafx.fxml;
}
