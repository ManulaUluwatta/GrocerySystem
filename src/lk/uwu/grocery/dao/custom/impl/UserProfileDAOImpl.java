package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.UserProfileDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;
import lk.uwu.grocery.dto.UserProfileDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserProfileDAOImpl implements UserProfileDAO {

    @Override
    public boolean add(UserProfileDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(UserProfileDTO dto) throws ClassNotFoundException, SQLException {
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
    public ArrayList<UserProfileDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection= ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from user_profile";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<UserProfileDTO> userList = new ArrayList<UserProfileDTO>();
        while (rst.next()){
            UserProfileDTO u=new UserProfileDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)

                    );
            userList.add(u);
        }
        return userList;
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
    public ArrayList<UserProfileDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<UserProfileDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<UserProfileDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<UserProfileDTO> getName(String name) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from user_profile where user_name='"+name+"'";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<UserProfileDTO> userList = new ArrayList<UserProfileDTO>();
        while (rst.next()){
            UserProfileDTO u=new UserProfileDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6)
            );
            userList.add(u);
        }
        return userList;
    }

    @Override
    public ArrayList<UserProfileDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
