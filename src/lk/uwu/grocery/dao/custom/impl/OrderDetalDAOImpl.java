package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.OrderDetailDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderDetalDAOImpl implements OrderDetailDAO {
    @Override
    public boolean add(OrderDetailDTO dto) throws ClassNotFoundException, SQLException {
        System.out.println("oddddddd");
        String sql = "Insert into order_detail values(?,?,?,?,?,?,?,?)";
        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, dto.getOrderDetailID());
        stm.setObject(2, dto.getOrderID());
        stm.setObject(3, dto.getItemCode());
        stm.setObject(4, dto.getItemName());
        stm.setObject(5, dto.getPricePerUnit());
        stm.setObject(6, dto.getDiscount());
        stm.setObject(7, dto.getTotalAmount());
        stm.setObject(8, dto.getOrderQty());
        int res = stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }


    }

    @Override
    public boolean update(OrderDetailDTO dto) throws ClassNotFoundException, SQLException {
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
    public ArrayList<OrderDetailDTO> view() throws ClassNotFoundException, SQLException {
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
    public ArrayList<OrderDetailDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<OrderDetailDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        for (OrderDetailDTO orderDetail : orderDetailsList ) {
            boolean isAdded = add(orderDetail);
            if (!isAdded) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<OrderDetailDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        String sql= "select * from order_detail where orderID='" + code + "'";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement pst=connection.prepareStatement(sql);
        ResultSet rst = pst.executeQuery();
        ArrayList<OrderDetailDTO> orderDetailList = new ArrayList<>();
        while (rst.next()) {
            OrderDetailDTO od = new OrderDetailDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getDouble(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getInt(8)
            );
            orderDetailList.add(od);

        }
        return orderDetailList;
    }
}
