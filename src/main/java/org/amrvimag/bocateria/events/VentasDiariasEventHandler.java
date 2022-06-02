package org.amrvimag.bocateria.events;

import java.util.ArrayList;
import java.util.List;

import org.amrvimag.bocateria.controller.ControllerDAO;
import org.amrvimag.bocateria.model.entity.Venta;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class VentasDiariasEventHandler {

    public List<Venta> onLoad() {
        System.out.println(ControllerDAO.getVentas());
        return ControllerDAO.getVentas();
    }
    
}
