package User;

public class OrderOptions {
    public static void submitOrder(User user, Basket basket){
        new Order(user, basket);
        BasketOption.clearBasket(basket);
    }

    public static void payForTheOrder(Long orderID){
        Order order = OrderDAO.getOrderById(orderID);
        order.setStatus("paid");
        OrderDAO.updateOrder(order);
    }

    public static void declineOrder(Long orderID){
        Order order = OrderDAO.getOrderById(orderID);
        if(!(order.getStatus().equals("paid")) || !(order.getStatus().equals("sent"))){
            OrderDAO.removeOrder(orderID);
        }
    }

    public static void editOrder(Long orderID){
        Order order = OrderDAO.getOrderById(orderID);
        if(!(order.getStatus().equals("paid")) || !(order.getStatus().equals("sent"))){
            Basket basket = BasketDAO.getBasketById(order.getUser().getBasket().getId());
            basket.setProductList(order.getProductList());
        }
    }
}
