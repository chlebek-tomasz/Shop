package User;

import Product.Product;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasketOption {
    public static void addProductToBasket(Long basketID, Product product) {
        Basket basket = BasketData.getBasketById(basketID);
        Set<Product> newProductSet = basket.getProductSet();
        newProductSet.add(product);
        basket.setProductSet(newProductSet);
        BasketData.updateBasket(basket);
    }

    public static void removeProductFromBasket(Basket basket, Product product){
        Set<Product> productSet = basket.getProductSet();
        productSet.remove(product);
        basket.setProductSet(productSet);
        BasketData.updateBasket(basket);
    }

    public static void showBasket(Basket basket){
        Set<Product> productSet = basket.getProductSet();
        for(Product p : productSet){
            System.out.println(p.toString());
        }
    }

    public static void clearBasket(Basket basket){
        basket.setProductSet(null);
    }
}
