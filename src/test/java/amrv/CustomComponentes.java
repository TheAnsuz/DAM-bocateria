package amrv;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import org.amrvimag.bocateria.swing.ASearchBox;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class CustomComponentes {
 
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        FlatDarkLaf.setup();
        UIManager.setLookAndFeel(new FlatDarkLaf());
        
        JFrame base = new JFrame("Prueba");
        ASearchBox box = new ASearchBox();
        box.addItem("Hola");
        box.addItem("Que tal");
        box.setEditable(true);
        
        base.setSize(500,500);
        base.add(box,BorderLayout.NORTH);
        base.setLocationRelativeTo(null);
        base.setVisible(true);
        base.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
