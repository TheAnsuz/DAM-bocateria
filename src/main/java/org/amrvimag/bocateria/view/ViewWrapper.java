package org.amrvimag.bocateria.view;

import java.awt.event.ActionListener;

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
    private final ConfigurationDialog configurationDialog;
    private final EmpleadoDialog empleadoDialog;
    private final ErrorDialog errorDialog;

    private ViewWrapper() {
        mainframe = new Mainframe();
        configurationDialog = new ConfigurationDialog(mainframe, true);
        empleadoDialog = new EmpleadoDialog(mainframe, true);
        errorDialog = new ErrorDialog(mainframe, true);
    }
    
    public void showError(Exception exception) {
        errorDialog.setError(exception);
        errorDialog.setVisible(true);
    }

    public void addCancelButtonListener(ActionListener list) {

    }
}
