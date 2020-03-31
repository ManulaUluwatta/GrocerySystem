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
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.CustomerController;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.other.IDGenarator;
import lk.uwu.grocery.other.Validator;
import lk.uwu.grocery.ui.tableView.CustomerTableView;

import javax.swing.*;

/**
 * Created by Manula Uluwatta on 1/14/2020.
 */
public class ManageCustomerFormController implements Initializable {

    @FXML
    private JFXTextField custFirstName_txt;

    @FXML
    private JFXTextField custLastName_txt;

    @FXML
    private JFXTextField custAddress_txt;

    @FXML
    private JFXTextField custEmail_txt;

    @FXML
    private JFXTextField custContact_txt;

    @FXML
    private JFXTextField custNic_txt;

    @FXML
    private JFXRadioButton studentRadio_btn;

    @FXML
    private ToggleGroup typeOfCustome;

    @FXML
    private JFXRadioButton staffRadio_btn;

    @FXML
    private JFXButton custAdd_btn;

    @FXML
    private JFXButton custUpdate_btn;

    @FXML
    private JFXButton custDelet_btn;

    @FXML
    private JFXTextField custID_txt;

    @FXML
    private ImageView customerImageView;

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

    private ObservableList<CustomerTableView> data;

    private String custType;
    private String photoPath;

    private String prifix;
    private String tableName;
    private String columName;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        customerController= (CustomerController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.CUSTOMER);
        data= FXCollections.observableArrayList();
        //customerController=new CustomerControllerImpl();
        photoPath= "/lk/uwu/grocery/ui/images/notAvalable.png";


        tableName="customer";
        columName="custID";
        prifix="C";
        custID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));


        loadCustomer();
    }

    @FXML
    void customerAddButtonAction(ActionEvent event) {
        if(studentRadio_btn.isSelected()){
            custType=studentRadio_btn.getText();
        }
        if(staffRadio_btn.isSelected()){
            custType=staffRadio_btn.getText();
        }
        CustomerDTO customerDTO=new CustomerDTO(
                custID_txt.getText(),
                custFirstName_txt.getText(),
                custLastName_txt.getText(),
                custAddress_txt.getText(),
                custContact_txt.getText(),
                custEmail_txt.getText(),
                custNic_txt.getText(),
                custType,
                photoPath

        );
        try {
            if(customerController.add(customerDTO)){
                JOptionPane.showMessageDialog(null,"Customer Has been Added");
                removeText();
            }else {
                JOptionPane.showMessageDialog(null,"Customer Add Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
        Logger.getLogger(ManageCustomerFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadCustomer();
        custID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void customerDeleteButtonAction(ActionEvent event) {
        String custID=custID_txt.getText();
        try {
            if(customerController.delete(custID)){
                JOptionPane.showMessageDialog(null,"Customer Deleted");
            }else {
                JOptionPane.showMessageDialog(null,"Customer Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadCustomer();
        custID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }

    @FXML
    void customerRefreshButtonAction(ActionEvent event) {
            loadCustomer();
            removeText();
    }

    @FXML
    void customerSearchButtonAction(ActionEvent event) {
        try {
            CustomerDTO customerDTO= (CustomerDTO) customerController.search(custID_txt.getText());
            if(customerDTO != null){
                custID_txt.setText(customerDTO.getCustID());
                custFirstName_txt.setText(customerDTO.getCustFirstName());
                custLastName_txt.setText(customerDTO.getCustLastName());
                custAddress_txt.setText(customerDTO.getAddress());
                custContact_txt.setText(customerDTO.getContactNo());
                custEmail_txt.setText(customerDTO.getEmail());
                custNic_txt.setText(customerDTO.getNic());

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
    void customerUpdateButtonAction(ActionEvent event) {
        if(studentRadio_btn.isSelected()){
            custType=studentRadio_btn.getText();
        }
        if(staffRadio_btn.isSelected()){
            custType=staffRadio_btn.getText();
        }
        CustomerDTO customerDTO=new CustomerDTO(
                custID_txt.getText(),
                custFirstName_txt.getText(),
                custLastName_txt.getText(),
                custAddress_txt.getText(),
                custContact_txt.getText(),
                custEmail_txt.getText(),
                custNic_txt.getText(),
                custType,
                photoPath
        );
        try {
            if(customerController.update(customerDTO)){
                JOptionPane.showMessageDialog(null,"Updated");
            }else {
                JOptionPane.showMessageDialog(null,"update failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loadCustomer();
        custID_txt.setText(IDGenarator.getNextIdGenaretor(tableName,columName,prifix));
    }
    @FXML
    void contactAction(ActionEvent event) {
        boolean result  = Validator.isPhoneNumber(custContact_txt.getText());
        if (result) {
            System.out.println("Contact supiri");
            custNic_txt.requestFocus();
            custContact_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            custContact_txt.setFocusColor(Paint.valueOf("red"));
            //JOptionPane .  showMessageDialog(null, "Invalid Number");
        }
    }
    @FXML
    void emailAction(ActionEvent event) {
        boolean result = Validator.isValidEmailAddress(custEmail_txt.getText());
        if (result) {
            System.out.println("supiri");
            custContact_txt.requestFocus();
        } else {
            custEmail_txt.setFocusColor(Paint.valueOf("red"));
            //JOptionPane.showMessageDialog(null, "Invalid Email");
        }
    }
    @FXML
    void nicAction(ActionEvent event) {
        boolean result = Validator.validateNIC(custNic_txt.getText());
        if (result) {
            System.out.println("supiri");
        } else {
            custNic_txt.setFocusColor(Paint.valueOf("red"));
            //JOptionPane.showMessageDialog(null, "Invalid NIC");
        }
    }

    @FXML
    void firstNameTxtAction(ActionEvent event) {
        boolean result  = Validator.isAlpha(custFirstName_txt.getText());
        if (result) {
            System.out.println("supiri");
            custLastName_txt.requestFocus();
            custFirstName_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            custFirstName_txt.setFocusColor(Paint.valueOf("red"));
            //JOptionPane .  showMessageDialog(null, "Invalid Number");
        }
    }

    @FXML
    void lastNameTxtAction(ActionEvent event) {
        boolean result  = Validator.isAlpha(custLastName_txt.getText());
        if (result) {
            System.out.println("supiri");
            custAddress_txt.requestFocus();
            custLastName_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            custLastName_txt.setFocusColor(Paint.valueOf("red"));
            //JOptionPane .  showMessageDialog(null, "Invalid Number");
        }
    }
    @FXML
    void addressTextAction(ActionEvent event) {
        custEmail_txt.requestFocus();
    }

    @FXML
    void searchCustomerAction(KeyEvent event) {
        String custName=searchByName_txt.getText();
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<CustomerDTO> allCustomers=customerController.getName(custName);
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
            customerImageView.setImage(image);
        }
    }
    void removeText(){
        custID_txt.setText("");
        custFirstName_txt.setText("");
        custLastName_txt.setText("");
        custAddress_txt.setText("");
        custContact_txt.setText("");
        custEmail_txt.setText("");
        custNic_txt.setText("");
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
    @FXML
    void customerTableAction(MouseEvent event) {
        CustomerTableView customerTableView=customerDetails_tbl.getSelectionModel().getSelectedItem();
        custID_txt.setText(""+customerTableView.getCustID());
        custFirstName_txt.setText(""+customerTableView.getCustFirstName());
        custLastName_txt.setText(""+customerTableView.getCustLastName());
        custAddress_txt.setText(""+customerTableView.getCustAddress());
        custEmail_txt.setText(""+customerTableView.getCustEmail());
        custContact_txt.setText(""+customerTableView.getCustContact());
        custNic_txt.setText(""+customerTableView.getCustNic());
        String name=custFirstName_txt.getText();

        try {
            List<CustomerDTO> allCustomers=customerController.getName(name);
            for (CustomerDTO cust :
                    allCustomers) {
                photoPath=cust.getCustPic();
                System.out.println(photoPath);
                String type=cust.getCustType();
                if(type.equals("Student")){
                    studentRadio_btn.setSelected(true);
                }
                if(type.equals("Staff")){
                    staffRadio_btn.setSelected(true);
                }
            }

            Image image=new Image(photoPath,237,242,false,false);
            customerImageView.setImage(image);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


//    void tableAction(MouseEvent event) {
//        ItemsTableView itemsTableView=itemsTeble.getSelectionModel().getSelectedItem();
//        itemCodeText.setText(""+itemsTableView.getItemCode());
//        descText.setText(itemsTableView.getDesc());
//        unitPriceText.setText(""+itemsTableView.getUnitPrice());
//        qtyOnHandText.setText(""+itemsTableView.getQtyOnHand());
//
//    }
}
