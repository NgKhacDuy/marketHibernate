/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.dialog;

import BLL.CustomersBLL;
import BLL.OrderBLL;
import BLL.OrderDetailBLL;
import BLL.VegetableBLL;
import Custom.ButtonRadius;
import Custom.CreateID;
import Custom.PanelActionCount;
import Custom.TableActionCellEditor;
import Custom.TableActionCellRender;
import Custom.TableActionChoiceCellEditor;
import Custom.TableActionChoiceCellRender;
import Custom.TableActionCountCellEditor;
import Custom.TableActionCountCellRender;
import Custom.TableActionEvent;
import Custom.mytextfield.DataSearch;
import Custom.mytextfield.EventClick;
import Custom.mytextfield.PanelSearch;
import POJO.Customers;
import POJO.OrderDetail;
import POJO.Orders;
import POJO.Vegetable;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.beans.VetoableChangeListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class HoaDonDialog extends javax.swing.JDialog {
    private JPopupMenu menu;
    private PanelSearch search;
    
    public int status = 0;
    
    private VegetableBLL vegBLL = new VegetableBLL();
    private CustomersBLL cusBLL = new CustomersBLL();
    private OrderBLL orderBLL = new OrderBLL();
    private OrderDetailBLL orderDetailBLL = new OrderDetailBLL();
    
    private List<Vegetable> listVegetable = new ArrayList<>();
    private List<Customers> listCustomers = new ArrayList<>();
    private Set<Vegetable> listVegetableChoice = new HashSet<>();
    private List<OrderDetail> listOrderDetail = new ArrayList<>();
    
    private DefaultTableModel modelTbChoice;
    /**
     * Creates new form HoaDon
     */
    public HoaDonDialog(javax.swing.JPanel parent, List<Orders> listOrders) {
        initComponents();
        
        listCustomers = cusBLL.loadCustomers();
        
        
        
        menu = new JPopupMenu();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164,164,164)));
        search = new PanelSearch();
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick() {
            @Override
            public void itemClick(DataSearch data) {
                menu.setVisible(false);
                txt_SearchCustomer.setText(data.getID()+"-"+data.getText());
                
                System.out.println("Click Item : " + data.getText());
            }

            @Override
            public void itemRemove(Component com, DataSearch data) {
                search.remove(com);
                removeHistory(data.getText());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
                if (search.getItemSize() == 0) {
                    menu.setVisible(false);
                }
                System.out.println("Remove Item : " + data.getText());
            }
        });
        
        
        
        setSize(new Dimension(1200, 630));
        setLocationRelativeTo(parent);
        
        
        
        txt_IDOrder.setText(new CreateID().createID(orderBLL.listID(listOrders))+"");
        
        
        
        loadVegetable();
        
        
        
        modelTbChoice = new DefaultTableModel();
        modelTbChoice.addColumn("ID");
        modelTbChoice.addColumn("Name");
        modelTbChoice.addColumn("Unit");
        modelTbChoice.addColumn("Amount");
        modelTbChoice.addColumn("Price");
        modelTbChoice.addColumn("Action");
        
        table_Choiced.setModel(modelTbChoice);
        
    }
    public void ActionTableSP(){
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onEdit(int row) {
            }

            @Override
            public void onDelete(int row) {
                if (table_Choiced.isEditing()) {
                    table_Choiced.getCellEditor().stopCellEditing();
                }
                for(Vegetable i : listVegetableChoice){
                    if(i.getVegetableID()==(int)table_Choiced.getValueAt(row, 0)){
                        OrderDetail od = orderDetailBLL.getOrderDetail(Integer.parseInt(txt_IDOrder.getText()), i.getVegetableID());
                        orderDetailBLL.deleteOrderDetail(od);
                        modelTbChoice.removeRow(row);
                        listVegetableChoice.remove(i);
                        setTotal();
                    }
                        
                }
            }

            @Override
            public void onView(int row) {
            }

            @Override
            public void choice(int row) {
                if((int)table_SP.getValueAt(row, 3)==0){
                    int confirm =JOptionPane.showConfirmDialog(null,"Sản phẩm hiện tại đã hết hàng?","Xác nhận",JOptionPane.YES_NO_OPTION);
                    if(confirm==JOptionPane.YES_OPTION);
                            
                  }
                else{
                            loadVegetableChoicedFromTbSP(listVegetable.get(row));
                            setTotal();
                            }
            }

            
            @Override
            public void add(int row) {
                float total = 0;
                Vegetable v =null;
                for(Vegetable vv : listVegetable){
                    if(vv.getVegetableID()==(int)table_Choiced.getValueAt(row, 0))
                        v=vv;
                }
                if((int)table_Choiced.getValueAt(row, 3) >= v.getAmount()){
                    table_Choiced.setValueAt(v.getAmount(), row, 3);
                    table_Choiced.setValueAt(v.getAmount()*v.getPrice(), row, 4);
                }
                else{
                    table_Choiced.setValueAt((int)table_Choiced.getValueAt(row, 3)+1, row, 3);
                    table_Choiced.setValueAt((float)table_Choiced.getValueAt(row, 4)+v.getPrice(), row, 4);
                }
                setTotal();
            }

            @Override
            public void minus(int row) {
                float total = 0;
                Vegetable v =null;
                for(Vegetable vv : listVegetable){
                    if(vv.getVegetableID()==(int)table_Choiced.getValueAt(row, 0))
                        v=vv;
                }
                if((int)table_Choiced.getValueAt(row, 3)==0){
                    table_Choiced.setValueAt(0, row, 3);
                    table_Choiced.setValueAt(0, row, 4);
                }
                else{
                    table_Choiced.setValueAt((int)table_Choiced.getValueAt(row, 3)-1, row, 3);
                    table_Choiced.setValueAt((float)table_Choiced.getValueAt(row, 4)-v.getPrice(), row, 4);
                }
                setTotal();
            }

        };
        table_SP.getColumnModel().getColumn(5).setCellRenderer(new TableActionChoiceCellRender());
        table_SP.getColumnModel().getColumn(5).setCellEditor(new TableActionChoiceCellEditor(event));
        table_Choiced.getColumnModel().getColumn(5).setCellRenderer(new TableActionCountCellRender());
        table_Choiced.getColumnModel().getColumn(5).setCellEditor(new TableActionCountCellEditor(event));    
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void setTotal(){
        float total =0;
        int i=0;
                while(i<listVegetableChoice.size()){
                    total+=(float)table_Choiced.getValueAt(i++, 4);
                }
                txt_Total.setText(total+"");
    }
    public void loadVegetable(){
        listVegetable = vegBLL.loadVegetable();
        Object[][] datamodel;
        datamodel = vegBLL.convertListCompact(listVegetable);
        String[] title={"TT","Name","Unit","Amount","Price","Action"};
        DefaultTableModel model = new DefaultTableModel(datamodel,title);
        table_SP.setModel(model);
        ActionTableSP();
    }
    public void loadVegetableChoicedFromTbSP(Vegetable v){
        if(addVegetableChoiced(v)){
            listVegetableChoice.add(v);
            modelTbChoice.addRow(vegBLL.convertItemCompactToTbSP(v));
            ActionTableSP();
        }
    }
    public void loadVegetableChoiced(Vegetable v){
            if(addVegetableChoiced(v)){
            listVegetableChoice.add(v);
            modelTbChoice.addRow(vegBLL.convertItemCompact(v));
            ActionTableSP();
            }
    }
    public boolean addVegetableChoiced(Vegetable v){
        Iterator<Vegetable> i = listVegetableChoice.iterator();
        while(i.hasNext()){
            Vegetable vv = i.next();
            if(vv.getVegetableID()==v.getVegetableID()){
                return false;
            }
        }
        return true;
    }
    public void clearListVegetableChoiced(){
        listVegetableChoice.clear();
        modelTbChoice.setRowCount(0);
    }
    public Vegetable searchByName(String name){
        Vegetable v = new Vegetable();
        Iterator<Vegetable> iterator = listVegetableChoice.iterator();
        while(iterator.hasNext()){
            Vegetable vv = iterator.next();
            if(name.equals(vv.getVegetable_Name())){
                v =vv;
                break;
            }
        }
            
            return v;
    }
    private void UpdateOrderDetail(){
        Orders o = new Orders();
            o.setOrderID(Integer.parseInt(txt_IDOrder.getText()));
            o.setNote(txt_Note.getText());
            o.setTotal(Float.parseFloat(txt_Total.getText()));
            java.util.Date d = txt_DateCreate.getDate();
            String dateString = String.format("%1$tY-%1$tm-%1$td",d);
            o.setDate(Date.valueOf(dateString));
            String[] cus = txt_SearchCustomer.getText().split("-");
            System.out.println(cus[0]);
            System.out.println(cus[1]);
            for(Customers c : listCustomers){
                if(c.getCustomerID()==Integer.parseInt(cus[0]) && c.getFullname().equals(cus[1])){
                    o.setCustomers(c);
                    break;
                }
            }
            
            List<OrderDetail> od = new ArrayList<>();
             for(int i =0 ; i < listVegetableChoice.size() ; i++){
                OrderDetail odd = new OrderDetail();
                odd.setOrder(o);
                odd.setVegetable(searchByName(table_Choiced.getValueAt(i, 1).toString()));
                odd.setPrice((float)table_Choiced.getValueAt(i, 4));
                odd.setQuantity((int)table_Choiced.getValueAt(i, 3));
                od.add(odd);
                
            }
             o.setListOrderDetail(od);
             orderBLL.updateOrder(o);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_SP = new Custom.TableCustom1();
        jLabel18 = new javax.swing.JLabel();
        btn_Cancel = new Custom.ButtonRadius();
        btn_Save = new Custom.ButtonRadius();
        txt_Total = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_Note = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_IDOrder = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelRadius10 = new Custom.PanelRadius();
        btn_Out = new Custom.ButtonRadius();
        lb_Order = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table_Choiced = new Custom.TableCustom1();
        txt_SearchCustomer = new Custom.mytextfield.MyTextField();
        txt_DateCreate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1023, 630));

        table_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_SP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table_SP.setSelectionBackground(new java.awt.Color(54, 175, 106));
        jScrollPane4.setViewportView(table_SP);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Sản phẩm");

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

        txt_Total.setText("0");
        txt_Total.setEnabled(false);
        txt_Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TotalActionPerformed(evt);
            }
        });

        jLabel17.setText("Tổng tiền");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setText("Thanh toán");

        jLabel15.setText("Ghi chú");

        txt_Note.setColumns(20);
        txt_Note.setRows(5);
        jScrollPane3.setViewportView(txt_Note);

        jLabel14.setText("Ngày tạo");

        jLabel7.setText("Khách hàng");

        txt_IDOrder.setEnabled(false);

        jLabel6.setText("Mã hóa đơn");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Đơn hàng");

        panelRadius10.setBackground(new java.awt.Color(127, 192, 214));

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

        lb_Order.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_Order.setForeground(new java.awt.Color(255, 255, 255));
        lb_Order.setText("Thêm hóa đơn");

        javax.swing.GroupLayout panelRadius10Layout = new javax.swing.GroupLayout(panelRadius10);
        panelRadius10.setLayout(panelRadius10Layout);
        panelRadius10Layout.setHorizontalGroup(
            panelRadius10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(panelRadius10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRadius10Layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(lb_Order, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(765, Short.MAX_VALUE)))
        );
        panelRadius10Layout.setVerticalGroup(
            panelRadius10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRadius10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(panelRadius10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRadius10Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lb_Order, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Sản phẩm đã chọn");

        table_Choiced.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        table_Choiced.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table_Choiced.setSelectionBackground(new java.awt.Color(54, 175, 106));
        jScrollPane5.setViewportView(table_Choiced);

        txt_SearchCustomer.setBorder(null);
        txt_SearchCustomer.setPreferredSize(new java.awt.Dimension(64, 24));
        txt_SearchCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_SearchCustomerMouseClicked(evt);
            }
        });
        txt_SearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchCustomerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchCustomerKeyReleased(evt);
            }
        });

        txt_DateCreate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRadius10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(677, 677, 677))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_SearchCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(txt_DateCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE))
                .addGap(37, 37, 37))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_IDOrder)
                            .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(60, 60, 60)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(676, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRadius10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(txt_SearchCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txt_DateCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addGap(51, 51, 51))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_IDOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel7)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel14)
                    .addGap(40, 40, 40)
                    .addComponent(jLabel15)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel17)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txt_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(97, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        if(status==1){//insert
            Orders o = new Orders();
            o.setOrderID(Integer.parseInt(txt_IDOrder.getText()));
            o.setNote(txt_Note.getText());
            o.setTotal(Float.parseFloat(txt_Total.getText()));
            java.util.Date d = txt_DateCreate.getDate();
            String dateString = String.format("%1$tY-%1$tm-%1$td",d);
            o.setDate(Date.valueOf(dateString));
            String[] cus = txt_SearchCustomer.getText().split("-");
            Customers c = new Customers();
            for(Customers cc : listCustomers){
                if(cc.getCustomerID()==Integer.parseInt(cus[0]) && cc.getFullname().equals(cus[1])){
                    o.setCustomers(cc);
                    c=cc;
                }
            }
            List<OrderDetail> od = new ArrayList<>();
         for(int i =0 ; i < listVegetableChoice.size() ; i++){
             OrderDetail odd = new OrderDetail();
                odd.setOrder(o);
                odd.setVegetable(searchByName(table_Choiced.getValueAt(i, 1).toString()));
                odd.setPrice((float)table_Choiced.getValueAt(i, 4));
                odd.setQuantity((int)table_Choiced.getValueAt(i, 3));
                od.add(odd);
                
            }
         o.setListOrderDetail(od);
          orderBLL.newOrder(o);
        }
        else{
            UpdateOrderDetail();
        }
        this.dispose();
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void txt_TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TotalActionPerformed

    private void txt_SearchCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchCustomerMouseClicked
        if (search.getItemSize() > 0) {
            menu.show(txt_SearchCustomer, 0, txt_SearchCustomer.getHeight());
            search.clearSelected();
        }
    }//GEN-LAST:event_txt_SearchCustomerMouseClicked

    private void txt_SearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchCustomerKeyReleased
        if (evt.getKeyCode() != KeyEvent.VK_UP && evt.getKeyCode() != KeyEvent.VK_DOWN && evt.getKeyCode() != KeyEvent.VK_ENTER) {
            String text = txt_SearchCustomer.getText().trim().toLowerCase();
            search.setData(Search(text));
            if (search.getItemSize() > 0) {
                //  * 2 top and bot border
                menu.show(txt_SearchCustomer, 0, txt_SearchCustomer.getHeight());
                menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 35) + 2);
            } else {
                menu.setVisible(false);
            }
        }
    }//GEN-LAST:event_txt_SearchCustomerKeyReleased

    private void txt_SearchCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchCustomerKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            search.keyUp();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            search.keyDown();
        } else if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = search.getSelectedText();
            txt_SearchCustomer.setText(text);
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txt_SearchCustomerKeyPressed

    private List<DataSearch> Search(String search){
        int limitData=7;
        List<DataSearch> list = new ArrayList<>();

        for(Customers s :listCustomers){
            if (s.getFullname().toLowerCase().contains(search)) {
                boolean story = isStory(s.getFullname());
                if (story) {
                    list.add(0, new DataSearch(s.getCustomerID(),s.getFullname(), story));
                    //  add or insert to first record
                } else {
                    list.add(new DataSearch(s.getCustomerID(),s.getFullname(), story));
                    //  add to last record
                }
                if (list.size() == limitData) {
                    break;
                }
            }
        }
        return list;
    }
    
    String dataStory[] = {"300 - Rise of an Empire",
        "Empire Records",
        "Empire State",
        "Frozen",
        "The Courier"};

    private void removeHistory(String text) {
        for (int i = 0; i < dataStory.length; i++) {
            String d = dataStory[i];
            if (d.toLowerCase().equals(text.toLowerCase())) {
                dataStory[i] = "";
            }
        }
    }

    private boolean isStory(String text) {
        for (String d : dataStory) {
            if (d.toLowerCase().equals(text.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HoaDonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HoaDonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HoaDonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HoaDonDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                HoaDonDialog dialog = new HoaDonDialog(new javax.swing.JPanel(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.ButtonRadius btn_Cancel;
    private Custom.ButtonRadius btn_Out;
    private Custom.ButtonRadius btn_Save;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JLabel lb_Order;
    private Custom.PanelRadius panelRadius10;
    private Custom.TableCustom1 table_Choiced;
    private Custom.TableCustom1 table_SP;
    public com.toedter.calendar.JDateChooser txt_DateCreate;
    public javax.swing.JTextField txt_IDOrder;
    public javax.swing.JTextArea txt_Note;
    public Custom.mytextfield.MyTextField txt_SearchCustomer;
    public javax.swing.JTextField txt_Total;
    // End of variables declaration//GEN-END:variables
}
