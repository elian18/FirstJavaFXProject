package controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
        if((txtUser.getText().equals("elian18") && txtPasword.getText().equals("elian") )||  
        (txtUser.getText().equals("SebasRo17")&&txtPasword.getText().equals("sebas")) || 
        (txtUser.getText().equals("JoRoX")&&txtPasword.getText().equals("epngood"))){
            {//comparar inicio de sesion

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
                Parent root = loader.load();
                MainSceneController controller = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage(); // Crea la ventana
                stage.setScene(scene);
                controller.init(txtUser.getText(), stage, this);
                stage.show();
                this.stage.close();

                }
            }else{
                Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
                dialogoAlerta.setTitle("AVISO");
                dialogoAlerta.setHeaderText(null);
                dialogoAlerta.setContentText("Usuario y/o contraseña incorrecta");
                dialogoAlerta.initStyle(StageStyle.TRANSPARENT);
                dialogoAlerta.showAndWait();
            }
            
        }

        public void setStage(Stage primaryStage) {  
            stage = primaryStage;   // Guardar ventana para que el controllador no elimine la ventana
        }
}


