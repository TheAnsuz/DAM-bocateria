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
    
    public void employeeButtonClick() {
        ViewWrapper.getView().showEmpleadoSelector();
    }
    
    public void configurationButtonClick() {
        ViewWrapper.getView().showConfiguration();
    }
    
    public void pagarEffectivoButtonClick() {
        System.out.println("Click - pagar en efectivo");
    }
    
    public void pagarTarjetaButtonClick() {
        System.out.println("Click - pagar con tarjeta");
    }
    
    public void cancelarButtonClick() {
        System.out.println("Click - cancelar pedido");
    }
    
    public List<Producto> productTypeSelectButtonClick(Producto.Tipos type, boolean isSelected) {
        System.out.println("Click - " +(isSelected ? "seleccionada" : "desseleccionada") + " categoria" + type.getNombre());
        return new ArrayList<>();
    }
    
    public void addProductoItemButtonClick(int index, Producto producto) {
        System.out.println("Se quiere añadir el producto nº" + index + " de la lista: " + producto.getName());
    }
    
    public void removeProductoButtonClick(int index, Producto producto) {
        System.out.println("Se quiere eliminar el producto nº" + index + " de la lista: " + producto.getName());
    }
    
    public List<Producto> getLoadedProductos() {
        
        return new ArrayList<>();
    }
    
    public Map<Producto.Tipos,Image> loadProductTypes() {
        
        return new HashMap<>();
    }

}
