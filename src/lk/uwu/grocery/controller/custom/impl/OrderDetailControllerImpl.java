package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.OrderDetailController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.OrderDetailDAO;
import lk.uwu.grocery.dto.OrderDetailDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class OrderDetailControllerImpl implements OrderDetailController {
    private OrderDetailDAO orderDetailsDAO;

    public OrderDetailControllerImpl() {
        orderDetailsDAO = (OrderDetailDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.ORDERDETAIL);
    }

    @Override
    public boolean add(OrderDetailDTO dto) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.add(dto);
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
    public ArrayList<OrderDetailDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<OrderDetailDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return orderDetailsDAO.getDetailByCode(code);
    }
}
