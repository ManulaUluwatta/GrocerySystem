package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SuppierTableView {
    private SimpleStringProperty supID;
    private SimpleStringProperty supFirstName;
    private SimpleStringProperty supLastName;
    private SimpleStringProperty supAddress;
    private SimpleStringProperty supCompany;
    private SimpleStringProperty supEmail;
    private SimpleStringProperty supContact;
    private SimpleStringProperty supNIC;

    public SuppierTableView() {
    }

    public SuppierTableView(String supID, String supFirstName, String supLastName, String supAddress, String supCompany, String supEmail, String supContact, String supNIC) {
        this.supID =new SimpleStringProperty(supID);
        this.supFirstName =new SimpleStringProperty(supFirstName);
        this.supLastName =new SimpleStringProperty(supLastName);
        this.supAddress =new SimpleStringProperty(supAddress);
        this.supCompany =new SimpleStringProperty(supCompany);
        this.supEmail =new SimpleStringProperty(supEmail);
        this.supContact =new SimpleStringProperty(supContact);
        this.supNIC =new SimpleStringProperty(supNIC);
    }

    public String getSupID() {
        return supID.get();
    }

    public SimpleStringProperty supIDProperty() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID.set(supID);
    }

    public String getSupFirstName() {
        return supFirstName.get();
    }

    public SimpleStringProperty supFirstNameProperty() {
        return supFirstName;
    }

    public void setSupFirstName(String supFirstName) {
        this.supFirstName.set(supFirstName);
    }

    public String getSupLastName() {
        return supLastName.get();
    }

    public SimpleStringProperty supLastNameProperty() {
        return supLastName;
    }

    public void setSupLastName(String supLastName) {
        this.supLastName.set(supLastName);
    }

    public String getSupAddress() {
        return supAddress.get();
    }

    public SimpleStringProperty supAddressProperty() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress.set(supAddress);
    }

    public String getSupCompany() {
        return supCompany.get();
    }

    public SimpleStringProperty supCompanyProperty() {
        return supCompany;
    }

    public void setSupCompany(String supCompany) {
        this.supCompany.set(supCompany);
    }

    public String getSupEmail() {
        return supEmail.get();
    }

    public SimpleStringProperty supEmailProperty() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail.set(supEmail);
    }

    public String getSupContact() {
        return supContact.get();
    }

    public SimpleStringProperty supContactProperty() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact.set(supContact);
    }

    public String getSupNIC() {
        return supNIC.get();
    }

    public SimpleStringProperty supNICProperty() {
        return supNIC;
    }

    public void setSupNIC(String supNIC) {
        this.supNIC.set(supNIC);
    }
}
