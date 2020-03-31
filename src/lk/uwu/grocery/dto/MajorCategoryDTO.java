package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class MajorCategoryDTO implements SuperDTO {
    private String majorCatID;
    private String majorCatName;

    public MajorCategoryDTO() {
    }

    public MajorCategoryDTO(String majorCatID, String majorCatName) {
        this.majorCatID = majorCatID;
        this.majorCatName = majorCatName;
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
}
