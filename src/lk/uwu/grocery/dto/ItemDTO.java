package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ItemDTO implements SuperDTO {
    private String itemCode;
    private String itemName;
    private String majorCatID;
    private String subCatID;
    private String sub_description;
    private double itemSellingPrice;
    private double itemCost;
    private int qtyOnHand;
    private String photo_path;
    private String supID;

    public ItemDTO() {
    }

    public ItemDTO(String itemCode, String itemName, String majorCatID, String subCatID, String sub_description, double itemSellingPrice, double itemCost, int qtyOnHand, String photo_path, String supID) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.majorCatID = majorCatID;
        this.subCatID = subCatID;
        this.sub_description = sub_description;
        this.itemSellingPrice = itemSellingPrice;
        this.itemCost = itemCost;
        this.qtyOnHand = qtyOnHand;
        this.photo_path = photo_path;
        this.supID = supID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getMajorCatID() {
        return majorCatID;
    }

    public void setMajorCatID(String majorCatID) {
        this.majorCatID = majorCatID;
    }

    public String getSubCatID() {
        return subCatID;
    }

    public void setSubCatID(String subCatID) {
        this.subCatID = subCatID;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public double getItemSellingPrice() {
        return itemSellingPrice;
    }

    public void setItemSellingPrice(double itemSellingPrice) {
        this.itemSellingPrice = itemSellingPrice;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public String getPhoto_path() {
        return photo_path;
    }

    public void setPhoto_path(String photo_path) {
        this.photo_path = photo_path;
    }

    public String getSupID() {
        return supID;
    }

    public void setSupID(String supID) {
        this.supID = supID;
    }
}
