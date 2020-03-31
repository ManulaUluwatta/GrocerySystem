package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.SuperController;
import lk.uwu.grocery.controller.custom.SupplierController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.SupplierDAO;
import lk.uwu.grocery.dto.SuperDTO;
import lk.uwu.grocery.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SupplierControllerImpl implements SupplierController {
    private SupplierDAO supplierDAO;

    public SupplierControllerImpl() {
        supplierDAO= (SupplierDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.SUPPLIER);
    }

    @Override
    public boolean add(SupplierDTO dto) throws ClassNotFoundException, SQLException {
        return supplierDAO.add(dto);
    }

    @Override
    public boolean update(SupplierDTO dto) throws ClassNotFoundException, SQLException {
        return supplierDAO.update(dto);
    }

    @Override
    public boolean delete(String supID) throws ClassNotFoundException, SQLException {
        return supplierDAO.delete(supID);
    }

    @Override
    public SuperDTO search(String supID) throws ClassNotFoundException, SQLException {
        return supplierDAO.search(supID);
    }

    @Override
    public ArrayList<SupplierDTO> view() throws ClassNotFoundException, SQLException {
        return supplierDAO.view();
    }

    @Override
    public ArrayList<SupplierDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return supplierDAO.getName(name);
    }

    @Override
    public ArrayList<SupplierDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
