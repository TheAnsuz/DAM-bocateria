package org.amrvimag.bocateria.controller;

import org.amrvimag.bocateria.model.dao.EmpleadosDAO;
import org.amrvimag.bocateria.model.dao.ProductosDAO;
import org.amrvimag.bocateria.model.dao.VentasDAO;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.view.ViewWrapper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
        ArrayList<Venta> ventas =  new ArrayList<>();
        try {
            ventas = VentasDAO.getVentas();
        } catch (Exception e) {
            ViewWrapper.getView().showError(e);
        }
        return ventas;
    }

    public static void addVenta(Empleado emp, double total) {
        try {
            if (!VentasDAO.addVenta(emp, total))
                throw new Exception("No se ha podido añadir una venta");
        } catch (Exception e) {
            ViewWrapper.getView().showError(e);
        }
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
