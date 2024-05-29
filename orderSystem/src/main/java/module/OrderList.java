package module;

public class OrderList {
    private final String orderId;
    private final String DishId;
    private final String comments;
    public OrderList(String orderId, String DishId, String comments) {
        this.orderId = orderId;
        this.DishId = DishId;
        this.comments = comments;
    }
    public String getOrderId() {
        return orderId;
    }
    public String getDishId() {
        return DishId;
    }
    public String getComments() {
        return comments;
    }
}
