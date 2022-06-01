package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.amrvimag.bocateria.model.dao.EmpleadosDAO;
import org.amrvimag.bocateria.model.dao.ProductosDAO;
import org.amrvimag.bocateria.model.dao.VentasDAO;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ConnectionTest {

    public static void main(String[] args) {

        ConnectionDB
                .createConnection("jdbc:mysql://localhost:3306/bocateria", "root", "");

        try {
            if (ProductosDAO
                    .addProducto(Producto.Tipos.BOCADILLO, "BOCADISHO DE CHORISO MESI", -69,new File("")))
                System.out.println("Mesi insertado");
            Producto[] prods = ProductosDAO.getProductos(Producto.Tipos.BEBIDA);
            Producto mesi = null;
            for (Producto prod : prods) {
                if (prod.getName().equals("BOCADISHO DE CHORISO MESI"))
                    mesi = prod;
                System.out.println(prod);
            }
            if (ProductosDAO.removeProducto(mesi))
                System.out.println("Mesi borrado");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println();

        try {
            if (EmpleadosDAO.addEmp("E4", "Mesi", 69))
                System.out.println("Mesi insertado");
            Empleado[] emps = EmpleadosDAO.getAllEmps();
            Empleado mesi = null;
            for (Empleado emp : emps) {
                if (emp.getName().equals("Mesi"))
                    mesi = emp;
                System.out.println(emp);
            }
            if (EmpleadosDAO.removeEmp(mesi))
                System.out.println("Mesi borrado");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            Empleado marta = EmpleadosDAO.getEmp("E2");
            if (VentasDAO.addVenta(marta, 69))
                System.out.println("Venta insertada");
            Venta[] ventas = VentasDAO.getVentas();
            for (Venta v : ventas) {
                System.out.println(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
