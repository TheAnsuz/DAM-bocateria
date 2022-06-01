package org.amrvimag.bocateria.view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

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
