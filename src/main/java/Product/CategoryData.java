package Product;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class CategoryData {
    public static void addCategory(Category category){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeCategory(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getCategoryById(id));
        session.close();
    }

    public static Category getCategoryById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

}
