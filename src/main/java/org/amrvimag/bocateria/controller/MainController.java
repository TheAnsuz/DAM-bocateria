package org.amrvimag.bocateria.controller;

import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Ticket;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.view.TicketDialog;

import java.util.ArrayList;

public class MainController {

    private static MainController instance;

    private MainController() {}

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();

        return instance;
    }

    private ArrayList<Producto> currentVenta = new ArrayList<>();

    private Empleado currentEmpleado;

    public ArrayList<Producto> getCurrentVenta() {
        return currentVenta;
    }

    public void clearCurrentVenta() {
        currentVenta = new ArrayList<>();
    }

    public void addCurrentVenta(Producto prod) {
        currentVenta.add(prod);
    }

    public void removeCurrentVenta(int index) {
        currentVenta.remove(index);
    }

    public double getTotalPrice() {
        double price = 0;
        for (Producto p : currentVenta)
            price += p.getPrice();

        return price;
    }

    public Empleado getCurrentEmpleado() {
        return currentEmpleado;
    }

    public void setCurrentEmpleado(Empleado currentEmpleado) {
        MainController.getInstance().currentEmpleado = currentEmpleado;
    }

    public void pay(boolean card) {
        if (MainController.getInstance().getCurrentVenta().isEmpty())
            return;

        ControllerDAO.addVenta(getCurrentEmpleado(), getTotalPrice());
        ArrayList<Venta> ventas = ControllerDAO.getVentas();
        Ticket ticket = new Ticket(ventas.get(ventas.size() -1), getCurrentVenta(), card);
        new TicketDialog(ticket.generateText()).setVisible(true);
        clearCurrentVenta();
    }
}
