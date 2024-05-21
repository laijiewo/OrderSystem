package module;

public class Person {
    enum Gender {
        MALE, FEMALE
    }
    private final int PersonID;
    private final String LastName;
    private final String FirsName;
    private String PhoneNumber;
    private final Gender Gender;

    public Person(int PersonID, String LastName, String FirsName, String PhoneNumber, Gender Gender) {
        this.PersonID = PersonID;
        this.LastName = LastName;
        this.FirsName = FirsName;
        this.PhoneNumber = PhoneNumber;
        this.Gender = Gender;
    }

    public int getPersonID() {
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
