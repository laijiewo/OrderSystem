package module;

import module.enums.*;

public class User extends Person {
    private DeliveryArea address;


    public User(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, DeliveryArea address) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
        this.address = address;
        personType = personEnum.USER;
    }

    public DeliveryArea getAddress() {
        return address;
    }

    public void setAddress(DeliveryArea address) {
        this.address = address;
    }
}
