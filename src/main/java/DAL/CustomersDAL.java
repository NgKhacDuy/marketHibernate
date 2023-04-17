/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJO.Customers;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class CustomersDAL {
    static Session session;

    public CustomersDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public List loadCustomers(){
        List<Customers> customers;
        session.beginTransaction();
        customers = session.createQuery("FROM Customers",Customers.class).list();
        session.getTransaction().commit();
        return customers;
    }
    public Customers getCustomers(int CustomersID){
        Customers v = session.get(Customers.class, CustomersID);
        return v;
    }
    public void addCustomers(Customers v){
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
    public void updateCustomers(Customers v){
        session.beginTransaction();
        session.update(v);
        session.getTransaction().commit();
    }
    public void deleteCustomers(Customers v){
        session.beginTransaction();
        session.delete(v);
        session.getTransaction().commit();
    }
    public List searchCustomer(String str){
        session.beginTransaction();
        String hql ="FROM Customers  WHERE CONCAT(Fullname,Address,City) LIKE :str";
        Query query = session.createQuery(hql);
        query.setParameter("str", "%"+str+"%");
        List<Customers> list = query.list();
        session.getTransaction().commit();
        return list;
    }
//    public static void main(String[] args) {
//        CustomersDAL c = new CustomersDAL();
////        List<Customers> list = c.loadCustomers();
////        list.forEach(p->System.out.printf("%s\n", p.getFullname()));
//        System.out.println(cj.getFullname());
//    }
}
