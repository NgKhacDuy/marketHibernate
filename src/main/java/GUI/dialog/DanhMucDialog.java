/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.dialog;

import java.awt.Color;
import java.awt.Dimension;
import BLL.CategoryBLL;
import Custom.CreateID;
import POJO.Category;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */
public class DanhMucDialog extends javax.swing.JDialog {
    public int status =0;
    CategoryBLL cateBLL = new CategoryBLL();
    Category c = new  Category();

    /**
     * Creates new form DanhMuc
     */
    public DanhMucDialog(javax.swing.JPanel parent) {
        initComponents();
        
        setSize(new Dimension(400,370));
        
        setLocationRelativeTo(parent);
        
        this.c=c;
//        setBackground(new Color(255,255,255));
    }
    
    public void setCategory(Category c){
        this.c=c;
        txt_NameCategory.setText(c.getName());
        txt_Note.setText(c.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRadius9 = new Custom.PanelRadius();
        jLabel8 = new javax.swing.JLabel();
        btn_Out = new Custom.ButtonRadius();
        jLabel1 = new javax.swing.JLabel();
        txt_NameCategory = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Note = new javax.swing.JTextArea();
        btn_Save = new Custom.ButtonRadius();
        btn_Cancel = new Custom.ButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelRadius9.setBackground(new java.awt.Color(127, 192, 214));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Thêm loại sản phẩm");

        btn_Out.setForeground(new java.awt.Color(255, 255, 255));
        btn_Out.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cross.png"))); // NOI18N
        btn_Out.setColor(new java.awt.Color(127, 192, 214));
        btn_Out.setColorClick(new java.awt.Color(0, 102, 102));
        btn_Out.setColorOver(new java.awt.Color(0, 153, 153));
        btn_Out.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Out.setRoundBottomLeft(6);
        btn_Out.setRoundBottomRight(6);
        btn_Out.setRoundTopLeft(6);
        btn_Out.setRoundTopRight(6);
        btn_Out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRadius9Layout = new javax.swing.GroupLayout(panelRadius9);
        panelRadius9.setLayout(panelRadius9Layout);
        panelRadius9Layout.setHorizontalGroup(
            panelRadius9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(btn_Out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelRadius9Layout.setVerticalGroup(
            panelRadius9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRadius9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRadius9Layout.createSequentialGroup()
                        .addComponent(btn_Out, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setText("Tên loại sản phẩm");

        jLabel2.setText("Mô tả");

        txt_Note.setColumns(20);
        txt_Note.setRows(5);
        jScrollPane1.setViewportView(txt_Note);

        btn_Save.setForeground(new java.awt.Color(255, 255, 255));
        btn_Save.setText("Lưu");
        btn_Save.setColor(new java.awt.Color(0, 204, 204));
        btn_Save.setColorClick(new java.awt.Color(0, 102, 102));
        btn_Save.setColorOver(new java.awt.Color(0, 153, 153));
        btn_Save.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Save.setRoundBottomLeft(6);
        btn_Save.setRoundBottomRight(6);
        btn_Save.setRoundTopLeft(6);
        btn_Save.setRoundTopRight(6);
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btn_Cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancel.setText("Hủy");
        btn_Cancel.setColor(new java.awt.Color(204, 204, 204));
        btn_Cancel.setColorClick(new java.awt.Color(102, 102, 102));
        btn_Cancel.setColorOver(new java.awt.Color(153, 153, 153));
        btn_Cancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Cancel.setRoundBottomLeft(6);
        btn_Cancel.setRoundBottomRight(6);
        btn_Cancel.setRoundTopLeft(6);
        btn_Cancel.setRoundTopRight(6);
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRadius9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(39, 39, 39)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_NameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(87, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelRadius9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 255, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(72, 72, 72)
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_NameCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_OutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_OutActionPerformed

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        if(status==1){
            Category c = new Category();

            CreateID cre = new CreateID();
            int[] listID = cateBLL.listID(cateBLL.loadCategory());
            cre.createID(listID);
            c.setCategoryID(cre.getID());
            c.setName(txt_NameCategory.getText());
            c.setDescription(txt_Note.getText());
        
            cateBLL.newCategory(c);
        }
        else{
            Category c = new Category();
            CategoryBLL cateBLL = new CategoryBLL();
            c.setCategoryID(this.c.getCategoryID());
            c.setName(txt_NameCategory.getText());
            c.setDescription(txt_Note.getText());
            
            cateBLL.updateCategory(c);
        }
        this.dispose();
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhMucDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMucDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMucDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMucDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DanhMucDialog dialog = new DanhMucDialog(new javax.swing.JPanel(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonRadius btn_Cancel;
    private Custom.ButtonRadius btn_Out;
    private Custom.ButtonRadius btn_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Custom.PanelRadius panelRadius9;
    private javax.swing.JTextField txt_NameCategory;
    private javax.swing.JTextArea txt_Note;
    // End of variables declaration//GEN-END:variables
}
