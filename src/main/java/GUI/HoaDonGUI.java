/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.CategoryBLL;
import BLL.OrderBLL;
import BLL.OrderDetailBLL;
import BLL.VegetableBLL;
import Custom.TableActionCellEditor;
import Custom.TableActionCellRender;
import Custom.TableActionChoiceCellEditor;
import Custom.TableActionChoiceCellRender;
import Custom.TableActionEvent;
import GUI.dialog.DanhMucDialog;
import GUI.dialog.HoaDonDialog;
import POJO.OrderDetail;
import POJO.Orders;
import POJO.Vegetable;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonGUI extends javax.swing.JPanel {
    private OrderBLL orderBLL;
    private OrderDetailBLL orderDetailBLL;
    private HoaDonDialog d;
    private List<Orders> listOrderss = new ArrayList<>();
    /**
     * Creates new form HoaDonGUI
     */
    public HoaDonGUI() {
        initComponents();
        
        orderBLL = new OrderBLL();
        orderDetailBLL = new OrderDetailBLL();
        
        loadOrder();
        
        d = new HoaDonDialog(this,listOrderss);
        
//        ActionTable();
    }
    public void ActionTable(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                d.status=0;
                d.txt_IDOrder.setText(listOrderss.get(row).getOrderID()+"");
                d.lb_Order.setText("Sửa thông tin hóa đơn");
                d.txt_DateCreate.setDate(listOrderss.get(row).getDate());
                d.txt_Note.setText(listOrderss.get(row).getNote());
                d.txt_Total.setText(listOrderss.get(row).getTotal()+"");
                d.txt_SearchCustomer.setText(listOrderss.get(row).getCustomers().getCustomerID()+"-"+listOrderss.get(row).getCustomers().getFullname());
                List<OrderDetail> listOD =  listOrderss.get(row).getListOrderDetail();
                d.clearListVegetableChoiced();
                for(int i=0;i<listOD.size();i++){
                    Vegetable v = listOD.get(i).getVegetable();
                    v.setAmount(listOD.get(i).getQuantity());
                    v.setPrice(listOD.get(i).getPrice());
                    d.loadVegetableChoiced(v);
                }
                d.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                    if(table.getSelectionModel().isSelectionEmpty()==true)
                        JOptionPane.showMessageDialog(table, "Vui lòng chọn hóa đơn muốn xóa");
                    else{
                        int confirm =JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa sản phẩm này?","Xác nhận",JOptionPane.YES_NO_OPTION);
                        if(confirm==JOptionPane.YES_OPTION){
                            Orders o = new Orders();
                            o.setOrderID(listOrderss.get(row).getOrderID());
                            o.setDate(listOrderss.get(row).getDate());
                            o.setTotal(listOrderss.get(row).getTotal());
                            o.setNote(listOrderss.get(row).getNote());
                            o.setCustomers(listOrderss.get(row).getCustomers());
                            orderBLL.deleteOrder(o);
                            orderDetailBLL.deleteOrderDetail(o.getOrderID());
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.removeRow(row);
                        }
                    }
                }
            }

            @Override
            public void onView(int row) {
            }

            @Override
            public void choice(int row) {
            }

            @Override
            public void add(int row) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void minus(int row) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        table.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));
    }
    
    public void loadOrder(){
        listOrderss = orderBLL.loadOrder();
        Object[][] datamodel;
        datamodel = orderBLL.convertList(listOrderss);
        String[] title={"ID","Customer","Date","Total","Note","Action"};
        DefaultTableModel model = new DefaultTableModel(datamodel,title);
        table.setModel(model);
        ActionTable();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRadius9 = new Custom.PanelRadius();
        jLabel7 = new javax.swing.JLabel();
        panelRadius2 = new Custom.PanelRadius();
        txt_NameCustomer = new javax.swing.JTextField();
        btn_Search = new Custom.ButtonRadius();
        btn_Add = new Custom.ButtonRadius();
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new Custom.TableCustom1();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonRadius1 = new Custom.ButtonRadius();
        txt_DateCreate = new com.toedter.calendar.JDateChooser();

        panelRadius9.setBackground(new java.awt.Color(63, 86, 185));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hóa đơn");

        javax.swing.GroupLayout panelRadius9Layout = new javax.swing.GroupLayout(panelRadius9);
        panelRadius9.setLayout(panelRadius9Layout);
        panelRadius9Layout.setHorizontalGroup(
            panelRadius9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(986, Short.MAX_VALUE))
        );
        panelRadius9Layout.setVerticalGroup(
            panelRadius9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRadius9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelRadius2.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius2.setForeground(new java.awt.Color(255, 255, 255));
        panelRadius2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        panelRadius2.setRoundBottomLeft(20);
        panelRadius2.setRoundBottomRight(20);
        panelRadius2.setRoundTopLeft(20);
        panelRadius2.setRoundTopRight(20);

        txt_NameCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameCustomerActionPerformed(evt);
            }
        });

        btn_Search.setBackground(new java.awt.Color(153, 255, 0));
        btn_Search.setForeground(new java.awt.Color(255, 255, 255));
        btn_Search.setText("TÌm kiếm");
        btn_Search.setColor(new java.awt.Color(153, 255, 0));
        btn_Search.setColorClick(new java.awt.Color(51, 153, 0));
        btn_Search.setColorOver(new java.awt.Color(0, 204, 51));
        btn_Search.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Search.setRoundBottomLeft(6);
        btn_Search.setRoundBottomRight(6);
        btn_Search.setRoundTopLeft(6);
        btn_Search.setRoundTopRight(6);
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        btn_Add.setBackground(new java.awt.Color(255, 51, 51));
        btn_Add.setForeground(new java.awt.Color(255, 255, 255));
        btn_Add.setColor(new java.awt.Color(255, 51, 51));
        btn_Add.setColorClick(new java.awt.Color(153, 0, 0));
        btn_Add.setColorOver(new java.awt.Color(204, 0, 0));
        btn_Add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_Add.setLabel("Thêm mới");
        btn_Add.setRoundBottomLeft(6);
        btn_Add.setRoundBottomRight(6);
        btn_Add.setRoundTopLeft(6);
        btn_Add.setRoundTopRight(6);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "TT", "Name", "Description", "Count of Vegrtable", "", "Title 6"
            }
        ));
        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setSelectionBackground(new java.awt.Color(54, 175, 106));
        jScrollPane3.setViewportView(table);

        jLabel8.setText("Khách hàng");

        jLabel9.setText("Ngày tạo");

        buttonRadius1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/reload.png"))); // NOI18N
        buttonRadius1.setColor(new java.awt.Color(224, 224, 224));
        buttonRadius1.setColorClick(new java.awt.Color(153, 153, 153));
        buttonRadius1.setColorOver(new java.awt.Color(204, 204, 204));
        buttonRadius1.setRoundBottomLeft(5);
        buttonRadius1.setRoundBottomRight(5);
        buttonRadius1.setRoundTopLeft(5);
        buttonRadius1.setRoundTopRight(5);
        buttonRadius1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRadius1ActionPerformed(evt);
            }
        });

        txt_DateCreate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout panelRadius2Layout = new javax.swing.GroupLayout(panelRadius2);
        panelRadius2.setLayout(panelRadius2Layout);
        panelRadius2Layout.setHorizontalGroup(
            panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRadius2Layout.createSequentialGroup()
                .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRadius2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRadius2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRadius2Layout.createSequentialGroup()
                                .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_NameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50)
                                .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRadius2Layout.createSequentialGroup()
                                        .addComponent(txt_DateCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 333, Short.MAX_VALUE)))))
                .addGap(40, 40, 40))
        );
        panelRadius2Layout.setVerticalGroup(
            panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRadius2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_NameCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_DateCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(buttonRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRadius9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRadius2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRadius9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRadius2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NameCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameCustomerActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        d.status=1;
        d.lb_Order.setText("Thêm hóa đơn");
        d.setVisible(true);
        
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        java.util.Date d = txt_DateCreate.getDate();
        String dateString = String.format("%1$tY-%1$tm-%1$td",d);
        String str = txt_NameCustomer.getText()+"%"+dateString;
        System.out.println(str);
        Object[][] datamodel;
        datamodel = orderBLL.convertListSearch(orderBLL.searchOrder(str));
        String[] title={"ID","Customer","Date","Total","Note","Action"};
        DefaultTableModel model = new DefaultTableModel(datamodel,title);
        table.setModel(model);
        ActionTable();
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void buttonRadius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius1ActionPerformed
        // TODO add your handling code here:
        loadOrder();
        txt_NameCustomer.setText("");
        txt_DateCreate.setDate(null);
    }//GEN-LAST:event_buttonRadius1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonRadius btn_Add;
    private Custom.ButtonRadius btn_Search;
    private Custom.ButtonRadius buttonRadius1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private Custom.PanelRadius panelRadius2;
    private Custom.PanelRadius panelRadius9;
    private Custom.TableCustom1 table;
    private com.toedter.calendar.JDateChooser txt_DateCreate;
    private javax.swing.JTextField txt_NameCustomer;
    // End of variables declaration//GEN-END:variables
}
