/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJO.Category;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession();){
            session.beginTransaction();
            Category c = new Category();
            c.setCategoryID(4);
            c.setName("Hello");
            c.setDescription("helo hello ");
//            session.save(c);
            session.getTransaction().commit();
            
        }
    }
}
