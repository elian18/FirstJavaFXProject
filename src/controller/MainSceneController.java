package controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainSceneController implements Initializable {
String fecha = String.format("%s", LocalDate.now());
private volatile boolean stop = false;

private double HS, BB, CC, BD, F, HD, JB, MP, P, PB, PG, PM, PP, S, SP;

@FXML
private Spinner<Integer> countBBinaria;
SpinnerValueFactory<Integer> valueBinaria = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countCC;
SpinnerValueFactory<Integer> valueCC = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countD;
SpinnerValueFactory<Integer> valueD = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countF;
SpinnerValueFactory<Integer> valueF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countHDoble;
SpinnerValueFactory<Integer> valueHDoble = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countHSimple;
SpinnerValueFactory<Integer> valueSimple = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countJBurguer;
SpinnerValueFactory<Integer> valueJBurguer = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countMPapas;
SpinnerValueFactory<Integer> valueMPapas = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countP;
SpinnerValueFactory<Integer> valueP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countPBurguer;
SpinnerValueFactory<Integer> valuePBurguer = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countPGrandes;
SpinnerValueFactory<Integer> valuePGrandes = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countPMedianas;
SpinnerValueFactory<Integer> valuePMedianas = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countPPequenas;
SpinnerValueFactory<Integer> valuePPequenas = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countS;
SpinnerValueFactory<Integer> valueS = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Spinner<Integer> countSPapa;
SpinnerValueFactory<Integer> valueSPapa = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);

@FXML
private Label labelFecha;

@FXML
private Label lblTime;

@FXML
private Label lblName;

@FXML
private TextField txtAdress;

@FXML
private TextField txtCI;

@FXML
private TextField txtName;

@FXML
private TextField txtPhone;

@FXML
private TextArea txtPedido;

@FXML
private Label lblTotal;

@FXML
private TextArea txtCant;

@FXML
private TextArea txtPrice;

/**
 * Metodo para regresar a la ventana 1
 * @param event
 * @throws IOException
 */
@FXML
void showWindow1(ActionEvent event) throws IOException {
                Parent viewParent = FXMLLoader.load(getClass().getResource("/view/Window1.fxml"));
                Scene viewScene = new Scene(viewParent);
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(viewScene);
                window.show();
}
/**
 * Metodo para avanzar a la pantalla 3
 * @param event
 * @throws IOException
 */
@FXML
void showWindow3(ActionEvent event) throws IOException {
        stop = true;
        String usuario = lblName.getText();
        String nombre = txtName.getText();
        String ci = txtCI.getText();
        String direccion = txtAdress.getText();
        String phone = txtPhone.getText();
        String cantidad = txtCant.getText();
        String pedido = txtPedido.getText();
        String precio = txtPrice.getText();
        String total = lblTotal.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window3.fxml"));
        Parent viewParent = loader.load();
        LastSceneController lastSceneController = loader.getController();
        lastSceneController.displayDatos(usuario, nombre, ci, direccion, phone);
        lastSceneController.displayPedido(cantidad, pedido, precio, total);
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
}

/**
 * Botones para tomar el pedido
 * @param event
 */

@FXML
void btnHSimple(MouseEvent event) {
        HS = 1 * countHSimple.getValue();
        txtPedido.appendText("Hamburguesa simple\n" );
        txtCant.appendText(String.valueOf(countHSimple.getValue())+"\n" );
        txtPrice.appendText("$"+HS+"\n");
}

@FXML
void btnBBinaria(MouseEvent event) {
        BB = 1.75 * countBBinaria.getValue();
        txtPedido.appendText("Hamburguesa Binaria\n");
        txtCant.appendText(String.valueOf(countBBinaria.getValue())+"\n");
        txtPrice.appendText("$"+BB+"\n");
}

@FXML
void btnBDieta(MouseEvent event) {
        BD = 1.75 * countD.getValue();
        txtPedido.appendText("Coca-Cola Diet\n");
        txtCant.appendText(String.valueOf(countD.getValue())+"\n");
        txtPrice.appendText("$"+BD+"\n");
}

@FXML
void btnCCola(MouseEvent event) {
        CC = 1.5 * countCC.getValue();
        txtPedido.appendText("Coca-Cola\n");
        txtCant.appendText(String.valueOf(countCC.getValue())+"\n");
        txtPrice.appendText("$"+CC+"\n");

}

@FXML
void btnFanta(MouseEvent event) {
        F = 1.5 * countF.getValue();
        txtPedido.appendText("Fanta\n");
        txtCant.appendText(String.valueOf(countF.getValue())+"\n");
        txtPrice.appendText("$"+F+"\n");

}

@FXML
void btnHDoble(MouseEvent event) {
        HD = 2.25 * countHDoble.getValue();
        txtPedido.appendText("Hamburguesa Doble\n");
        txtCant.appendText(String.valueOf(countHDoble.getValue())+"\n");
        txtPrice.appendText("$"+HD+"\n");

}

@FXML
void btnJBurguer(MouseEvent event) {
        JB = 2.5 * countJBurguer.getValue();
        txtPedido.appendText("Java Burguer\n");
        txtCant.appendText(String.valueOf(countJBurguer.getValue())+"\n");
        txtPrice.appendText("$"+JB+"\n");
}

@FXML
void btnMPapas(MouseEvent event) {
        MP = 1.5 * countMPapas.getValue();
        txtPedido.appendText("Molli Papas\n");
        txtCant.appendText(String.valueOf(countMPapas.getValue())+"\n");
        txtPrice.appendText("$"+MP+"\n");

}

@FXML
void btnPBurguer(MouseEvent event) {
        PB = 2.5 * countPBurguer.getValue();
        txtPedido.appendText("PrograBurguer\n");
        txtCant.appendText(String.valueOf(countPBurguer.getValue())+"\n");
        txtPrice.appendText("$"+PB+"\n");
}

@FXML
void btnPGrandes(MouseEvent event) {
        PG = 2 * countPGrandes.getValue();
        txtPedido.appendText("Papas Grandes\n");
        txtCant.appendText(String.valueOf(countPGrandes.getValue())+"\n");
        txtPrice.appendText("$"+PG+"\n");

}

@FXML
void btnPMedianas(MouseEvent event) {
        PM = 1.5 * countPMedianas.getValue();
        txtPedido.appendText("Papas Medianas\n");
        txtCant.appendText(String.valueOf(countPMedianas.getValue())+"\n");
        txtPrice.appendText("$"+PM+"\n");
}

@FXML
void btnPPequenas(MouseEvent event) {
        PP = 1.25 * countPPequenas.getValue();
        txtPedido.appendText("Papas Pequeñas\n");
        txtCant.appendText(String.valueOf(countPPequenas.getValue())+"\n");
        txtPrice.appendText("$"+PP+"\n");

}

@FXML
void btnPepsi(MouseEvent event) {
        P = 1.5 * countP.getValue();
        txtPedido.appendText("Pepsi\n");
        txtCant.appendText(String.valueOf(countP.getValue())+"\n");
        txtPrice.appendText("$"+P+"\n");
}

@FXML
void btnSPapa(MouseEvent event) {
        SP = 1 * countSPapa.getValue();
        txtPedido.appendText("SalchiPapa\n");
        txtCant.appendText(String.valueOf(countSPapa.getValue())+"\n");
        txtPrice.appendText("$"+SP+"\n");

}

@FXML
void btnSprite(MouseEvent event) {
        S = 1 * countS.getValue();
        txtPedido.appendText("Sprite\n");
        txtCant.appendText(String.valueOf(countS.getValue())+"\n");
        txtPrice.appendText("$"+S+"\n");
}

/**
 * Metodo que suma los precios de los productos
 * @param event
 */
@FXML
void sumarPedidos(ActionEvent event) {
        Double suma = HS+BB+CC+BD+F+HD+JB+MP+P+PB+PG+PM+PP+S+SP;
        String total = suma.toString();
        lblTotal.setText(total);
}
public void init(String usuario, Stage stage, HomeScreenController homeScreenController) {
        lblName.setText(usuario);
        labelFecha.setText(fecha);

}
/**
 * Metodo que indica la hora en tiempo real
 */

public void showTime() {
        Thread thread = new Thread(() ->{
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
                while (!stop) {
                        try {
                                Thread.sleep(1000);
                        } catch (Exception e) {
                                System.out.println("e");
                        }
                        final String showTime = sdf.format(new Date());
                        Platform.runLater(()->{
                                lblTime.setText(showTime);
                        });
                }
        });
        thread.start();
}

/**
 * Interface que inicializa la hora y los spinners
 */
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
        showTime();
        
        countHSimple.setValueFactory(valueSimple);
        countBBinaria.setValueFactory(valueBinaria);
        countCC.setValueFactory(valueCC);
        countD.setValueFactory(valueD);        
        countF.setValueFactory(valueF);
        countHDoble.setValueFactory(valueHDoble);
        countJBurguer.setValueFactory(valueJBurguer);
        countMPapas.setValueFactory(valueMPapas);
        countP.setValueFactory(valueP);
        countPBurguer.setValueFactory(valuePBurguer);
        countPGrandes.setValueFactory(valuePGrandes);
        countPMedianas.setValueFactory(valuePMedianas);
        countPPequenas.setValueFactory(valuePPequenas);
        countS.setValueFactory(valueS);
        countSPapa.setValueFactory(valueSPapa);
}
/**
 * Metodo que indica los datos del cliente
 * @param usuario
 * @param nombre
 * @param ci
 * @param direccion
 * @param phone
 * @param fecha
 */
public void displayDatos(String usuario, String nombre, String ci, String direccion, String phone, String fecha) {
        lblName.setText(usuario);
        txtName.setText(nombre);
        txtCI.setText(ci);
        txtAdress.setText(direccion);
        txtPhone.setText(phone);
        labelFecha.setText(fecha);

}

/**
 * Metodo que regresa el usuario y la fecha a las pantallas
 * @param usuario
 * @param fecha
 */
public void display(String usuario, String fecha) {
        lblName.setText(usuario);
        labelFecha.setText(fecha);
}

}
