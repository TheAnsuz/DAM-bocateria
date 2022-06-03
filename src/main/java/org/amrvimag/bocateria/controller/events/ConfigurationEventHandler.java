package org.amrvimag.bocateria.controller.events;

import org.amrvimag.bocateria.Configuration;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ConfigurationEventHandler {
    
    public boolean onConfirmChanges(String url, String user, String password, String laf, String appName) {
        Configuration.setConfig("sql.url", url);
        Configuration.setConfig("sql.username", user);
        Configuration.setConfig("sql.password", password);
        Configuration.setConfig("application.laf", laf);
        Configuration.setConfig("application.name", appName);
        return true; // Returns true if the window should close
    }
    
    public void onClose(String url, String user, String password, String laf, String appName) {
        // Si cancelas deberian de restablecerse los valores para que no cambie nada
//        Configuration.setConfig("sql.url", url);
//        Configuration.setConfig("sql.username", user);
//        Configuration.setConfig("sql.password", password);
//        Configuration.setConfig("application.laf", laf);
//        Configuration.setConfig("application.name", appName);
    }
    
}
