package module;

public class DeliveryPerson extends Person{
    enum DeliveryStatus {
        DELIVERING,
        WAITING,
        RESTING;
    }
    private String deliveryArea;
    private DeliveryStatus deliveryStatus;
    public DeliveryPerson(int PersonID, String LastName, String FirsName, String PhoneNumber, Gender Gender, String deliveryArea, DeliveryStatus deliveryStatus) {
        super(PersonID, LastName, FirsName, PhoneNumber, Gender);
        this.deliveryArea = deliveryArea;
        this.deliveryStatus = deliveryStatus;
    }
    public String getDeliveryArea() {
        return deliveryArea;
    }
    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
