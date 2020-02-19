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
    public static void addProductToBasket(Long basketID, Product product) {
        Basket basket = BasketData.getBasketById(basketID);
        Set<Product> newProductSet = basket.getProductSet();
        newProductSet.add(product);
        basket.setProductSet(newProductSet);
        BasketData.updateBasket(basket);
    }

    public static void removeProductFromBasket(Long basketID, Product product){
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
        Basket basket = BasketData.getBasketById(basketID);
        basket.setProductSet(productSet);
        BasketData.updateBasket(basket);
    }

    public static void showBasket(Long basketID){
        Basket basket = BasketData.getBasketById(basketID);
        Set<Product> productSet = basket.getProductSet();
        for(Product p : productSet){
            System.out.println(p.toString());
        }
    }

    public static void clearBasket(Basket basket){
        basket.setProductSet(null);
    }
}
