package lk.uwu.grocery.dto;

import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderDTO implements SuperDTO {
    private String orderID;
    private String custID;
    private String orderDate;
    private ArrayList orderDetailsList;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String custID, String orderDate, ArrayList orderDetailsList) {
        this.orderID = orderID;
        this.custID = custID;
        this.orderDate = orderDate;
        this.orderDetailsList = orderDetailsList;
    }

    public OrderDTO(String orderID, String custID, String orderDate) {
        this.orderID = orderID;
        this.custID = custID;
        this.orderDate = orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public ArrayList getOrderDetailsList() {
        return orderDetailsList;
    }

    public void setOrderDetailsList(ArrayList orderDetailsList) {
        this.orderDetailsList = orderDetailsList;
    }
}
