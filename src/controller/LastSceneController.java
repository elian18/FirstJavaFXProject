package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class LastSceneController {

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
    void showVentana2(ActionEvent event) throws IOException {
        Parent viewParent = FXMLLoader.load(getClass().getResource("/view/Window2.fxml"));
                Scene viewScene = new Scene(viewParent);

                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

                window.setScene(viewScene);
                window.show();
    }

    public void displayDatos(String nombre, String ci, String direccion, String phone) {
        lblNombre.setText(nombre);
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

