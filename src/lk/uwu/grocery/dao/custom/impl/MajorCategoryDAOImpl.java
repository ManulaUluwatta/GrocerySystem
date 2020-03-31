package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.MajorCategoryDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.MajorCategoryDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class MajorCategoryDAOImpl implements MajorCategoryDAO {
    @Override
    public boolean add(MajorCategoryDTO dto) throws ClassNotFoundException, SQLException {
        String sql="insert into major_category values(?,?)";
        Connection connection= ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,dto.getMajorCatID());
        stm.setObject(2,dto.getMajorCatName());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(MajorCategoryDTO dto) throws ClassNotFoundException, SQLException {
        String sql="update major_category set majorCatName=? where majorCatID=?";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1 ,dto.getMajorCatName());
        stm.setObject(2,dto.getMajorCatID());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String majorCatID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="delete from major_category where majorCatID='"+majorCatID+"' ";
        int res=stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SuperDTO search(String majorCatID) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from major_category where majorCatID='"+majorCatID+"'";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            MajorCategoryDTO c=new MajorCategoryDTO(
                    rst.getString(1),
                    rst.getString(2)
            );
            return c;
        }
        return null;
    }

    @Override
    public ArrayList<MajorCategoryDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from major_category";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<MajorCategoryDTO> custList = new ArrayList<MajorCategoryDTO>();
        while (rst.next()){
            MajorCategoryDTO c=new MajorCategoryDTO(
                    rst.getString(1),
                    rst.getString(2)
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
    public ArrayList<MajorCategoryDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<MajorCategoryDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<MajorCategoryDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<MajorCategoryDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<MajorCategoryDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
