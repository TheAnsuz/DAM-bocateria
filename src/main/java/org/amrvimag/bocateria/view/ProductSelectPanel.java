package org.amrvimag.bocateria.view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ProductSelectPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductSelectPanel
     */
    public ProductSelectPanel() {
        initComponents();
    }

    public void setImage(Image image) {
        icon.setIcon(new ImageIcon(image));
    }
    
    public void setCost(double cost) {
        this.cost.setText(ViewWrapper.getView().formatNumber(cost));
    }
    
    public void setName(String name) {
        this.name.setText(name);
    }
    
    public void setSelected(boolean selected) {
        if (selected)
            super.setBackground(javax.swing.UIManager.getDefaults().getColor("Buttons.disabledBackground"));
        else
            super.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icon = new javax.swing.JLabel();
        cost = new javax.swing.JLabel();
        name = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(32767, 75));
        setMinimumSize(new java.awt.Dimension(200, 75));
        setPreferredSize(new java.awt.Dimension(530, 75));

        icon.setMaximumSize(new java.awt.Dimension(75, 75));
        icon.setMinimumSize(new java.awt.Dimension(75, 75));
        icon.setPreferredSize(new java.awt.Dimension(75, 75));

        cost.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        cost.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cost.setText("${cost}");

        name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        name.setText("${name}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cost, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cost;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}