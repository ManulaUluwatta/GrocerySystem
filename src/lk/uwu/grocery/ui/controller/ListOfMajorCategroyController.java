package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.MajorCategoryController;
import lk.uwu.grocery.dto.MajorCategoryDTO;
import lk.uwu.grocery.ui.tableView.MajorCategoryTableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ListOfMajorCategroyController implements Initializable {

    @FXML
    private TableView<MajorCategoryTableView> majorCategory_tbl;

    @FXML
    private TableColumn<MajorCategoryTableView, String> tItemCode;

    @FXML
    private TableColumn<MajorCategoryTableView, String> tItemName;

    private MajorCategoryController majorCategoryController;
    private ObservableList<MajorCategoryTableView> data;
    private ManageItemFormController manageItemFormController;
    private ManageSubCategoryController manageSubCategoryController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        majorCategoryController= (MajorCategoryController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.MAJOR_CATEGORY);
        data= FXCollections.observableArrayList();
        loadMajorCategory();
    }

    @FXML
    void majorCategoryTableAction(MouseEvent event) {
            MajorCategoryTableView majorCategoryTableView=majorCategory_tbl.getSelectionModel().getSelectedItem();
            manageItemFormController.majorCatID_txt.setText(""+majorCategoryTableView.getMajorCatID());
            manageSubCategoryController.majoCatID_txt2.setText(""+majorCategoryTableView.getMajorCatID());
            manageSubCategoryController.majorCatName_txt2.setText(""+majorCategoryTableView.getMajorCatName());
            ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();

    }


    public void loadMajorCategory() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<MajorCategoryDTO> allCategory=majorCategoryController.view();
            if(allCategory != null){
                for (MajorCategoryDTO categroy :
                        allCategory) {
                    data.add(new MajorCategoryTableView(categroy.getMajorCatID(), categroy.getMajorCatName()));
                }
            }
            majorCategory_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("majorCatID"));
            tItemName.setCellValueFactory(new PropertyValueFactory("majorCatName"));

            majorCategory_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
