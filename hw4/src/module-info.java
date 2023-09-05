module hw4 {
	
	requires javafx.controls;
	requires java.desktop;
	requires javafx.graphics;
	
	exports application;
	
	opens application to javafx.graphics, javafx.fxml;
}
