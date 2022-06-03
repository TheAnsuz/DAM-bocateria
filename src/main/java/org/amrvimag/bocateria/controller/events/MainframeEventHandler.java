package org.amrvimag.bocateria.controller.events;

import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.amrvimag.bocateria.controller.ControllerDAO;
import org.amrvimag.bocateria.controller.DataController;
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

    public void ventasButtonClick() {
        ViewWrapper.getView().showVentas();
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
    public boolean pagarEffectivoButtonClick() {
        if (ViewWrapper.getView().getEmpleado() == null)
            return false;
        DataController.getInstance().pay(false);
        return true;
    }

    /**
     * Evento al hacer click en el boton pagar con tarjeta
     */
    public boolean pagarTarjetaButtonClick() {
        if (ViewWrapper.getView().getEmpleado() == null)
            return false;
        DataController.getInstance().pay(true);
        return true;
    }

    /**
     * Evento al hacer click en el boton de cancelar pedido
     */
    public void cancelarButtonClick() {
        DataController.getInstance().clearAddedProducts();
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
        return ControllerDAO.getAllProductos(type);
    }

    /**
     * Evento al hacer click en un producto para agregarlo a los productos de la
     * venta
     *
     * @param index indice del producto en la lista de productos
     * @param producto referencia al producto en la lista
     */
    public void addProductoItemButtonClick(int index, Producto producto) {
        DataController.getInstance().addAddedProducts(producto);
    }

    /**
     * Evento al hacer click en un producto para eliminarlo de la lista de
     * productos de la venta (al hacer click en la lista de la izquierda)
     *
     * @param index indice del producto en la lista de venta
     * @param producto referencia del producto en la lista de ventas
     */
    public void removeProductoButtonClick(int index, Producto producto) {
        DataController.getInstance().removeAddedProducts(index);
    }

    /**
     * Obtiene los productos que deben aparecer en la venta
     *
     * @return los productos que tendrá la venta
     */
    public List<Producto> getLoadedProductos() {
        return DataController.getInstance().getAddedProducts();
    }

    /**
     * Evento que se ejecuta cuando cargan los tipos de productos, sirve para
     * devolver los tipos de productos que deben de cargarse asi como la imagen
     * que los representa
     *
     * @return un mapa con el tipo de producto y su imagen
     */
    public Map<Producto.Tipos, Image> loadProductTypes() {
        Map<Producto.Tipos, Image> map = new HashMap<>();

        for (Producto.Tipos prod : Producto.Tipos.values()) {
            map.put(prod, prod.getImage());
        }
        return map;
    }

}
