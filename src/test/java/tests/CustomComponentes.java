package tests;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class CustomComponentes {

    private static final JFrame ventana = new JFrame();

    public static void main(String[] args) throws
            UnsupportedLookAndFeelException {
        ventana.setSize(500, 500);
        GridLayout layout = new GridLayout(0, 3);

        JPanel panel = new JPanel(layout);
        panel.setAutoscrolls(true);
        for (int i = 0; i < 20; i++) {
            panel.add(new JButton("Hola"));
        }

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.add(panel);
        ventana.setVisible(true);
    }

}
