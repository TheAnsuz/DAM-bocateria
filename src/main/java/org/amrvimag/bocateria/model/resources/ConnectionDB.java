package org.amrvimag.bocateria.model.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.amrvimag.bocateria.Configuration;
import org.amrvimag.bocateria.view.ViewWrapper;

public class ConnectionDB implements Configuration.ConfigurationListener {

    private static Connection con;

    public static void createConnection(String url, String usr, String password) {
        System.out.println(url + ", " + usr + ", " + password);
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

    @Override
    public void onChange(String key, String oldValue, String newValue) {
        switch (key) {
            case "sql.url":
            case "sql.username":
            case "sql.password":
                con = null;
                createConnection(Configuration.getConfig("sql.url"), Configuration
                        .getConfig("sql.username"), Configuration
                        .getConfig("sql.password"));
        }
    }
}
