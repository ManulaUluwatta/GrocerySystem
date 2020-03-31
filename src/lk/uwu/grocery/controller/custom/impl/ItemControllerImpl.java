package lk.uwu.grocery.controller.custom.impl;

import lk.uwu.grocery.controller.ControllerFactory;
import lk.uwu.grocery.controller.custom.ItemController;
import lk.uwu.grocery.dao.DAOFactory;
import lk.uwu.grocery.dao.custom.ItemDAO;
import lk.uwu.grocery.dto.ItemDTO;
import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/20/2020.
 */
public class ItemControllerImpl implements ItemController {
    private ItemDAO itemDAO;

    public ItemControllerImpl() {
        itemDAO= (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DOATypes.ITEM);

    }

    @Override
    public boolean add(ItemDTO dto) throws ClassNotFoundException, SQLException {
        return itemDAO.add(dto);
    }

    @Override
    public boolean update(ItemDTO dto) throws ClassNotFoundException, SQLException {
        return itemDAO.update(dto);
    }

    @Override
    public boolean delete(String name) throws ClassNotFoundException, SQLException {
        return itemDAO.delete(name);
    }

    @Override
    public SuperDTO search(String name) throws ClassNotFoundException, SQLException {
        return itemDAO.search(name);
    }

    @Override
    public ArrayList<ItemDTO> view() throws ClassNotFoundException, SQLException {
        return itemDAO.view();
    }

    @Override
    public ArrayList<ItemDTO> getName(String name) throws ClassNotFoundException, SQLException {
        return itemDAO.getName(name);
    }

    @Override
    public ArrayList<ItemDTO> getDetailByCode(String code) throws ClassNotFoundException, SQLException {
        return null;
    }


}
