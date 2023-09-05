package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	try {
        // Set title for the primary window
        primaryStage.setTitle("SERS Benefit Calculator");

        // Initialize a new GridPane and set padding and gaps
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10)); // Padding inside grid
        grid.setVgap(5); // Vertical gap between elements
        grid.setHgap(5); // Horizontal gap between elements

        // Create labels and text fields for final average salary and years of credited service
        Label fin_as = new Label("Final Average Salary ($):");
        TextField FinalAverageSalary = new TextField();
        Label year_l = new Label("Years of Credited Service (years):");
        TextField years = new TextField();
        
        // Add labels and text fields to the grid
        grid.add(fin_as, 0, 0);
        grid.add(FinalAverageSalary, 1, 0);
        grid.add(year_l, 0, 1);
        grid.add(years, 1, 1);

        // Create Calculate button and add it to the grid
        Button button = new Button("Calculate");
        grid.add(button, 1, 3);

        // Create a text field for output
        Text txt = new Text();
        grid.add(txt, 0, 4);;

        // Set action for Calculate button, to calculate benefits and contributions
        button.setOnAction(e -> {
            
            double benefitsA3 = calculateBenefits("A-3", Double.parseDouble(FinalAverageSalary.getText()),Double.parseDouble(years.getText()));
            double benefitsA4 = calculateBenefits("A-4", Double.parseDouble(FinalAverageSalary.getText()),Double.parseDouble(years.getText()));
            double contributionsA3 = calculateContributions("A-3", Double.parseDouble(FinalAverageSalary.getText()),Double.parseDouble(years.getText()));
            double contributionsA4 = calculateContributions("A-4", Double.parseDouble(FinalAverageSalary.getText()),Double.parseDouble(years.getText()));
            
        	double biweeklyA3 = calculatebi(contributionsA3,Double.parseDouble(years.getText()));
        	double biweeklyA4 = calculatebi(contributionsA4,Double.parseDouble(years.getText()));
        	
            // Set text to output text field
            txt.setText(String.format("Output\n A-3 Class: Annual Retirement Benefit =$ %.2f, Monthly Annuity =$ %.2f, Total Member Contributions =$ %.2f,Amount withheld from each Bi-weekly pay =$ %.2f \n\n" +
                            "A-4 Class: Annual Retirement Benefit =$ %.2f, Monthly Annuity =$ %.2f, Total Member Contributions =$ %.2f , Amount withheld from each Bi-weekly pay =$ %.2f",
                    benefitsA3, benefitsA3 / 12, contributionsA3,biweeklyA3,
                    benefitsA4, benefitsA4 / 12, contributionsA4,biweeklyA4));
        });

        // Set font for output text
        txt.setFont(Font.font("Cambria", 14));

        // Create a scene with the grid, set it to the primary stage and show the stage
        primaryStage.setScene(new Scene(grid, 1300, 200));
        primaryStage.show();
        
    	}
    	// Catch and handle NumberFormatException
    	catch (NumberFormatException e) {
    	    System.out.println("Enter numbers in Final Average Salary and  Years");
    	}
    }

    // Method to calculate benefits
    private double calculateBenefits(String classOfService, double FinalAverageSalary, double year) {
        
    	
    	double AnnualRetirementBenefit=0;
    	
    	// Different calculation for different class of service
    	if(classOfService.equals("A-3"))
    	{
    		AnnualRetirementBenefit = 0.02*year*FinalAverageSalary;
    	}
    	if(classOfService.equals("A-4"))
    	{
    		AnnualRetirementBenefit = 0.025*year*FinalAverageSalary;
    	}
        
    	return AnnualRetirementBenefit;    
    }

    // Method to calculate contributions
    private double calculateContributions(String classOfService, double FinalAverageSalary, double year) {
        
    	
    	double TotalMemberContributions=0;
    	
    	// Different calculation for different class of service
    	if(classOfService.equals("A-3"))
    	{
    		TotalMemberContributions = 0.0625*year*FinalAverageSalary;
    	}
    	if(classOfService.equals("A-4"))
    	{
    		TotalMemberContributions = 0.093*year*FinalAverageSalary;
    	}
        
    	return TotalMemberContributions; 
    }

    // Method to calculate biweekly pay
    private double calculatebi(double TotalMemberContributions, double year) {
    	
    	double biweek = (year*52.5)/2;
    	double bi = TotalMemberContributions/biweek;
    	
    	return bi;
    }
    
    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
