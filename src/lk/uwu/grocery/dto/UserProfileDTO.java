package lk.uwu.grocery.dto;

public class UserProfileDTO implements SuperDTO {
    private String passID;
    private String userName;
    private String password;
    private String adminName;
    private String adminEmail;
    private String photoPath;

    public UserProfileDTO() {
    }

    public UserProfileDTO(String passID, String userName, String password, String adminName, String adminEmail, String photoPath) {
        this.passID = passID;
        this.userName = userName;
        this.password = password;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.photoPath = photoPath;
    }

    public String getPassID() {
        return passID;
    }

    public void setPassID(String passID) {
        this.passID = passID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
