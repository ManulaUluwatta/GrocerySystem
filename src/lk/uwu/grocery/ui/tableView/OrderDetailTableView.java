package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 3/8/2020.
 */
public class OrderDetailTableView {
    private SimpleStringProperty orderDetailID;
    private SimpleStringProperty orderID;
    private SimpleStringProperty itemCode;
    private SimpleStringProperty itemName;
    private SimpleDoubleProperty pricePerUnit;
    private SimpleDoubleProperty discount;
    private SimpleDoubleProperty totalAmount;
    private SimpleIntegerProperty orderQty;
    private SimpleDoubleProperty amount;



    public OrderDetailTableView(String orderDetailID, String orderID, String itemCode, String itemName, double pricePerUnit, double discount, double totalAmount, int orderQty) {
        this.orderDetailID = new SimpleStringProperty(orderDetailID);
        this.orderID = new SimpleStringProperty(orderID);
        this.itemCode = new SimpleStringProperty(itemCode);
        this.itemName = new SimpleStringProperty(itemName);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
        this.discount = new SimpleDoubleProperty(discount);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.orderQty = new SimpleIntegerProperty(orderQty);
    }

    public OrderDetailTableView(String itemCode, String itemName, double pricePerUnit, double discount, double totalAmount, int orderQty) {
        this.itemCode = new SimpleStringProperty(itemCode);
        this.itemName = new SimpleStringProperty(itemName);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
        this.discount = new SimpleDoubleProperty(discount);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.orderQty = new SimpleIntegerProperty(orderQty);

    }

    public OrderDetailTableView(String itemCode, String itemName, double pricePerUnit, double totalDiscount, double totalAmount, int orderQty, double amount) {
        this.itemCode = new SimpleStringProperty(itemCode);
        this.itemName = new SimpleStringProperty(itemName);
        this.pricePerUnit = new SimpleDoubleProperty(pricePerUnit);
        this.discount = new SimpleDoubleProperty(totalDiscount);
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.orderQty = new SimpleIntegerProperty(orderQty);
        this.amount=new SimpleDoubleProperty(amount);
    }


    public String getOrderDetailID() {
        return orderDetailID.get();
    }

    public SimpleStringProperty orderDetailIDProperty() {
        return orderDetailID;
    }

    public void setOrderDetailID(String orderDetailID) {
        this.orderDetailID.set(orderDetailID);
    }

    public String getOrderID() {
        return orderID.get();
    }

    public SimpleStringProperty orderIDProperty() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
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

    public double getPricePerUnit() {
        return pricePerUnit.get();
    }

    public SimpleDoubleProperty pricePerUnitProperty() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit.set(pricePerUnit);
    }

    public double getDiscount() {
        return discount.get();
    }

    public SimpleDoubleProperty discountProperty() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount.set(discount);
    }

    public double getTotalAmount() {
        return totalAmount.get();
    }

    public SimpleDoubleProperty totalAmountProperty() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount.set(totalAmount);
    }

    public int getOrderQty() {
        return orderQty.get();
    }

    public SimpleIntegerProperty orderQtyProperty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty.set(orderQty);
    }

    public double getAmount() {
        return amount.get();
    }

    public SimpleDoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }
}
