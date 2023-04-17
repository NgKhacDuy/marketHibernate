/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import static DAL.OrderDAL.session;
import POJO.OrderDetail;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class OrderDetailDAL {
    static Session session;

    public OrderDetailDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.setJdbcBatchSize(20);
    }
   
//    public void addOrderDetail(List<OrderDetail> od){
//        session.beginTransaction();
//
//        for(int i = 0 ; i < od.size(); i++){
//            OrderDetail odd = od.get(i);
//            session.save(odd);
//            if(i%20==0){
//                session.flush();
//                session.clear();
//            }
//        }
//        session.getTransaction().commit();
//    }
    
    public void addOrderDetail(OrderDetail od){
        session.beginTransaction();
        session.save(od);
         session.getTransaction().commit();
    }
    public void updateOrderDetail(OrderDetail od){
        session.beginTransaction();
        session.update(od);
         session.getTransaction().commit();
    }
    public void deleteOrderDetail(OrderDetail od){
        session.beginTransaction();
        session.delete(od);
         session.getTransaction().commit();
    }
    public void deleteOrderDetail(int orderID){
        session.beginTransaction();
        String hql = "DELETE OrderDetail WHERE OrderID= : orderID";
        Query query = session.createQuery(hql);
        query.setParameter("orderID", orderID);
        query.executeUpdate();
         session.getTransaction().commit();
    }
     public OrderDetail getOrderDetail(int OrderID, int VegetableID){
        session.beginTransaction();
        String hql ="FROM OrderDetail Where OrderID =:orderID  AND VegetableID = :vegetableID";
        Query query = session.createQuery(hql);
        query.setParameter("orderID",OrderID);
        query.setParameter("vegetableID",VegetableID);
        List<OrderDetail> od = query.list();
        session.getTransaction().commit();
        return od.get(0);
    }

    public List ThongKeVegetable(){
        List<Object> list;
        session.beginTransaction();
        String hql=  "SELECT v.Vegetable_Name, SUM(od.Quantity) AS Amount "
                + "FROM OrderDetail od "
                + "join od.vegetable v "
                + "GROUP BY v.VegetableID "
                +"ORDER BY  Amount DESC";
        Query q = session.createQuery(hql);
        list=q.list();
        session.getTransaction().commit();
        return list;
    }
    public List ThongKeVegetableByTime(int thang,int nam){
         List<Object> list;
        session.beginTransaction();
        String hql=  "SELECT v.Vegetable_Name, SUM(od.Quantity) AS Amount "
                + "FROM Orders o "
                +",OrderDetail od "
                + "join od.vegetable v "
                + "WHERE  YEAR(o.Date)= :nam "
                +"AND MONTH(o.Date)=:thang "
                +"AND o.OrderID = od.OrderID "
                +"AND od.VegetableID = v.VegetableID "
                + "GROUP BY v.VegetableID "
                +"ORDER BY  Amount DESC";
        Query q = session.createQuery(hql);
        q.setParameter("thang", "%"+thang+"%");
        q.setParameter("nam", "%"+nam+"%");
        list=q.list();
        session.getTransaction().commit();
        return list;
    }
   public static void main(String[] args) {
        OrderDetailDAL od =new OrderDetailDAL();
//        List list = od.ThongKeVegetableByTime(4,2023);
        od.deleteOrderDetail(0);
    }
}
