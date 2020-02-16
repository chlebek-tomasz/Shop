package User;

public class OrderOptions {
    public static void submitOrder(User user, Bracket bracket){
        new Order(user, bracket);
        BracketOptions.clearBracket(bracket);
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
            Bracket bracket = BracketDAO.getBracketById(order.getUser().getBracket().getId());
            bracket.setProductList(order.getProductList());
        }
    }
}
