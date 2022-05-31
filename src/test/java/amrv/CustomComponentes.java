package amrv;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import org.amrvimag.bocateria.view.TScrollPane;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class CustomComponentes {

    private static JButton selectedComponent = null;
    private static JFrame ventana = null;
    private static JScrollPane scroll = null;
    private static JPanel panel = null;

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        ventana = new JFrame();
        ventana.setSize(500, 500);
        scroll = new TScrollPane();
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setMaximumSize(new Dimension(panel.getSize().width, Short.MAX_VALUE));
        for (int i = 0; i < 25; i++) {
            JButton boton = new JButton("Boton " + i);
            boton.addActionListener((ActionEvent e) -> {
                if (boton.equals(selectedComponent))
                    selectedComponent = null;
                else
                    selectedComponent = boton;
                productTypeSelected(selectedComponent);
            });
            panel.add(boton);
        }
//        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panel);
//        final Dimension size = scroll.getHorizontalScrollBar().getPreferredSize();
//        size.setSize(size.getWidth(), 60);
//        scroll.getHorizontalScrollBar().setPreferredSize(size);
//        scroll.getHorizontalScrollBar().setSize(size);
//        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        ventana.add(scroll);
        System.out.println(panel.getComponentCount());
        System.out.println(panel.getSize());
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

    public static void productTypeSelected(JButton button) {
        System.out.println(button);
    }

    public static class MouseMotion extends MouseAdapter {

        private float multiplier = 1f;
        private Point start = null;

        @Override
        public void mousePressed(MouseEvent e) {
            start = e.getPoint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (start != null && !SwingUtilities.isLeftMouseButton(e)) {

                scroll.getHorizontalScrollBar().setValue(scroll.getHorizontalScrollBar().getValue() + Math.round(10 * (start.x > e.getX() ? multiplier : -multiplier)));
                
            }

            start = e.getPoint();
        }

    }
}
