package org.amrvimag.bocateria.view;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.amrvimag.bocateria.ResourceIO;
import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 * @param <E> producto
 */
public class ProductSelectRenderer<E extends Producto> extends ProductSelectPanel implements ListCellRenderer<Producto> {

    public ProductSelectRenderer() {
        super();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Producto> list, Producto value, int index, boolean isSelected, boolean cellHasFocus) {
        super.setImage(value.getImg() == null ? ResourceIO
                .resourceImage("image/undefined.png", 64, 64) : value.getImg());
        super.setName(value.getName());
        super.setCost(value.getPrice());

        super.setSelected(isSelected);

        return this;
    }

}
