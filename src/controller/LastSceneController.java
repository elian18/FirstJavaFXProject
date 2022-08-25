package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
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
    private Label lblUser;

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
        String usuario = lblUser.getText();
        String nombre = lblNombre.getText();
        String ci = lblCI.getText();
        String direccion = lblDireccion.getText();
        String phone = lblPhone.getText();

        String cantidad = txtMostrarCantidad.getText();
        String pedido = txtMostrarPedido.getText();
        String precio = txtMostrarPrecio.getText();
        String total = txtMostrarTotal.getText();

        String fecha = String.format("%s", LocalDate.now());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
        Parent viewParent = loader.load();
        MainSceneController mainSceneController = loader.getController();
        mainSceneController.displayDatos(usuario, nombre, ci, direccion, phone, fecha);
        mainSceneController.displayPedido(cantidad, pedido, precio, total);
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }


    @FXML
    void showVentana2(ActionEvent event) throws IOException {
        String fecha = String.format("%s", LocalDate.now());
        String usuario = lblUser.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
        Parent viewParent = loader.load();
        MainSceneController mainSceneController = loader.getController();
        mainSceneController.display(usuario, fecha);
        Scene viewScene = new Scene(viewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(viewScene);
        window.show();
    }


    @FXML
    void generarPedido(ActionEvent event) throws FileNotFoundException, DocumentException {
        int numero = (int) (Math.random()*100+1);
        String nombre = lblNombre.getText();
        String ci = lblCI.getText();
        String direccion = lblDireccion.getText();
        String phone = lblPhone.getText();

        String cantidad = txtMostrarCantidad.getText();
        String pedido = txtMostrarPedido.getText();
        String precio = txtMostrarPrecio.getText();
        String total = txtMostrarTotal.getText();

        Document documento = new Document();
        String destino = ci+"-"+numero+".pdf";
        FileOutputStream ficheroPDF = new FileOutputStream(destino);
        PdfWriter.getInstance(documento, ficheroPDF);
        documento.open();

        Phrase p = new Phrase("\t\t\t\tPROGRABURGUERS\n\n");
        documento.add(p);

        Paragraph titulo = new Paragraph("                                   FACTURA \n\n",
                FontFactory.getFont("arial",
                        22,
                        Font.BOLD,
                        BaseColor.BLUE
                        )
        );

        documento.add(titulo);
        
        Paragraph datos = new Paragraph("NOMBRE: "+nombre +"                                                 "+"CEDULA: "+ ci + "\n"
                                        +"DIRECCION: "+ direccion +"                                                    "+"TELEFONO: "+ phone+"\n\n\n",
                                        FontFactory.getFont("arial",
                                        14,
                                        Font.NORMAL,
                                        BaseColor.BLACK
                                        )
        );

        documento.add(datos);

        PdfPTable tabla = new PdfPTable(3);
        tabla.addCell("PEDIDO");
        tabla.addCell("CANTIDAD");
        tabla.addCell("PRECIO");

        tabla.addCell(pedido);
        tabla.addCell(cantidad);
        tabla.addCell(precio);

        documento.add(tabla);

        Paragraph fin = new Paragraph("\n\n                                                                                   TOTAL: "+"$ "+total+"\n",
                                        FontFactory.getFont("arial",
                                        14,
                                        Font.NORMAL,
                                        BaseColor.BLACK)
        );

        documento.add(fin);
        documento.close();

    }

    public void displayDatos(String usuario, String nombre, String ci, String direccion, String phone) {
        lblUser.setText(usuario);
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

