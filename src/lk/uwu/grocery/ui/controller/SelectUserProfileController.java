package lk.uwu.grocery.ui.controller;

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
import lk.uwu.grocery.controller.custom.UserProfileController;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.dto.UserProfileDTO;
import lk.uwu.grocery.ui.tableView.CustomerTableView;
import lk.uwu.grocery.ui.tableView.UserProfileTableView;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SelectUserProfileController implements Initializable {
    @FXML
    private TableView<UserProfileTableView> userProfileViewTable;

    @FXML
    private TableColumn<UserProfileTableView, String> userNameTbl_cl;

    @FXML
    private TableColumn<UserProfileTableView, String> nameTbl_cl;

    @FXML
    private TableColumn<UserProfileTableView, String> emailTbl_cl;

    private UserProfileController userProfileController;
    private UserLoginController userLoginController;

    private ObservableList<UserProfileTableView> data;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userProfileController= (UserProfileController) ControllerFactory.getInstance().getController(ControllerFactory.controllerType.USER_PROFILE);
        data= FXCollections.observableArrayList();
        loadUserProfile();
    }
    @FXML
    void selectUserAction(MouseEvent event) {
        UserProfileTableView userProfileTableView=userProfileViewTable.getSelectionModel().getSelectedItem();
        userLoginController.userName1_txt.setText(""+userProfileTableView.getUserName());
        ((Stage)(((TableView)event.getSource()).getScene().getWindow())).close();


    }

    private void loadUserProfile() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }
        try {
            List<UserProfileDTO> allUsers=userProfileController.view();
            if(allUsers != null){
                for (UserProfileDTO user :
                        allUsers) {
                    data.add(new UserProfileTableView(user.getUserName(),user.getAdminName(),user.getAdminEmail()));
                }
            }
            userProfileViewTable.getItems().removeAll();
            userNameTbl_cl.setCellValueFactory(new PropertyValueFactory("userName"));
            nameTbl_cl.setCellValueFactory(new PropertyValueFactory("adminName"));
            emailTbl_cl.setCellValueFactory(new PropertyValueFactory("adminEmail"));

            userProfileViewTable.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
