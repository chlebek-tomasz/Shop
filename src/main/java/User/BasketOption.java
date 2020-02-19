package User;

import Hibernate.HibernateUtil;
import Product.Product;
import org.hibernate.Session;
import org.hibernate.Query;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import Product.*;

public class BasketOption {
    public static void addProductToBasket(Basket basket, Product product) {
        Set<Product> newProductSet = basket.getProductSet();
        newProductSet.add(product);
        basket.setProductSet(newProductSet);
        basket.setTotalValue(basket.getTotalValue()+product.getValue());
        BasketData.updateBasket(basket);
    }

    public static void removeProductFromBasket(Basket basket, Product product){
        String hql = "select productSet from Basket";
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery(hql);
        List<Product> products = query.list();
        Set<Product> productSet = new HashSet<Product>();
        for(Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
            Product product1 = iterator.next();
            if(!(product1.getID().equals(product.getID()))) {
                productSet.add(product1);
            }
        }
        session.close();
        basket.setProductSet(productSet);
        basket.setTotalValue(basket.getTotalValue()-product.getValue());
        BasketData.updateBasket(basket);
    }

    public static void clearBasket(Basket basket){
        Set<Product> tempProductSet = basket.getProductSet();
        tempProductSet.clear();
        basket.setProductSet(tempProductSet);
        BasketData.updateBasket(basket);
    }
}
