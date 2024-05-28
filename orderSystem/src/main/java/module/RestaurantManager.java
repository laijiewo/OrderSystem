package module;

import java.time.LocalDate;
<<<<<<< HEAD
//import java.util.Date;

public class RestaurantManager extends Person {
    private int RestaurantID;
    private final LocalDate startManagementDate;
    public RestaurantManager(int PersonID, String LastName, String FirstName, String PhoneNumber, Gender Gender, int RestaurantID, LocalDate startManagementDate) {
        super(PersonID, LastName, FirstName, PhoneNumber, Gender);
=======
import java.util.Date;
import module.enums.Gender;

public class RestaurantManager extends Person {
    private int RestaurantID;
    private final Date startManagementDate;
    public RestaurantManager(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, int RestaurantID, Date startManagementDate) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
>>>>>>> main
        this.RestaurantID = RestaurantID;
        this.startManagementDate = startManagementDate;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public LocalDate getStartManagementDate() {
        return startManagementDate;
    }

}
