package lk.uwu.grocery.ui.controller;

/**
 * Created by Manula Uluwatta on 1/15/2020.
 */

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.ItemController;
import lk.uwu.grocery.controller.custom.OrderController;
import lk.uwu.grocery.controller.custom.OrderDetailController;
import lk.uwu.grocery.controller.custom.PaymentController;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.ItemDTO;
import lk.uwu.grocery.dto.OrderDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.PaymentDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.other.Validator;
import lk.uwu.grocery.ui.tableView.ItemTableView;
import lk.uwu.grocery.ui.tableView.OrderDetailTableView;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.DoubleUnaryOperator;

public class PlaceOrderFormController implements Initializable{
    @FXML
    private JFXTextField orderID_txt;

    @FXML
    private JFXTextField orderDetatiID_txt;

    @FXML
    private JFXTextField paymentID_txt;

    @FXML
    private JFXTextField orderDate_txt;

    @FXML
    private JFXTextField custID_txt;
    public static JFXTextField custID_txt2;

    @FXML
    private JFXTextField custName_txt;
    public static JFXTextField custName_txt2;

    @FXML
    private JFXTextField contact_txt;
    public static JFXTextField contact_txt2;

    @FXML
    private JFXTextField itemCode_txt;
    public static JFXTextField itemCode_txt2;



    @FXML
    private JFXTextField itemName_txt;
    public static JFXTextField itemName_txt2;

    @FXML
    private JFXTextField itemDesc_txt;
    public static JFXTextField itemDesc_txt2;

    @FXML
    private JFXTextField orderQty_txt;

    @FXML
    private JFXTextField pricePerUnit_txt;
    public static JFXTextField pricePerUnit_txt2;

    @FXML
    private JFXTextField discountPerUnit_txt;

    @FXML
    private JFXTextField totalAmount_txt;


    @FXML
    private JFXButton select_btn;

    @FXML
    private JFXButton selectItem_btn;

    @FXML
    private TableView<OrderDetailTableView> orderCart_tbl;

    @FXML
    private TableColumn<OrderDetailTableView, String> cart_itemCode;

    @FXML
    private TableColumn<OrderDetailTableView, String> cartItemName;

    @FXML
    private TableColumn<OrderDetailTableView, Double> cart_discount;

    @FXML
    private TableColumn<OrderDetailTableView, Integer> cartOrderQty;

    @FXML
    private TableColumn<OrderDetailTableView, Double> cartUnitPrice;

    @FXML
    private TableColumn<OrderDetailTableView, Double> cartAmount;


    @FXML
    private TableColumn<OrderDetailTableView, Double> cartTotalAmount;

    @FXML
    private JFXTextField grandTotal_txt;

    @FXML
    private JFXTextField totalDiscount_txt;

    @FXML
    private JFXTextField total_txt;


    @FXML
    private JFXButton removeFromCart_btn;

    @FXML
    private JFXButton confirm_btn;

    private String prifix;
    private String tableName;
    private String columName;

    private ItemController itemController;
    private OrderDetailController orderDetailController;
    private OrderController orderController;
    private PaymentController paymentController;
    private ObservableList<OrderDetailTableView> data;

    double totalDiscount=0;
    double amount=0;
    double total=0;
    double grandTotal=0;
    double sumOfDiscount=0;
    double stotalAmount=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        orderDetailController= (OrderDetailController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ORDERDETAIL);
        orderController= (OrderController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ORDERS);
        paymentController= (PaymentController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.PAYMENT);
        data= FXCollections.observableArrayList();
        custID_txt2=custID_txt;
        custName_txt2=custName_txt;
        contact_txt2=contact_txt;

        itemCode_txt2=itemCode_txt;
        itemName_txt2=itemName_txt;
        itemDesc_txt2=itemDesc_txt;
        pricePerUnit_txt2=pricePerUnit_txt;

        tableName = "orders";
        columName = "orderID";
        prifix = "OR";

        orderID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

        tableName = "payment";
        columName = "payID";
        prifix = "P";

        paymentID_txt.setText(IDGenarator.getNextIdGenaretor(tableName, columName, prifix));

        tableName = "order_detail";
        columName = "orderDetailID";
        prifix = "OD";

        orderDetatiID_txt.setText(IDGenarator.getNextIdGenaretor(tableName, columName, prifix));

        loadDate();
       // loadItem();
    }

    @FXML
    void selectButtonAction(ActionEvent event) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ListOfCustomers.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void selectItemButtonAction(ActionEvent event) {
        try {
            Parent root= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/SelectItemForm.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            orderQty_txt.requestFocus();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void qtyTextAction(ActionEvent event) {
        boolean result = Validator.isNumber(orderQty_txt.getText());
        if (result) {
            discountPerUnit_txt.requestFocus();
            System.out.println("supiri");
        } else {
            orderQty_txt.setFocusColor(Paint.valueOf("red"));
        }

    }
    @FXML
    void discountTextAction(ActionEvent event) {
            int qty=Integer.parseInt(orderQty_txt.getText());
            double price=Double.parseDouble(pricePerUnit_txt.getText());
            amount=qty*price;
            double discount=Double.parseDouble(discountPerUnit_txt.getText());
            double discountValue=discount/100;
            totalDiscount=amount*discountValue;
            stotalAmount=amount-totalDiscount;
            totalAmount_txt.setText(stotalAmount+"");

    }


    @FXML
    void addCartButtonAction(ActionEvent event) {
        Boolean validatorOk= Validator.isNotEmpty(new String[]{custID_txt.getText(),itemCode_txt.getText(),pricePerUnit_txt.getText(),orderQty_txt.getText()});
        if(!validatorOk){
            JOptionPane.showMessageDialog(null,"Please fill All Text field");
        }else {
            String orderID = orderID_txt.getText();
            String custID = custID_txt.getText();
            String orderDate = orderDate_txt.getText();

            String itemCode = itemCode_txt.getText();
            String itemName = itemName_txt.getText();
            double pricePerUnit = Double.parseDouble(pricePerUnit_txt.getText());
            double discount = Double.parseDouble(discountPerUnit_txt.getText());
            double totalAmount = Double.parseDouble(totalAmount_txt.getText());
            int orderQty = Integer.parseInt(orderQty_txt.getText());

            OrderDetailDTO orderDetailDTO = new OrderDetailDTO(
                    itemCode,
                    itemName,
                    pricePerUnit,
                    discount,
                    totalAmount,
                    orderQty
            );

           /* if (!data.isEmpty()) {
                for (int i = data.size(); i > 0; i--) {
                    data.remove(i - 1);
                }
            }*/
            ArrayList<OrderDetailDTO> allOrderDetail = new ArrayList<>();
            allOrderDetail.add(orderDetailDTO);
            if (allOrderDetail != null) {
                for (OrderDetailDTO orderDetail :
                        allOrderDetail) {
                    data.add(new OrderDetailTableView(
                            orderDetail.getItemCode(),
                            orderDetail.getItemName(),
                            orderDetail.getPricePerUnit(),
                            totalDiscount,
                            orderDetail.getTotalAmount(),
                            orderDetail.getOrderQty(),
                            amount
                    ));
                }
            }
            orderCart_tbl.getItems().removeAll();
            cart_itemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            cartItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            cartOrderQty.setCellValueFactory(new PropertyValueFactory("orderQty"));
            cartUnitPrice.setCellValueFactory(new PropertyValueFactory("pricePerUnit"));
            cart_discount.setCellValueFactory(new PropertyValueFactory("discount"));
            cartAmount.setCellValueFactory(new PropertyValueFactory("amount"));
            cartTotalAmount.setCellValueFactory(new PropertyValueFactory("totalAmount"));

            orderCart_tbl.setItems(data);

               /* for(int i=data.size();i>0;i--){
                    OrderDetailTableView orderDetailTableView=orderCart_tbl.getItems()
                    //custFirstName_txt.setText(""+customerTableView.getCustFirstName());
                    total_txt.setText(orde);
                }*/
            total += amount;
            sumOfDiscount += totalDiscount;
            grandTotal += stotalAmount;
            total_txt.setText("" + total);
            totalDiscount_txt.setText("" + sumOfDiscount);
            grandTotal_txt.setText("" + grandTotal);


        /*String orderID=orderID_txt.getText();
        String custID=custID_txt.getText();
        String orderDate=orderDate_txt.getText();

        String itemCode=itemCode_txt.getText();
        String itemName=itemName_txt.getText();
        double pricePerUnit=Double.parseDouble(pricePerUnit_txt.getText());
        double discount=Double.parseDouble(discountPerUnit_txt.getText());
        double totalAmount=Double.parseDouble(totalAmount_txt.getText());
        int ordetQty=Integer.parseInt(orderQty_txt.getText());*/
        /*ArrayList<OrderDetailDTO> orderDetailList=new ArrayList<>();


        OrderDetailDTO orderDetailDTO=new OrderDetailDTO(
                orderDetatiID_txt.getText(),
                orderID_txt.getText(),
                itemCode_txt.getText(),
                itemName_txt.getText(),
                Double.parseDouble(pricePerUnit_txt.getText()),
                Double.parseDouble(discountPerUnit_txt.getText()),
                Double.parseDouble(totalAmount_txt.getText()),
                Integer.parseInt(orderQty_txt.getText())
                );
        orderDetailList.add(orderDetailDTO);
        OrderDTO orderDTO=new OrderDTO(
                orderID_txt.getText(),
                custID_txt.getText(),
                orderDate_txt.getText(),
                orderDetailList

        );
        try {
            if(orderDetailController.add(orderDetailDTO)){
                System.out.println("pass");
                if (!data.isEmpty()) {
                    for (int i = data.size(); i > 0; i--) {
                        data.remove(i - 1);
                    }
                }
                try {
                    List<OrderDetailDTO> allOrderDetail = orderDetailController.view();
                    if (allOrderDetail != null) {
                        for (OrderDetailDTO orderDetail :
                                allOrderDetail) {
                            data.add(new OrderDetailTableView(
                                    orderDetail.getItemCode(),
                                    orderDetail.getItemName(),
                                    orderDetail.getPricePerUnit(),
                                    orderDetail.getDiscount(),
                                    orderDetail.getTotalAmount(),
                                    orderDetail.getOrderQty()

                            ));
                        }
                    }
                    orderCart_tbl.getItems().removeAll();
                    cart_itemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
                    cartItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
                    cartOrderQty.setCellValueFactory(new PropertyValueFactory("orderQty"));
                    cartUnitPrice.setCellValueFactory(new PropertyValueFactory("pricePerUnit"));
                    cart_discount.setCellValueFactory(new PropertyValueFactory("discount"));
                    cartAmount.setCellValueFactory(new PropertyValueFactory("totalAmount"));

                    orderCart_tbl.setItems(data);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else {
                System.out.println("erorr");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

*/
        }
    }
    @FXML
    void removeButtonAction(ActionEvent event) {
        OrderDetailTableView orderDetailTableView=orderCart_tbl.getSelectionModel().getSelectedItem();

            data.remove(orderCart_tbl.getSelectionModel().getSelectedItem());
            double selectAmount=orderDetailTableView.getAmount();
            double selectTotalAmount=orderDetailTableView.getTotalAmount();
            double selectDiscount=orderDetailTableView.getDiscount();
            total-=selectAmount;
            grandTotal-=selectTotalAmount;
            sumOfDiscount-=selectDiscount;

            total_txt.setText(""+total);
            totalDiscount_txt.setText(""+sumOfDiscount);
            grandTotal_txt.setText(""+grandTotal);



    }
    @FXML
    void makePaymentAction(ActionEvent event) {
        String orderID=orderID_txt.getText();
        String orderDetailID=orderDetatiID_txt.getText();
        String orderDate=orderDate_txt.getText();
        String custID=custID_txt.getText();
        String payID=paymentID_txt.getText();
        double totalAmount=Double.parseDouble(grandTotal_txt.getText());
        double totalDiscount=Double.parseDouble(totalDiscount_txt.getText());

        ArrayList<OrderDetailDTO> orderDetailDTOList=new ArrayList<>();
        for(int i=0;i<data.size();i++){
            OrderDetailTableView orderDetailTableView=orderCart_tbl.getItems().get(i);
            String itemCode=orderDetailTableView.getItemCode();
            String itemName=orderDetailTableView.getItemName();
            int orderQty=orderDetailTableView.getOrderQty();
            double unitPrice=orderDetailTableView.getPricePerUnit();
            double amount=orderDetailTableView.getAmount();
            double discount=orderDetailTableView.getDiscount();


            OrderDetailDTO orderDetailDTO=new OrderDetailDTO(
                    orderDetailID,
                    orderID,
                    itemCode,
                    itemName,
                    unitPrice,
                    discount,
                    amount,
                    orderQty
                    );
            orderDetailDTOList.add(orderDetailDTO);
        }
        PaymentDTO paymentDTO=new PaymentDTO(
                payID,
                orderID,
                orderDate,
                totalAmount,
                totalDiscount
                );
        OrderDTO orderDTO=new OrderDTO(
                orderID,
                custID,
                orderDate,
                orderDetailDTOList
         );

        try {
            boolean result=orderController.add(orderDTO);
            paymentController.add(paymentDTO);
            JOptionPane.showMessageDialog(null,"Success");
            /////jasper
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= ConnectionFactory.getInstance().getConnection();
            String reportPath = "D:\\Project\\Project_01_uwu\\GroceryManagementSystem\\src\\lk\\uwu\\grocery\\jasper\\Invoice.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, connection);
            JasperViewer.viewReport(jp);
            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }
    /*    @FXML
    void addToCartAction(MouseEvent event) {
//        String orderID=orderID_txt.getText();
//        String orderDate=orderDate_txt.getText();
//        String payID=paymentID_txt.getText();
//        String orderDetailID=orderDetatiID_txt.getText();
//        String custID=custID_txt.getText();
//        ItemTableView itemTableView=pItemView_tbl.getSelectionModel().getSelectedItem();
//        String itemCode=itemTableView.getItemCode();

                *//*
                *

        itemName_txt.setText(""+itemTableView.getItemName());
        iMajorCatID_txt.setText(""+itemTableView.getMajorCatID());
        iSubCatID_txt.setText(""+itemTableView.getSubCatID());*//*
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<ItemDTO> allItem=itemController.view();
            if(allItem != null){
                for (ItemDTO item :
                        allItem) {
                    data.add(new ItemTableView(
                            item.getItemCode(),
                            item.getItemName(),
                            item.getSub_description(),
                            item.getQtyOnHand(),
                            item.getItemSellingPrice()

                    ));
                }
            }
            orderCart_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            tItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            tSubCatName.setCellValueFactory(new PropertyValueFactory("sub_description"));
            tQtyOnHand.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
            tPricePerUnit.setCellValueFactory(new PropertyValueFactory("itemSellingPrice"));

            orderCart_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/
    private void loadDate() {
        Date d1              = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date          = sdf.format(d1);
        orderDate_txt.setText(date);

    }
/*    public void loadItem() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<ItemDTO> allItem=itemController.view();
            if(allItem != null){
                for (ItemDTO item :
                        allItem) {
                    data.add(new ItemTableView(
                            item.getItemCode(),
                            item.getItemName(),
                            item.getSub_description(),
                            item.getQtyOnHand(),
                            item.getItemSellingPrice()

                    ));
                }
            }
            pItemView_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            tItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            tSubCatName.setCellValueFactory(new PropertyValueFactory("sub_description"));
            tQtyOnHand.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
            tPricePerUnit.setCellValueFactory(new PropertyValueFactory("itemSellingPrice"));

            pItemView_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/


}
