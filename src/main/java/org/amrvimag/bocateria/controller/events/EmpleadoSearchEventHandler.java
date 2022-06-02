package org.amrvimag.bocateria.controller.events;

import org.amrvimag.bocateria.controller.ControllerDAO;
import org.amrvimag.bocateria.model.entity.Empleado;

import java.util.ArrayList;
import org.amrvimag.bocateria.view.ViewWrapper;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class EmpleadoSearchEventHandler {
    
    public Empleado[] onSearch(String text, boolean ignoreCase, boolean contains) {
        ArrayList<Empleado> empleados = ControllerDAO.getEmpleados();

        if (text.isEmpty()) return empleados.toArray(new Empleado[0]);

        ArrayList<Empleado> results = new ArrayList<>();
        if (ignoreCase) text = text.toLowerCase();
        for (Empleado emp: empleados) {
            String empName = emp.getName();
            if (ignoreCase) empName = empName.toLowerCase();
            if (contains && empName.contains(text))
                results.add(emp);
            if (!contains && empName.startsWith(text))
                results.add(emp);
        }

        return results.toArray(new Empleado[0]);
    }
    
    public boolean onEmpleadoSelect(Empleado empleado) {
        ViewWrapper.getView().setEmpleado(empleado);
        return true; // True if the window should close after this method gets executed
    }
    
    public void onClose() {
        
    }
    
}
