package module;
import module.enums.*;
public class DeliveryPerson extends Person{
    private String deliveryArea;
    private DeliveryStatus deliveryStatus;
    public DeliveryPerson(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, String deliveryArea, DeliveryStatus deliveryStatus) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
        this.deliveryArea = deliveryArea;
        this.deliveryStatus = deliveryStatus;
        personType = personEnum.DELIVERY_PERSON;
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
