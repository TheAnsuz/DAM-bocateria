package org.amrvimag.bocateria.view;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import org.amrvimag.bocateria.ResourceIO;
import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 * @param <E>
 */
public class ProductInfoRenderer<E extends Producto> extends ProductInfoPanel implements ListCellRenderer<Producto> {

    public ProductInfoRenderer() {
        super();
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Producto> list, Producto value, int index, boolean isSelected, boolean cellHasFocus) {
        Color defaultColor = UIManager.getDefaults().getColor("List.background");
        super
                .setBackground(index % 2 == 0 ? defaultColor.brighter() : defaultColor
                        .darker());
        if (isSelected)
            super.setBackground(index % 2 == 0 ? super.getBackground()
                    .brighter() : super.getBackground().darker());
        super.setImage(value.getImg() == null ? ResourceIO
                .resourceImage("image/undefined.png", 64, 64) : value.getImg());
        super.setPrimaryText(value.getName());
        super.setSecondaryText(value.getType().getNombre());
        super.setDetailText(value.getPrice() + "€");

        return this;
    }

}
