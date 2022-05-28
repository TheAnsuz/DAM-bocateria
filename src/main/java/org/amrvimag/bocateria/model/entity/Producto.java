package org.amrvimag.bocateria.model.entity;

public class Producto {

    private final String type;
    private final int id;
    private String name;
    private double price;

    public Producto(String type, int id, String name, double price) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
