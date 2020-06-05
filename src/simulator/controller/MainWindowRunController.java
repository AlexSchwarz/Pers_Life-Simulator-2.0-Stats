package simulator.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import simulator.model.Config;
import simulator.model.Environment;

public class MainWindowRunController {

    @FXML private Button buttonInit;
    @FXML private Button buttonRun;
    @FXML private LineChart lineChart;

    Environment environment;

    @FXML
    public void initialize() {

    }

    public void init() {
        environment = new Environment();
    }

    public void run() {
        environment.progressEnvironment(Config.PROGRESSION_STEPS);
    }

}
