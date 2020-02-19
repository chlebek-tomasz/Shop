package User;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class UserSettings {
    public static void changePassword(User user, String oldPassword, String newPassword) {
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            UserData.updateUser(user);
        }
    }

    public static void changeEmail(User user, String newEmail){
        user.setEmail(newEmail);
        UserData.updateUser(user);
    }
}
