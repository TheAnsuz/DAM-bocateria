package org.amrvimag.bocateria.model.entity;

import javax.swing.*;
import java.awt.image.BufferedImage;

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
        BOCADILLO("bocadillos", new ImageIcon()),
        BEBIDA("bebidas", new ImageIcon()),
        OTRO("otros", new ImageIcon());

        private Tipos(String nombre, ImageIcon icon) {
            this.nombre = nombre;
            this.icon = icon;
        }

        private String nombre;
        private ImageIcon icon;

        public String getNombre() {
            return nombre;
        }

        public ImageIcon getIcon() {
            return icon;
        }
    }
}
