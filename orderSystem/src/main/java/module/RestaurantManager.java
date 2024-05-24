package module;

import java.time.LocalDate;
//import java.util.Date;

public class RestaurantManager extends Person {
    private int RestaurantID;
    private final LocalDate startManagementDate;
    public RestaurantManager(int PersonID, String LastName, String FirstName, String PhoneNumber, Gender Gender, int RestaurantID, LocalDate startManagementDate) {
        super(PersonID, LastName, FirstName, PhoneNumber, Gender);
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
