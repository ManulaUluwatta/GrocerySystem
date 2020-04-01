package lk.uwu.grocery.ui.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class SidePaneController implements Initializable{
        private AnchorPane dash;

        @FXML
        public static AnchorPane anchorPane;

        @FXML
        private JFXButton manageItem_btn;

        @FXML
        private JFXButton manageSupplier_btn;

        @FXML
        private JFXButton manageOrder_btn;

        @FXML
        private JFXButton viewSummary_btn;


        @FXML
        public static JFXButton manageCustomer_btn;

        @FXML
        private JFXButton placeOrder_btn;

        @FXML
        void homeButtonAction(ActionEvent event) {

        }

        @FXML
        void viewUserProfileAction(ActionEvent event) {
                try {
                        dash = FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageUserProfile.fxml"));
                        DashBoardController.rootPane.getChildren().setAll(dash);
                        DashBoardController.sDrawer.close();
                        DashBoardController.sDrawer.toBack();

                } catch (IOException e) {
                        e.printStackTrace();
                }
                DashBoardController.humburgAction(event);
        }

        @FXML
        void manageCustomerAction(ActionEvent event) {
                try {
                        dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageCustomerForm.fxml"));
                        DashBoardController.rootPane.getChildren().setAll(dash);
                        DashBoardController.sDrawer.close();
                        DashBoardController.sDrawer.toBack();

                } catch (IOException e) {
                        e.printStackTrace();
                }
                DashBoardController.humburgAction(event);
        }

        @FXML
        void manageItemAction(ActionEvent event) {
                try {
                        dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageItemForm.fxml"));
                        DashBoardController.rootPane.getChildren().setAll(dash);
                        DashBoardController.sDrawer.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                DashBoardController.humburgAction(event);
        }

        @FXML
        void manageSupplierAction(ActionEvent event) {
                try {
                        dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageSupplierForm.fxml"));
                        DashBoardController.rootPane.getChildren().setAll(dash);
                        DashBoardController.sDrawer.close();
                        //DashBoardController.sDrawer.toBack();

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
        @FXML
        void viewSummaryAction(ActionEvent event) {

        }

        @FXML
        void manageOrderButtonAction(ActionEvent event) {
                try {
                        dash=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageOrderForm.fxml"));
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
