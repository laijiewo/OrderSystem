package module;

public class Person {
    private final String PersonID;
    private final String LastName;
    private final String FirsName;
    private String PhoneNumber;
    private String password;
    private final Gender Gender;

    public Person(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender) {
        this.PersonID = PersonID;
        this.LastName = LastName;
        this.FirsName = FirsName;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
    }

    public String getPersonID() {
        return PersonID;
    }


    public String getLastName() {
        return LastName;
    }

    public String getFirsName() {
        return FirsName;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
    public String getGender() {
        return Gender.toString();
    }
}
