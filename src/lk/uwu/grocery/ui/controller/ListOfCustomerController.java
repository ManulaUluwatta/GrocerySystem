package lk.uwu.grocery.ui.controller;

/**
 * Created by Manula Uluwatta on 1/22/2020.
 */
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.CustomerController;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.ui.tableView.CustomerTableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ListOfCustomerController implements Initializable{
    @FXML
    private TableView<CustomerTableView> customerDetails_tbl;

    @FXML
    private TableColumn<CustomerTableView, String> tCustID;

    @FXML
    private TableColumn<CustomerTableView, String> tCustFirstName;

    @FXML
    private TableColumn<CustomerTableView, String> tCustLastName;

    @FXML
    private TableColumn<CustomerTableView, String> tCustAddress;

    @FXML
    private TableColumn<CustomerTableView, String> tCustEmail;

    @FXML
    private TableColumn<CustomerTableView, String> tCustContact;

    @FXML
    private TableColumn<CustomerTableView, String> tCustNic;

    @FXML
    private TableColumn<CustomerTableView, String> tCustType;

    @FXML
    private JFXTextField searchByName_txt;

    @FXML
    private JFXButton custSearch_btn;

    @FXML
    private JFXButton custRefresh_btn;

    private CustomerController customerController;
    private PlaceOrderFormController placeOrderFormController;

    private ObservableList<CustomerTableView> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        customerController= (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.CUSTOMER);
        data= FXCollections.observableArrayList();
        loadCustomer();
    }

    @FXML
    void customerRefreshButtonAction(ActionEvent event) {

    }

    @FXML
    void customerSearchButtonAction(ActionEvent event) {

    }


    @FXML
    void customerTableAction(MouseEvent event) {
        CustomerTableView customerTableView=customerDetails_tbl.getSelectionModel().getSelectedItem();
        placeOrderFormController.custID_txt2.setText(""+customerTableView.getCustID());
        placeOrderFormController.custName_txt2.setText(""+customerTableView.getCustFirstName());
        placeOrderFormController.contact_txt2.setText(""+customerTableView.getCustContact());
        ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();

    }
    public void loadCustomer() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<CustomerDTO> allCustomers=customerController.view();
            if(allCustomers != null){
                for (CustomerDTO cust :
                        allCustomers) {
                    data.add(new CustomerTableView(cust.getCustID(), cust.getCustFirstName(), cust.getCustLastName(), cust.getAddress(), cust.getEmail(),cust.getContactNo(), cust.getNic(),cust.getCustType()));
                }
            }
            customerDetails_tbl.getItems().removeAll();
            tCustID.setCellValueFactory(new PropertyValueFactory("custID"));
            tCustFirstName.setCellValueFactory(new PropertyValueFactory("custFirstName"));
            tCustLastName.setCellValueFactory(new PropertyValueFactory("custLastName"));
            tCustAddress.setCellValueFactory(new PropertyValueFactory("custAddress"));
            tCustEmail.setCellValueFactory(new PropertyValueFactory("custEmail"));
            tCustContact.setCellValueFactory(new PropertyValueFactory("custContact"));
            tCustNic.setCellValueFactory(new PropertyValueFactory("custNic"));
            tCustType.setCellValueFactory(new PropertyValueFactory("custType"));

            customerDetails_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
