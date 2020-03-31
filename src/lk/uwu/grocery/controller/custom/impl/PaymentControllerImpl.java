package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.PaymentController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.PaymentDAO;
import lk.uwu.grocery.dto.PaymentDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class PaymentControllerImpl implements PaymentController {
    private PaymentDAO paymentDAO;

    public PaymentControllerImpl() {
        paymentDAO=(PaymentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.PAYMENT);
    }

    @Override
    public boolean add(PaymentDTO dto) throws ClassNotFoundException, SQLException {
        return paymentDAO.add(dto);
    }

    @Override
    public boolean update(PaymentDTO dto) throws ClassNotFoundException, SQLException {
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
    public ArrayList<PaymentDTO> view() throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
