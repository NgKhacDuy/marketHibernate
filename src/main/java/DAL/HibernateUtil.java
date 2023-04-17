/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;


import java.util.Properties;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author duy
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();
//    static{
//        Configuration conf = new Configuration();
//        
//        Properties props = new Properties();
//        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//        props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
//        props.put(Environment.URL, "jdbc:mysql://localhost:3306/market3?serverTimezone=UTC&amp;useUnicode=true&amp;characterEncoding=utf8");
//        props.put(Environment.USER, "root");
//        props.put(Environment.PASS, "");
//        props.put(Environment.SHOW_SQL, "true");
//        
//        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
//        sessionFactory = conf.buildSessionFactory(registry);
//    }
    private static SessionFactory buildSessionFactory(){
        ServiceRegistry serviceRegisty = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegisty).getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void close(){
        getSessionFactory().close();
    }
}
