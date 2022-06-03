package org.amrvimag.bocateria.model.dao;

import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class VentasDAO {

    /**
     * Gets an array with all the sales stored in the database
     * @return An array with al the sales
     * @throws SQLException
     */
    public static ArrayList<Venta> getVentas() throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM ventas";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ArrayList<Venta> ventas = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            Timestamp date = rs.getTimestamp(2);
            String idEmp = rs.getString(3);
            double total = rs.getDouble(4);
            ventas.add(new Venta(id, date, EmpleadosDAO.getEmp(idEmp), total));
            System.out.println(new Venta(id, date, EmpleadosDAO.getEmp(idEmp), total));
        }
        return ventas;
    }

    /**
     * Adds a new sale to the database
     * @param emp The eployee that carried out the sale
     * @param total The money of the sale
     * @return Whether the operation has been carried out successfully
     * @throws SQLException
     */
    public static boolean addVenta(Empleado emp, double total) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String update = "INSERT INTO ventas VALUES(null, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setTimestamp(1, new java.sql.Timestamp(new Date().getTime()));
        pst.setString(2, emp.getId());
        pst.setDouble(3, total);
//        System.out.println("VENTA AÑADIDA");

        return pst.executeUpdate() > 0;
    }
}
