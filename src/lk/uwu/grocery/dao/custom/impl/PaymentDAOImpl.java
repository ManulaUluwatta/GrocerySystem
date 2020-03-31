package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.PaymentDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.PaymentDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean add(PaymentDTO dto) throws ClassNotFoundException, SQLException {
        Connection conn = ConnectionFactory.getInstance().getConnection();
        String sql = "Insert into payment values(?,?,?,?,?)";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, dto.getPayID());
        stm.setObject(2, dto.getOrderID());
        stm.setObject(3, dto.getPaymentDate());
        stm.setObject(4, dto.getPaymentAmount());
        stm.setObject(5, dto.getPayDiscount());
        int res = stm.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean update(PaymentDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean delete(String name) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public SuperDTO search(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> view() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean updateStock(OrderDetailDTO od) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean updateStock(ArrayList<OrderDetailDTO> oderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<PaymentDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<PaymentDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<PaymentDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
