package module;

import java.sql.Date;

public class Review {
    private final String R_PersonID;
    private final Date R_Date;
    private final float Rating;
    private final String Comment;
    private final String R_RestaurantID;


    public Review(String R_PersonID, Date R_Date, float Rating, String Comment, String R_RestaurantID) {
        this.R_PersonID = R_PersonID;
        this.R_Date = R_Date;
        this.Rating = Rating;
        this.Comment = Comment;
        this.R_RestaurantID = R_RestaurantID;
    }

    public String getR_PersonID() {
        return R_PersonID;
    }


    public Date getR_Date() {
        return  R_Date;
    }

    public float getRating() {
        return Rating;
    }

    public String getComment() {
        return Comment;
    }

    public String getR_RestaurantID() {
        return R_RestaurantID;
    }
}
