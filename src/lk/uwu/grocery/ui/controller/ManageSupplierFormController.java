package lk.uwu.grocery.ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.File;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.SupplierController;
import lk.uwu.grocery.dto.SupplierDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.other.Validator;
import lk.uwu.grocery.ui.tableView.SuppierTableView;

import javax.swing.*;

/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class ManageSupplierFormController implements Initializable{


    @FXML
    private JFXTextField supFirstName_txt;

    @FXML
    private JFXTextField supLastName_txt;

    @FXML
    private JFXTextField supAddress_txt;

    @FXML
    private JFXTextField supEmail_txt;

    @FXML
    private JFXTextField supContact_txt;

    @FXML
    private JFXTextField supNIC_txt;

    @FXML
    private JFXButton add_btn;

    @FXML
    private JFXButton update_btn;

    @FXML
    private JFXButton delete_btn;

    @FXML
    private JFXTextField supID_txt;

    @FXML
    private JFXTextField supCompany_txt;

    @FXML
    private JFXButton browse_btn;

    @FXML
    private JFXButton remove_btn;

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
    private JFXTextField searchSupplierName_txt;


    @FXML
    private ImageView supplierImageView;

    @FXML
    private JFXButton search_btn;

    @FXML
    private JFXButton refresh_btn;

    private SupplierController supplierController;
    private ObservableList<SuppierTableView> data;

    private String prifix;
    private String tableName;
    private String columName;

    private String photoPath;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        supplierController= (SupplierController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.SUPPLIER);
        data= FXCollections.observableArrayList();
        photoPath= "/lk/uwu/grocery/ui/images/notAvalable.png";

        tableName="Supplier";
        columName="supID";
        prifix="S";
        supID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));

        loadSupplier();
    }

    @FXML
    void addButtonAction(ActionEvent event) {
        SupplierDTO supplierDTO=new SupplierDTO(
                supID_txt.getText(),
                supFirstName_txt.getText(),
                supLastName_txt.getText(),
                supAddress_txt.getText(),
                supCompany_txt.getText(),
                supContact_txt.getText(),
                supEmail_txt.getText(),
                supNIC_txt.getText(),
                photoPath
        );
        try {
            if(supplierController.add(supplierDTO)){
                JOptionPane.showMessageDialog(null,"Supplier was Added");
                removeText();
            }else {
                JOptionPane.showMessageDialog(null,"Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSupplier();
        supID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void browseButtonAction(ActionEvent event) {

        FileChooser file=new FileChooser();

        //FileNameExtensionFilter filter=new FileNameExtensionFilter("*.Images","jpg","gif","png");

        //file.setInitialDirectory(new File(System.getProperty("user.home")));

        File selectedFile=file.showOpenDialog(null);

        if(selectedFile !=null){
            photoPath="file:"+selectedFile.getAbsolutePath();
            System.out.println(photoPath);
            Image image=new Image(photoPath,237,242,false,false);
            supplierImageView.setImage(image);
        }

    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        String supID=supID_txt.getText();
        try {
            if(supplierController.delete(supID)){
                JOptionPane.showMessageDialog(null,"Supplier Deleted");
            }else {
                JOptionPane.showMessageDialog(null,"Supplier Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSupplier();
        supID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void refreshButtonAction(ActionEvent event) {
        loadSupplier();
        removeText();
    }

    @FXML
    void removeButtonAction(ActionEvent event) {

    }

    @FXML
    void searchButtonAction(ActionEvent event) {

    }
    @FXML
    void supplierTableAction(MouseEvent event) {
        SuppierTableView suppierTableView=supplerDetail_tbl.getSelectionModel().getSelectedItem();
        supID_txt.setText(""+suppierTableView.getSupID());
        supFirstName_txt.setText(""+suppierTableView.getSupFirstName());
        supLastName_txt.setText(""+suppierTableView.getSupLastName());
        supAddress_txt.setText(""+suppierTableView.getSupAddress());
        supCompany_txt.setText(""+suppierTableView.getSupCompany());
        supContact_txt.setText(""+suppierTableView.getSupContact());
        supEmail_txt.setText(""+suppierTableView.getSupEmail());
        supNIC_txt.setText(""+suppierTableView.getSupNIC());

        String name=supFirstName_txt.getText();
        try {
            List<SupplierDTO> allSuppliers = supplierController.getName(name);
            for (SupplierDTO sup :
                    allSuppliers) {
                photoPath=sup.getSup_pic();
                System.out.println(photoPath);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Image image=new Image(photoPath,237,242,false,false);
        supplierImageView.setImage(image);

    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        SupplierDTO supplierDTO=new SupplierDTO(
                supID_txt.getText(),
                supFirstName_txt.getText(),
                supLastName_txt.getText(),
                supAddress_txt.getText(),
                supCompany_txt.getText(),
                supContact_txt.getText(),
                supEmail_txt.getText(),
                supNIC_txt.getText(),
                photoPath
        );
        try {
            if(supplierController.update(supplierDTO)){
                JOptionPane.showMessageDialog(null,"Updated");
            }else {
                JOptionPane.showMessageDialog(null,"update failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadSupplier();
    }
    @FXML
    void contactAction(ActionEvent event) {
        boolean result  = Validator.isPhoneNumber(supContact_txt.getText());
        if (result) {
            System.out.println("Contact supiri");
        } else {
            JOptionPane .  showMessageDialog(null, "Invalid Number");
        }
    }
    @FXML
    void emailAction(ActionEvent event) {
        boolean result = Validator.isValidEmailAddress(supEmail_txt.getText());
        if (result) {
            System.out.println("supiri");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email");
        }
    }
    @FXML
    void nicAction(ActionEvent event) {
        boolean result = Validator.validateNIC(supNIC_txt.getText());
        if (result) {
            System.out.println("supiri");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid NIC");
        }
    }
    @FXML
    void supplierSearchAction(KeyEvent event) {
        String name=searchSupplierName_txt.getText();
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<SupplierDTO> allSuppliers=supplierController.getName(name);
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


    void removeText(){
        supID_txt.setText("");
        supFirstName_txt.setText("");
        supLastName_txt.setText("");
        supAddress_txt.setText("");
        supCompany_txt.setText("");
        supContact_txt.setText("");
        supEmail_txt.setText("");
        supNIC_txt.setText("");
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
