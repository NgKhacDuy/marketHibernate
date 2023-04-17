/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BLL.CategoryBLL;
import BLL.VegetableBLL;
import Custom.TableActionCellEditor;
import Custom.TableActionCellRender;
import Custom.TableActionEvent;
import GUI.dialog.SanPhamDialo;
import POJO.Category;
import POJO.Vegetable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class SanPhamGUI extends javax.swing.JPanel {
    private VegetableBLL vegBLL;
    private SanPhamDialo d;
    private List<Vegetable> listVegetable = new ArrayList<Vegetable>();
    private List<Category> listCategory = new ArrayList<>();
    private CategoryBLL cateBLL;
    /**
     * Creates new form NhapHangGUI
     */
    public SanPhamGUI() {
        initComponents();
        
        vegBLL = new VegetableBLL();
        cateBLL = new  CategoryBLL();
                
        loadVegetable();
        listCategory = loadCategory();
        
        d = new SanPhamDialo(this,listCategory,listVegetable);
        
        
//        ActionTable();
    }

    public void ActionTable(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
                d.status=0;
                d.lb_Vegetable.setText("Sửa sản phẩm");
                d.txt_IDVegetable.setText(listVegetable.get(row).getVegetableID()+"");
                d.txt_NameVegtable.setText(listVegetable.get(row).getVegetable_Name());
                d.txt_Amount.setText(listVegetable.get(row).getAmount()+"");
                d.txt_Price.setText(listVegetable.get(row).getPrice()+"");
                d.txt_URLImg.setText(listVegetable.get(row).getImage());
                d.cbb_Category.setSelectedItem(listVegetable.get(row).getCategory().getName());
                d.cbb_Unit.setSelectedItem(listVegetable.get(row).getUnit());
                d.lb_Img.setIcon(new ImageIcon(listVegetable.get(row).getImage()));
                d.setVisible(true);
            }

            @Override
            public void onDelete(int row) {
                if (table.isEditing()) {
                    table.getCellEditor().stopCellEditing();
                    if(table.getSelectionModel().isSelectionEmpty() == true)
                        JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm muốn xóa");
                    else{
                        int confirm =JOptionPane.showConfirmDialog(null,"Bạn có chắc chắn muốn xóa sản phẩm này?","Xác nhận",JOptionPane.YES_NO_OPTION);
                        if(confirm==JOptionPane.YES_OPTION){
                            Vegetable v = new Vegetable();
                            v.setVegetableID(listVegetable.get(row).getVegetableID());
                            v.setVegetable_Name(listVegetable.get(row).getVegetable_Name());
                            v.setAmount(listVegetable.get(row).getAmount());
                            v.setImage(listVegetable.get(row).getImage());
                            v.setUnit(listVegetable.get(row).getUnit());
                            v.setPrice(listVegetable.get(row).getPrice());
                            v.setCategory(listVegetable.get(row).getCategory());
                            vegBLL.deleteVegetable(v);
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.removeRow(row);
                        }
                    }
                }
            }

            @Override
            public void onView(int row) {
                System.out.println("View row : " + row);
            }

            @Override
            public void choice(int row) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        table.getColumnModel().getColumn(7).setCellRenderer(new TableActionCellRender());
        table.getColumnModel().getColumn(7).setCellEditor(new TableActionCellEditor(event));
    }
    
    public void loadVegetable(){
        listVegetable = vegBLL.loadVegetable();
        Object[][] datamodel;
        datamodel = vegBLL.convertList(listVegetable);
        String[] title={"TT","Category","Name","Unit","Amount","Image","Price","Action"};
        DefaultTableModel model = new DefaultTableModel(datamodel,title);
        table.setModel(model);
        ActionTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public List<Category> loadCategory(){
        List<Category> list = new ArrayList<>();
        for(Category i:cateBLL.loadCategory()){
            cbb_Category.addItem(i.getName());
            list.add(i);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRadius1 = new Custom.PanelRadius();
        txt_NameVegetable = new javax.swing.JTextField();
        btn_Search = new Custom.ButtonRadius();
        cbb_Category = new javax.swing.JComboBox<>();
        btn_Add = new Custom.ButtonRadius();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new Custom.TableCustom1();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        buttonRadius1 = new Custom.ButtonRadius();
        panelRadius3 = new Custom.PanelRadius();
        jLabel1 = new javax.swing.JLabel();

        panelRadius1.setBackground(new java.awt.Color(255, 255, 255));
        panelRadius1.setRoundBottomLeft(20);
        panelRadius1.setRoundBottomRight(20);
        panelRadius1.setRoundTopLeft(20);
        panelRadius1.setRoundTopRight(20);

        txt_NameVegetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameVegetableActionPerformed(evt);
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
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setRowHeight(40);
        table.setSelectionBackground(new java.awt.Color(54, 175, 106));
        jScrollPane2.setViewportView(table);

        jLabel10.setText("Loại sản phẩm");

        jLabel11.setText("Tên sản phẩm");

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

        javax.swing.GroupLayout panelRadius1Layout = new javax.swing.GroupLayout(panelRadius1);
        panelRadius1.setLayout(panelRadius1Layout);
        panelRadius1Layout.setHorizontalGroup(
            panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRadius1Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelRadius1Layout.createSequentialGroup()
                            .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbb_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62)
                            .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelRadius1Layout.createSequentialGroup()
                                    .addComponent(txt_NameVegetable, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(46, 46, 46))
        );
        panelRadius1Layout.setVerticalGroup(
            panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(panelRadius1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_NameVegetable, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(buttonRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        panelRadius3.setBackground(new java.awt.Color(63, 86, 185));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sản phẩm");

        javax.swing.GroupLayout panelRadius3Layout = new javax.swing.GroupLayout(panelRadius3);
        panelRadius3.setLayout(panelRadius3Layout);
        panelRadius3Layout.setHorizontalGroup(
            panelRadius3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(986, Short.MAX_VALUE))
        );
        panelRadius3Layout.setVerticalGroup(
            panelRadius3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRadius3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRadius3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRadius3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRadius1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_NameVegetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameVegetableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameVegetableActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        d.status=1;
        d.setVisible(true);
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        String str="";
        for(int i = 0 ; i < listCategory.size() ; i++)
            if(listCategory.get(i).getName().equals(cbb_Category.getSelectedItem().toString())){
                System.out.println(listCategory.get(i).getCategoryID());
                str+=listCategory.get(i).getCategoryID()+"";}
        str+=txt_NameVegetable.getText();
        Object[][] datamodel;
        datamodel = vegBLL.convertList(vegBLL.searchVegetable(str));
        String[] title={"TT","Category","Name","Unit","Amount","Image","Price","Action"};
        DefaultTableModel model = new DefaultTableModel(datamodel,title);
        table.setModel(model);
        ActionTable();

    }//GEN-LAST:event_btn_SearchActionPerformed

    private void buttonRadius1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRadius1ActionPerformed
        // TODO add your handling code here:
        loadVegetable();
        cbb_Category.setSelectedIndex(0);
        txt_NameVegetable.setText("");
    }//GEN-LAST:event_buttonRadius1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonRadius btn_Add;
    private Custom.ButtonRadius btn_Search;
    private Custom.ButtonRadius buttonRadius1;
    private javax.swing.JComboBox<String> cbb_Category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane2;
    private Custom.PanelRadius panelRadius1;
    private Custom.PanelRadius panelRadius3;
    private Custom.TableCustom1 table;
    private javax.swing.JTextField txt_NameVegetable;
    // End of variables declaration//GEN-END:variables
}
