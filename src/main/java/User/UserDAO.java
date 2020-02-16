package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class UserDAO {
    public void addUser(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
        session.close();
    }

    public void removeUser(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.remove(getUserById(id));
        session.close();
    }

    public User getUserById(Long id){
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
