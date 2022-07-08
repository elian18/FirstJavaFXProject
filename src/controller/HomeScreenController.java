package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HomeScreenController {

    private Stage stage;

    @FXML
    private TextField txtUser;

    @FXML
    void showWindow2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Window2.fxml"));
        Parent root = loader.load();
        MainSceneController controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();      // Crea nueva ventana
        stage.setScene(scene);
        controller.init(txtUser.getText(), stage, this);
        stage.show();
        this.stage.close();         
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;   // Guardar ventana para que el controllador no elimine la ventana
    }

    public void show() {
        stage.show();
    }

}


