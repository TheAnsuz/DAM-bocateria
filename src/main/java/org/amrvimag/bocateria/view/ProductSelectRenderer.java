package org.amrvimag.bocateria.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import org.amrvimag.bocateria.ResourceIO;
import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 * @param <E> producto
 */
public class ProductSelectRenderer<E extends Producto> extends JPanel implements ListCellRenderer<Producto> {

    private static final Color FOCUS_COLOR = new Color(220, 200, 120);

    private final JPanel innerPanel = new JPanel(new BorderLayout(10, 10));
    private final JLabel productLabel = new JLabel("");
    private final JLabel productoInfo = new JLabel("");
    private final Color defaultColor;
    private final Color defaultBackground;

    public ProductSelectRenderer() {
        final Font font = super.getFont();

        productLabel.setFont(new Font(font.getName(), Font.PLAIN, 24));

        productoInfo.setBorder(new EmptyBorder(0, 0, 0, 10));
        productoInfo
                .setFont(new Font(font.getName(), Font.BOLD + Font.ITALIC, 24));

        innerPanel.add(productLabel, BorderLayout.LINE_START);
        innerPanel.add(productoInfo, BorderLayout.LINE_END);
        innerPanel.setBorder(new RoundedBorder(8));

        defaultColor = productLabel.getForeground();
        defaultBackground = innerPanel.getBackground();

        super.setLayout(new GridLayout(1, 1));
        super.setOpaque(false);
        super.setBackground(new Color(0, 0, 0, 0));
        super.add(innerPanel);
        super.setBorder(new EmptyBorder(10, 5, 10, 5));
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Producto> list, Producto value, int index, boolean isSelected, boolean cellHasFocus) {
        productLabel.setIcon(new ImageIcon(ResourceIO
                .resourceImage("image/default.png", 96, 96)));
        productLabel.setText(value.getName());
        productoInfo.setText(value.getPrice() + "€");
        if (cellHasFocus) {
            productLabel.setForeground(FOCUS_COLOR);
            productoInfo.setForeground(FOCUS_COLOR);
        } else {
            productLabel.setForeground(defaultColor);
            productoInfo.setForeground(defaultColor);
        }

        if (isSelected)
            innerPanel.setBackground(innerPanel.getBackground().darker());
        else
            innerPanel.setBackground(defaultBackground);

        return this;
    }

}
