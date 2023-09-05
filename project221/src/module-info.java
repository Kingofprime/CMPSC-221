module project221 {
	
		requires javafx.controls;
		requires java.sql;
		
		exports application;
		
		opens application to javafx.graphics, javafx.fxml;
	

}
