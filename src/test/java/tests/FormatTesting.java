package tests;

import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class FormatTesting {

    public static void main(String[] args) {
        Producto producto = new Producto(Producto.Tipos.OTRO, 0, "hola", 55.65, null);
        int ammount = 934;

        StringBuilder builder = new StringBuilder();

        final double cantidadMaxima = Math.floor(999 / producto
                .getPrice());

        while (ammount > cantidadMaxima) {
            ammount -= cantidadMaxima;
            builder.append(String.format("%-21s %5s %11s%n",
                    producto.getName(), cantidadMaxima, producto.getPrice() * cantidadMaxima + "€")
            );
        }

        if (ammount > 0)
            builder.append(String.format("%-21s %5s %11s%n",
                    producto.getName(), ammount, producto.getPrice() * ammount + "€")
            );

        System.out.println(builder.toString());
    }
}
