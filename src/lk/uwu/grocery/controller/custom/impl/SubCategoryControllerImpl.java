package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.SubCategoryController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.SubCategoryDAO;
import lk.uwu.grocery.dto.SubCategoryDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class SubCategoryControllerImpl implements SubCategoryController {
    private SubCategoryDAO subCategoryDAO;

    public SubCategoryControllerImpl() {
        subCategoryDAO= (SubCategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.SUB_CATEGORY);
    }

    @Override
    public boolean add(SubCategoryDTO dto) throws ClassNotFoundException, SQLException {
        return subCategoryDAO.add(dto);
    }

    @Override
    public boolean update(SubCategoryDTO dto) throws ClassNotFoundException, SQLException {
        return subCategoryDAO.update(dto);
    }

    @Override
    public boolean delete(String name) throws ClassNotFoundException, SQLException {
        return subCategoryDAO.delete(name);
    }

    @Override
    public SuperDTO search(String name) throws ClassNotFoundException, SQLException {
        return subCategoryDAO.search(name);
    }

    @Override
    public ArrayList<SubCategoryDTO> view() throws ClassNotFoundException, SQLException {
        return subCategoryDAO.view();
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
