package org.amrvimag.bocateria.view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ViewWrapper {

    private static ViewWrapper wrapper;

    public static ViewWrapper getView() {
        if (wrapper == null)
            wrapper = new ViewWrapper();

        return wrapper;
    }

    private final Mainframe mainframe;
    private final ConfigurationDialog configuration;

    private ViewWrapper() {
        FlatDarkLaf.setup();
        FlatLightLaf.setup();
        mainframe = new Mainframe();
        configuration = new ConfigurationDialog(mainframe, true);
    }
}
