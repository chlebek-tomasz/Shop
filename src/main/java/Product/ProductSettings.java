package Product;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class ProductSettings {
    public void changeDescription(Product product, String description){
        product.setDescription(description);
        ProductData.updateProduct(product);
    }

    public void changeQuantity(Product product, int quantity) {
        product.setQuantity(quantity);
        ProductData.updateProduct(product);
    }
}
