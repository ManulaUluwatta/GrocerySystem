package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.SubCategoryDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SubCategoryDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SubCategoryDAOImpl implements SubCategoryDAO {
    @Override
    public boolean add(SubCategoryDTO dto) throws ClassNotFoundException, SQLException {
        String sql="insert into sub_category values(?,?,?,?)";
        Connection connection= ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,dto.getSubCatID());
        stm.setObject(2,dto.getMajorCatID());
        stm.setObject(3,dto.getMajorCatName());
        stm.setObject(4,dto.getSubCatName());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(SubCategoryDTO dto) throws ClassNotFoundException, SQLException {
        String sql="update sub_category set majorCatID=?, majorCatName=?, subCatName=? where subCatID=?";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1 ,dto.getMajorCatID());
        stm.setObject(2,dto.getMajorCatName());
        stm.setObject(3,dto.getSubCatName());
        stm.setObject(4,dto.getSubCatID());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String subCatID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="delete from sub_category where subCatID='"+subCatID+"' ";
        int res=stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SuperDTO search(String subCatID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from sub_category where custID='"+subCatID+"'";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            SubCategoryDTO c=new SubCategoryDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            return c;
        }
        return null;
    }

    @Override
    public ArrayList<SubCategoryDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from sub_category";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<SubCategoryDTO> subCatList = new ArrayList<SubCategoryDTO>();
        while (rst.next()){
            SubCategoryDTO c=new SubCategoryDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            subCatList.add(c);
        }
        return subCatList;
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
    public ArrayList<SubCategoryDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<SubCategoryDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<SubCategoryDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<SubCategoryDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<SubCategoryDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
