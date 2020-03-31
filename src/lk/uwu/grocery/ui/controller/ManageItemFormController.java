package lk.uwu.grocery.ui.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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

import javafx.fxml.FXML;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.ItemController;
import lk.uwu.grocery.dto.ItemDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.ui.tableView.ItemTableView;
import net.connectcode.Code128Auto;

import javax.swing.*;


/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class ManageItemFormController implements Initializable {
    @FXML
    private JFXTextField itemCode_text;

    @FXML
    private JFXTextField itemName_txt;

    @FXML
    private JFXTextField supID_txt;
    public static JFXTextField supID_txt2;

    @FXML
    private JFXTextField iMajorCatID_txt;
    public static JFXTextField majorCatID_txt;

    @FXML
    private JFXTextField iSubCatID_txt;
    public static JFXTextField subCatID_txt;

    @FXML
    private JFXTextArea description_txt;

    @FXML
    private JFXTextField sellPrice_txt;

    @FXML
    private JFXTextField costPrice_txt;

    @FXML
    private JFXTextField quantity_txt;

    @FXML
    private JFXButton barcode_btn;


    @FXML
    private TableView<ItemTableView> itemVew_tbl;

    @FXML
    private TableColumn<ItemTableView, String> tItemCode;

    @FXML
    private TableColumn<ItemTableView, String> tItemName;

    @FXML
    private TableColumn<ItemTableView, String> tMajoCatID;

    @FXML
    private TableColumn<ItemTableView, String> tSubCatID;

    @FXML
    private TableColumn<ItemTableView, String> tSubCatName;

    @FXML
    private TableColumn<ItemTableView, Integer> tQtyOnHand;

    @FXML
    private TableColumn<ItemTableView, Double> tCost;

    @FXML
    private TableColumn<ItemTableView, Double> tSellPrice;


    @FXML
    private TableColumn<ItemTableView, String> tSupID;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton update_btn;

    @FXML
    private JFXButton delete_btn;

    @FXML
    private JFXButton borwse_btn;

    @FXML
    private JFXButton remove_btn;

    @FXML
    private JFXButton subCategorySelect_btn;

    @FXML
    private JFXButton categorySelect_btn;

    @FXML
    private JFXButton supllierSelect_btn;

    @FXML
    private JFXButton viewMajorCategory_btn;

    @FXML
    private JFXButton viewSubCat_btn;

    @FXML
    private JFXTextField itemNameSearch_txt;

    @FXML
    private JFXTextArea barcode_txt;

    @FXML
    private JFXButton print_btn;


    @FXML
    private AnchorPane itemViewAcnchor;
    //public static AnchorPane itemViewAnchor2;
    private AnchorPane viewPane;

    public static AnchorPane viewSubCatPane;

    private String prifix;
    private String tableName;
    private String columName;

    private ItemController itemController;
    private ObservableList<ItemTableView> data;
    private String photoPath;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        itemController= (ItemController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.ITEM);
        data= FXCollections.observableArrayList();
        photoPath= "/lk/uwu/grocery/ui/images/notAvalable.png";

        ////


        ////
        viewPane=itemViewAcnchor;
        viewSubCatPane=itemViewAcnchor;
        //itemViewAnchor2=itemViewAcnchor;
        majorCatID_txt=iMajorCatID_txt;
        supID_txt2=supID_txt;
        subCatID_txt=iSubCatID_txt;

        tableName="item";
        columName="itemCode";
        prifix="I";
        itemCode_text.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
        loadItem();
        loadBarcod();
    }

    @FXML
    void categorySelectAction(ActionEvent event) {

            //viewPane= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ListOfMajorCategory.fxml"));
            //itemViewAcnchor.getChildren().setAll(viewPane);
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
    void printAction(ActionEvent event) {
        Stage prStage=new Stage();
        pageSetup(barcode_txt,prStage);

    }
    private void pageSetup(Node node, Stage owner)
    {
        // Create the PrinterJob
        PrinterJob job = PrinterJob.createPrinterJob();

        if (job == null)
        {
            return;
        }

        // Show the page setup dialog
        boolean proceed = job.showPageSetupDialog(owner);

        if (proceed)
        {
            print(job, node);
        }
    }

    private void print(PrinterJob job, Node node)
    {
        // Set the Job Status Message
        //jobStatus.textProperty().bind(job.jobStatusProperty().asString());

        // Print the node
        boolean printed = job.printPage(node);

        if (printed)
        {
            job.endJob();
        }
    }

    @FXML
    void subCategorySelectAction(ActionEvent event) {
//        try {
//            viewPane= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageSubCategory.fxml"));
//            itemViewAcnchor.getChildren().setAll(viewPane);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ListOfSubCategory.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void supplierSelectAction(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ListOfSuppliers.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewMajorCategoryAction(ActionEvent event) {
        try {
            viewPane= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageMajorCategory.fxml"));
            itemViewAcnchor.getChildren().setAll(viewPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void buttonAction(ActionEvent event) {
        try {
            Parent root=FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/BarcodeGenarator.fxml"));
            Stage primaryStage=new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewSubCatAction(ActionEvent event) {
        try {
            viewPane= FXMLLoader.load(getClass().getResource("/lk/uwu/grocery/ui/fxml/ManageSubCategory.fxml"));
            itemViewAcnchor.getChildren().setAll(viewPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void browseAction(ActionEvent event) {

    }

    @FXML
    void itemAddAction(ActionEvent event) {
        ItemDTO itemDTO=new ItemDTO(
                itemCode_text.getText(),
                itemName_txt.getText(),
                iMajorCatID_txt.getText(),
                iSubCatID_txt.getText(),
                description_txt.getText(),
                Double.parseDouble(sellPrice_txt.getText()),
                Double.parseDouble(costPrice_txt.getText()),
                Integer.parseInt(quantity_txt.getText()),
                photoPath,
                supID_txt.getText()
            );
        try {
            if(itemController.add(itemDTO)){
                JOptionPane.showMessageDialog(null,"Added");
            }else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadItem();
        removeText();
        itemCode_text.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

    }

    @FXML
    void itemDeleteAction(ActionEvent event) {
        String itemCode=itemCode_text.getText();
        try {
            if(itemController.delete(itemCode)){
                JOptionPane.showMessageDialog(null,"Deleted");
            }else {
                JOptionPane.showMessageDialog(null,"Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadItem();
        removeText();
        itemCode_text.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void itemUpdateAction(ActionEvent event) {
        ItemDTO itemDTO=new ItemDTO(
                itemCode_text.getText(),
                itemName_txt.getText(),
                iMajorCatID_txt.getText(),
                iSubCatID_txt.getText(),
                description_txt.getText(),
                Double.parseDouble(sellPrice_txt.getText()),
                Double.parseDouble(costPrice_txt.getText()),
                Integer.parseInt(quantity_txt.getText()),
                photoPath,
                supID_txt.getText()


                );
        try {
            if(itemController.update(itemDTO)){
                JOptionPane.showMessageDialog(null,"Updated");
            }else {
                JOptionPane.showMessageDialog(null,"Update failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadItem();
        removeText();
        itemCode_text.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

    }

    @FXML
    void removeAction(ActionEvent event) {

    }

    @FXML
    void itemTableAction(MouseEvent event) {
        ItemTableView itemTableView=itemVew_tbl.getSelectionModel().getSelectedItem();
        itemCode_text.setText(""+itemTableView.getItemCode());
        itemName_txt.setText(""+itemTableView.getItemName());
        iMajorCatID_txt.setText(""+itemTableView.getMajorCatID());
        iSubCatID_txt.setText(""+itemTableView.getSubCatID());
        supID_txt.setText(""+itemTableView.getSupID());
        description_txt.setText(""+itemTableView.getSub_description());
        sellPrice_txt.setText(""+itemTableView.getItemSellingPrice());
        quantity_txt.setText(""+itemTableView.getQtyOnHand());
        costPrice_txt.setText(""+itemTableView.getItemCost());
    }

    void removeText(){
        itemName_txt.setText("");
        supID_txt.setText("");
        iSubCatID_txt.setText("");
        iMajorCatID_txt.setText("");
        description_txt.setText("");
        sellPrice_txt.setText("");
        costPrice_txt.setText("");
        quantity_txt.setText("");
    }

    @FXML
    void searchItemAction(KeyEvent event) {
        String itemName=itemNameSearch_txt.getText();
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<ItemDTO> allItem=itemController.getName(itemName);
            if(allItem != null){
                for (ItemDTO item :
                        allItem) {
                    data.add(new ItemTableView(
                            item.getItemCode(),
                            item.getItemName(),
                            item.getMajorCatID(),
                            item.getSubCatID(),
                            item.getSub_description(),
                            item.getItemSellingPrice(),
                            item.getItemCost(),
                            item.getQtyOnHand(),
                            item.getPhoto_path(),
                            item.getSupID()

                    ));
                }
            }
            itemVew_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            tItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            tMajoCatID.setCellValueFactory(new PropertyValueFactory("majorCatID"));
            tSubCatID.setCellValueFactory(new PropertyValueFactory("subCatID"));
            tSubCatName.setCellValueFactory(new PropertyValueFactory("sub_description"));
            tQtyOnHand.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
            tCost.setCellValueFactory(new PropertyValueFactory("itemCost"));
            tSellPrice.setCellValueFactory(new PropertyValueFactory("itemSellingPrice"));
            tSupID.setCellValueFactory(new PropertyValueFactory("supID"));

            itemVew_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void loadItem() {
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
                            item.getMajorCatID(),
                            item.getSubCatID(),
                            item.getSub_description(),
                            item.getItemSellingPrice(),
                            item.getItemCost(),
                            item.getQtyOnHand(),
                            item.getPhoto_path(),
                            item.getSupID()

                    ));
                }
            }
            itemVew_tbl.getItems().removeAll();
            tItemCode.setCellValueFactory(new PropertyValueFactory("itemCode"));
            tItemName.setCellValueFactory(new PropertyValueFactory("itemName"));
            tMajoCatID.setCellValueFactory(new PropertyValueFactory("majorCatID"));
            tSubCatID.setCellValueFactory(new PropertyValueFactory("subCatID"));
            tSubCatName.setCellValueFactory(new PropertyValueFactory("sub_description"));
            tQtyOnHand.setCellValueFactory(new PropertyValueFactory("qtyOnHand"));
            tCost.setCellValueFactory(new PropertyValueFactory("itemCost"));
            tSellPrice.setCellValueFactory(new PropertyValueFactory("itemSellingPrice"));
            tSupID.setCellValueFactory(new PropertyValueFactory("supID"));

            itemVew_tbl.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void loadBarcod() {
        Code128Auto code128Auto=new Code128Auto();
        System.out.println(itemCode_text.getText());
        String barcode=code128Auto.encode(itemCode_text.getText());
        System.out.println("mm");
        barcode_txt.setText(barcode);
        barcode_txt.setFont(new javafx.scene.text.Font("CCode128_S3_Trial",24));

    }
}
