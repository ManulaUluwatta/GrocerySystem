package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Manula Uluwatta on 1/13/2020.
 */
public class WellcomeScreenController implements Initializable {
    private AnchorPane dash;
    WellcomeScreenController wellcomeScreenController;
    @FXML
    private AnchorPane wellcomePane;


    @FXML
    private JFXButton start_btn;

    @FXML
    private JFXSpinner spinner;

    @FXML
    AnchorPane main;

    @FXML
    void startButtonAction(ActionEvent event) {
//        try {
//            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/uwu/grocery/ui/fxml/UserLogin.fxml"));
//            Parent root=(Parent) fxmlLoader.load();
//            Stage stage=new Stage();
//            stage.setScene(new Scene(root));
//            stage.show();
//
//            ((Stage)(((JFXButton)event.getSource()).getScene().getWindow())).close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/UserLogin.fxml"));
            wellcomePane.getChildren().setAll(dash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
