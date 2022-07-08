package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainSceneController {
    private HomeScreenController controllerWindow1;
    private Stage stage; //stage: ventana la que se visualiza
    @FXML
    private Label lblName;

    @FXML
    void showWindow1(ActionEvent event) {
        controllerWindow1.show();
        stage.close();
    }

    public void init(String text, Stage stage, HomeScreenController homeScreenController) {
        lblName.setText(text);
        this.controllerWindow1 = homeScreenController;
        this.stage = stage;
    }

}
