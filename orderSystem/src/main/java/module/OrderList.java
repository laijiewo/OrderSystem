package module;

public class OrderList {
    private final int orderId;
    private final int DishId;
    private final String comments;
    public OrderList(int orderId, int DishId, String comments) {
        this.orderId = orderId;
        this.DishId = DishId;
        this.comments = comments;
    }
    public int getOrderId() {
        return orderId;
    }
    public int getDishId() {
        return DishId;
    }
    public String getComments() {
        return comments;
    }
}
