package org.amrvimag.bocateria.controller;

import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Ticket;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.view.TicketDialog;
import org.amrvimag.bocateria.view.ViewWrapper;

import javax.swing.text.View;
import java.util.ArrayList;

public class MainController {

    private static MainController instance;

    private MainController() {}

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();

        return instance;
    }

    private ArrayList<Producto> currentProducts = new ArrayList<>();

    public ArrayList<Producto> getCurrentProducts() {
        return currentProducts;
    }

    public void clearCurrentVenta() {
        currentProducts = new ArrayList<>();
    }

    public void addCurrentVenta(Producto prod) {
        currentProducts.add(prod);
    }

    public void removeCurrentVenta(int index) {
        currentProducts.remove(index);
    }

    public double getTotalPrice() {
        double price = 0;
        for (Producto p : currentProducts)
            price += p.getPrice();

        return price;
    }

    public void pay(boolean card) {
        if (MainController.getInstance().getCurrentProducts().isEmpty())
            return;

        ControllerDAO.addVenta(ViewWrapper.getView().getEmpleado(), getTotalPrice());
        ArrayList<Venta> ventas = ControllerDAO.getVentas();
        Ticket ticket = new Ticket(ventas.get(ventas.size() -1), getCurrentProducts(), card);
        ViewWrapper.getView().showTicket(ticket);
        clearCurrentVenta();
    }
}
