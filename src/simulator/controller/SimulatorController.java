package simulator.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import simulator.model.Environment;

import java.util.ArrayList;
import java.util.List;


public class SimulatorController {

    @FXML private TextArea textArea1;
    @FXML private TextArea textArea2;
    @FXML private TextArea textArea3;
    @FXML private TextArea textArea4;
    @FXML private TextArea textArea5;
    @FXML private TextArea textArea6;
    @FXML private TextArea textArea7;
    @FXML private TextArea textArea8;
    @FXML private TextArea textArea9;
    @FXML private TextArea textArea10;
    @FXML private TextArea textArea11;
    @FXML private TextArea textArea12;
    @FXML private TextArea textArea13;
    @FXML private TextArea textArea14;
    @FXML private TextArea textArea15;
    @FXML private TextArea textArea16;
    @FXML private TextArea textAreaMoveList;

    Environment environment;
    List<TextArea> textAreaList;

    @FXML
    public void initialize() {
        textAreaList = new ArrayList<>();
        textAreaList.add(textArea1);
        textAreaList.add(textArea2);
        textAreaList.add(textArea3);
        textAreaList.add(textArea4);
        textAreaList.add(textArea5);
        textAreaList.add(textArea6);
        textAreaList.add(textArea7);
        textAreaList.add(textArea8);
        textAreaList.add(textArea9);
        textAreaList.add(textArea10);
        textAreaList.add(textArea11);
        textAreaList.add(textArea12);
        textAreaList.add(textArea13);
        textAreaList.add(textArea14);
        textAreaList.add(textArea15);
        textAreaList.add(textArea16);
    }

    public void init() {
        environment = new Environment();
        updateAllTextAreas();
    }

    public void updateAllTextAreas() {
        for(int i = 1; i <= 16 ; i ++) {
            textAreaList.get(i-1).setText(environment.getAreaString(i));
        }
        textAreaMoveList.setText(environment.getMoveList());
    }

    public void updateTextArea(int number) {
        textAreaList.get(number-1).setText(environment.getAreaString(number));
        textAreaMoveList.setText(environment.getMoveList());
    }

    public void step() {
        TextArea textArea = textAreaList.get(environment.getCurrentArea()-1);
        textArea.setStyle("-fx-border-color: none");
        if(environment.stepEnvironment()) {
            updateTextArea(environment.getCurrentArea()-1);
        }else {
            updateAllTextAreas();
        }
        textAreaList.get(environment.getCurrentArea()-1).setStyle("-fx-border-color: #54ee38");
    }


}
