import Product.Category;
import Product.CategoryDAO;
import Product.*;

public class Shop {
    public static void main(String[] args) {
        System.out.println("Hello");
        Category category = new Category("Shoes");
        CategoryDAO.addCategory(category);
        Product product = new Shoes("Nike AirMax", category, "The best shoes ever", 100, 20,41);
        ProductDAO.addProduct(product);
    }
}
