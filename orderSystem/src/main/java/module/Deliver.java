package module;

public class Deliver {
    private final int OrderID;
    private int Deli_PersonID;
    private DeliverStatus status;

    public Deliver(int OrderID, int Deli_PersonID, DeliverStatus status) {
        this.OrderID = OrderID;
        this.Deli_PersonID = Deli_PersonID;
        this.status = status;
    }

    public int getOrderID() {
        return OrderID;
    }

    public int getDeli_PersonID() {
        return Deli_PersonID;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }
}
