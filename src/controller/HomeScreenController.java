package controller;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class HomeScreenController {

    private Stage stage;

    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField txtPasword;


    @FXML
    private void eventKey(KeyEvent event)
    {
        Object evt = event.getSource();
        if(evt.equals(txtUser))
        {
            if(event.getCharacter() .equals(" "))
            {
                event.consume();
            }
        }else if(evt.equals(txtPasword))
        {
            if(event.getCharacter().equals(" "))
            {
                event.consume();
            }
        }
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    void showWindow2(ActionEvent event) throws IOException {
        if(txtUser.getText().equalsIgnoreCase("admin")  ){
            if(txtPasword.getText().equalsIgnoreCase("admin")){//comparar inicio de sesion
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
                Parent root = loader.load();
                MainSceneController mainSceneController = loader.getController();
                mainSceneController.init(txtUser.getText(), stage, this);
                Stage stage = new Stage(); 
                stage.setScene(new Scene(root));
                stage.show();
                this.stage.close();   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta");
            }
        }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;   // Guardar ventana para que el controllador no elimine la ventana
    }

    public void show() {
        stage.show();
    }

}


