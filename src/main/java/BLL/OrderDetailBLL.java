/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OrderDetailDAL;
import POJO.OrderDetail;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailBLL {
        private OrderDetailDAL orderDetailDAL;

    public OrderDetailBLL() {
        orderDetailDAL = new OrderDetailDAL();
    }
        public void updateOrderDetail(OrderDetail od){
            orderDetailDAL.updateOrderDetail(od);
        }
         
        public void deleteOrderDetail(int orderID){
            orderDetailDAL.deleteOrderDetail(orderID);
        }
        
        public void deleteOrderDetail(OrderDetail od){
            orderDetailDAL.deleteOrderDetail(od);
        }
        
          public void newOrderDetail(OrderDetail od){
               orderDetailDAL.addOrderDetail(od);
          }
          
          public OrderDetail getOrderDetail(int OrderID, int VegetableID){
             return orderDetailDAL.getOrderDetail(OrderID, VegetableID);
          }
          public List ThongKeVegetable(){
              return orderDetailDAL.ThongKeVegetable();
          }
          public Object[][] covertListThongKe(List list){
              int rows = list.size();
              int cols = 3;
              Object[][] obj = new Object[rows][cols];
              for(int i=0;i<rows;i++){
                  Object[] objj = (Object[])list.get(i);
                  obj[i][0]=i+1;
                  obj[i][1]=objj[0];
                  obj[i][2]=objj[1];
              }
              return obj;
          }
}
