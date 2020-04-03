package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.UserProfileController;
import lk.uwu.grocery.dto.UserProfileDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.ui.tableView.UserProfileTableView;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ManageUserProfileController implements Initializable {
    @FXML
    private TableView<UserProfileTableView> userProfile_tbl;

    @FXML
    private TableColumn<UserProfileTableView, String> passIDTbl_cl;

    @FXML
    private TableColumn<UserProfileTableView, String> userNameTbl_cl;

    @FXML
    private TableColumn<UserProfileTableView, String> adminNameTbl_cl;

    @FXML
    private TableColumn<UserProfileTableView, String> adminEmaillTbl_cl;


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

    private String photoPath;

    private String tableName;
    private String columName;
    private String prifix;

    private UserProfileController userProfileController;
    private ObservableList<UserProfileTableView> data;
    private UserProfileDTO userProfileDTO;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userProfileController= (UserProfileController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.USER_PROFILE);
        data= FXCollections.observableArrayList();
        photoPath= "/lk/uwu/grocery/ui/images/notAvalable.png";

        tableName="user_profile";
        columName="pass_id";
        prifix="P";
        userID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

    }
    @FXML
    void addButtonAction(ActionEvent event) {
        userProfileDTO=new UserProfileDTO(
                userID_txt.getText(),
                userName_txt.getText(),
                password_txt.getText(),
                adminName_txt.getText(),
                adminEmail_txt.getText(),
                photoPath
        );

        try {
            boolean isAdded=userProfileController.add(userProfileDTO);
            if (isAdded==true){
                JOptionPane.showMessageDialog(null,"User Added");
            }else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void deleteButtonAction(ActionEvent event) {

    }

    @FXML
    void updateButtonAction(ActionEvent event) {

    }

    @FXML
    void userProfileTableAction(MouseEvent event) {

    }

}
