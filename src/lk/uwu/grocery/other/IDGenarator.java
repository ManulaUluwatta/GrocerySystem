package lk.uwu.grocery.other;

import lk.uwu.grocery.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Manula Uluwatta on 1/22/2020.
 */
public class IDGenarator {
    private Connection connection;

    public IDGenarator()  {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    public static String getNewID(String tableName, String columName, String prefix) throws SQLException {
        String lastId = Idcounter.getLastId(tableName, columName);
        String newId = "";
        if (lastId != null) {
            String tempId = "";
            char tempPrefix[] = prefix.toCharArray();
            char lastCode[] = lastId.toCharArray();
            for (int i = tempPrefix.length; i < lastCode.length; i++) {
                tempId += lastCode[i];
            }
            int number = Integer.parseInt(tempId);
            if (number < 9) {
                return newId = prefix + "00" + (++number);
            } else if (number < 99) {
                return newId = prefix + "0" + (++number);
            } else {
                return newId = prefix + (++number);
            }
        } else {
            return prefix + "001";
        }

    }

    public static String getNextIdGenaretor(String tableName, String columName, String prefix){
        String ID = null;
        try {
            ID=(IDGenarator.getNewID(tableName, columName, prefix));
        } catch (SQLException ex) {
            Logger.getLogger(IDGenarator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }


}
