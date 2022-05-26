package org.amrvimag.bocateria.swing;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class ASearchBox<E> extends JComboBox {

    public ASearchBox() {
        super();
    }
    
    public ASearchBox(ComboBoxModel<E> model) {
        super(model);
    }
    
    public ASearchBox(E[] elements) {
        super(elements);
    }

    
}
