package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 1/22/2020.
 */
public class ItemTableView {
    private SimpleStringProperty itemCode;
    private SimpleStringProperty itemName;
    private SimpleStringProperty majorCatID;
    private SimpleStringProperty subCatID;
    private SimpleStringProperty sub_description;
    private SimpleDoubleProperty itemSellingPrice;
    private SimpleDoubleProperty itemCost;
    private SimpleIntegerProperty qtyOnHand;
    private SimpleStringProperty photo_path;
    private SimpleStringProperty supID;

    public ItemTableView(String itemCode, String itemName, String majorCatID, String subCatID, String sub_description, Double itemSellingPrice, Double itemCost, int qtyOnHand, String photo_path, String supID) {
        this.itemCode =new SimpleStringProperty(itemCode);
        this.itemName =new SimpleStringProperty(itemName);
        this.majorCatID =new SimpleStringProperty(majorCatID);
        this.subCatID =new SimpleStringProperty(subCatID);
        this.sub_description =new SimpleStringProperty(sub_description);
        this.itemSellingPrice =new SimpleDoubleProperty(itemSellingPrice);
        this.itemCost =new SimpleDoubleProperty(itemCost);
        this.qtyOnHand =new SimpleIntegerProperty(qtyOnHand);
        this.photo_path =new SimpleStringProperty(photo_path);
        this.supID =new SimpleStringProperty(supID);
    }



    public ItemTableView(String itemCode, String itemName, String sub_description, int qtyOnHand, double itemSellingPrice) {
        this.itemCode =new SimpleStringProperty(itemCode);
        this.itemName =new SimpleStringProperty(itemName);
        this.sub_description =new SimpleStringProperty(sub_description);
        this.qtyOnHand =new SimpleIntegerProperty(qtyOnHand);
        this.itemSellingPrice =new SimpleDoubleProperty(itemSellingPrice);
    }

    public String getItemCode() {
        return itemCode.get();
    }

    public SimpleStringProperty itemCodeProperty() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode.set(itemCode);
    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
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

    public String getSubCatID() {
        return subCatID.get();
    }

    public SimpleStringProperty subCatIDProperty() {
        return subCatID;
    }

    public void setSubCatID(String subCatID) {
        this.subCatID.set(subCatID);
    }

    public String getSub_description() {
        return sub_description.get();
    }

    public SimpleStringProperty sub_descriptionProperty() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description.set(sub_description);
    }

    public double getItemSellingPrice() {
        return itemSellingPrice.get();
    }

    public SimpleDoubleProperty itemSellingPriceProperty() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(double itemSellingPrice) {
        this.itemSellingPrice.set(itemSellingPrice);
    }

    public double getItemCost() {
        return itemCost.get();
    }

    public SimpleDoubleProperty itemCostProperty() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost.set(itemCost);
    }

    public int getQtyOnHand() {
        return qtyOnHand.get();
    }

    public SimpleIntegerProperty qtyOnHandProperty() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand.set(qtyOnHand);
    }

    public String getPhoto_path() {
        return photo_path.get();
    }

    public SimpleStringProperty photo_pathProperty() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path.set(photo_path);
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
}
