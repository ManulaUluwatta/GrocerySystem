package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.custom.UserProfileController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.UserProfileDAO;
import lk.uwu.grocery.dto.SuperDTO;
import lk.uwu.grocery.dto.UserProfileDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserProfileControllerImpl implements UserProfileController {

    private UserProfileDAO userProfileDAO;

    public UserProfileControllerImpl() {
        userProfileDAO= (UserProfileDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.USER_PROFILE);
    }

    @Override
    public boolean add(UserProfileDTO dto) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(UserProfileDTO dto) throws ClassNotFoundException, SQLException {
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
    public ArrayList<UserProfileDTO> view() throws ClassNotFoundException, SQLException {
        return userProfileDAO.view();
    }

    @Override
    public ArrayList<UserProfileDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return userProfileDAO.getName(name);
    }

    @Override
    public ArrayList<UserProfileDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }
}
