package lk.uwu.grocery.ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.OrderController;
import lk.uwu.grocery.controller.custom.OrderDetailController;
import lk.uwu.grocery.dto.OrderDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.ui.tableView.CustomerTableView;
import lk.uwu.grocery.ui.tableView.OrderDetailTableView;
import lk.uwu.grocery.ui.tableView.OrderTableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ManageOrderFormController implements Initializable {
    @FXML
    private TableView<OrderTableView> orderTable;

    @FXML
    private TableColumn<OrderTableView, String> orderID_cl;

    @FXML
    private TableColumn<OrderTableView, String> custID_cl;

    @FXML
    private TableColumn<OrderTableView, String> orderDate_cl;

    @FXML
    private TableView<OrderDetailTableView> orderDatail_tbl;

    @FXML
    private TableColumn<OrderDetailTableView, String> orderDetailID_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, String> orderID_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, String> itemCode_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, String> itemName_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, Double> unitPrice_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, Integer> orderQty_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, Double> discount_dcl;

    @FXML
    private TableColumn<OrderDetailTableView, Double> totalAmount_dcl;

    private OrderController orderController;
    private OrderDetailController orderDetailController;

    private ObservableList<OrderTableView> orderData;
    private ObservableList<OrderDetailTableView> orderDetailData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderController= (OrderController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ORDERS);
        orderDetailController= (OrderDetailController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ORDERDETAIL);
        orderData= FXCollections.observableArrayList();
        orderDetailData=FXCollections.observableArrayList();

        loadOrders();
    }
    @FXML
    void orderTableAction(MouseEvent event) {
        OrderTableView orderTableView=orderTable.getSelectionModel().getSelectedItem();
        String orderID=orderTableView.getOrderID();
        if (!orderDetailData.isEmpty()) {
            for (int i = orderDetailData.size(); i > 0; i--) {
                orderDetailData.remove(i - 1);
            }
        }
        try {
            ArrayList<OrderDetailDTO> orderDetailList=orderDetailController.getDetailByCode(orderID);
            for (OrderDetailDTO orderDetail : orderDetailList){
                orderDetailData.add(
                        new OrderDetailTableView(
                        orderDetail.getOrderDetailID(),
                        orderDetail.getOrderID(),
                        orderDetail.getItemCode(),
                        orderDetail.getItemName(),
                        orderDetail.getPricePerUnit(),
                        orderDetail.getDiscount(),
                        orderDetail.getTotalAmount(),
                        orderDetail.getOrderQty()
                        )
                );
            }
            orderDatail_tbl.getItems().removeAll();
            orderDetailID_dcl.setCellValueFactory(new PropertyValueFactory("orderDetailID"));
            orderID_dcl.setCellValueFactory(new PropertyValueFactory("orderID"));
            itemCode_dcl.setCellValueFactory(new PropertyValueFactory("itemCode"));
            itemName_dcl.setCellValueFactory(new PropertyValueFactory("itemName"));
            unitPrice_dcl.setCellValueFactory(new PropertyValueFactory("pricePerUnit"));
            discount_dcl.setCellValueFactory(new PropertyValueFactory("discount"));
            totalAmount_dcl.setCellValueFactory(new PropertyValueFactory("totalAmount"));
            orderQty_dcl.setCellValueFactory(new PropertyValueFactory("orderQty"));

            orderDatail_tbl.setItems(orderDetailData);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadOrders() {
        if (!orderData.isEmpty()) {
            for (int i = orderData.size(); i > 0; i--) {
                orderData.remove(i - 1);
            }
        }

        try {
            List<OrderDTO> allOrders = orderController.view();

        if(allOrders != null){
                for (OrderDTO orders :
                        allOrders) {
                    orderData.add(
                            new OrderTableView(
                                    orders.getOrderID(),
                                    orders.getCustID(),
                                    orders.getOrderDate()
                            )
                    );
                }
            }
            orderTable.getItems().removeAll();
            orderID_cl.setCellValueFactory(new PropertyValueFactory("orderID"));
            custID_cl.setCellValueFactory(new PropertyValueFactory("custID"));
            orderDate_cl.setCellValueFactory(new PropertyValueFactory("orderDate"));

            orderTable.setItems(orderData);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
