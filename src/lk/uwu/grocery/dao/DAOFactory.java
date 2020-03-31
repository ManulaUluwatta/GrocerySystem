package lk.uwu.grocery.dao;

import lk.uwu.grocery.controller.custom.impl.SubCategoryControllerImpl;
import lk.uwu.grocery.dao.custom.impl.*;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public class DAOFactory {
    public enum DOATypes{
        CUSTOMER,SUPPLIER,MAJOR_CATEGORY,SUB_CATEGORY,ITEM,ORDERS,ORDERDETAIL,PAYMENT,USER_PROFILE;
    }
    private static DAOFactory daoFactory;

    public DAOFactory() {

    }
    public static DAOFactory getInstance(){
        if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(DOATypes types){
        switch (types){
            case CUSTOMER:
                return (SuperDAO) new CustomerDAOImpl();
            case SUPPLIER:
                return (SuperDAO) new SupplierDAOImpl();
            case MAJOR_CATEGORY:
                return (SuperDAO) new MajorCategoryDAOImpl();
            case SUB_CATEGORY:
                return (SuperDAO) new SubCategoryDAOImpl();
            case ITEM:
                return (SuperDAO) new ItemDAOImpl();
            case ORDERS:
                return (SuperDAO) new OrderDAOImpl();
            case ORDERDETAIL:
                return (SuperDAO) new OrderDetalDAOImpl();
            case PAYMENT:
                return (SuperDAO) new PaymentDAOImpl();
            case USER_PROFILE:
                return (SuperDAO) new UserProfileDAOImpl();
            default:
                return null;
        }
    }
}
