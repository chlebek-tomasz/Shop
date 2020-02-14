package User;

public class UserSettings {
    public static void changePassword(User user, String oldPassword, String newPassword) {
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            UserDAO.updateUser(user);
        }
    }

    public static void changeEmail(User user, String newEmail){
        user.setEmail(newEmail);
        UserDAO.updateUser(user);
    }
}
