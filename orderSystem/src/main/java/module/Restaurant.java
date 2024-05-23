package module;

public class Restaurant {
    private final String RestaurantID;
    private String RestaurantName;
    private String RestaurantAddress;
    private String Contact_Information;
    private String Business_Hours;
    private String M_PersonID;

    public Restaurant(String RestaurantID, String RestaurantName, String RestaurantAddress, String Contact_Information, String Business_Hours, String M_PersonID) {
        this.RestaurantID = RestaurantID;
        this.RestaurantName = RestaurantName;
        this.RestaurantAddress = RestaurantAddress;
        this.Contact_Information = Contact_Information;
        this.Business_Hours = Business_Hours;
        this.M_PersonID = M_PersonID;
    }


    public String  getRestaurantID() {
        return RestaurantID;
    }

    public String getRestaurantName() {
        return RestaurantName;
    }

    public String getRestaurantAddress() {
        return RestaurantAddress;
    }

    public String getContact_Information() {
        return Contact_Information;
    }

    public String getBusiness_Hours() {
        return Business_Hours;
    }

    public String getM_PersonID() {
        return M_PersonID;
    }

    public void setRestaurantName(String RestaurantName) {
        this.RestaurantName = RestaurantName;
    }

    public void setRestaurantAddress(String RestaurantAddress) {
        this.RestaurantAddress = RestaurantAddress;
    }

    public void setContact_Information(String Contact_Information) {
        this.Contact_Information = Contact_Information;
    }

    public void setBusiness_Hours(String Business_Hours) {
        this.Business_Hours = Business_Hours;
    }

    public void setM_PersonID(String M_PersonID) {
        this.M_PersonID = M_PersonID;
    }


}
