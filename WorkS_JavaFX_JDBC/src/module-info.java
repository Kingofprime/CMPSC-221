module WorkS_JavaFX_JDBC {
	requires javafx.controls;
	requires java.sql;
	
	exports application;
	
	opens application to javafx.graphics, javafx.fxml;
}
