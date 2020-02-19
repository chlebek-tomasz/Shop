import Product.Category;
import Product.*;
import User.*;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Hello");
        Category category = new Category("Shoes");
        Product product1 = new Shoes("Nike AirMax", category, "The best shoes ever", 100, 20,41);
        Product product2 = new Shoes("Nike VaporMax", category, "The best shoes ever", 100, 20,41);
        Product product3 = new Shoes("Adidas", category, "The best shoes ever", 100, 20,41);
        User user = new User("email@gmail.com", "abcd", "Fname", "Lname");
        //System.out.println(user.getPassword());
        //UserSettings.changePassword(user, "abcd", "bcde1234");
        //user = UserData.getUserById(user.getID());
        //System.out.println(user.getPassword());
        //UserData.removeUser(user.getID());
        BasketOption.addProductToBasket(user.getBasket(), product1);
        BasketOption.addProductToBasket(user.getBasket(), product2);
        //BasketOption.addProductToBasket(user.getBasket(), product3);
        //BasketOption.showBasket(user.getID());
        BasketOption.removeProductFromBasket(user.getBasket(), product1);
        //BasketOption.clearBasket(user.getBasket());
        //BasketOption.showBasket(user.getID());
//        OrderOptions.payForTheOrder(user.getBasket().getId());
//        BasketOption.showBasket(user.getBasket());

    }
}
