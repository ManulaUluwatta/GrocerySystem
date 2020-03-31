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
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.ItemController;
import lk.uwu.grocery.dto.ItemDTO;
import lk.uwu.grocery.ui.tableView.ItemTableView;

/**
 * Created by Manula Uluwatta on 2/13/2020.
 */
public class SelectItemFromController implements Initializable {
    @FXML
    private AnchorPane itemViewAcnchor;

    @FXML
    private TableView<ItemTableView> itemVew_tbl;

    @FXML
    private TableColumn<ItemTableView, String> tItemCode;

    @FXML
    private TableColumn<ItemTableView, String> tItemName;

    @FXML
    private TableColumn<ItemTableView, String> tDescription;

    @FXML
    private TableColumn<ItemTableView, Integer> tQtyOnHand;

    @FXML
    private TableColumn<ItemTableView, Double> tSellPrice;

    @FXML
    private JFXTextField search_txt;

    @FXML
    private JFXButton search_btn;

    private PlaceOrderFormController placeOrderFormController;

    private ItemController itemController;
    private ObservableList<ItemTableView> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemController = (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ITEM);
        data = FXCollections.observableArrayList();
        loadItem();
    }

    @FXML
    void itemTableAction(MouseEvent event) {
        ItemTableView itemTableView=itemVew_tbl.getSelectionModel().getSelectedItem();
        placeOrderFormController.itemCode_txt2.setText(""+itemTableView.getItemCode());
        placeOrderFormController.itemName_txt2.setText(""+itemTableView.getItemName());
        placeOrderFormController.itemDesc_txt2.setText(""+itemTableView.getSub_description());
        placeOrderFormController.pricePerUnit_txt2.setText(""+itemTableView.getItemSellingPrice());
        ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();
    }

    @FXML
    void searchButtonAction(ActionEvent event) {

    }

    public void loadItem() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<ItemDTO> allItem = itemController.view();
            if (allItem != null) {
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
            itemVew_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            tItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            tDescription.setCellValueFactory(new PropertyValueFactory("sub_description"));
            tQtyOnHand.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
            tSellPrice.setCellValueFactory(new PropertyValueFactory("itemSellingPrice"));

            itemVew_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
