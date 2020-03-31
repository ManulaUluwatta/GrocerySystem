package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

public class UserProfileTableView {
    private SimpleStringProperty passID;
    private SimpleStringProperty userName;
    private SimpleStringProperty password;
    private SimpleStringProperty adminName;
    private SimpleStringProperty adminEmail;
    private SimpleStringProperty photoPath;

    public UserProfileTableView(String passID, String userName, String password, String adminName, String adminEmail, String photoPath) {
        this.passID = new SimpleStringProperty(passID);
        this.userName = new SimpleStringProperty(userName);
        this.password = new SimpleStringProperty(password);
        this.adminName = new SimpleStringProperty(adminName);
        this.adminEmail = new SimpleStringProperty(adminEmail);
        this.photoPath =new SimpleStringProperty(photoPath);
    }

    public UserProfileTableView(String userName,String adminName, String adminEmail) {
        this.userName = new SimpleStringProperty(userName);
        this.adminName = new SimpleStringProperty(adminName);
        this.adminEmail = new SimpleStringProperty(adminEmail);
    }

    public String getPassID() {
        return passID.get();
    }

    public SimpleStringProperty passIDProperty() {
        return passID;
    }

    public void setPassID(String passID) {
        this.passID.set(passID);
    }

    public String getUserName() {
        return userName.get();
    }

    public SimpleStringProperty userNameProperty() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getAdminName() {
        return adminName.get();
    }

    public SimpleStringProperty adminNameProperty() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName.set(adminName);
    }

    public String getAdminEmail() {
        return adminEmail.get();
    }

    public SimpleStringProperty adminEmailProperty() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail.set(adminEmail);
    }

    public String getPhotoPath() {
        return photoPath.get();
    }

    public SimpleStringProperty photoPathProperty() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath.set(photoPath);
    }
}
