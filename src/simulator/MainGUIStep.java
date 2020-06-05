package simulator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainGUIStep extends Application {

    private Stage primaryStage;

    @Override
    public void start (Stage primaryStage){
        this.primaryStage = primaryStage;
        mainWindow();
    }

    private void mainWindow () {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/MainWindowGUIStep.fxml"));
            Pane rootPane = loader.load();
            Scene scene = new Scene(rootPane);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
