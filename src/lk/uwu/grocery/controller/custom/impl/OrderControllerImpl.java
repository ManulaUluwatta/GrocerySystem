package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.OrderController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.ItemDAO;
import lk.uwu.grocery.dao.custom.OrderDAO;
import lk.uwu.grocery.dao.custom.OrderDetailDAO;
import lk.uwu.grocery.dao.custom.PaymentDAO;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.OrderDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderControllerImpl implements OrderController {
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;
    private ItemDAO itemDAO;
    private PaymentDAO paymentDAO;
    private Connection conn;

    public OrderControllerImpl() {
        orderDAO=(OrderDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.ORDERS);
        orderDetailDAO=(OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.ORDERDETAIL);
        itemDAO=(ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.ITEM);
        paymentDAO= (PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.PAYMENT);
        conn= ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(OrderDTO dto) throws ClassNotFoundException, SQLException {
        try{

            conn.setAutoCommit(false);
            boolean orderAdded=orderDAO.add(dto);
            if(orderAdded){
                System.out.println("step1");
                boolean orderDetailAdded=orderDetailDAO.add(dto.getOrderDetailsList());
                if(orderDetailAdded){
                    System.out.println("step2");
                    boolean itemUpdated=itemDAO.updateStock(dto.getOrderDetailsList());
                    if(itemUpdated) {
                        System.out.println("step3");
                        conn.commit();
                        return true;
                    }
                }
            }
            conn.rollback();
            return false;
        }finally{
            conn.setAutoCommit(true);
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
        return orderDAO.view();
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
