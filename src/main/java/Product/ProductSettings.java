package Product;

import Hibernate.HibernateUtil;
import org.hibernate.Session;

public class ProductSettings {
    public void changeDescription(Product product, String description){
        Session session = HibernateUtil.getSessionFactory().openSession();
        product.setDescription(description);
        session.update(product);
        session.close();
    }

    public void changeQuantity(Product product, int quantity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        product.setQuantity(quantity);
        session.update(product);
        session.close();
    }
}
