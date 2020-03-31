package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.OrderDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderDAOImpl implements OrderDAO {
    @Override
    public boolean add(OrderDTO dto) throws ClassNotFoundException, SQLException {
        String sql = "Insert into orders values(?,?,?)";
        Connection conn = ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, dto.getOrderID());
        stm.setObject(2, dto.getCustID());
        stm.setObject(3, dto.getOrderDate());
        int res = stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(OrderDTO dto) throws ClassNotFoundException, SQLException {
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
    public ArrayList<OrderDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from orders";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<OrderDTO> itemList = new ArrayList<OrderDTO>();
        while (rst.next()){
            OrderDTO o=new OrderDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
            itemList.add(o);
        }
        return itemList;
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
    public ArrayList<OrderDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<OrderDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<OrderDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<OrderDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
