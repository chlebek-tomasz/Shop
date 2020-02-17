package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class UserData {
    public static void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public static void removeUser(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = getUserById(id);
        Basket basket = user.getBasket();
        session.remove(user);
        BasketData.removeBasket(basket.getId());
        session.close();
    }

    public static User getUserById(Long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public static void updateUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(user);
        session.close();
    }
}
