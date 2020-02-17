package User;

import Product.Product;

import java.util.List;

public class BasketOption {
    public static void addProductToBasket(Long basketID, Product product){
        Basket basket = BasketData.getBasketById(basketID);
        List<Product> productList = basket.getProductList();
        productList.add(product);
        basket.setProductList(productList);
        BasketData.updateBasket(basket);
    }

    public static void removeProductFromBasket(Basket basket, Product product){
        List<Product> productList = basket.getProductList();
        productList.remove(product);
        basket.setProductList(productList);
        BasketData.updateBasket(basket);
    }

    public static void showBasket(Basket basket){
        List<Product> productList = basket.getProductList();
        for(Product p : productList){
            System.out.println(p.toString());
        }
    }

    public static void clearBasket(Basket basket){
        basket.setProductList(null);
    }
}
