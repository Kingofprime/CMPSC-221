module Midterm_Two {

    requires javafx.controls;

    exports application;

    opens application to javafx.graphics, javafx.fxml;
}