package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.CustomerDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(CustomerDTO c1) throws ClassNotFoundException, SQLException {
        String sql="insert into customer values(?,?,?,?,?,?,?,?,?)";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,c1.getCustID());
        stm.setObject(2,c1.getCustFirstName());
        stm.setObject(3,c1.getCustLastName());
        stm.setObject(4,c1.getAddress());
        stm.setObject(5,c1.getContactNo());
        stm.setObject(6,c1.getEmail());
        stm.setObject(7,c1.getNic());
        stm.setObject(8,c1.getCustType());
        stm.setObject(9,c1.getCustPic());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        String sql="update customer set custFirstName=?,custLastName=?,custAddress=?,custContact=?,custEmail=?,custNIC=?,custType=?,cust_pic=? where custID=?";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1 ,dto.getCustFirstName());
        stm.setObject(2,dto.getCustLastName());
        stm.setObject(3,dto.getAddress());
        stm.setObject(4,dto.getContactNo());
        stm.setObject(5,dto.getEmail());
        stm.setObject(6,dto.getNic());
        stm.setObject(7,dto.getCustType());
        stm.setObject(8,dto.getCustPic());
        stm.setObject(9,dto.getCustID());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String custID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="delete from customer where custID='"+custID+"' ";
        int res=stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SuperDTO search(String custID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from customer where custID='"+custID+"'";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
                CustomerDTO c=new CustomerDTO(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4),
                        rst.getString(5),
                        rst.getString(6),
                        rst.getString(7),
                        rst.getString(8),
                        rst.getString(9)
                );
                return c;
        }
        return null;
    }


    @Override
    public ArrayList<CustomerDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from customer";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<CustomerDTO> custList = new ArrayList<CustomerDTO>();
        while (rst.next()){
            CustomerDTO c=new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
            custList.add(c);
        }
        return custList;
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
    public ArrayList<CustomerDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<CustomerDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<CustomerDTO> getName(String name) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from customer where custFirstName like '%"+name+"%'";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<CustomerDTO> custList = new ArrayList<CustomerDTO>();
        while (rst.next()){
            CustomerDTO c=new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)
            );
            custList.add(c);
        }
        return custList;
    }

    @Override
    public ArrayList<CustomerDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
