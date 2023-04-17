/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import POJO.Orders;
import DAL.OrderDAL;
import POJO.Customers;
import POJO.OrderDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderBLL {
    private OrderDAL orderDAL;

    public OrderBLL() {
        orderDAL = new OrderDAL();
    }
    public List loadOrder(){
        List list;
        list = orderDAL.loadOrder();
        return list;
    }
    public Object[][] convertList(List<Orders> list){
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            obj[i][0] = list.get(i).getOrderID();
            obj[i][1] = list.get(i).getCustomers();
            obj[i][2] = list.get(i).getDate();
            obj[i][3] = list.get(i).getTotal();
            obj[i][4] = list.get(i).getNote();
        }
        return obj;
    }
    public void newOrder(Orders v){
        orderDAL.addOrder(v);
    }
    public void updateOrder(Orders v){
        orderDAL.updateOrder(v);
    }
    public void deleteOrder(Orders v){
        orderDAL.deleteOrder(v);
    }
    public Orders getOrder(int OrderID){
        Orders v = orderDAL.getOrder(OrderID);
        return v;
    }
    
    public int[] listID(List<Orders> list){
        int[] listID = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++){
            listID[i] = list.get(i).getOrderID();
        }
        return listID;
    }
    
    public List<Orders> searchOrder(String str){
        return orderDAL.searchOrder(str);
    }
    public Object[][] convertListSearch(List list){
        int rows = list.size();
        int cols = 5;
        Object[][] obj = new Object[rows][cols];
        for(int i = 0 ; i < rows ; i++){
            Object[] objj = (Object[]) list.get(i);
            obj[i][0] = objj[0];
            obj[i][1] = objj[1];
            obj[i][2] = objj[2];
            obj[i][3] = objj[3];
            obj[i][4] = objj[4];
        }
        return obj;
    }
}
