package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LastSceneController {

    private MainSceneController controllerWindow2;
    private Stage stage;

    @FXML
    private Label lblCI;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPhone;

    @FXML
    void showVentana2(ActionEvent event) {
        controllerWindow2.show();
        stage.close();
    }

    public void displayDatos(String nombre, String ci, String direccion, String phone, Stage stage, MainSceneController mainSceneController) {
        lblNombre.setText(nombre);
        lblCI.setText(ci);
        lblDireccion.setText(direccion);
        lblPhone.setText(phone);
        this.controllerWindow2 = mainSceneController;
        this.stage = stage;
    }

}

