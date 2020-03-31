package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderDetailDTO implements SuperDTO {
    private String orderDetailID;
    private String orderID;
    private String itemCode;
    private String itemName;
    private double PricePerUnit;
    private double discount;
    private double totalAmount;
    private int orderQty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderDetailID, String orderID, String itemCode, String itemName, double pricePerUnit, double discount, double totalAmount, int orderQty) {
        this.orderDetailID = orderDetailID;
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.PricePerUnit = pricePerUnit;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.orderQty = orderQty;
    }

    public OrderDetailDTO(String itemCode, String itemName, double pricePerUnit, double discount, double totalAmount, int orderQty) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.PricePerUnit = pricePerUnit;
        this.discount = discount;
        this.totalAmount = totalAmount;
        this.orderQty = orderQty;
    }

    public String getOrderDetailID() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID = orderDetailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
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

    public double getPricePerUnit() {
        return PricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.PricePerUnit = pricePerUnit;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }
}
