module XYZCompany_UIProject {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.sql;
	
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
