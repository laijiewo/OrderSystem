package module;

import java.util.Date;

public class RestaurantManager extends Person {
    private int RestaurantID;
    private final Date startManagementDate;
    public RestaurantManager(int PersonID, String LastName, String FirsName, String PhoneNumber, Gender Gender, int RestaurantID, Date startManagementDate) {
        super(PersonID, LastName, FirsName, PhoneNumber, Gender);
        this.RestaurantID = RestaurantID;
        this.startManagementDate = startManagementDate;
    }

    public int getRestaurantID() {
        return RestaurantID;
    }

    public Date getStartManagementDate() {
        return startManagementDate;
    }

}
