package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SubCategoryDTO implements SuperDTO {
    private String subCatID;
    private String majorCatID;
    private String majorCatName;
    private String subCatName;

    public SubCategoryDTO() {
    }

    public SubCategoryDTO(String subCatID, String majorCatID, String majorCatName, String subCatName) {
        this.subCatID = subCatID;
        this.majorCatID = majorCatID;
        this.majorCatName = majorCatName;
        this.subCatName = subCatName;
    }

    public String getSubCatID() {
        return subCatID;
    }

    public void setSubCatID(String subCatID) {
        this.subCatID = subCatID;
    }

    public String getMajorCatID() {
        return majorCatID;
    }

    public void setMajorCatID(String majorCatID) {
        this.majorCatID = majorCatID;
    }

    public String getMajorCatName() {
        return majorCatName;
    }

    public void setMajorCatName(String majorCatName) {
        this.majorCatName = majorCatName;
    }

    public String getSubCatName() {
        return subCatName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName = subCatName;
    }
}
