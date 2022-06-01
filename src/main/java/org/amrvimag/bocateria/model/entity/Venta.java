package org.amrvimag.bocateria.model.entity;

import java.sql.Timestamp;

public class Venta {
    private final int id;
    private final Timestamp timestamp;
    private final Empleado emp;
    private final double total;

    public Venta(int id, Timestamp date, Empleado emp, double total) {
        this.id = id;
        this.timestamp = date;
        this.emp = emp;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
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
               ", timestamp=" + timestamp +
               ", emp=" + emp +
               ", total=" + total +
               '}';
    }
}
