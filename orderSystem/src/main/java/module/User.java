package module;

import module.enums.Gender;

public class User extends Person {
    private String address;


    public User(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, String address) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
