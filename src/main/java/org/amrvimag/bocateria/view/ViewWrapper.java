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

    private static final List<LookAndFeel> lafs = new ArrayList<>(Arrays
            .asList(new FlatDarkLaf(), new FlatLightLaf(), new NimbusLookAndFeel(), new MetalLookAndFeel()));

    public static ViewWrapper getView() {
        if (wrapper == null)
            wrapper = new ViewWrapper();

        return wrapper;
    }

    public static LookAndFeel[] getLookAndFeels() {
        return lafs.toArray(new LookAndFeel[0]);
    }

    public static void setLookAndFeel(LookAndFeel laf) {
        try {
            UIManager.setLookAndFeel(laf);
            getView()._setLookAndFeel(laf);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ViewWrapper.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private Mainframe mainframe;
    private ConfigurationDialog configuration;

    private ViewWrapper() {
        FlatDarkLaf.setup();
        FlatLightLaf.setup();
        mainframe = new Mainframe();
        configuration = new ConfigurationDialog(mainframe, true);
    }

    private void _setLookAndFeel(LookAndFeel laf) {
        SwingUtilities.updateComponentTreeUI(mainframe);
        mainframe.pack();
        SwingUtilities.updateComponentTreeUI(configuration);
        configuration.pack();
    }

}
