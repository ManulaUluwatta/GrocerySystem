package lk.uwu.grocery.controller;

import lk.uwu.grocery.controller.custom.impl.*;
import lk.uwu.grocery.db.ConnectionFactory;
import lk.uwu.grocery.dto.CustomerDTO;

/**
 * Created by Manula Uluwatta on 1/16/2020.
 */
public class ControllerFactory {
    private static ControllerFactory controllerFactory;

    public enum controllerType{
        CUSTOMER,SUPPLIER,MAJOR_CATEGORY,SUB_CATEGORY,ITEM,ORDERS,ORDERDETAIL,PAYMENT,USER_PROFILE;
    }

    public ControllerFactory() {
    }

    public static ControllerFactory getInstance(){
        if(controllerFactory==null){
            controllerFactory=new ControllerFactory();
        }
        return controllerFactory;
    }
    public SuperController getController(controllerType type){
        switch (type){
            case CUSTOMER:
                return (SuperController) new CustomerControllerImpl();
            case SUPPLIER:
                return (SuperController) new SupplierControllerImpl();
            case MAJOR_CATEGORY:
                return (SuperController) new MajorCategoryControllerImpl();
            case SUB_CATEGORY:
                return (SuperController) new SubCategoryControllerImpl();
            case ITEM:
                return (SuperController) new ItemControllerImpl();
            case ORDERS:
                return (SuperController) new OrderControllerImpl();
            case ORDERDETAIL:
                return (SuperController) new OrderDetailControllerImpl();
            case PAYMENT:
                return (SuperController) new PaymentControllerImpl();
            case USER_PROFILE:
                return (SuperController) new UserProfileControllerImpl();
            default:
                return null;
        }

    }
}
