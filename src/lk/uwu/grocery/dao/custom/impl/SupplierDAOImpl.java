package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.SuperDAO;
import lk.uwu.grocery.dao.custom.SupplierDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;
import lk.uwu.grocery.dto.SupplierDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SupplierDAOImpl implements SupplierDAO {

    @Override
    public boolean add(SupplierDTO s1) throws ClassNotFoundException, SQLException {
        String sql="insert into supplier values(?,?,?,?,?,?,?,?,?)";
        Connection connection= ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,s1.getSupID());
        stm.setObject(2,s1.getSupFirstName());
        stm.setObject(3,s1.getSupLastName());
        stm.setObject(4,s1.getSupAddress());
        stm.setObject(5,s1.getSupCompany());
        stm.setObject(6,s1.getSupContact());
        stm.setObject(7,s1.getSupEmail());
        stm.setObject(8,s1.getSupNIC());
        stm.setObject(9,s1.getSup_pic());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(SupplierDTO dto) throws ClassNotFoundException, SQLException {
        String sql="update supplier set supFirstName=?,supLastName=?,supAddress=?,supCompany=?,supContact=?,supEmial=?,supNIC=?,sup_pic=? where supID=?";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1 ,dto.getSupFirstName());
        stm.setObject(2,dto.getSupLastName());
        stm.setObject(3,dto.getSupAddress());
        stm.setObject(4,dto.getSupCompany());
        stm.setObject(5,dto.getSupContact());
        stm.setObject(6,dto.getSupEmail());
        stm.setObject(7,dto.getSupNIC());
        stm.setObject(8,dto.getSup_pic());
        stm.setObject(9,dto.getSupID());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String supID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="delete from supplier where supID='"+supID+"' ";
        int res=stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SuperDTO search(String supID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from supplier where supID='"+supID+"'";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            SupplierDTO s=new SupplierDTO(
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
            return s;
        }
        return null;
    }

    @Override
    public ArrayList<SupplierDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from supplier";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
        while (rst.next()){
            SupplierDTO s=new SupplierDTO(
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
            supplierList.add(s);
        }
        return supplierList;
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
    public ArrayList<SupplierDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<SupplierDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<SupplierDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<SupplierDTO> getName(String name) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from supplier where supFirstName like '%"+name+"%'";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<SupplierDTO> supplierList = new ArrayList<SupplierDTO>();
        while (rst.next()){
            SupplierDTO s=new SupplierDTO(
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
            supplierList.add(s);
        }
        return supplierList;
    }

    @Override
    public ArrayList<SupplierDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
