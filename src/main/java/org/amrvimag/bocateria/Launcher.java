package org.amrvimag.bocateria;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;

import org.amrvimag.bocateria.model.resources.ConnectionDB;
import org.amrvimag.bocateria.view.ViewWrapper;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Launcher {

    public static void main(String[] args) {
        System.err.println("AVISO: el programa esta creado para mostrar en consola los errores a pesar de que funcione perfectamente.");
        try {
            ViewWrapper.setLookAndFeelFromConfig();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionDB.createConnection(Configuration.getConfig("sql.url"),
                Configuration.getConfig("sql.username"),
                Configuration.getConfig("sql.password"));
        ViewWrapper.initialize();
    }
}
