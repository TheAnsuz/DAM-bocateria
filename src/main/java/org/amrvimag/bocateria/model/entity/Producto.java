package org.amrvimag.bocateria.model.entity;

import org.amrvimag.bocateria.ResourceIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Producto {

    private final Producto.Tipos type;
    private final int id;
    private String name;
    private double price;
    private BufferedImage img;

    public Producto(Producto.Tipos type, int id, String name, double price, BufferedImage img) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public Producto.Tipos getType() {
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

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "type='" + type.getNombre() + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public enum Tipos {
        BOCADILLO("bocadillos", ResourceIO.resourceImage("image/bocadillo.png")),
        BEBIDA("bebidas", ResourceIO.resourceImage("image/bebidas.png")),
        OTRO("otros", ResourceIO.resourceImage("image/otros.png"));

        Tipos(String nombre, Image image) {
            this.nombre = nombre;
            this.image = image;
        }

        private String nombre;
        private Image image;

        public String getNombre() {
            return nombre;
        }

        public Image getImage() {
            return image;
        }
    }

    // The equals and hashCode are necessary for the HashMap in Ticket to sort the products correctly
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return id == producto.id && type == producto.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id);
    }
}
