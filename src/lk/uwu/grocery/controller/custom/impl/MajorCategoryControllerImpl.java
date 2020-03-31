package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.MajorCategoryController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.MajorCategoryDAO;
import lk.uwu.grocery.dto.MajorCategoryDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/19/2020.
 */
public class MajorCategoryControllerImpl implements MajorCategoryController {
    private MajorCategoryDAO majorCategoryDAO;

    public MajorCategoryControllerImpl() {
        majorCategoryDAO = (MajorCategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.MAJOR_CATEGORY);
    }

    @Override
    public boolean add(MajorCategoryDTO dto) throws ClassNotFoundException, SQLException {
        return majorCategoryDAO.add(dto);
    }

    @Override
    public boolean update(MajorCategoryDTO dto) throws ClassNotFoundException, SQLException {
        return majorCategoryDAO.update(dto);
    }

    @Override
    public boolean delete(String majorCatID) throws ClassNotFoundException, SQLException {
        return majorCategoryDAO.delete(majorCatID);
    }

    @Override
    public SuperDTO search(String majorCatID) throws ClassNotFoundException, SQLException {
        return majorCategoryDAO.search(majorCatID);
    }

    @Override
    public ArrayList<MajorCategoryDTO> view() throws ClassNotFoundException, SQLException {
        return majorCategoryDAO.view();
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
