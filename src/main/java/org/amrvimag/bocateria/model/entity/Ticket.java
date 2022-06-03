package org.amrvimag.bocateria.model.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

    private final int id;
    private final String employee;
    private final Timestamp time;
    private final HashMap<Producto, Integer> prods;
    private final double price;
    private final boolean tarjeta;

    public Ticket(Venta venta, List<Producto> prods, boolean tarjeta) {
        this.id = venta.getId();
        this.time = venta.getTimestamp();
        this.employee = venta.getEmp().getName();
        this.prods = getProdQuantities(prods);
        this.price = venta.getTotal();
        this.tarjeta = tarjeta;
    }

    private HashMap<Producto, Integer> getProdQuantities(List<Producto> prods) {
        HashMap<Producto, Integer> map = new HashMap<>();
        for (Producto p : prods) {
            if (!map.containsKey(p))
                map.put(p, 1);
            else
                map.replace(p, map.get(p) + 1);
        }
        return map;
    }

    public int getId() {
        return id;
    }

    public String getEmployee() {
        return employee;
    }

    public HashMap<Producto, Integer> getProds() {
        return prods;
    }

    public Timestamp getTime() {
        return time;
    }

    private void appendProduct(StringBuilder builder, Producto producto, Integer ammount) {

        while (producto.getPrice() * ammount > 999) {
            int cantidad = 1;
            double precio = 1;
            builder.append(
                    String.format("%-21s %5s %11s%n",
                            producto.getName(), cantidad, precio * cantidad + "€")
            );

        }

    }

    public String getTicketText() {
        String timeFormatted = new SimpleDateFormat("dd/MM HH:mm:ss").format(time);
        StringBuilder ticket = new StringBuilder();
        ticket.append("=======================================\n");
        ticket.append(String.format("%24s %n", "Bocatería"));
        ticket.append("=======================================\n");
        ticket.append("Le atendió: ").append(employee).append("\n");
        ticket.append("A día ").append(timeFormatted).append("\n");
        ticket.append("ID: ").append(id).append("\n");
        ticket.append("***************************************\n\n");
        ticket.append("Producto              Cant.      Precio\n");
        ticket.append("--------              -----     -------\n");
        for (Map.Entry<Producto, Integer> e : prods.entrySet()) {
            appendProduct(ticket, e.getKey(), e.getValue());
        }
        ticket.append("---------------------------------------\n");
        ticket.append(String.format("%40s", price + "€\n"));
        ticket.append("Modo de pago: ").append(tarjeta ? "tarjeta" : "en efectivo").append("\n");
        ticket.append("\n");
        ticket.append("=======================================\n");
        ticket.append(String.format("%31s %n", "¡Gracias por su compra!"));
        ticket.append("=======================================\n");
        return ticket.toString();
    }

}
