package org.amrvimag.bocateria.model.dao;

import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Venta;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class VentasDAO {

    /**
     * Gets an array with all the sales stored in the database
     * @return An array with al the sales
     * @throws SQLException
     */
    public static Venta[] getVentas() throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM ventas";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ArrayList<Venta> ventasList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            Date date = rs.getDate(2);
            String idEmp = rs.getString(3);
            double total = rs.getDouble(4);
            ventasList.add(new Venta(id, date, EmpleadosDAO.getEmp(idEmp), total));
        }

        return ventasList.toArray(new Venta[0]);
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
        pst.setDate(1, new java.sql.Date(new Date().getTime()));
        pst.setString(2, emp.getId());
        pst.setDouble(3, total);

        return pst.executeUpdate() > 0;
    }
}
