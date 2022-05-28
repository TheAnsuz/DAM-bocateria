package org.amrvimag.bocateria.model.entity;

import java.util.Date;

public class Venta {
    private final int id;
    private final Date date;
    private final Empleado emp;
    private final double total;

    public Venta(int id, Date date, Empleado emp, double total) {
        this.id = id;
        this.date = date;
        this.emp = emp;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Empleado getEmp() {
        return emp;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", date=" + date +
                ", emp=" + emp +
                ", total=" + total +
                '}';
    }
}
