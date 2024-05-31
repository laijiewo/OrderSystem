package module;

public class OrderList {
    private final String orderId;
    private final String DishId;
    private final String comments;
    private int number;
    public OrderList(String orderId, String DishId, String comments, int number) {
        this.orderId = orderId;
        this.DishId = DishId;
        this.comments = comments;
        this.number = number;
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
    public int getNumber() {return number;}
    public void increaseNumber() {this.number = number+1;}
}
