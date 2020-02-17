package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class OrderData {
    public static void addOrder(Order order){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeOrder(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getOrderById(id));
        session.close();
    }

    public static Order getOrderById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    public static void updateOrder(Order order){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(order);
        session.close();
    }
}
