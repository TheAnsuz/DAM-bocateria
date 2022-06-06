package org.amrvimag.bocateria.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import org.amrvimag.bocateria.model.dao.EmpleadosDAO;
import org.amrvimag.bocateria.model.dao.ProductosDAO;
import org.amrvimag.bocateria.model.dao.VentasDAO;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.view.ViewWrapper;

public class ControllerDAO {

    public static ArrayList<Producto> getAllProductos(Producto.Tipos type) {
        ArrayList<Producto> prods = new ArrayList<>();
        try {
            prods = ProductosDAO.getProductos(type);
        } catch (Exception e) {
            ViewWrapper.getView().showError(e);
        }
        return prods;
    }

    public static ArrayList<Venta> getVentas() {
        ArrayList<Venta> ventas = new ArrayList<>();
        try {
            ventas = VentasDAO.getVentas();
        } catch (Exception e) {
            ViewWrapper.getView().showError(e);
        }
        return ventas;
    }

    public static boolean addVenta(Empleado emp, double total) {
        if (total > 999.99) {
            ViewWrapper.getView().showWarning("Las ventas no pueden ser superiores a 999.99€");
            return false;
        }
        try {
            if (!VentasDAO.addVenta(emp, total))
                throw new Exception("No se ha podido añadir una venta");
        } catch (Exception e) {
            ViewWrapper.getView().showError(e);
            return false;
        }
        return true;
    }

    public static ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado> emps = new ArrayList<>();
        try {
            emps = EmpleadosDAO.getAllEmps();
        } catch (SQLException e) {
            ViewWrapper.getView().showError(e);
        }
        return emps;
    }

}
