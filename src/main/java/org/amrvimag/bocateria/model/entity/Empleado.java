package org.amrvimag.bocateria.model.entity;

public class Empleado {

    private final String id;
    private String nombre;
    private double comision;

    public Empleado(String id, String nombre, double comision) {
        this.id = id;
        this.nombre = nombre;
        this.comision = comision;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
}
