package org.amrvimag.bocateria.model.dao;

import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductosDAO {

    /**
     * Gets the products that belong to a specific type of product
     * @param type  The product type (name of the table)
     * @return The array of products present in that table
     * @throws SQLException
     */
    public static Producto[] getProductos(String type) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM " + type;
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ArrayList<Producto> prodList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double price = rs.getDouble(3);
            prodList.add(new Producto(type, id, name, price));
        }

        return prodList.toArray(new Producto[0]);
    }

    /**
     * Adds a new product to the database
     * @param type The product type (name of the table)
     * @param name The name of the product
     * @param price The price of the product
     * @return Whether the operation was carried out successfully
     * @throws SQLException
     */
    public static boolean addProducto(String type, String name, double price) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String update = "INSERT INTO " + type + " ";
        update += "VALUES(null, ?, ?)";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setString(1, name);
        pst.setDouble(2, price);

        return pst.executeUpdate() > 0;
    }

    /**
     * Removes a product from the database
     * @param prod Product to remove
     * @return Whether the operation was carried out successfully
     * @throws SQLException
     */
    public static boolean removeProducto(Producto prod) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        String update = "DELETE FROM " + prod.getType();
        // We need to get the name of the primary key, because every product table has a
        // different name for it
        update += " WHERE " + getTablePK(prod.getType()) + "=?";
        PreparedStatement pst = con.prepareStatement(update);
        pst.setInt(1, prod.getId());

        return pst.executeUpdate() > 0;
    }


    /**
     * Gets the name of the column which is primary key of the given table
     * @param type The product type (name of the table)
     * @return The name of the primary key column
     * @throws SQLException
     */
    private static String getTablePK(String type) throws SQLException {
        Connection con = ConnectionDB.getConnection();
        ResultSet rs = con.getMetaData().getPrimaryKeys(null, null, type);
        rs.next();
        return rs.getString(4);
    }

}