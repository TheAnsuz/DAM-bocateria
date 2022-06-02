package org.amrvimag.bocateria.events;

import org.amrvimag.bocateria.model.entity.Empleado;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class EmpleadoSearchEventHandler {
    
    public Empleado[] onSearch(String text, boolean ignoreCase, boolean contains) {
        return new Empleado[0];
    }
    
    public boolean onEmpleadoSelect(Empleado empleado) {
        
        return true; // True if the window should close after this method gets executed
    }
    
    public void onClose() {
        
    }
    
}
