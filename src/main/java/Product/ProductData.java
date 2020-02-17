package Product;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class ProductData {
    public static void addProduct(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeProduct(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getProductById(id));
        session.close();
    }

    public static Product getProductById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public static void updateProduct(Product product){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(product);
        session.close();
    }
}
