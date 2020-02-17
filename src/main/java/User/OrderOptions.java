package User;

public class OrderOptions {
    public static void submitOrder(User user, Basket basket){
        new Order(user);
        BasketOption.clearBasket(basket);
    }

    public static void payForTheOrder(Long orderID){
        Order order = OrderData.getOrderById(orderID);
        order.setStatus("paid");
        OrderData.updateOrder(order);
    }

    public static void declineOrder(Long orderID){
        Order order = OrderData.getOrderById(orderID);
        if(!(order.getStatus().equals("paid")) || !(order.getStatus().equals("sent"))){
            OrderData.removeOrder(orderID);
        }
    }

    public static void editOrder(Long orderID){
        Order order = OrderData.getOrderById(orderID);
        if(!(order.getStatus().equals("paid")) || !(order.getStatus().equals("sent"))){
            Basket basket = BasketData.getBasketById(order.getUser().getBasket().getId());
            basket.setProductList(order.getProductList());
        }
    }
}
