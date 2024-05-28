package dao;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import JDBC.JDBCTool;
import module.*;

import javax.xml.crypto.Data;

public class reviewDAO {


    public static List<Review> getR_PersonIDList() throws SQLException {
        List<Review> reviews = new ArrayList<Review>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM review");

            while(rs.next()) {

                String R_PersonID = rs.getString("R_PersonID");
                Date Date = rs.getDate("Data");
                float Rating = rs.getInt("Rating");
                String ReviewContent = rs.getString("ReviewContent");
                String RestaurantID = rs.getString("RestaurantID");
                Review r = new Review(R_PersonID, Date, Rating, ReviewContent, RestaurantID);

                reviews.add(r);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public Review getRestaurantByID(int R_PersonID) throws SQLException {
        List<Review> reviews = getR_PersonIDList();
        Review review = null;
        for(Review r : reviews) {
            if(r.getR_PersonID().equals(R_PersonID)) {
                review = r;
            }
        }
        return review;
    }
    public List<Review> getReviewsByData(Data data) throws SQLException{
        List<Review> reviews = new ArrayList<Review>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM review WHERE date LIKE %data%");
            while(rs.next()) {
                String R_PersonID = rs.getString("R_PersonID");
                Date Date = rs.getDate("Data");
                float Rating = rs.getFloat("Rating");
                String ReviewContent = rs.getString("ReviewContent");
                String RestaurantID = rs.getString("RestaurantID");
                Review r = new Review(R_PersonID, Date, Rating, ReviewContent, RestaurantID);

                reviews.add(r);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    public boolean insertReview(Review r) throws SQLException {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO review VALUES (?,?,?,?,?)");
            ps.setString(1, r.getR_PersonID());
            ps.setDate(2, r.getR_Date());
            ps.setString(3,r.getR_RestaurantID());
            ps.setString(4,r.getComment());
            ps.setFloat(5,r.getRating());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean updateReview(Review r)  {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("update review set Date=?,RestaurantID=?,Rating=?,Comment=? where R_PersonID = ?");
            ps.setString(1, r.getR_PersonID());
            ps.setDate(2, r.getR_Date());
            ps.setString(3,r.getR_RestaurantID());
            ps.setString(4,r.getComment());
            ps.setFloat(5,r.getRating());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean deleteReviewByPersonID(String R_PersonID) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM review WHERE R_PersonID = ?");
            ps.setString(1,R_PersonID);
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }

    }
    public boolean deleteReviewByPersonID(Date date) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM review WHERE date = ?");
            ps.setDate(1,date);
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }

    }

}
