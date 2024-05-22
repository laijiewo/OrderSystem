package module;

import java.util.Date;

public class Review {
    private final int R_PersonID;
    private final Date R_Date;
    private final int Rating;
    private final String Comment;
    private final int R_RestaurantID;


    public Review(int R_PersonID, Date R_Date, int Rating, String Comment, int R_RestaurantID) {
        this.R_PersonID = R_PersonID;
        this.R_Date = R_Date;
        this.Rating = Rating;
        this.Comment = Comment;
        this.R_RestaurantID = R_RestaurantID;
    }

    public int getR_PersonID() {
        return R_PersonID;
    }


    public Date getR_Date() {
        return R_Date;
    }

    public int getRating() {
        return Rating;
    }

    public String getComment() {
        return Comment;
    }

    public int getR_RestaurantID() {
        return R_RestaurantID;
    }
}
