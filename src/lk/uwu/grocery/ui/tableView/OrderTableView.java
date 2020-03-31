package lk.uwu.grocery.ui.tableView;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Manula Uluwatta on 3/11/2020.
 */
public class OrderTableView {
    private SimpleStringProperty orderID;
    private SimpleStringProperty custID;
    private SimpleStringProperty orderDate;

    public OrderTableView(String orderID, String custID, String orderDate) {
        this.orderID = new SimpleStringProperty(orderID);
        this.custID = new SimpleStringProperty(custID);
        this.orderDate = new SimpleStringProperty(orderDate);
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

    public String getCustID() {
        return custID.get();
    }

    public SimpleStringProperty custIDProperty() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID.set(custID);
    }

    public String getOrderDate() {
        return orderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate.set(orderDate);
    }
}
