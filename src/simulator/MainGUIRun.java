package simulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import simulator.model.Config;
import simulator.model.DomainData;
import simulator.model.Environment;

import java.util.List;

public class MainGUIRun extends Application{

    private Stage primaryStage;

    @Override
    public void start (Stage primaryStage){
        this.primaryStage = primaryStage;
        mainWindow();
    }

    private void mainWindow () {
        try {
            final Environment environment = new Environment();
            final NumberAxis xAxis = new NumberAxis(0,1000,10);
            final NumberAxis yAxis = new NumberAxis(0,100,10);
            xAxis.setLabel("Day");
            yAxis.setLabel("Organism Count");

            final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis,yAxis);
            lineChart.setTitle("Pray-Predator Simulation");

            List<DomainData> dataList = environment.runEnvironment(Config.PROGRESSION_STEPS);
            XYChart.Series plantSeries = new XYChart.Series();
            XYChart.Series rabbitSeries = new XYChart.Series();
            XYChart.Series wolfSeries = new XYChart.Series();
            for(DomainData domainData : dataList) {
                plantSeries.getData().add(new XYChart.Data(domainData.getDay(), domainData.getPlantCount()));
                rabbitSeries.getData().add(new XYChart.Data(domainData.getDay(), domainData.getRabbitCount()));
                wolfSeries.getData().add(new XYChart.Data(domainData.getDay(), domainData.getWolfCount()));
            }
            lineChart.getData().add(plantSeries);
            lineChart.getData().add(rabbitSeries);
            lineChart.getData().add(wolfSeries);

            Scene scene = new Scene(lineChart);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
