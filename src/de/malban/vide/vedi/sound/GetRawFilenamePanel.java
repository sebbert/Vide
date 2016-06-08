package de.malban.vide.vedi.sound;


import de.malban.config.Configuration;
import de.malban.gui.components.ModalInternalFrame;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class GetRawFilenamePanel extends javax.swing.JPanel {

    /** Creates new form FilePropertiesPanel */
    public GetRawFilenamePanel() {
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
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel13.setText("sample name");

        jButtonCreate.setText("ok");
        jButtonCreate.setName("ok"); // NOI18N
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jLabel14.setText("Enter name for sample:");

        jLabel15.setText("Saving is done to current directory, ");

        jLabel16.setText("\"raw\" fill be appended to given name!");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/malban/vide/images/disk_add.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1))
                    .addComponent(jLabel15)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldFlags, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCreate)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFlags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButtonCreate))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        // try to create dir and save project properties
    }//GEN-LAST:event_jButtonCreateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonCreate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JTextField jTextFieldFlags;
    // End of variables declaration//GEN-END:variables

    // returns new Properties, not saved yet!
    JInternalFrame modelDialog;
    public static String showEnterValueDialog()
    {
        JFrame frame = Configuration.getConfiguration().getMainFrame();
        GetRawFilenamePanel panel = new GetRawFilenamePanel();
        
        ArrayList<JButton> eb= new ArrayList<JButton>();
        eb.add(panel.jButtonCreate);
        ModalInternalFrame modal = new ModalInternalFrame("Enter \"raw\" name!", frame.getRootPane(), frame, panel,null, null , eb);
        panel.modelDialog = modal;
        modal.setVisible(true);
        String result = modal.getNamedExit();
        if (result.equals("ok"))
        {
            return panel.jTextFieldFlags.getText();
        }
        return "";
    }    

}
