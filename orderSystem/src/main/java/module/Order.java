package module;

import java.sql.Date;

public class Order {
    private final String orderId;
    private final Date orderDate;
    private boolean isPaid;
    private final String U_PersonId;


    public Order(String orderId, Date orderDate, boolean isPaid, String U_PersonId) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.isPaid = isPaid;
        this.U_PersonId = U_PersonId;
    }


    public String getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public String getU_PersonId() {
        return U_PersonId;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}
