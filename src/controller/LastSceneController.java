package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private TextArea txtMostrarCantidad;

    @FXML
    private Label txtMostrarIVA;

    @FXML
    private TextArea txtMostrarPedido;

    @FXML
    private TextArea txtMostrarPrecio;

    @FXML
    private Label txtMostrarTotal;




    @FXML
    void showVentana2(ActionEvent event) {
        controllerWindow2.show();
        this.stage.close();
    }

    public void init(String nombre, Stage stage, MainSceneController mainSceneController) {
        lblNombre.setText(nombre);
        this.controllerWindow2 = mainSceneController;
        this.stage = stage;
    }


    public void displayDatos(String ci, String direccion, String phone) {
        lblCI.setText(ci);
        lblDireccion.setText(direccion);
        lblPhone.setText(phone);

    }

    public void displayPedido(String cantidad, String pedido, String precio, String total){
        txtMostrarCantidad.setText(cantidad);
        txtMostrarPedido.setText(pedido);
        txtMostrarPrecio.setText(precio);
        txtMostrarTotal.setText(total);
    }


}

