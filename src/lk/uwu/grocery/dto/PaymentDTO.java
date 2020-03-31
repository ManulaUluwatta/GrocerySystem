package lk.uwu.grocery.dto;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class PaymentDTO implements SuperDTO {
    private String payID;
    private String orderID;
    private String paymentDate;
    private Double paymentAmount;
    private Double payDiscount;

    public PaymentDTO() {
    }

    public PaymentDTO(String payID, String orderID, String paymentDate, Double paymentAmount, Double payDiscount) {
        this.payID = payID;
        this.orderID = orderID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
        this.payDiscount = payDiscount;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getPayDiscount() {
        return payDiscount;
    }

    public void setPayDiscount(Double payDiscount) {
        this.payDiscount = payDiscount;
    }
}
