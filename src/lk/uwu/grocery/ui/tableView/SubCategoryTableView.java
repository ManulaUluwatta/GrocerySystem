package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class SubCategoryTableView {
    private SimpleStringProperty subCatID;
    private SimpleStringProperty majorCatID;
    private SimpleStringProperty majorCatName;
    private SimpleStringProperty subCatName;

    public SubCategoryTableView() {
    }

    public SubCategoryTableView(String subCatID, String majorCatID, String majorCatName, String subCatName) {
        this.subCatID =new SimpleStringProperty(subCatID);
        this.majorCatID =new SimpleStringProperty(majorCatID);
        this.majorCatName =new SimpleStringProperty(majorCatName);
        this.subCatName =new SimpleStringProperty(subCatName);
    }

    public String getSubCatID() {
        return subCatID.get();
    }

    public SimpleStringProperty subCatIDProperty() {
        return subCatID;
    }

    public void setSubCatID(String subCatID) {
        this.subCatID.set(subCatID);
    }

    public String getMajorCatID() {
        return majorCatID.get();
    }

    public SimpleStringProperty majorCatIDProperty() {
        return majorCatID;
    }

    public void setMajorCatID(String majorCatID) {
        this.majorCatID.set(majorCatID);
    }

    public String getMajorCatName() {
        return majorCatName.get();
    }

    public SimpleStringProperty majorCatNameProperty() {
        return majorCatName;
    }

    public void setMajorCatName(String majorCatName) {
        this.majorCatName.set(majorCatName);
    }

    public String getSubCatName() {
        return subCatName.get();
    }

    public SimpleStringProperty subCatNameProperty() {
        return subCatName;
    }

    public void setSubCatName(String subCatName) {
        this.subCatName.set(subCatName);
    }
}
