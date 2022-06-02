package org.amrvimag.bocateria.events;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.amrvimag.bocateria.model.entity.Producto;
import org.amrvimag.bocateria.view.ViewWrapper;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class MainframeEventHandler {

    /**
     * Evento al hacer click en el boton empleado
     */
    public void employeeButtonClick() {
        ViewWrapper.getView().showEmpleadoSelector();
    }

    /**
     * Evento al hacer click en el boton configuracion
     */
    public void configurationButtonClick() {
        ViewWrapper.getView().showConfiguration();
    }

    /**
     * Evento al hacer click en el boton de pagar con efectivo
     */
    public void pagarEffectivoButtonClick() {
        System.out.println("Click - pagar en efectivo");
    }

    /**
     * Evento al hacer click en el boton pagar con tarjeta
     */
    public void pagarTarjetaButtonClick() {
        System.out.println("Click - pagar con tarjeta");
    }

    /**
     * Evento al hacer click en el boton de cancelar pedido
     */
    public void cancelarButtonClick() {
        System.out.println("Click - cancelar pedido");
    }

    /**
     * Evento al seleccionar un tipo de producto, devuelve la lista de productos
     * que aparecerán al hacer click en ese producto
     *
     * @param type el tipo de producto
     * @param isSelected si esta seleccionandose o desseleccionandose
     * @return una lista con todos los productos de ese tipo
     */
    public List<Producto> productTypeSelectButtonClick(Producto.Tipos type, boolean isSelected) {
        System.out
                .println("Click - " + (isSelected ? "seleccionada" : "desseleccionada") + " categoria" + type
                        .getNombre());
        return new ArrayList<>();
    }

    /**
     * Evento al hacer click en un producto para agregarlo a los productos de la
     * venta
     *
     * @param index indice del producto en la lista de productos
     * @param producto referencia al producto en la lista
     */
    public void addProductoItemButtonClick(int index, Producto producto) {
        System.out
                .println("Se quiere añadir el producto nº" + index + " de la lista: " + producto
                        .getName());
    }

    /**
     * Evento al hacer click en un producto para eliminarlo de la lista de
     * productos de la venta (al hacer click en la lista de la izquierda)
     *
     * @param index indice del producto en la lista de venta
     * @param producto referencia del producto en la lista de ventas
     */
    public void removeProductoButtonClick(int index, Producto producto) {
        System.out
                .println("Se quiere eliminar el producto nº" + index + " de la lista: " + producto
                        .getName());
    }

    /**
     * Obtiene los productos que deben aparecer en la venta
     *
     * @return los productos que tendrá la venta
     */
    public List<Producto> getLoadedProductos() {

        return new ArrayList<>();
    }

    /**
     * Evento que se ejecuta cuando cargan los tipos de productos, sirve para
     * devolver los tipos de productos que deben de cargarse asi como la imagen
     * que los representa
     *
     * @return un mapa con el tipo de producto y su imagen
     */
    public Map<Producto.Tipos, Image> loadProductTypes() {

        return new HashMap<>();
    }

}
