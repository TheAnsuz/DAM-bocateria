package org.amrvimag.bocateria.view;

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
    
    private Mainframe mainframe;

    private ViewWrapper() {
        mainframe = new Mainframe();
    }

}
