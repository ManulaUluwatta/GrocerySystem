package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 1/18/2020.
 */
public class CustomerTableView {
    private SimpleStringProperty custID;
    private SimpleStringProperty custFirstName;
    private SimpleStringProperty custLastName;
    private SimpleStringProperty custAddress;
    private SimpleStringProperty custEmail;
    private SimpleStringProperty custContact;
    private SimpleStringProperty custNic;
    private SimpleStringProperty custType;

    public CustomerTableView() {
    }

    public CustomerTableView(String custID, String custFirstName, String custLastName, String custAddress, String custEmail, String custContact, String custNic, String custType) {
        this.custID = new SimpleStringProperty(custID);
        this.custFirstName = new SimpleStringProperty(custFirstName);
        this.custLastName = new SimpleStringProperty(custLastName);
        this.custAddress = new SimpleStringProperty(custAddress);
        this.custEmail = new SimpleStringProperty(custEmail);
        this.custContact = new SimpleStringProperty(custContact);
        this.custNic = new SimpleStringProperty(custNic);
        this.custType = new SimpleStringProperty(custType);
    }

    public String getCustID() {
        return custID.get();
    }

    public SimpleStringProperty custIDProperty() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID.set(custID);
    }

    public String getCustFirstName() {
        return custFirstName.get();
    }

    public SimpleStringProperty custFirstNameProperty() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName.set(custFirstName);
    }

    public String getCustLastName() {
        return custLastName.get();
    }

    public SimpleStringProperty custLastNameProperty() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName.set(custLastName);
    }

    public String getCustAddress() {
        return custAddress.get();
    }

    public SimpleStringProperty custAddressProperty() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress.set(custAddress);
    }

    public String getCustEmail() {
        return custEmail.get();
    }

    public SimpleStringProperty custEmailProperty() {
        return custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail.set(custEmail);
    }

    public String getCustContact() {
        return custContact.get();
    }

    public SimpleStringProperty custContactProperty() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact.set(custContact);
    }

    public String getCustNic() {
        return custNic.get();
    }

    public SimpleStringProperty custNicProperty() {
        return custNic;
    }

    public void setCustNic(String custNic) {
        this.custNic.set(custNic);
    }

    public String getCustType() {
        return custType.get();
    }

    public SimpleStringProperty custTypeProperty() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType.set(custType);
    }
}
