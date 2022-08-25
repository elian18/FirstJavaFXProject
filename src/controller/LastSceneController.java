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
    void showEditVentana2(ActionEvent event) throws IOException {

        String nombre = lblNombre.getText();
        String ci = lblCI.getText();
        String direccion = lblDireccion.getText();
        String phone = lblPhone.getText();

        String cantidad = txtMostrarCantidad.getText();
        String pedido = txtMostrarPedido.getText();
        String precio = txtMostrarPrecio.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
        Parent viewParent = loader.load();
        MainSceneController mainSceneController = loader.getController();
        mainSceneController.displayDatos(nombre, ci, direccion, phone);
        mainSceneController.displayPedido(cantidad, pedido, precio);
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }


    @FXML
    void showVentana2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
        Parent viewParent = loader.load();
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

