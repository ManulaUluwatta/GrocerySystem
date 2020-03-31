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
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.SubCategoryController;
import lk.uwu.grocery.dto.SubCategoryDTO;
import lk.uwu.grocery.ui.tableView.SubCategoryTableView;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ListOfSubCategoryController implements Initializable {

    @FXML
    private TableView<SubCategoryTableView> subCategory_tbl;

    @FXML
    private TableColumn<SubCategoryTableView, String> tMajorCatID;

    @FXML
    private TableColumn<SubCategoryTableView, String> tMajorCatName;

    @FXML
    private TableColumn<SubCategoryTableView, String> tSubCatID;

    @FXML
    private TableColumn<SubCategoryTableView, String> tSubCatName;

    @FXML
    private JFXButton search_btn;

    @FXML
    private JFXTextField searchByItemName_txt;

    private SubCategoryController subCategoryController;
    private ObservableList<SubCategoryTableView> data;
    private ManageItemFormController manageItemFormController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subCategoryController= (SubCategoryController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SUB_CATEGORY);
        data= FXCollections.observableArrayList();
        loadSubCategory();
    }

    @FXML
    void saerchButtonAction(ActionEvent event) {

    }

    @FXML
    void subCategoryTableAction(MouseEvent event) {
        SubCategoryTableView subCategoryTableView=subCategory_tbl.getSelectionModel().getSelectedItem();
        manageItemFormController.subCatID_txt.setText(""+subCategoryTableView.getSubCatID());
        ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();
    }

    public void loadSubCategory() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<SubCategoryDTO> allCategory=subCategoryController.view();
            if(allCategory != null){
                for (SubCategoryDTO categroy :
                        allCategory) {
                    data.add(new SubCategoryTableView(
                            categroy.getSubCatID(),
                            categroy.getMajorCatID(),
                            categroy.getMajorCatName(),
                            categroy.getSubCatName()));
                }
            }
            subCategory_tbl.getItems().removeAll();
            tSubCatID.setCellValueFactory(new PropertyValueFactory("subCatID"));
            tMajorCatID.setCellValueFactory(new PropertyValueFactory("majorCatID"));
            tMajorCatName.setCellValueFactory(new PropertyValueFactory("majorCatName"));
            tSubCatName.setCellValueFactory(new PropertyValueFactory("subCatName"));

            subCategory_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
