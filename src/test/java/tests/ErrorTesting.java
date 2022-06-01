package tests;

import org.amrvimag.bocateria.view.ViewWrapper;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class ErrorTesting {

    public static void main(String[] args) {
        while (true) {
            if (!ViewWrapper.getView().seesError())
                ViewWrapper.getView().showError(new NullPointerException("CERDOOOOOOOOOOOOOO"));
        }

    }
}
