package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SERS extends Application {
    private TextField yearsTextField;
    private TextField averageSalaryTextField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Retirement Calculator");

        // Create UI elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Label yearsLabel = new Label("Years of Credited Service:");
        yearsTextField = new TextField();

        Label averageSalaryLabel = new Label("Final Average Salary:");
        averageSalaryTextField = new TextField();

        Label output = new Label();
        
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> 
        {
            int years = Integer.parseInt(yearsTextField.getText());
            double averageSalary = Double.parseDouble(averageSalaryTextField.getText());

            double annualRetirementBenefitA3 = 0.02 * years * averageSalary;
            double monthlyAnnuityA3 = annualRetirementBenefitA3 / 12;

            double totalMemberContributionsA3 = averageSalary * years * 0.0625;
            double biweeklyPayA3 = 2*totalMemberContributionsA3 / (years * 52);

            double annualRetirementBenefitA4 = 0.025 * years * averageSalary;
            double monthlyAnnuityA4 = annualRetirementBenefitA4 / 12;

            double totalMemberContributionsA4 = averageSalary * years * 0.093;
            double biweeklyPayA4 = 2*totalMemberContributionsA4 / (years * 52);

            output.setText("Class Membership: A3\n"
            		+"Annual Retirement Benefit: " + annualRetirementBenefitA3
            +"\nMonthly Annuity: " + monthlyAnnuityA3
            +"\nTotal Member Contributions: " + totalMemberContributionsA3
            	+"\nBiweekly Pay: " + biweeklyPayA3
            	+"\n\n"
            		+"\nClass Membership: A4"
            +"\nAnnual Retirement Benefit: " + annualRetirementBenefitA4
            +"\nMonthly Annuity: " + monthlyAnnuityA4
            +"\nTotal Member Contributions: " + totalMemberContributionsA4
            +"\nBiweekly Pay: " + biweeklyPayA4);
        });
        
       
        
        // Add UI elements to the grid pane
        gridPane.add(yearsLabel, 0, 0);
        gridPane.add(yearsTextField, 1, 0, 2, 1);
        gridPane.add(averageSalaryLabel, 0, 1);
        gridPane.add(averageSalaryTextField, 1, 1, 2, 1);
        gridPane.add(calculateButton, 0, 2);
        gridPane.add(output, 0, 3);

        // Create the scene and set it on the stage
        Scene scene = new Scene(gridPane, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
}
