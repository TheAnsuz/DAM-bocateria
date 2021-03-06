package org.amrvimag.bocateria.view;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import org.amrvimag.bocateria.ResourceIO;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz
 */
public class ErrorDialog extends javax.swing.JDialog {

    private Exception exception;

    public void setError(Exception exception) {
        this.exception = exception;
        this.textDescription.setText(splitIntoLines(exception
                .getLocalizedMessage(), 80));
        this.textLog.setText(generateTrace(exception));
        this.pack();
    }

    /**
     * Creates new form ErrorDialog, these dialogs must have a window attached
     * to them and wont let the user do anything until they are closed
     *
     * @param parent the root of this dialog (parent window)
     */
    public ErrorDialog(java.awt.Frame parent) {
        super(parent, true);
        this.exception = new Exception("Undefined exception");
        initComponents();
        super.setTitle("Error: " + exception.getClass().getSimpleName());
        this.textDescription.setText(splitIntoLines(exception
                .getLocalizedMessage(), 80));
        super.pack();
//        super.setLocationRelativeTo(parent);
        super.setResizable(false);
        super.getRootPane().setDefaultButton(buttonOK);
        super.setIconImage(ResourceIO.resourceImage("image/warning.png"));
//        super.setVisible(true);
    }

    private static String generateTrace(Exception exception) {
        final StringBuilder builder = new StringBuilder();
        for (StackTraceElement elem : exception.getStackTrace())
            builder.append(elem.toString()).append(System.lineSeparator());

        return builder.toString();
    }

    private static String splitIntoLines(String text, int width) {
        final StringBuilder temp = new StringBuilder(text);
        for (int i = width; i < temp.length(); i += width) {
            if (i < temp.length())
                temp.insert(i, "<br>");

        }
        return "<html>" + temp.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonOK = new javax.swing.JButton();
        buttonCopy = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textLog = new javax.swing.JTextArea();
        textDescription = new javax.swing.JLabel();

        FormListener formListener = new FormListener();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonOK.setText("OK");
        buttonOK.addActionListener(formListener);
        buttonOK.setDefaultCapable(true);
        buttonOK.requestFocus();

        buttonCopy.setText("Copiar al portapapeles");
        buttonCopy.setFocusable(false);
        buttonCopy.addActionListener(formListener);

        textLog.setColumns(20);
        textLog.setRows(5);
        textLog.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textLog.setFocusable(false);
        jScrollPane1.setViewportView(textLog);
        textLog.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                return false;
            }

        });
        textLog.setText(generateTrace(exception));

        textDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCopy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonOK))
                    .addComponent(textDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOK)
                    .addComponent(buttonCopy))
                .addContainerGap())
        );

        pack();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == buttonOK) {
                ErrorDialog.this.buttonOKActionPerformed(evt);
            }
            else if (evt.getSource() == buttonCopy) {
                ErrorDialog.this.buttonCopyActionPerformed(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonOKActionPerformed

    private String generateStackTrace() {
        return exception.toString() + System.lineSeparator() + textLog.getText();
    }

    private void buttonCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCopyActionPerformed
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(new StringSelection(generateStackTrace()), null);
    }//GEN-LAST:event_buttonCopyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCopy;
    private javax.swing.JButton buttonOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel textDescription;
    private javax.swing.JTextArea textLog;
    // End of variables declaration//GEN-END:variables

}
