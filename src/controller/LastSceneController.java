package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LastSceneController {

    private MainSceneController controllerWindow2;
    private Stage stage;

    @FXML
    private Label lblNombre;

    @FXML
    void showVentana2(ActionEvent event) {
        controllerWindow2.show();
        stage.close();
    }

    public void init(String text, Stage stage, MainSceneController mainSceneController) {
        lblNombre.setText(text);
        this.controllerWindow2 = mainSceneController;
        this.stage = stage;
    }

}

