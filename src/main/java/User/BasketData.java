package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class BasketData {
    public static void addBasket(Basket basket){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(basket);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeBasket(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.remove(getBasketById(id));
        session.getTransaction().commit();
        session.close();
    }

    public static Basket getBasketById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Basket basket = session.get(Basket.class, id);
        session.close();
        return basket;
    }

    public static void updateBasket(Basket basket){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(basket);
        session.getTransaction().commit();
        session.close();
    }
}
