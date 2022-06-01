package org.amrvimag.bocateria.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.amrvimag.bocateria.ResourceIO;
import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 * @param <E>
 */
public class ProductInfoRenderer<E extends Producto> extends ProductInfoPanel implements ListCellRenderer<Producto> {

    private final Color defaultColor;

    public ProductInfoRenderer() {
        super();
        defaultColor = super.getBackground();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Producto> list, Producto value, int index, boolean isSelected, boolean cellHasFocus) {
        super.setBackground(index % 2 == 0 ? defaultColor.brighter() : defaultColor.darker());
        super.setImage(value.getImg() == null ? ResourceIO.resourceImage("image/undefined.png", 32, 32) : value.getImg());
        super.setPrimaryText(value.getName());
        super.setSecondaryText(value.getType().getNombre());
        super.setDetailText(value.getPrice() + "€");

        return this;
    }

}
