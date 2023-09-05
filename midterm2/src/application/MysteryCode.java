package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class MysteryCode extends Application {
	
	public static void main(String[] args) {
        launch(args);
    }
 
    @Override 
    public void start(Stage stage) {
    	
        stage.setTitle("Area Chart Sample");
        
        final NumberAxis xAxis = new NumberAxis(1, 32, 1);
        xAxis.setMinorTickCount(0);    
        
        final NumberAxis yAxis = new NumberAxis(-5, 50, 5);        
        yAxis.setMinorTickLength(yAxis.getTickLength());
        yAxis.setForceZeroInRange(false);        
        
        final AreaChart<Number,Number> areaChart = 
            new AreaChart<Number,Number>(xAxis,yAxis);       
        areaChart.setTitle("Temperature Monitoring (in Degrees C)");
 
        XYChart.Series seriesMarch = new XYChart.Series();
        seriesMarch.setName("March");
        seriesMarch.getData().add(new XYChart.Data(0, -2));
        seriesMarch.getData().add(new XYChart.Data(3, -4));
        seriesMarch.getData().add(new XYChart.Data(6, 0));
        seriesMarch.getData().add(new XYChart.Data(9, 5));
        seriesMarch.getData().add(new XYChart.Data(12, -4));
        seriesMarch.getData().add(new XYChart.Data(15, 6));
        seriesMarch.getData().add(new XYChart.Data(18, 8));
        seriesMarch.getData().add(new XYChart.Data(21, 14));
        seriesMarch.getData().add(new XYChart.Data(24, 4));
        seriesMarch.getData().add(new XYChart.Data(27, 6));
        seriesMarch.getData().add(new XYChart.Data(31, 6));
                
        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(1, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));
        
        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(0, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));
                
        XYChart.Series seriesJune = new XYChart.Series();
        seriesJune.setName("June");
        seriesJune.getData().add(new XYChart.Data(1, 0));
        seriesJune.getData().add(new XYChart.Data(4, 5));
        seriesJune.getData().add(new XYChart.Data(7, 15));
        seriesJune.getData().add(new XYChart.Data(10, 44));
        seriesJune.getData().add(new XYChart.Data(13, 30));
        seriesJune.getData().add(new XYChart.Data(16, 25));
        seriesJune.getData().add(new XYChart.Data(19, 21));
        seriesJune.getData().add(new XYChart.Data(22, 33));
        seriesJune.getData().add(new XYChart.Data(25, 40));
        seriesJune.getData().add(new XYChart.Data(28, 29));
        seriesJune.getData().add(new XYChart.Data(31, 37));
        
        Scene scene  = new Scene(areaChart,1200,700);
        areaChart.getData().addAll(seriesMarch, seriesApril, seriesMay, seriesJune);
        stage.setScene(scene);
        stage.show();
    }
 
    
}