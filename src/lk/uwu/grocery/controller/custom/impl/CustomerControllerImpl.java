package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.CustomerController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.CustomerDAO;
import lk.uwu.grocery.dto.CustomerDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public class CustomerControllerImpl implements CustomerController {
    private CustomerDAO customerDAO;

    public CustomerControllerImpl() {
        customerDAO= (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.CUSTOMER);
    }

    @Override
    public boolean add(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        return customerDAO.add(dto);
    }

    @Override
    public boolean update(CustomerDTO dto) throws ClassNotFoundException, SQLException {
        return customerDAO.update(dto);
    }

    @Override
    public boolean delete(String custID) throws ClassNotFoundException, SQLException {
        return customerDAO.delete(custID);
    }

    @Override
    public SuperDTO search(String custID) throws ClassNotFoundException, SQLException {
        return customerDAO.search(custID);
    }

    @Override
    public ArrayList<CustomerDTO> view() throws ClassNotFoundException, SQLException {
        return customerDAO.view();
    }

    @Override
    public ArrayList<CustomerDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return customerDAO.getName(name);
    }

    @Override
    public ArrayList<CustomerDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }


}
