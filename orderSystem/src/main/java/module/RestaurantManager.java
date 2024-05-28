package module;

import java.util.Date;
import module.enums.Gender;

public class RestaurantManager extends Person {
    private String RestaurantID;
    private final Date startManagementDate;
    public RestaurantManager(String PersonID, String LastName, String FirsName, String PhoneNumber, String password, Gender Gender, String RestaurantID, Date startManagementDate) {
        super(PersonID, LastName, FirsName, PhoneNumber, password, Gender);
        this.RestaurantID = RestaurantID;
        this.startManagementDate = startManagementDate;
    }

    public String getRestaurantID() {
        return RestaurantID;
    }

    public Date getStartManagementDate() {
        return startManagementDate;
    }

}
