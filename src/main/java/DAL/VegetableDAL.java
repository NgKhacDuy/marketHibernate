/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import POJO.Category;
import POJO.Vegetable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Admin
 */
public class VegetableDAL {
    static Session session;

    public VegetableDAL() {
        session = HibernateUtil.getSessionFactory().openSession();
    }
    public List loadVegetable(){
        List<Vegetable> vegetable;
        session.beginTransaction();
        vegetable = session.createQuery("FROM Vegetable",Vegetable.class).list();
        session.getTransaction().commit();
        return vegetable;
    }
    public Vegetable getVegetable(int VegetableID){
        Vegetable v = session.get(Vegetable.class, VegetableID);
        return v;
    }
    public void addVegetable(Vegetable v){
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
    }
    public void updateVegetable(Vegetable v){
        session.beginTransaction();
        session.update(v);
        session.getTransaction().commit();
    }
    public void deleteVegetable(Vegetable v){
        session.beginTransaction();
        session.delete(v);
        session.getTransaction().commit();
    }
    public List searchVegetable(String str){
        session.beginTransaction();
        String hql ="FROM Vegetable AS v WHERE CONCAT(CatagoryID,Vegetable_Name) LIKE :str";
        Query query = session.createQuery(hql);
        query.setParameter("str", "%"+str+"%");
        List<Vegetable> vegetable = query.list();
        session.getTransaction().commit();
        return vegetable;
        
    }
//    public static void main(String[] args) {
//        VegetableDAL d = new VegetableDAL();
//        Vegetable v = new Vegetable();
////        v.setVegetableID(14);
//        Category c = session.get(Category.class, 1);
//        System.out.println(c.getName());
//        v.setCategory(c);
//        v.setVegetable_Name("Strawberry");
//        v.setUnit("kg");
//        v.setImage("images/strawberry.jnp");
//        v.setPrice(40000);
//        d.addVegetable(v);
//        session.close();
//    }
    
}
