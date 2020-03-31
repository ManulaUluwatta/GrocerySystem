package lk.uwu.grocery.dto;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SupplierDTO implements SuperDTO {
    private String supID;
    private String supFirstName;
    private String supLastName;
    private String supAddress;
    private String supCompany;
    private String supContact;
    private String supEmail;
    private String supNIC;
    private String sup_pic;

    public SupplierDTO() {
    }

    public SupplierDTO(String supID, String supFirstName, String supLastName, String supAddress, String supCompany, String supContact, String supEmail, String supNIC, String sup_pic) {
        this.supID = supID;
        this.supFirstName = supFirstName;
        this.supLastName = supLastName;
        this.supAddress = supAddress;
        this.supCompany = supCompany;
        this.supContact = supContact;
        this.supEmail = supEmail;
        this.supNIC = supNIC;
        this.sup_pic = sup_pic;
    }

    public String getSupID() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }

    public String getSupFirstName() {
        return supFirstName;
    }

    public void setSupFirstName(String supFirstName) {
        this.supFirstName = supFirstName;
    }

    public String getSupLastName() {
        return supLastName;
    }

    public void setSupLastName(String supLastName) {
        this.supLastName = supLastName;
    }

    public String getSupAddress() {
        return supAddress;
    }

    public void setSupAddress(String supAddress) {
        this.supAddress = supAddress;
    }

    public String getSupCompany() {
        return supCompany;
    }

    public void setSupCompany(String supCompany) {
        this.supCompany = supCompany;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    public String getSupEmail() {
        return supEmail;
    }

    public void setSupEmail(String supEmail) {
        this.supEmail = supEmail;
    }

    public String getSupNIC() {
        return supNIC;
    }

    public void setSupNIC(String supNIC) {
        this.supNIC = supNIC;
    }

    public String getSup_pic() {
        return sup_pic;
    }

    public void setSup_pic(String sup_pic) {
        this.sup_pic = sup_pic;
    }
}
