package org.amrvimag.bocateria.view;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JScrollPane;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class JGrid<E> extends JScrollPane {

    private GridCellRenderer renderer;
    private List<E> items;
    private int rows;
    private int columns;

    public JGrid(E[] items) {
        this.items = new ArrayList<>(Arrays.asList(items));
    }

    @Override
    public void paintComponents(Graphics g) {
        for (E elem : items) {
            renderer.getGridCellComponent(this, elem, 0, WIDTH, true, true)
        }
    }

    public interface GridCellRenderer<E> {

        public Component getGridCellComponent(JGrid<? super E> grid, E element, int row, int column, boolean isSelected, boolean cellHasFocus);

    }

    private int getCellNum(int row, int column) {
        // nº columnas * fila actual + columna actual
        return columns * row + column;
    }

    public E getItem(int row, int column) {
        return items.get(getCellNum(row, column));
    }

    public E getItem(Point item) {
        return getItem(item.x, item.y);
    }

    public E getItem(int index) {
        return items.get(index);
    }

    private Point getCellPos(int index) {
        return new Point((int) index / columns, index % columns);
    }
}
