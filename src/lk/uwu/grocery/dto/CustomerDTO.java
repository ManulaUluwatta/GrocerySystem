package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public class CustomerDTO implements SuperDTO {
    private String custID;
    private String custFirstName;
    private String custLastName;
    private String address;
    private String contactNo;
    private String Email;
    private String nic;
    private String custType;
    private String custPic;

    public CustomerDTO() {
    }

    public CustomerDTO(String custID, String custFirstName, String custLastName, String address, String contactNo, String email, String nic, String custType, String custPic) {
        this.custID = custID;
        this.custFirstName = custFirstName;
        this.custLastName = custLastName;
        this.address = address;
        this.contactNo = contactNo;
        Email = email;
        this.nic = nic;
        this.custType = custType;
        this.custPic = custPic;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getCustFirstName() {
        return custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustLastName() {
        return custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }

    public String getCustPic() {
        return custPic;
    }

    public void setCustPic(String custPic) {
        this.custPic = custPic;
    }
}
