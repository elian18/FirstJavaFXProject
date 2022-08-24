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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainSceneController implements Initializable {

    private HomeScreenController controllerWindow1;
    private Stage stage; //stage: ventana la que se visualiza
    MainSceneController mainSceneController;
    private volatile boolean stop = false;

    private double HS;
    private double BB;
    private double CC;
    private double BD;
    private double F;
    private double HD;
    private double JB;
    private double MP;
    private double P;
    private double PB;
    private double PG;
    private double PM;
    private double PP;
    private double S;
    private double SP;
    
    
    
    @FXML
    private Spinner<Integer> countBBinaria;

    @FXML
    private Spinner<Integer> countCC;

    @FXML
    private Spinner<Integer> countD;

    @FXML
    private Spinner<Integer> countF;

    @FXML
    private Spinner<Integer> countHDoble;

    @FXML
    private Spinner<Integer> countHSimple;

    @FXML
    private Spinner<Integer> countJBurguer;

    @FXML
    private Spinner<Integer> countMPapas;

    @FXML
    private Spinner<Integer> countP;

    @FXML
    private Spinner<Integer> countPBurguer;

    @FXML
    private Spinner<Integer> countPGrandes;

    @FXML
    private Spinner<Integer> countPMedianas;

    @FXML
    private Spinner<Integer> countPPequenas;

    @FXML
    private Spinner<Integer> countS;

    @FXML
    private Spinner<Integer> countSPapa;
        
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

    @FXML
    void showWindow1(ActionEvent event) {
        controllerWindow1.show();
        stage.close();
    }

    @FXML
    void showWindow3(ActionEvent event) throws IOException {
        stop = true;
        String nombre = txtName.getText();
        String ci = txtCI.getText();
        String direccion = txtAdress.getText();
        String phone = txtPhone.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window3.fxml"));
        Parent root = loader.load();
        LastSceneController controller = loader.getController();
        controller.displayDatos(nombre, ci, direccion, phone, stage, this);
        Scene scene = new Scene(root);
        Stage stage = new Stage(); // Crea la ventana
        stage.setScene(scene);
        stage.show();
        this.stage.close();
    }

    
    @FXML
    void sumarPedidos(ActionEvent event) {
        Double suma = HS+BB+CC+BD+F+HD+JB+MP+P+PB+PG+PM+PP+S+SP;
        String total = suma.toString();
        lblTotal.setText(total);
    }


    public void init(String text, Stage stage, HomeScreenController homeScreenController) {
        lblName.setText(text);
        String fecha = String.format("%s", LocalDate.now());
        labelFecha.setText(fecha);
        this.controllerWindow1 = homeScreenController;
        this.stage = stage;
    }

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

    public void show() {
        stage.show();
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        showTime();

        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueFactory.setValue(0);
        countHSimple.setValueFactory(valueFactory);
        countHSimple.valueProperty().addListener((obs, oldValue, newValue) -> {
            HS = 1*newValue;
                txtPedido.appendText("Hamburguesa simple\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+HS+"\n");
        });
        
        SpinnerValueFactory<Integer> valueBinaria = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueBinaria.setValue(0);
        countBBinaria.setValueFactory(valueBinaria);
        countBBinaria.valueProperty().addListener((obs, oldValue, newValue) ->  {
            BB = 1.75*newValue;
                txtPedido.appendText("Burguer Binaria\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+BB+"\n");       
        }); 

        SpinnerValueFactory<Integer> valueCC = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueCC.setValue(0);
        countCC.setValueFactory(valueCC);
        countCC.valueProperty().addListener((obs, oldValue, newValue) ->  {
        CC = 1.5*newValue;
                txtPedido.appendText("CocaCola\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+CC+"\n");
        });

        SpinnerValueFactory<Integer> valueD = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueD.setValue(0);
        countD.setValueFactory(valueD);
        countD.valueProperty().addListener((obs, oldValue, newValue) ->  {
        BD = 1.75*newValue;    
                txtPedido.appendText("Bebida dietetica\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+BD+"\n");  
        });        


        SpinnerValueFactory<Integer> valueF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueF.setValue(0);
        countF.setValueFactory(valueF);
        countF.valueProperty().addListener((obs, oldValue, newValue) ->  {
        F = 1.50*newValue;    
                txtPedido.appendText("Fanta\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+F+"\n"); 
        });          
        

        SpinnerValueFactory<Integer> valueHD = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueHD.setValue(0);
        countHDoble.setValueFactory(valueHD);
        countHDoble.valueProperty().addListener((obs, oldValue, newValue) ->   {
        HD = 2.25*newValue; 
                txtPedido.appendText("Hamburguesa Doble\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+HD+"\n");  
        }); 

        SpinnerValueFactory<Integer> valueJB = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueJB.setValue(0);
        countJBurguer.setValueFactory(valueJB);
        countJBurguer.valueProperty().addListener((obs, oldValue, newValue) ->   {
        JB = 2.50*newValue; 
                txtPedido.appendText("JavaBurguer\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+JB+"\n"); 
        }); 

        SpinnerValueFactory<Integer> valueMP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueMP.setValue(0);
        countMPapas.setValueFactory(valueMP);
        countMPapas.valueProperty().addListener((obs, oldValue, newValue) ->  {
        MP = 1.50*newValue; 
                txtPedido.appendText("MolliPapas\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+MP+"\n");  
        }); 
        

        SpinnerValueFactory<Integer> valueP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueP.setValue(0);
        countP.setValueFactory(valueP);
        countP.valueProperty().addListener((obs, oldValue, newValue) -> {
        P = 1.50*newValue;  
                txtPedido.appendText("Pepsi\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+P+"\n"); 
        }); 
        

        SpinnerValueFactory<Integer> valuePB = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePB.setValue(0);
        countPBurguer.setValueFactory(valuePB);
        countPBurguer.valueProperty().addListener((obs, oldValue, newValue) -> {
        PB = 2.50*newValue;
                txtPedido.appendText("PrograBurguer\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+PB+"\n"); 
        }); 
        

        SpinnerValueFactory<Integer> valuePG = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePG.setValue(0);
        countPGrandes.setValueFactory(valuePG);
        countPGrandes.valueProperty().addListener((obs, oldValue, newValue) ->  {
        PG = 2.00*newValue;
                txtPedido.appendText("Papas Grandes\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+PG+"\n");  
        }); 
        

        SpinnerValueFactory<Integer> valuePM = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePM.setValue(0);
        countPMedianas.setValueFactory(valuePM);
        countPMedianas.valueProperty().addListener((obs, oldValue, newValue) -> {
        PM = 1.50*newValue; 
                txtPedido.appendText("Papas Medianas\n" );
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+PM+"\n");  
        }); 
        

        SpinnerValueFactory<Integer> valuePP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePP.setValue(0);
        countPPequenas.setValueFactory(valuePP);
        countPPequenas.valueProperty().addListener((obs, oldValue, newValue) ->{
        PP = 1.50*newValue;   
                txtPedido.appendText("Papas Pequeñas \n");
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+PP+"\n");
        }); 
        

        SpinnerValueFactory<Integer> valueS = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueS.setValue(0);
        countS.setValueFactory(valueS);
        countS.valueProperty().addListener((obs, oldValue, newValue) ->  {
        S = 1.00*newValue;
                txtPedido.appendText("Sprite \n");
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+S+"\n");
        }); 

        SpinnerValueFactory<Integer> valueSP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueSP.setValue(0);
        countSPapa.setValueFactory(valueSP);
        countSPapa.valueProperty().addListener((obs, oldValue, newValue) ->  {
        SP = 1.00*newValue;
                txtPedido.appendText("SalchiPapa\n");
                txtCant.appendText(Integer.toString(newValue)+"\n");
                txtPrice.appendText("$"+SP+"\n");
        }); 
    }}
