package tests;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Ticket;
import org.amrvimag.bocateria.model.entity.Venta;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class FormatTesting {

    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        productos
                .add(new Producto(Producto.Tipos.OTRO, 0, "Guacamole", 30, null));
        Producto producto = new Producto(Producto.Tipos.OTRO, 0, "hola", 55.65, null);
        Empleado emp = new Empleado("alpha", "Romeo", 100);
        Venta venta = new Venta(100, Timestamp.valueOf(LocalDateTime.now()), emp, 123123.45);
        Ticket ticket = new Ticket(venta,productos,true);
        System.out.println(ticket.getTicketText());
    }
}
