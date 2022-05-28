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
    public static Empleado[] getAllEmps() throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM empleados";
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ArrayList<Empleado> empList = new ArrayList<>();
        while (rs.next()) {
            String id = rs.getString(1);
            String name = rs.getString(2);
            double comision = rs.getDouble(3);
            empList.add(new Empleado(id, name, comision));
        }

        return empList.toArray(new Empleado[0]);
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

    /**
     * Adds a new employee to the database
     * @param id The ID of the employee
     * @param name The name of the employee
     * @param comision The comission of the employee
     * @return Whether the operation has been carried out successfully
     * @throws SQLException
     */
    public static boolean addEmp(String id, String name, double comision) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String update = "INSERT INTO empleados VALUES(?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setString(1, id);
        pst.setString(2, name);
        pst.setDouble(3, comision);

        return pst.executeUpdate() > 0;
    }

    /**
     * Removes an employee from the database
     * @param emp The employee to remove
     * @return Whether the operation has been carried out successfully
     * @throws SQLException
     */
    public static boolean removeEmp(Empleado emp) throws SQLException {
        return removeEmp(emp.getId());
    }

    /**
     * Removes an employee from the database
     * @param id The employee to remove
     * @return Whether the operation has been carried out successfully
     * @throws SQLException
     */
    public static boolean removeEmp(String id) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String update = "DELETE FROM empleados WHERE id_empleado=?";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setString(1, id);

        return pst.executeUpdate() > 0;
    }
}
