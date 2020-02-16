package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class BasketDAO {
    public static void addBasket(Basket basket){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(basket);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeBasket(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getBasketById(id));
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
        session.update(basket);
        session.close();
    }
}
