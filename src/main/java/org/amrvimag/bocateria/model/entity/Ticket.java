package org.amrvimag.bocateria.model.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticket {

    private final int id;
    private final String employee;
    private final Date date;
    private final HashMap<Producto, Integer> prods = new HashMap<>();
    private final double price;
    private final boolean tarjeta;

    public Ticket(Venta venta, List<Producto> prods, boolean tarjeta) {
        this.id = venta.getId();
        this.date = venta.getTimestamp();
        this.employee = venta.getEmp().getName();
        getProdsInMap(prods);
        this.price = venta.getTotal();
        this.tarjeta = tarjeta;

        System.out.println(generateText());
    }

    private void getProdsInMap(List<Producto> prods) {
        for (Producto p : prods) {
            System.out.println(p + " : " + (this.prods.containsKey(p) ? "Ya existe" : "No existe"));
            if (!this.prods.containsKey(p)) {
                this.prods.put(p, 1);
            }
            else {
                this.prods.replace(p, this.prods.get(p) + 1);
            }
        }
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

    public Date getDate() {
        return date;
    }

    public String generateText() {
        StringBuilder ticket = new StringBuilder();
        ticket.append("=======================================\n");
        ticket.append(String.format("%24s %n", "Bocatería"));
        ticket.append("=======================================\n");
        ticket.append("Le atendió: ").append(employee).append("\n");
        ticket.append("ID: ").append(id).append("\n");
        ticket.append("***************************************\n\n");
        ticket.append("Producto              Cant.     Precio\n");
        ticket.append("--------              -----     -------\n");
        for (Map.Entry<Producto, Integer> e : prods.entrySet()) {
            Producto p = e.getKey();
            Integer c = e.getValue();
            ticket.append(String.format("%-21s %5s %11s%n", p.getName(), c, p.getPrice() * c + "€"));
        }
        ticket.append("---------------------------------------\n");
        ticket.append("Precio total: ").append(price).append("€").append("\n");
        ticket.append("Modo de pago: ").append(tarjeta ? "tarjeta" : "en efectivo").append("\n");
        ticket.append("\n");
        ticket.append("=======================================\n");
        ticket.append(String.format("%31s %n", "¡Gracias por su compra!"));
        ticket.append("=======================================\n");
        return ticket.toString();
    }

}
