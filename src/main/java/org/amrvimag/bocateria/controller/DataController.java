package org.amrvimag.bocateria.controller;

import java.util.ArrayList;
import org.amrvimag.bocateria.Configuration;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Ticket;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;
import org.amrvimag.bocateria.view.ViewWrapper;

public class DataController implements Configuration.ConfigurationListener {

    private static DataController instance;

    private DataController() {
    }

    public static DataController getInstance() {
        if (instance == null) {
            instance = new DataController();
            Configuration.addListener(instance);
        }
        return instance;
    }

    private ArrayList<Producto> addedProducts = new ArrayList<>();

    public ArrayList<Producto> getAddedProducts() {
        return addedProducts;
    }

    public void clearAddedProducts() {
        addedProducts = new ArrayList<>();
    }

    public void addAddedProducts(Producto prod) {
        addedProducts.add(prod);
    }

    public void removeAddedProducts(int index) {
        addedProducts.remove(index);
    }

    public double getTotalPrice() {
        double price = 0;
        for (Producto p : addedProducts)
            price += p.getPrice();

        return price;
    }

    public void pay(boolean card) {
        if (addedProducts.isEmpty())
            return;

        ControllerDAO.addVenta(ViewWrapper.getView().getEmpleado(), getTotalPrice());
        ArrayList<Venta> ventas = ControllerDAO.getVentas();
        Ticket ticket = new Ticket(ventas.get(ventas.size() - 1), addedProducts, card);
        ViewWrapper.getView().showTicket(ticket);
        clearAddedProducts();
    }

    @Override
    public void onChange(String key, String oldValue, String newValue) {
        String url = Configuration.getConfig("sql.url");
        String user = Configuration.getConfig("sql.username");
        String pass = Configuration.getConfig("sql.password");

        switch (key) {
            case "sql.url":
                url = newValue;
                break;
            case "sql.username":
                user = newValue;
                break;
            case "sql.password":
                pass = newValue;
                break;
        }
        ConnectionDB.updateDatabaseConfig(url, user, pass);
    }
}
