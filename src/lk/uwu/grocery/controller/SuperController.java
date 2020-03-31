package lk.uwu.grocery.controller;

import lk.uwu.grocery.dto.SuperDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public interface SuperController<T extends SuperDTO> {

    public boolean add(T dto)throws ClassNotFoundException,SQLException;
    public boolean update(T dto)throws ClassNotFoundException,SQLException;
    public boolean delete(String name)throws ClassNotFoundException,SQLException;
    public SuperDTO search(String name)throws ClassNotFoundException,SQLException;
    public ArrayList<T> view()throws ClassNotFoundException,SQLException;
    public ArrayList<T> getName(String name)throws ClassNotFoundException,SQLException;
    public ArrayList<T> getDetailByCode(String code)throws ClassNotFoundException,SQLException;

}
