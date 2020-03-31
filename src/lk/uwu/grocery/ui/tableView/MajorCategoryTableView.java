package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class MajorCategoryTableView {
    private SimpleStringProperty majorCatID;
    private SimpleStringProperty majorCatName;

    public MajorCategoryTableView() {
    }

    public MajorCategoryTableView(String majorCatID, String majorCatName) {
        this.majorCatID = new SimpleStringProperty(majorCatID);
        this.majorCatName = new SimpleStringProperty(majorCatName);
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
}
