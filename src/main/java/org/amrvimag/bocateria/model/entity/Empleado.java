package org.amrvimag.bocateria.model.entity;

public class Empleado {

    private final String id;
    private String name;
    private double comision;

    public Empleado(String id, String name, double comision) {
        this.id = id;
        this.name = name;
        this.comision = comision;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id='" + id + '\'' +
                ", nombre='" + name + '\'' +
                ", comision=" + comision +
                '}';
    }
}
