package org.amrvimag.bocateria.model.dao;

import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadosDAO {

    /**
     * Gets an array of all the employees
     * @return The array of employees
     * @throws SQLException
     */
    public static ArrayList<Empleado> getAllEmps() throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM empleados";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();

        ArrayList<Empleado> emps = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            double comision = rs.getDouble(3);
            emps.add(new Empleado(id, name, comision));
        }

        return emps;
    }

    /**
     * Gets the employee with the specified ID
     * @param id The ID of the employee
     * @return The employee with the specified ID
     * @throws SQLException
     */
    public static Empleado getEmp(String id) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM empleados WHERE id_empleado=?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, id);
        ResultSet rs = pst.executeQuery();

        Empleado emp = null;
        if (rs.next()) {
            String name = rs.getString(2);
            double comision = rs.getDouble(3);
            emp = new Empleado(id, name, comision);
        }

        return emp;
    }
}
