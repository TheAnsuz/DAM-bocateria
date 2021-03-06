package org.amrvimag.bocateria.controller.events;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.amrvimag.bocateria.controller.ControllerDAO;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class VentasDiariasEventHandler {

    /**
     * Triggers when the ventas window is loaded
     *
     * @return The list of ventas that happened today
     */
    public List<Venta> onLoad() {
        if (ConnectionDB.getConnection() == null)
            return new ArrayList<>();

        ArrayList<Venta> ventasToday = new ArrayList<>();
        for (Venta v : ControllerDAO.getVentas()) {
            // Only the ventas that happened today will be displayed on the table
            if (v.getTimestamp().toLocalDateTime().getDayOfYear() == LocalDateTime.now().getDayOfYear())
                ventasToday.add(v);
        }
        return ventasToday;
    }

    public double getTotalVentas(List<Venta> ventas) {
        double val = 0;
        for (Venta venta : ventas)
            val += venta.getTotal();
        return val;
    }

}
