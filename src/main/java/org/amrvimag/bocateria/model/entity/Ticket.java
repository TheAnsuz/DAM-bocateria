package org.amrvimag.bocateria.model.entity;

import java.util.Date;
import java.util.List;

public class Ticket {

    private final int id;
    private final String employee;
    private final Date date;
    private final List<Producto> products;

    public Ticket(Venta venta, List<Producto> prods) {
        this.id = venta.getId();
        this.date = venta.getDate();
        this.employee = venta.getEmp().getName();
        this.products = prods;
    }

    public int getId() {
        return id;
    }

    public String getEmployee() {
        return employee;
    }

    public List<Producto> getProducts() {
        return products;
    }

    public Date getDate() {
        return date;
    }
}
