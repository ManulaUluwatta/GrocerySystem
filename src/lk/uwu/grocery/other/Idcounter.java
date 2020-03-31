package lk.uwu.grocery.other;

import lk.uwu.grocery.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Manula Uluwatta on 1/22/2020.
 */
public class Idcounter {
    private Connection connection;

    public Idcounter() {
        connection = ConnectionFactory.getInstance().getConnection();

    }

    public static String getLastId(String tableName, String columName) throws SQLException {
        String sql = String.format("SELECT %s FROM %s ORDER BY %s DESC LIMIT 1", columName, tableName, columName);
        Connection connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }
}
