package de.malban.vide.vecx.panels;


import de.malban.config.Configuration;
import de.malban.gui.components.ModalInternalFrame;
import de.malban.vide.dissy.DASM6809;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class AddVariablePanel extends javax.swing.JPanel {

    /** Creates new form FilePropertiesPanel */
    public AddVariablePanel() {
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldFlags = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButtonCreate = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        jLabel13.setText("Address");

        jButtonCreate.setText("ok");
        jButtonCreate.setName("ok"); // NOI18N
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jLabel14.setText("Enter address for new variable (current dissi-bank)!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldFlags, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButtonCreate))
                    .addComponent(jLabel14))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFlags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButtonCreate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        // try to create dir and save project properties
    }//GEN-LAST:event_jButtonCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCreate;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JTextField jTextFieldFlags;
    // End of variables declaration//GEN-END:variables

    // returns new Properties, not saved yet!
    JInternalFrame modelDialog;
    public static int showEnterValueDialog()
    {
        JFrame frame = Configuration.getConfiguration().getMainFrame();
        AddVariablePanel panel = new AddVariablePanel();
        
        ArrayList<JButton> eb= new ArrayList<JButton>();
        eb.add(panel.jButtonCreate);
        ModalInternalFrame modal = new ModalInternalFrame("Enter value!", frame.getRootPane(), frame, panel,null, null , eb);
        panel.modelDialog = modal;
        modal.setVisible(true);
        String result = modal.getNamedExit();
        if (result.equals("ok"))
        {
            return DASM6809.toNumber(panel.jTextFieldFlags.getText());
        }
        return 0;
    }    

}
