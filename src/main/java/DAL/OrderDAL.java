/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJO.Customers;
import POJO.OrderDetail;
import POJO.Orders;
import java.sql.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class OrderDAL {
    static Session session;

    public OrderDAL() {
         session = HibernateUtil.getSessionFactory().openSession();
    }
    public List loadOrder(){
        List<Orders> order;
        session.beginTransaction();
        order = session.createQuery("FROM Orders",Orders.class).list();
        session.getTransaction().commit();
        return order;
    }
    public Orders getOrder(int OrderID){
        Orders v = session.get(Orders.class, OrderID);
        return v;
    }
    public void addOrder(Orders v){
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
    public void updateOrder(Orders v){
        session.beginTransaction();
        session.update(v);
         session.getTransaction().commit();
    }
    public void deleteOrder(Orders v){
        session.beginTransaction();
        session.delete(v);
         session.getTransaction().commit();
    }
    public List<Orders> searchOrder(String str){
        session.beginTransaction();
        String hql ="SELECT o.OrderID,o.customers,o.Date,o.Total,o.Note FROM Orders o join o.customers c  WHERE CONCAT(c.Fullname,o.Date) LIKE :str";
        Query query = session.createQuery(hql);
        query.setParameter("str", "%"+str+"%");
        List<Orders> list = query.list();
        session.getTransaction().commit();
        return list;
    }
    public static void main(String[] args) {
        OrderDAL o = new OrderDAL();
        List list = o.searchOrder("Nguyen Van B2023-04-10");
        System.out.println(list.size());
        Object[] obj = (Object[]) list.get(1);
        System.out.println(obj[3]);
        
    }
}
