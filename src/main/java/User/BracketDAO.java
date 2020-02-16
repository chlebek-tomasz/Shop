package User;

import Hibernate.HibernateUtil;
import Product.Product;
import org.hibernate.Session;

public class BracketDAO {
    public static void addBracket(Bracket bracket){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(bracket);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeBracket(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getBracketById(id));
        session.close();
    }

    public static Bracket getBracketById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Bracket bracket = session.get(Bracket.class, id);
        session.close();
        return bracket;
    }

    public static void updateBracket(Bracket bracket){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(bracket);
        session.close();
    }
}
