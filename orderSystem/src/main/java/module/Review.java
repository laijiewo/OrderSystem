package module;

import java.sql.Date;

public class Review {

    private String R_PersonID;
    private Date R_Date;
    private float rating;
    private String reviewContent;
    private String R_RestaurantID;

    // Constructor
    public Review(String R_PersonID, Date R_Date, float rating, String reviewContent, String R_RestaurantID) {
        this.R_PersonID = R_PersonID;
        this.R_Date = R_Date;
        this.rating = rating;
        this.reviewContent = reviewContent;
        this.R_RestaurantID = R_RestaurantID;
    }

    // Getters and Setters
    public String getR_PersonID() {
        return R_PersonID;
    }

    public Date getR_Date() {
        return R_Date;
    }

    public float getRating() {
        return rating;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public String getR_RestaurantID() {
        return R_RestaurantID;
    }

    public void setR_PersonID(String r_PersonID) {
        R_PersonID = r_PersonID;
    }

    public void setR_Date(Date r_Date) {
        R_Date = r_Date;
    }

    public void setRating(float rating) {
        if (rating < 0.0 || rating > 5.0) {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0");
        }
        this.rating = rating;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public void setR_RestaurantID(String r_RestaurantID) {
        R_RestaurantID = r_RestaurantID;
    }
}
