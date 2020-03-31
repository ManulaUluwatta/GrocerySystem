package lk.uwu.grocery.dao.custom.impl;

import lk.uwu.grocery.dao.custom.ItemDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.ItemDTO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ItemDAOImpl implements ItemDAO {


    @Override
    public boolean add(ItemDTO dto) throws ClassNotFoundException, SQLException {
        String sql="insert into item values(?,?,?,?,?,?,?,?,?,?)";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,dto.getItemCode());
        stm.setObject(2,dto.getItemName());
        stm.setObject(3,dto.getMajorCatID());
        stm.setObject(4,dto.getSubCatID());
        stm.setObject(5,dto.getSub_description());
        stm.setObject(6,dto.getItemSellingPrice());
        stm.setObject(7,dto.getItemCost());
        stm.setObject(8,dto.getQtyOnHand());
        stm.setObject(9,dto.getPhoto_path());
        stm.setObject(10,dto.getSupID());
        int res=stm.executeUpdate();
        //System.out.println(res);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(ItemDTO dto) throws ClassNotFoundException, SQLException {
        String sql="update item set itemName=? , majorCatID=? , subCatID=? , sub_description=? , itemSellingPrice=? , itemCost=? , qtyOnHand=? , photo_path=? , supID=? where itemCode=?";
        Connection connection=ConnectionFactory.getInstance().getConnection();
        PreparedStatement stm=connection.prepareStatement(sql);
        stm.setObject(1,dto.getItemName());
        stm.setObject(2,dto.getMajorCatID());
        stm.setObject(3,dto.getSubCatID());
        stm.setObject(4,dto.getSub_description());
        stm.setObject(5,dto.getItemSellingPrice());
        stm.setObject(6,dto.getItemCost());
        stm.setObject(7,dto.getQtyOnHand());
        stm.setObject(8,dto.getPhoto_path());
        stm.setObject(9,dto.getSupID());
        stm.setObject(10,dto.getItemCode());
        int res=stm.executeUpdate();
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String itemCode) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="delete from item where itemCode='"+itemCode+"' ";
        int res=stm.executeUpdate(sql);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public SuperDTO search(String itemCode) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from item where custID='"+itemCode+"'";
        ResultSet rst=stm.executeQuery(sql);
        if(rst.next()){
            ItemDTO c=new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10)

            );
            return c;
        }
        return null;
    }

    @Override
    public ArrayList<ItemDTO> view() throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from item";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        while (rst.next()){
            ItemDTO c=new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10)
            );
            itemList.add(c);
        }
        return itemList;
    }

    @Override
    public boolean updateStock(OrderDetailDTO orderDetail) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        String SQL="Update Item set qtyOnHand=qtyOnHand-? where itemCode=?";
        PreparedStatement stm=connection.prepareStatement(SQL);
        stm.setObject(1, orderDetail.getOrderQty());
        stm.setObject(2, orderDetail.getItemCode());
        return stm.executeUpdate()>0;
    }

    @Override
    public boolean updateStock(ArrayList<OrderDetailDTO> oderDetailsList) throws ClassNotFoundException, SQLException {
        for(OrderDetailDTO orderDetail: oderDetailsList){
            boolean isAdded=updateStock(orderDetail);
            if(!isAdded){
                return false;
            }
        }
        return true;
    }

    @Override
    public ArrayList<ItemDTO> searchOrderByCustId(String custId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public String getNextOrderId() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<ItemDTO> searchOrderDetails(String orderId) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public boolean add(ArrayList<ItemDTO> orderDetailsList) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<ItemDTO> getName(String name) throws ClassNotFoundException, SQLException {
        Connection connection=ConnectionFactory.getInstance().getConnection();
        Statement stm=connection.createStatement();
        String sql="select * from item where itemName like '%"+name+"%'";
        ResultSet rst=stm.executeQuery(sql);
        ArrayList<ItemDTO> itemList = new ArrayList<ItemDTO>();
        while (rst.next()){
            ItemDTO c=new ItemDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getDouble(6),
                    rst.getDouble(7),
                    rst.getInt(8),
                    rst.getString(9),
                    rst.getString(10)
            );
            itemList.add(c);
        }
        return itemList;
    }

    @Override
    public ArrayList<ItemDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
