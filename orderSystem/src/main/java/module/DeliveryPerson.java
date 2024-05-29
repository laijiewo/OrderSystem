package module;
import module.enums.*;
public class DeliveryPerson extends Person{
    private DeliveryArea deliveryArea;
    private DeliveryStatus deliveryStatus;
    public DeliveryPerson(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, DeliveryArea deliveryArea, DeliveryStatus deliveryStatus) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
        this.deliveryArea = deliveryArea;
        this.deliveryStatus = deliveryStatus;
        personType = personEnum.DELIVERY_PERSON;
    }
    public DeliveryArea getDeliveryArea() {
        return deliveryArea;
    }
    public void setDeliveryArea(DeliveryArea deliveryArea) {
        this.deliveryArea = deliveryArea;
    }
    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
