package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SidePaneCashierController implements Initializable {
    @FXML
    private JFXButton home_btn;

    @FXML
    private JFXButton placeOrder_btn;

    @FXML
    private JFXButton manageCustomer_btn;

    private AnchorPane dash;

    @FXML
    void homeButtonAction(ActionEvent event) {

    }

    @FXML
    void manageCustomerAction(ActionEvent event) {
        try {
            dash= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageCustomerForm.fxml"));
            DashBoardController.rootPane.getChildren().setAll(dash);
            DashBoardController.sDrawer.close();
            DashBoardController.sDrawer.toBack();

        } catch (IOException e) {
            e.printStackTrace();
        }
        DashBoardController.humburgAction(event);

    }

    @FXML
    void placeOrderBtnAction(ActionEvent event) {
        try {
            dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/PlaceOrdeForm.fxml"));
            DashBoardController.rootPane.getChildren().setAll(dash);
            DashBoardController.sDrawer.close();
            //DashBoardController.sDrawer.toBack();

        } catch (IOException e) {
            e.printStackTrace();
        }
        DashBoardController.humburgAction(event);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
