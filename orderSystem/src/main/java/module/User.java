package module;

public class User extends Person {
    private String address;


    public User(int PersonID, String LastName, String FirsName, String PhoneNumber, Gender Gender, String address) {
        super(PersonID, LastName, FirsName, PhoneNumber, Gender);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
