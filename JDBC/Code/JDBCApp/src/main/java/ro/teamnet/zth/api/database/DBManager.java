package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Ramona.Raducu on 7/13/2017.
 */
public class DBManager {

    static String CONNECTION_STRING= "jdbc:oracle:thin:@" + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() {
        throw new UnsupportedOperationException();
    }

    private static void registerDriver() {
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        registerDriver();
        try {
            return DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER, DBProperties.PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int checkConnection(Connection connection) throws SQLException {
        String sqlIdentifier = "SELECT 1 FROM DUAL";
        Statement pst = connection.createStatement();

        ResultSet rs = pst.executeQuery(sqlIdentifier);
        while (rs.next()) {
            int r = rs.getInt("1");
            return r;
        }
        return 0;
    }


}
