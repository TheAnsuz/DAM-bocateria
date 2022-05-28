package org.amrvimag.bocateria.model.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection con;

    public static void createConnection(String url, String usr, String password) {
        if (con != null) return;

        try {
            con = DriverManager.getConnection(url, usr, password);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public static Connection getConnection() {
        return con;
    }
}
