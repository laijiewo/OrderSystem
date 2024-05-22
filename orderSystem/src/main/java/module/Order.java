package module;

import java.util.Date;

public class Order {
    private final int orderId;
    private final Date orderDate;
    private boolean isPaid;
    private final int U_PersonId;


    public Order(int orderId, Date orderDate, boolean isPaid, int U_PersonId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
        this.U_PersonId = U_PersonId;
    }


    public int getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public int getU_PersonId() {
        return U_PersonId;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}
