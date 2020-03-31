package lk.uwu.grocery.ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
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
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.MajorCategoryController;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.MajorCategoryDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.ui.tableView.MajorCategoryTableView;

import javax.swing.*;

/**
 * Created by Manula Uluwatta on 1/15/2020.
 */
public class ManageMajorCategoryController implements Initializable {
    @FXML
    private AnchorPane majorCategoryPane;

    @FXML
    private TableView<MajorCategoryTableView> majorCategory_tbl;

    @FXML
    private TableColumn<MajorCategoryTableView, String> tItemCode;

    @FXML
    private TableColumn<MajorCategoryTableView, String> tItemName;

    @FXML
    private JFXButton search_btn;

    @FXML
    private JFXTextField searchByItem_txt;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton update_btn;

    @FXML
    private JFXButton delete_btn;

    @FXML
    private JFXButton refresh_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXTextField categoryID_txt;

    @FXML
    private JFXTextField categoryName_txt;

    private AnchorPane dash;

    private MajorCategoryController majorCategoryController;
    private ObservableList<MajorCategoryTableView> data;
    private ManageItemFormController manageItemFormController;

    private String prifix;
    private String tableName;
    private String columName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        majorCategoryController= (MajorCategoryController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.MAJOR_CATEGORY);
        data= FXCollections.observableArrayList();

        tableName="major_category";
        columName="majorCatID";
        prifix="MC";
        categoryID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

        loadMajorCategory();

    }
    @FXML
    void backButtonAction(ActionEvent event) {
        try {
            dash= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageItemForm.fxml"));
            DashBoardController.rootPane.getChildren().setAll(dash);
            DashBoardController.sDrawer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void categoryAddAction(ActionEvent event) {
        MajorCategoryDTO majorCategoryDTO=new MajorCategoryDTO(
                categoryID_txt.getText(),
                categoryName_txt.getText()
        );
        try {
            if(majorCategoryController.add(majorCategoryDTO)){
                JOptionPane.showMessageDialog(null,"Added");
            }else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadMajorCategory();
        removeText();
        categoryID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void categoryUpdateAction(ActionEvent event) {
        MajorCategoryDTO majorCategoryDTO=new MajorCategoryDTO(
                categoryID_txt.getText(),
                categoryName_txt.getText()
        );
        try {
            if(majorCategoryController.update(majorCategoryDTO)){
                JOptionPane.showMessageDialog(null,"Updated");
            }else {
                JOptionPane.showMessageDialog(null,"update failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadMajorCategory();
        removeText();
        categoryID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void deleteCategoryAction(ActionEvent event) {

        String categoryID=categoryID_txt.getText();
        try {
            if(majorCategoryController.delete(categoryID)){
                JOptionPane.showMessageDialog(null,"Deleted");
            }else {
                JOptionPane.showMessageDialog(null,"Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadMajorCategory();
        removeText();
        categoryID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

    }
    @FXML
    void searchAction(ActionEvent event) {

        try {
            MajorCategoryDTO majorCategoryDTO= (MajorCategoryDTO) majorCategoryController.search(searchByItem_txt.getText());
            if(majorCategoryDTO != null){
                categoryID_txt.setText(majorCategoryDTO.getMajorCatID());
                categoryName_txt.setText(majorCategoryDTO.getMajorCatName());
            }else {
                JOptionPane.showMessageDialog(null,"Not found");
                removeText();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void refreshButtonAction(ActionEvent event) {
        loadMajorCategory();
    }

    @FXML
    void majorCategoryTableAction(MouseEvent event) {
        MajorCategoryTableView majorCategoryTableView=majorCategory_tbl.getSelectionModel().getSelectedItem();
        categoryID_txt.setText(""+majorCategoryTableView.getMajorCatID());
        categoryName_txt.setText(""+majorCategoryTableView.getMajorCatName());

        manageItemFormController.majorCatID_txt.setText(" "+majorCategoryTableView.getMajorCatID());


    }
    void removeText(){
        categoryID_txt.setText("");
        categoryName_txt.setText("");
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
