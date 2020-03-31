package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.UserProfileController;
import lk.uwu.grocery.dto.UserProfileDTO;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class UserLoginController implements Initializable {
    @FXML
    private AnchorPane anchorMain;

    @FXML
    private JFXTextField userName_tex;

    public static JFXTextField userName1_txt;

    @FXML
    private JFXPasswordField password_txt;

    @FXML
    private JFXButton selectProfile_btn;

    @FXML
    private JFXButton login_btn;

    public static String usernName;
    public  static String password;


    UserProfileController userProfileController;
    @FXML
    void loginButtonAction(ActionEvent event) {
            usernName=userName_tex.getText();
            password=password_txt.getText();
            String testPassword="";
            String testUserName="";

        try {
            ArrayList<UserProfileDTO> user=userProfileController.getName(usernName);
            for (UserProfileDTO allUser :
                    user) {
                testPassword=allUser.getPassword();
                testUserName=allUser.getUserName();

                System.out.println(testPassword);
                System.out.println(testUserName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(usernName.equals(usernName) && testPassword.equals(password)){
                FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/uwu/grocery/ui/fxml/DashBoard.fxml"));

                try {
                    Parent root=fxmlLoader.load();
                    Stage primaryStage=new Stage();
                    primaryStage.setScene(new Scene(root));
                    primaryStage.setTitle("Grocery Management System");
                    primaryStage.show();
                    ((Stage)(((JFXButton)event.getSource()).getScene().getWindow())).close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println(usernName);
                System.out.println(password);
            JOptionPane.showMessageDialog(null,"Invalied Password");

            }
    }
    @FXML
    void selectButtonAction(ActionEvent event) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SelectUserProfile.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initialize(URL location, ResourceBundle resources) {
        userProfileController= (UserProfileController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.USER_PROFILE);
        userName1_txt=userName_tex;

    }





}
