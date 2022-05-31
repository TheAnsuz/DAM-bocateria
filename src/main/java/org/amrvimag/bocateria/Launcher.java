package org.amrvimag.bocateria;

import org.amrvimag.bocateria.model.dao.EmpleadosDAO;
import org.amrvimag.bocateria.model.dao.ProductosDAO;
import org.amrvimag.bocateria.model.dao.VentasDAO;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Ticket;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class Launcher {

    public static void main(String[] args) {

        ConnectionDB.createConnection("jdbc:mysql://localhost:3306/bocateria", "root", "");
        /*try {
            //ProductosDAO.PRUEBA();
            JFrame j = new JFrame();
            j.setIconImage(ProductosDAO.PRUEBAGET());
            j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            j.setSize(800, 800);

            JButton btt = new JButton();
            btt.setIcon(new ImageIcon(ProductosDAO.PRUEBAGET()));
            btt.setLocation(40, 40);
            btt.setSize(40, 20);
            btt.setVisible(true);
            j.add(btt);
            j.setVisible(true);

            //ConnectionDB.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        Producto[] prods = null;

        JFrame j = new JFrame();
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        j.setSize(800, 800);

        JButton btt = new JButton();
        btt.setLocation(40, 40);
        btt.setSize(40, 20);
        btt.setVisible(true);
        j.add(btt);
        j.setVisible(true);

        try {

            //if (ProductosDAO.addProducto(Producto.Tipos.BOCADILLO, "BOCADISHO DE CHORISO MESI", -69)) System.out.println("Mesi insertado");
            prods = ProductosDAO.getProductos(Producto.Tipos.BOCADILLO);
            //Producto mesi = null;
            for (Producto prod : prods) {
                //if (prod.getName().equals("BOCADISHO DE CHORISO MESI")) mesi = prod;
                System.out.println(prod);
            }
            btt.setIcon(new ImageIcon(prods[1].getImg()));
            //if (ProductosDAO.removeProducto(mesi)) System.out.println("Mesi borrado");
        } catch (SQLException | IOException e) { e.printStackTrace(); }

        System.out.println();

        try {
            if (EmpleadosDAO.addEmp("E4", "Mesi", 69)) System.out.println("Mesi insertado");
            Empleado[] emps = EmpleadosDAO.getAllEmps();
            Empleado mesi = null;
            for (Empleado emp : emps) {
                if (emp.getName().equals("Mesi")) mesi = emp;
                System.out.println(emp);
            }
            if (EmpleadosDAO.removeEmp(mesi)) System.out.println("Mesi borrado");
        } catch (SQLException e) { e.printStackTrace(); }

        System.out.println();

        try {
            Empleado marta = EmpleadosDAO.getEmp("E2");
            if (VentasDAO.addVenta(marta, 69)) System.out.println("Venta insertada");
            Venta[] ventas = VentasDAO.getVentas();
            for (Venta v : ventas) {
                   System.out.println(v);
                   ArrayList a = new ArrayList<Producto>();
                   a.add(prods[0]);
                    a.add(prods[0]);
                    a.add(prods[0]);
                a.add(prods[1]);
                   new Ticket(v, a);
            }

            ConnectionDB.getConnection().close();
        } catch (SQLException e) { e.printStackTrace(); }

    }
}
