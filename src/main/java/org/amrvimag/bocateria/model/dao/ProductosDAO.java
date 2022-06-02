package org.amrvimag.bocateria.model.dao;

import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.model.resources.ConnectionDB;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class ProductosDAO {

    /**
     * Gets the products that belong to a specific type of product
     * @param type  The product type (name of the table)
     * @return The array of products present in that table
     * @throws SQLException
     */
    public static ArrayList<Producto> getProductos(Producto.Tipos type) throws SQLException, IOException {
        Connection con = ConnectionDB.getConnection();
        String query = "SELECT * FROM " + type.getNombre();
        PreparedStatement pst = con.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        ArrayList<Producto> prods = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double price = rs.getDouble(3);
            Blob b = rs.getBlob(4);
            BufferedImage img = ImageIO.read(b.getBinaryStream());
            prods.add(new Producto(type, id, name, price, img));
        }

        return prods;
    }
}
