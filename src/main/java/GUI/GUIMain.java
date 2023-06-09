/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Custom.DropDownMenu.menu.MenuEvent;
import Custom.ModernScrollBarUI;
import Custom.TableActionCellEditor;
import Custom.TableActionCellRender;
import Custom.TableActionEvent;
import Custom.mytextfield.DataSearch;
import Custom.mytextfield.PanelSearch;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.UIDefaults;
import javax.swing.UIManager;   
import javax.swing.table.DefaultTableModel;
import GUI.dialog.HoaDonDialog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;
import javax.swing.JPopupMenu;

/**
 *
 * @author duy
 */
public class GUIMain extends javax.swing.JFrame {

    
    public GUIMain() {
        initComponents();
        this.setTitle("Quản lý khóa học");
        
        
    }

    private void clickListenerLeftMenu(JPanel panelPara){
        //hàm chung để chuyển cái GUI con
        
        
        //Bỏ hết các GUI con cũ trước khi add GUI con mới vào
        body.removeAll();
        //lấy Bounds của jDesktopPanel để set Bound cho GUI con
        panelPara.setBounds(0,0,body.getPreferredSize().width,body.getPreferredSize().height);
        // làm cho GUI con hiển thị
        panelPara.setVisible(true);
        // add GUI con vào jDesktopPanel
        body.add(panelPara);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu1 = new Custom.Menu();
        body = new javax.swing.JDesktopPane();
        buttonRadius3 = new Custom.ButtonRadius();
        buttonRadius7 = new Custom.ButtonRadius();
        buttonRadius8 = new Custom.ButtonRadius();
        buttonRadius6 = new Custom.ButtonRadius();
        buttonRadius4 = new Custom.ButtonRadius();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout bodyLayout = new javax.swing.GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1227, Short.MAX_VALUE)
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        buttonRadius3.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius3.setText("Sản phẩm");
        buttonRadius3.setBorderColor(new java.awt.Color(0, 153, 255));
        buttonRadius3.setColor(new java.awt.Color(63, 86, 185));
        buttonRadius3.setColorClick(new java.awt.Color(0, 102, 204));
        buttonRadius3.setColorOver(new java.awt.Color(0, 102, 255));
        buttonRadius3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonRadius3.setRoundBottomLeft(30);
        buttonRadius3.setRoundTopLeft(30);
        buttonRadius3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius3ActionPerformed(evt);
            }
        });

        buttonRadius7.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius7.setText("Hóa đơn");
        buttonRadius7.setBorderColor(new java.awt.Color(0, 153, 255));
        buttonRadius7.setColor(new java.awt.Color(63, 86, 185));
        buttonRadius7.setColorClick(new java.awt.Color(0, 102, 204));
        buttonRadius7.setColorOver(new java.awt.Color(0, 102, 255));
        buttonRadius7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonRadius7.setRoundBottomLeft(30);
        buttonRadius7.setRoundTopLeft(30);
        buttonRadius7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius7ActionPerformed(evt);
            }
        });

        buttonRadius8.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius8.setText("Khách hàng");
        buttonRadius8.setBorderColor(new java.awt.Color(0, 153, 255));
        buttonRadius8.setColor(new java.awt.Color(63, 86, 185));
        buttonRadius8.setColorClick(new java.awt.Color(0, 102, 204));
        buttonRadius8.setColorOver(new java.awt.Color(0, 102, 255));
        buttonRadius8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonRadius8.setRoundBottomLeft(30);
        buttonRadius8.setRoundTopLeft(30);
        buttonRadius8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius8ActionPerformed(evt);
            }
        });

        buttonRadius6.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius6.setText("Thống kê");
        buttonRadius6.setBorderColor(new java.awt.Color(0, 153, 255));
        buttonRadius6.setColor(new java.awt.Color(63, 86, 185));
        buttonRadius6.setColorClick(new java.awt.Color(0, 102, 204));
        buttonRadius6.setColorOver(new java.awt.Color(0, 102, 255));
        buttonRadius6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonRadius6.setRoundBottomLeft(30);
        buttonRadius6.setRoundTopLeft(30);
        buttonRadius6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius6ActionPerformed(evt);
            }
        });

        buttonRadius4.setForeground(new java.awt.Color(255, 255, 255));
        buttonRadius4.setText("Danh mục");
        buttonRadius4.setBorderColor(new java.awt.Color(0, 153, 255));
        buttonRadius4.setColor(new java.awt.Color(63, 86, 185));
        buttonRadius4.setColorClick(new java.awt.Color(0, 102, 204));
        buttonRadius4.setColorOver(new java.awt.Color(0, 102, 255));
        buttonRadius4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        buttonRadius4.setRoundBottomLeft(30);
        buttonRadius4.setRoundTopLeft(30);
        buttonRadius4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu1Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRadius6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRadius8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRadius7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRadius3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRadius4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(body, javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRadius4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(buttonRadius3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRadius7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRadius8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonRadius6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRadius3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius3ActionPerformed
        // TODO add your handling code here:
        clickListenerLeftMenu(new SanPhamGUI());
    }//GEN-LAST:event_buttonRadius3ActionPerformed

    private void buttonRadius7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius7ActionPerformed
        // TODO add your handling code here:
        clickListenerLeftMenu(new HoaDonGUI());
    }//GEN-LAST:event_buttonRadius7ActionPerformed

    private void buttonRadius8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius8ActionPerformed
        // TODO add your handling code here:
        clickListenerLeftMenu(new KhachHangGUI());
    }//GEN-LAST:event_buttonRadius8ActionPerformed

    private void buttonRadius6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius6ActionPerformed
        // TODO add your handling code here:
        ThongKeGUI tk = new ThongKeGUI();
        clickListenerLeftMenu(tk);
        tk.chart.start();
    }//GEN-LAST:event_buttonRadius6ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void buttonRadius4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius4ActionPerformed
        // TODO add your handling code here:
        clickListenerLeftMenu(new DanhMucGUI());
    }//GEN-LAST:event_buttonRadius4ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ModernScrollBarUI.class.getCanonicalName());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane body;
    private Custom.ButtonRadius buttonRadius3;
    private Custom.ButtonRadius buttonRadius4;
    private Custom.ButtonRadius buttonRadius6;
    private Custom.ButtonRadius buttonRadius7;
    private Custom.ButtonRadius buttonRadius8;
    private Custom.Menu menu1;
    // End of variables declaration//GEN-END:variables
}
