/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Custom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Admin
 */
public class PanelChoiceAction extends javax.swing.JPanel {

    /**
     * Creates new form PanelAction
     */
    public PanelChoiceAction() {
        initComponents();
    }
     public void initEvent(TableActionEvent event, int row) {
        cmdChoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.choice(row);
            }
        });
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdChoice = new Custom.ButtonRadius();

        cmdChoice.setForeground(new java.awt.Color(255, 255, 255));
        cmdChoice.setText("Chọn");
        cmdChoice.setColor(new java.awt.Color(0, 204, 204));
        cmdChoice.setColorClick(new java.awt.Color(0, 102, 102));
        cmdChoice.setColorOver(new java.awt.Color(0, 153, 153));
        cmdChoice.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        cmdChoice.setRoundBottomLeft(5);
        cmdChoice.setRoundBottomRight(5);
        cmdChoice.setRoundTopLeft(5);
        cmdChoice.setRoundTopRight(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cmdChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonRadius cmdChoice;
    // End of variables declaration//GEN-END:variables
}
