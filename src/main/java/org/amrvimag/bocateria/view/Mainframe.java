package org.amrvimag.bocateria.view;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.amrvimag.bocateria.Configuration;
import org.amrvimag.bocateria.ResourceIO;
import org.amrvimag.bocateria.events.MainframeEventHandler;
import org.amrvimag.bocateria.model.entity.Empleado;
import org.amrvimag.bocateria.model.entity.Producto;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public final class Mainframe extends javax.swing.JFrame {

    private final MainframeEventHandler buttonClickHandler = new MainframeEventHandler();
    private Empleado emp = null;

    /**
     * Creates new form Mainframe
     */
    public Mainframe() {
        initComponents();

        for (Entry<Producto.Tipos, Image> tipo : buttonClickHandler
                .loadProductTypes().entrySet())
            this.addType(tipo.getKey(), tipo.getValue());

        buttonConfiguration.setIcon(new ImageIcon(ResourceIO
                .resourceImage("image/settings.png", 24, 24)));

        super.setTitle(Configuration
                .getDefaultConfig("aplication.name", "Tienda Amogus"));
        super.setIconImage(ResourceIO.resourceImage("image/icon.png", 32, 32));
        super.setMinimumSize(super.getSize());
        super.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        super.setMaximumSize(super.getSize());
    }

    private final Map<Producto.Tipos, JToggleButton> buttonTypes = new HashMap<>();
    private JToggleButton selectedProductTypeButton = null;
    private final ButtonGroup productTypeGroup = new ButtonGroup();

    public void addType(Producto.Tipos type, Image img) {
        JToggleButton button = constructButton(type.getNombre(), new ImageIcon(img));
        buttonTypes.put(type, button);
        panelProductType.add(button);
    }

    public void clearTypes() {
        buttonTypes.clear();
        panelProductType.removeAll();
        selectedProductTypeButton = null;
    }

    private JToggleButton constructButton(String text, Icon image) {
        JToggleButton button = new JToggleButton(text, image);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);

        int size = panelProductType.getHeight() - ((FlowLayout) panelProductType
                .getLayout()).getVgap() * 2;
        button.setSize(size, size);
        button.setPreferredSize(button.getSize());
        productTypeGroup.add(button);
        button.addActionListener((ActionEvent e) -> {
            if (button.equals(selectedProductTypeButton))
                selectedProductTypeButton = null;
            else
                selectedProductTypeButton = button;

            productSelectListModel.clear();
            for (Producto producto : buttonClickHandler
                    .productTypeSelectButtonClick(getKeyByValue(button), selectedProductTypeButton != null))
                productSelectListModel.addElement(producto);

        });

        return button;
    }

    private Producto.Tipos getKeyByValue(JToggleButton button) {
        for (Entry<Producto.Tipos, JToggleButton> entry : buttonTypes.entrySet()) {
            if (entry.getValue().equals(button))
                return entry.getKey();
        }
        return Producto.Tipos.OTRO;
    }

    public void setEmpleado(Empleado emp) {
        buttonEmployee.setText(emp.getName());
        this.emp = emp;
    }

    public Empleado getEmpleado() {
        return this.emp;
    }

    private final DefaultListModel<Producto> productSelectListModel = new DefaultListModel<>();
    private final DefaultListModel<Producto> productItemListModel = new DefaultListModel<>();
    private final ProductSelectRenderer<Producto> productSelectRenderer = new ProductSelectRenderer<>();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHeader = new javax.swing.JPanel();
        buttonEmployee = new javax.swing.JLabel();
        buttonConfiguration = new javax.swing.JLabel();
        panelTicket = new javax.swing.JPanel();
        panelScrollItemView = new javax.swing.JScrollPane();
        listItemView = new javax.swing.JList<>();
        buttonPagarEfectivo = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonPagarTarjeta = new javax.swing.JButton();
        panelProducts = new javax.swing.JPanel();
        panelScrollProduct = new javax.swing.JScrollPane();
        listItemSelect = new javax.swing.JList<>();
        panelScrollProductType = new javax.swing.JScrollPane();
        panelProductType = new javax.swing.JPanel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelHeader.setMaximumSize(new java.awt.Dimension(32767, 32));
        panelHeader.setMinimumSize(new java.awt.Dimension(383, 32));
        panelHeader.setPreferredSize(new java.awt.Dimension(383, 32));

        buttonEmployee.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        buttonEmployee.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonEmployee.setText(" ${emplado}");
        buttonEmployee.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"), 1, true));
        buttonEmployee.addMouseListener(formListener);

        buttonConfiguration.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        buttonConfiguration.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        buttonConfiguration.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonConfiguration.setText("Configuración ");
        buttonConfiguration.setBorder(new javax.swing.border.LineBorder(javax.swing.UIManager.getDefaults().getColor("Button.borderColor"), 1, true));
        buttonConfiguration.addMouseListener(formListener);

        javax.swing.GroupLayout panelHeaderLayout = new javax.swing.GroupLayout(panelHeader);
        panelHeader.setLayout(panelHeaderLayout);
        panelHeaderLayout.setHorizontalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addComponent(buttonEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonConfiguration)
                .addGap(0, 0, 0))
        );
        panelHeaderLayout.setVerticalGroup(
            panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHeaderLayout.createSequentialGroup()
                .addGroup(panelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelTicket.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Component.borderColor")));

        listItemView.setModel(productItemListModel);
        listItemView.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listItemView.setCellRenderer(new ProductInfoRenderer<Producto>());
        listItemView.addListSelectionListener(formListener);
        panelScrollItemView.setViewportView(listItemView);

        buttonPagarEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonPagarEfectivo.setText("Pagar en efectivo");
        buttonPagarEfectivo.addActionListener(formListener);

        buttonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        buttonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        buttonCancelar.setForeground(new java.awt.Color(51, 51, 51));
        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(formListener);

        buttonPagarTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buttonPagarTarjeta.setText("Pagar con tarjeta");
        buttonPagarTarjeta.addActionListener(formListener);

        javax.swing.GroupLayout panelTicketLayout = new javax.swing.GroupLayout(panelTicket);
        panelTicket.setLayout(panelTicketLayout);
        panelTicketLayout.setHorizontalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelScrollItemView)
                    .addGroup(panelTicketLayout.createSequentialGroup()
                        .addGroup(panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonPagarEfectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(buttonPagarTarjeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelTicketLayout.setVerticalGroup(
            panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelScrollItemView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTicketLayout.createSequentialGroup()
                        .addComponent(buttonPagarEfectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPagarTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelProducts.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Component.borderColor")));

        listItemSelect.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        listItemSelect.setModel(productSelectListModel);
        listItemSelect.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listItemSelect.setCellRenderer(productSelectRenderer);
        listItemSelect.addListSelectionListener(formListener);
        panelScrollProduct.setViewportView(listItemSelect);

        panelScrollProductType.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panelProductType.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelProductType.setMaximumSize(new java.awt.Dimension(32767, 200));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT);
        flowLayout1.setAlignOnBaseline(true);
        panelProductType.setLayout(flowLayout1);
        panelScrollProductType.setViewportView(panelProductType);

        javax.swing.GroupLayout panelProductsLayout = new javax.swing.GroupLayout(panelProducts);
        panelProducts.setLayout(panelProductsLayout);
        panelProductsLayout.setHorizontalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelScrollProductType)
                    .addComponent(panelScrollProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelProductsLayout.setVerticalGroup(
            panelProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelScrollProductType, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelScrollProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener, javax.swing.event.ListSelectionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == buttonPagarEfectivo) {
                Mainframe.this.buttonPagarEfectivoActionPerformed(evt);
            }
            else if (evt.getSource() == buttonCancelar) {
                Mainframe.this.buttonCancelarActionPerformed(evt);
            }
            else if (evt.getSource() == buttonPagarTarjeta) {
                Mainframe.this.buttonPagarTarjetaActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == buttonEmployee) {
                Mainframe.this.buttonEmployeeMouseClicked(evt);
            }
            else if (evt.getSource() == buttonConfiguration) {
                Mainframe.this.buttonConfigurationMouseClicked(evt);
            }
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == buttonEmployee) {
                Mainframe.this.buttonEmployeeMouseEntered(evt);
            }
            else if (evt.getSource() == buttonConfiguration) {
                Mainframe.this.buttonConfigurationMouseEntered(evt);
            }
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == buttonEmployee) {
                Mainframe.this.buttonEmployeeMouseExited(evt);
            }
            else if (evt.getSource() == buttonConfiguration) {
                Mainframe.this.buttonConfigurationMouseExited(evt);
            }
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
        }

        public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
            if (evt.getSource() == listItemView) {
                Mainframe.this.listItemViewValueChanged(evt);
            }
            else if (evt.getSource() == listItemSelect) {
                Mainframe.this.listItemSelectValueChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEmployeeMouseClicked
        buttonClickHandler.employeeButtonClick();
    }//GEN-LAST:event_buttonEmployeeMouseClicked

    private void buttonConfigurationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfigurationMouseClicked
        buttonClickHandler.configurationButtonClick();
    }//GEN-LAST:event_buttonConfigurationMouseClicked

    private void buttonPagarEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagarEfectivoActionPerformed
        buttonClickHandler.pagarEffectivoButtonClick();
    }//GEN-LAST:event_buttonPagarEfectivoActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        buttonClickHandler.cancelarButtonClick();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonPagarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPagarTarjetaActionPerformed
        buttonClickHandler.pagarTarjetaButtonClick();
    }//GEN-LAST:event_buttonPagarTarjetaActionPerformed

    private void listItemViewValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listItemViewValueChanged
        if (evt.getValueIsAdjusting() || listItemSelect.getSelectedIndex() < 0)
            return;

        final int index = listItemView.getSelectedIndex();
        buttonClickHandler
                .removeProductoButtonClick(index, productItemListModel
                        .elementAt(index));

        listItemView.clearSelection();
        listItemSetItems();
    }//GEN-LAST:event_listItemViewValueChanged

    private void buttonEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEmployeeMouseEntered
        buttonEmployee.setForeground(javax.swing.UIManager.getDefaults()
                .getColor("Actions.Blue"));
    }//GEN-LAST:event_buttonEmployeeMouseEntered

    private void buttonConfigurationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfigurationMouseEntered
        buttonConfiguration.setForeground(javax.swing.UIManager.getDefaults()
                .getColor("Actions.Blue"));
    }//GEN-LAST:event_buttonConfigurationMouseEntered

    private void buttonEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEmployeeMouseExited
        buttonEmployee.setForeground(javax.swing.UIManager.getDefaults()
                .getColor("Button.foreground"));
    }//GEN-LAST:event_buttonEmployeeMouseExited

    private void buttonConfigurationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonConfigurationMouseExited
        buttonConfiguration.setForeground(javax.swing.UIManager.getDefaults()
                .getColor("Button.foreground"));
    }//GEN-LAST:event_buttonConfigurationMouseExited

    private void listItemSelectValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listItemSelectValueChanged
        if (evt.getValueIsAdjusting() || listItemSelect.getSelectedIndex() < 0)
            return;

        final int index = listItemSelect.getSelectedIndex();
        buttonClickHandler
                .addProductoItemButtonClick(index, productSelectListModel
                        .elementAt(index));

        listItemSelect.clearSelection();
        listItemSetItems();
    }//GEN-LAST:event_listItemSelectValueChanged

    private void listItemSetItems() {
        productItemListModel.clear();
        for (Producto prod : buttonClickHandler.getLoadedProductos())
            productItemListModel.addElement(prod);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton buttonCancelar;
    protected javax.swing.JLabel buttonConfiguration;
    protected javax.swing.JLabel buttonEmployee;
    protected javax.swing.JButton buttonPagarEfectivo;
    protected javax.swing.JButton buttonPagarTarjeta;
    private javax.swing.JList<Producto> listItemSelect;
    private javax.swing.JList<Producto> listItemView;
    private javax.swing.JPanel panelHeader;
    private javax.swing.JPanel panelProductType;
    private javax.swing.JPanel panelProducts;
    private javax.swing.JScrollPane panelScrollItemView;
    private javax.swing.JScrollPane panelScrollProduct;
    private javax.swing.JScrollPane panelScrollProductType;
    private javax.swing.JPanel panelTicket;
    // End of variables declaration//GEN-END:variables

    public static void main(String[] args) {
//        FlatDarculaLaf.setup();
//        FlatDarkLaf.setup();
//        FlatLightLaf.setup();
        try {
            //        Launcher.main(args);
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Mainframe.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

        Mainframe frame = new Mainframe();

        frame.addType(Producto.Tipos.OTRO, ResourceIO
                .resourceImage("image/icon.png", 64, 64));

        final int size = 64;
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Cocaola", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de uwu", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Eneryeti", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));
        frame.productSelectListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size, size)));

        frame.productItemListModel
                .addElement(new Producto(Producto.Tipos.BEBIDA, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size / 2, size / 2)));
        frame.productItemListModel
                .addElement(new Producto(Producto.Tipos.OTRO, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size / 2, size / 2)));
        frame.productItemListModel
                .addElement(new Producto(Producto.Tipos.BOCADILLO, 12, "Agua de chica gamer", 14.49, ResourceIO
                        .resourceImage("image/undefined.png", size / 2, size / 2)));

        frame.setVisible(true);
    }
}
