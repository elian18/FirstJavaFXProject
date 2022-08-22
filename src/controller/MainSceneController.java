package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
    private Label labelHora;

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
    void showWindow1(ActionEvent event) {
        controllerWindow1.show();
        stage.close();
    }


    public void init(String text, Stage stage, HomeScreenController homeScreenController) {
        lblName.setText(text = "Elian Gavilanes");
        String fecha = String.format("%s", LocalDate.now());
        labelFecha.setText(fecha);
        this.controllerWindow1 = homeScreenController;
        this.stage = stage;
    }




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueFactory.setValue(0);
        countHSimple.setValueFactory(valueFactory);
        countHSimple.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Hamburguesa simple\t"+Integer.toString(newValue)));
        
        SpinnerValueFactory<Integer> valueBinaria = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueBinaria.setValue(0);
        countBBinaria.setValueFactory(valueBinaria);
        countBBinaria.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Burguer Binaria\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueCC = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueCC.setValue(0);
        countCC.setValueFactory(valueCC);
        countCC.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" CocaCola\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueD = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueD.setValue(0);
        countD.setValueFactory(valueD);
        countD.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Bebida dietetica\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueF = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueF.setValue(0);
        countF.setValueFactory(valueF);
        countF.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Fanta\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueHD = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueHD.setValue(0);
        countHDoble.setValueFactory(valueHD);
        countHDoble.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Hamburguesa Doble\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueJB = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueJB.setValue(0);
        countJBurguer.setValueFactory(valueJB);
        countJBurguer.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Java Burguer\t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueMP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueMP.setValue(0);
        countMPapas.setValueFactory(valueMP);
        countMPapas.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" MolliPapas\t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valueP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueP.setValue(0);
        countP.setValueFactory(valueP);
        countP.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Pepsi\t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valuePB = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePB.setValue(0);
        countPBurguer.setValueFactory(valuePB);
        countPBurguer.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Prograburguer \t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valuePG = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePG.setValue(0);
        countPGrandes.setValueFactory(valuePG);
        countPGrandes.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Papas Grandes\t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valuePM = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePM.setValue(0);
        countPMedianas.setValueFactory(valuePM);
        countPMedianas.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Papas Medianas\t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valuePP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valuePP.setValue(0);
        countPPequenas.setValueFactory(valuePP);
        countPPequenas.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Papas pequeñas\t"+Integer.toString(newValue)));
        

        SpinnerValueFactory<Integer> valueS = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueS.setValue(0);
        countS.setValueFactory(valueS);
        countS.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" Sprite \t"+Integer.toString(newValue)));

        SpinnerValueFactory<Integer> valueSP = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 50);
        valueSP.setValue(0);
        countSPapa.setValueFactory(valueSP);
        countSPapa.valueProperty().addListener((obs, oldValue, newValue) ->  
        txtPedido.setText(" SalchiPapa\t"+Integer.toString(newValue)))

    }


    @FXML
    void showWindow3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window3.fxml"));
        Parent root = loader.load();
        LastSceneController lastSceneController = loader.getController();
        lastSceneController.init(txtName.getText(), stage, this);
        Stage stage = new Stage(); 
        stage.setScene(new Scene(root));
        stage.show();
        this.stage.close();
    }

}
