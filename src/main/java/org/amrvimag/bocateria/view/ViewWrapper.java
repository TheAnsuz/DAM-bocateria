package org.amrvimag.bocateria.view;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import org.amrvimag.bocateria.Configuration;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Ticket;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ViewWrapper implements Configuration.ConfigurationListener {

    private final DecimalFormat numberFormatter = new DecimalFormat("#,##0.00 \u00A4");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static ViewWrapper wrapper;
    private static String selectedLookAndFeel = "System Default";
    private static final String[] supportedLookAndFeels = new String[]{
        "FlatDarkLaf", "FlatLightLaf", "Nimbus", "Metal", "FlatIntelliJLaf",
        "System Default"};

    public static void initialize() {
        if (wrapper == null) {
            wrapper = new ViewWrapper();
            Configuration.addListener(wrapper);
        }
    }

    public static ViewWrapper getView() {
        initialize();

        return wrapper;
    }

    public void setEmpleado(Empleado emp) {
        mainframe.setEmpleado(emp);
    }

    public Empleado getEmpleado() {
        return mainframe.getEmpleado();
    }

    public static String getSelectedLookAndFeel() {
        return selectedLookAndFeel;
    }

    public static String[] getSupportedLookAndFeels() {
        return supportedLookAndFeels;
    }

    public static void setLookAndFeel(String laf) throws
            UnsupportedLookAndFeelException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        switch (laf) {
            case "FlatDarkLaf":
            case "FlatDark":
                FlatDarkLaf.setup();
                UIManager.setLookAndFeel(new FlatDarkLaf());
                selectedLookAndFeel = "FlatDarkLaf";
                break;
            case "FlatLight":
            case "FlatLightLaf":
                FlatLightLaf.setup();
                UIManager.setLookAndFeel(new FlatLightLaf());
                selectedLookAndFeel = "FlatLightLaf";
                break;
            case "Nimbus":
                UIManager.setLookAndFeel(new NimbusLookAndFeel());
                selectedLookAndFeel = "Nimbus";
                break;
            case "Metal":
                UIManager.setLookAndFeel(new MetalLookAndFeel());
                selectedLookAndFeel = "Metal";
                break;
            case "FlatIntelliJLaf":
            case "FlatInelliJ":
                FlatIntelliJLaf.setup();
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                selectedLookAndFeel = "FlatIntelliJLaf";
                break;
            default:
                UIManager.setLookAndFeel(UIManager
                        .getSystemLookAndFeelClassName());
                selectedLookAndFeel = "System Default";
                break;
        }
    }

    private final Mainframe mainframe;
    private final ConfigurationDialog configurationDialog;
    private final EmpleadoDialog empleadoDialog;
    private final ErrorDialog errorDialog;
    private final VentasDialog ventasDialog;
    private final TicketDialog ticketDialog;

    private ViewWrapper() {
        mainframe = new Mainframe();
        configurationDialog = new ConfigurationDialog(mainframe, true);
        empleadoDialog = new EmpleadoDialog(mainframe, true);
        errorDialog = new ErrorDialog(mainframe);
        ventasDialog = new VentasDialog(mainframe, true);
        ticketDialog = new TicketDialog(mainframe, true);
        validateConfig();
        mainframe.setVisible(true);
        Configuration.addListener(mainframe);
    }

    public String formatTime(TemporalAccessor date) {
        return timeFormatter.format(date);
    }

    public String formatNumber(Number number) {
        return numberFormatter.format(number);
    }

    private void validateConfig() {
        if (!Configuration.exists())
            showConfiguration();
    }

    public void showError(Exception exception) {
        errorDialog.setError(exception);
        errorDialog.setLocationRelativeTo(mainframe);
        errorDialog.setVisible(true);
    }

    public void showTicket(Ticket ticket) {
        ticketDialog.setTicket(ticket);
        ticketDialog.setLocationRelativeTo(mainframe);
        ticketDialog.setVisible(true);
    }

    public boolean seesError() {
        return errorDialog.isVisible();
    }

    public void showConfiguration() {
        configurationDialog.setLocationRelativeTo(mainframe);
        configurationDialog.setVisible(true);
    }

    public boolean seesConfiguration() {
        return configurationDialog.isVisible();
    }

    public void showEmpleadoSelector() {
        empleadoDialog.setLocationRelativeTo(mainframe);
        empleadoDialog.setVisible(true);
    }

    public boolean seesEmpleadoSelector() {
        return empleadoDialog.isVisible();
    }

    public void showVentas() {
        ventasDialog.setLocationRelativeTo(mainframe);
        ventasDialog.setVisible(true);
    }

    public boolean seesVentasDialog() {
        return ventasDialog.isVisible();
    }

    @Override
    public void onChange(String key, String oldValue, String newValue) {
//        System.out.println("Drivethrough - " + key + " == " + oldValue + " > " + newValue);
        if (key.equals("application.laf")) {
//            System.out.println("Request LAF change");
            try {
                ViewWrapper.setLookAndFeel(newValue);
                SwingUtilities.updateComponentTreeUI(mainframe);
                SwingUtilities.updateComponentTreeUI(configurationDialog);
                SwingUtilities.updateComponentTreeUI(empleadoDialog);
                SwingUtilities.updateComponentTreeUI(errorDialog);
                SwingUtilities.updateComponentTreeUI(ventasDialog);
                SwingUtilities.updateComponentTreeUI(ticketDialog);
                mainframe.pack();
                configurationDialog.pack();
                empleadoDialog.pack();
                errorDialog.pack();
                ventasDialog.pack();
                ticketDialog.pack();

            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ViewWrapper.getView().showError(ex);
            }
        }
    }

}
