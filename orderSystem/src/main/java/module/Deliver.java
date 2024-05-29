package module;
import module.enums.OderStatus;
public class Deliver {
    private final String OrderID;
    private String Deli_PersonID;
    private OderStatus status;

    public Deliver(String OrderID, String Deli_PersonID, OderStatus status) {
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

    public OderStatus getStatus() {
        return status;
    }

    public void setStatus(OderStatus status) {
        this.status = status;
    }
}
