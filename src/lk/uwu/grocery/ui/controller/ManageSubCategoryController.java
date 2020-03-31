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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.SubCategoryController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dto.MajorCategoryDTO;
import lk.uwu.grocery.dto.SubCategoryDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.ui.tableView.SubCategoryTableView;

import javax.swing.*;

/**
 * Created by Manula Uluwatta on 1/15/2020.
 */
public class ManageSubCategoryController implements Initializable {
    @FXML
    private AnchorPane subCategoryPane;

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

    @FXML
    private JFXTextField majorCatName_txt;
    public static JFXTextField majorCatName_txt2;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton update_btn;

    @FXML
    private JFXButton delete_btn;

    @FXML
    private JFXButton refresh_btn;

    @FXML
    private JFXButton select_btn;

    @FXML
    private JFXButton back_btn;

    @FXML
    private JFXTextField majoCatID_txt;
    public static  JFXTextField majoCatID_txt2;

    @FXML
    private JFXTextField subCatID_txt;

    @FXML
    private JFXTextField subCatName_txt;

    private AnchorPane viewPane1;

    private AnchorPane dash;

    private SubCategoryController subCategoryController;
    private ObservableList<SubCategoryTableView> data;

    private String prifix;
    private String tableName;
    private String columName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        subCategoryController= (SubCategoryController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SUB_CATEGORY);
        data= FXCollections.observableArrayList();

        majoCatID_txt2=majoCatID_txt;
        majorCatName_txt2=majorCatName_txt;

        tableName="sub_category";
        columName="subCatID";
        prifix="SC";
        subCatID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

        loadSubCategory();

    }

    @FXML
    void addButtonAction(ActionEvent event) {
        SubCategoryDTO subCategoryDTO=new SubCategoryDTO(
                subCatID_txt.getText(),
                majoCatID_txt.getText(),
                majorCatName_txt.getText(),
                subCatName_txt.getText()
        );
        try {
            if(subCategoryController.add(subCategoryDTO)){
                JOptionPane.showMessageDialog(null,"Added");
            }else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSubCategory();
        removeText();
        subCatID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }
    @FXML
    void refreshButtonAction(ActionEvent event) {
        loadSubCategory();
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        String categoryID=subCatID_txt.getText();
        try {
            if(subCategoryController.delete(categoryID)){
                JOptionPane.showMessageDialog(null,"Deleted");
            }else {
                JOptionPane.showMessageDialog(null,"Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSubCategory();
        removeText();
        subCatID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
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
    void saerchButtonAction(ActionEvent event) {
        //loadSubCategory();
    }
    @FXML
    void selectButtonAction(ActionEvent event) {
//        try {
//            viewPane1= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageMajorCategory.fxml"));
//            ManageItemFormController.viewSubCatPane.getChildren().setAll(viewPane1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ListOfMajorCategory.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void subCategoryTableAction(MouseEvent event) {
        SubCategoryTableView subCategoryTableView=subCategory_tbl.getSelectionModel().getSelectedItem();
        majoCatID_txt.setText(""+subCategoryTableView.getMajorCatID());
        majorCatName_txt.setText(""+subCategoryTableView.getMajorCatName());
        subCatID_txt.setText(""+subCategoryTableView.getSubCatID());
        subCatName_txt.setText(""+subCategoryTableView.getSubCatName());

    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        SubCategoryDTO subCategoryDTO=new SubCategoryDTO(
                subCatID_txt.getText(),
                majoCatID_txt.getText(),
                majorCatName_txt.getText(),
                subCatName_txt.getText()
        );
        try {
            if(subCategoryController.update(subCategoryDTO)){
                JOptionPane.showMessageDialog(null,"Updated");
            }else {
                JOptionPane.showMessageDialog(null,"update failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSubCategory();
        removeText();
        subCatID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    void removeText(){
        majoCatID_txt.setText("");
        subCatID_txt.setText("");
        subCatName_txt.setText("");
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
