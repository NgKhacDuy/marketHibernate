/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJO.Category;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import POJO.Vegetable;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class CategoryDAL {
    static Session session;

    public CategoryDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    
    public List loadCategory(){
        List<Category> category;
        session.beginTransaction();
        category = session.createQuery("FROM Category",Category.class).list();
        session.getTransaction().commit();
        return category;
    }
    
    public Category getCategory(int CategoryID){
        Category c = session.get(Category.class,CategoryID);
        return c;
    }
    public void addCategory(Category c)
    {
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
    }
    public void updateCategory(Category c){
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
    }
    public void deleteCategory(Category c){
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
    }
    public List<Category> searchCategory(String str){
         session.beginTransaction();
        String hql ="FROM Category  WHERE Name LIKE :str";
        Query query = session.createQuery(hql);
        query.setParameter("str", "%"+str+"%");
        List<Category> list = query.list();
        session.getTransaction().commit();
        return list;
    }
//    public static void main(String[] args) {
//        CategoryDAL c = new CategoryDAL();
//        Category cc = new Category();
//        cc = session.get(Category.class, 5);
//        c.deleteCategory(cc);
//       
//    }
}
