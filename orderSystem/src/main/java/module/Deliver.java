package module;
import module.enums.DeliverStatus;
public class Deliver {
<<<<<<< HEAD
    private final int OrderID;
    private int Deli_PersonID;
=======
    private final String OrderID;
    private String Deli_PersonID;
>>>>>>> main
    private DeliverStatus status;

    public Deliver(String OrderID, String Deli_PersonID, DeliverStatus status) {
        this.OrderID = OrderID;
        this.Deli_PersonID = Deli_PersonID;
        this.status = status;
    }

    public String getOrderID() {
        return OrderID;
    }

    public String getDeli_PersonID() {
        return Deli_PersonID;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }
}
