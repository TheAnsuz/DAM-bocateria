package org.amrvimag.bocateria.model.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.amrvimag.bocateria.view.ViewWrapper;

public class ConnectionDB {

    private static Connection con;

    public static void createConnection(String url, String usr, String password) {
        if (con != null)
            return;

        try {
            con = DriverManager.getConnection(url, usr, password);
        } catch (SQLException e) {
            ViewWrapper.getView().showError(e);
        }
    }

    public static Connection getConnection() {
        return con;
    }

    public static void updateDatabaseConfig(String url, String username, String password) {
        con = null;
//        System.out.println("Updated database connection");
        createConnection(url, username, password);
    }

}
