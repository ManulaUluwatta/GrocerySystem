package lk.uwu.grocery.ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.SupplierController;
import lk.uwu.grocery.dto.SupplierDTO;
import lk.uwu.grocery.ui.tableView.SuppierTableView;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ListOfSupplierController implements Initializable {
    @FXML
    private TableView<SuppierTableView> supplerDetail_tbl;

    @FXML
    private TableColumn<SuppierTableView, String> tSupID;

    @FXML
    private TableColumn<SuppierTableView, String> tSupFirstName;

    @FXML
    private TableColumn<SuppierTableView, String> tSupLastName;

    @FXML
    private TableColumn<SuppierTableView, String> tSupAddress;

    @FXML
    private TableColumn<SuppierTableView, String> tSupCompany;

    @FXML
    private TableColumn<SuppierTableView, String> tSupEmail;

    @FXML
    private TableColumn<SuppierTableView, String> tSupNIC;

    @FXML
    private TableColumn<SuppierTableView, String> tSupContact;

    @FXML
    private JFXButton search_btn;

    private SupplierController supplierController;
    private ObservableList<SuppierTableView> data;
    private ManageItemFormController manageItemFormController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        supplierController= (SupplierController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SUPPLIER);
        data= FXCollections.observableArrayList();
        loadSupplier();
    }

    @FXML
    void searchButtonAction(ActionEvent event) {

    }

    @FXML
    void supplierTableAction(MouseEvent event) {
        SuppierTableView suppierTableView=supplerDetail_tbl.getSelectionModel().getSelectedItem();
        manageItemFormController.supID_txt2.setText(""+suppierTableView.getSupID());
        ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();
    }

    public void loadSupplier() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<SupplierDTO> allSuppliers=supplierController.view();
            if(allSuppliers != null){
                for (SupplierDTO sup :
                        allSuppliers) {
                    data.add(new SuppierTableView(
                            sup.getSupID(),
                            sup.getSupFirstName(),
                            sup.getSupLastName(),
                            sup.getSupAddress(),
                            sup.getSupCompany(),
                            sup.getSupEmail(),
                            sup.getSupContact(),
                            sup.getSupNIC()
                    ));
                }
            }
            supplerDetail_tbl.getItems().removeAll();
            tSupID.setCellValueFactory(new PropertyValueFactory("supID"));
            tSupFirstName.setCellValueFactory(new PropertyValueFactory("supFirstName"));
            tSupLastName.setCellValueFactory(new PropertyValueFactory("supLastName"));
            tSupAddress.setCellValueFactory(new PropertyValueFactory("supAddress"));
            tSupCompany.setCellValueFactory(new PropertyValueFactory("supCompany"));
            tSupContact.setCellValueFactory(new PropertyValueFactory("supContact"));
            tSupEmail.setCellValueFactory(new PropertyValueFactory("supEmail"));
            tSupNIC.setCellValueFactory(new PropertyValueFactory("supNIC"));

            supplerDetail_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
