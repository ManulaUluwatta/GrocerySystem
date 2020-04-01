package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageUserProfileController implements Initializable {
    @FXML
    private TableView<?> userProfile_tbl;

    @FXML
    private JFXTextField userID_txt;

    @FXML
    private JFXTextField userName_txt;

    @FXML
    private JFXTextField adminName_txt;

    @FXML
    private JFXTextField adminEmail_txt;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton update_btn;

    @FXML
    private JFXButton delete_btn;

    @FXML
    private JFXPasswordField password_txt;

    @FXML
    private ImageView imageView;

    @FXML
    void addButtonAction(ActionEvent event) {

    }

    @FXML
    void deleteButtonAction(ActionEvent event) {

    }

    @FXML
    void updateButtonAction(ActionEvent event) {

    }

    @FXML
    void userProfileAction(MouseEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
