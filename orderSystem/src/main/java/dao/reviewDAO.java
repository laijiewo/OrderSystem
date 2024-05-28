package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCTool;
import module.Review;

public class reviewDAO {

    public static List<Review> getReviewList() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM review");
            while (rs.next()) {
                String R_PersonID = rs.getString("R_PersonID");
                Date date = rs.getDate("Date");
                float Rating = rs.getFloat("Rating");
                String ReviewContent = rs.getString("ReviewContent");
                String RestaurantID = rs.getString("RestaurantID");
                Review review = new Review(R_PersonID, date, Rating, ReviewContent, RestaurantID);
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }
        return reviews;
    }

    public static Review getReviewByID(String R_PersonID, Date date) throws SQLException {
        Review review = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM review WHERE R_PersonID = ? AND Date = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, R_PersonID);
            ps.setDate(2, date);
            rs = ps.executeQuery();
            if (rs.next()) {
                float Rating = rs.getFloat("Rating");
                String ReviewContent = rs.getString("ReviewContent");
                String RestaurantID = rs.getString("RestaurantID");
                review = new Review(R_PersonID, date, Rating, ReviewContent, RestaurantID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return review;
    }

    public static List<Review> getReviewsByDate(Date date) throws SQLException {
        List<Review> reviews = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM review WHERE Date = ?";
            ps = conn.prepareStatement(sql);
            ps.setDate(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                String R_PersonID = rs.getString("R_PersonID");
                float Rating = rs.getFloat("Rating");
                String ReviewContent = rs.getString("ReviewContent");
                String RestaurantID = rs.getString("RestaurantID");
                Review review = new Review(R_PersonID, date, Rating, ReviewContent, RestaurantID);
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return reviews;
    }

    public static boolean insertReview(Review review) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "INSERT INTO review (R_PersonID, Date, Rating, ReviewContent, RestaurantID) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, review.getR_PersonID());
            ps.setDate(2, review.getR_Date());
            ps.setFloat(3, review.getRating());
            ps.setString(4, review.getReviewContent());
            ps.setString(5, review.getR_RestaurantID());
            int rowsInserted = ps.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException s) {
            s.printStackTrace();
            return false;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static boolean updateReview(Review review) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "UPDATE review SET Rating = ?, ReviewContent = ?, RestaurantID = ? WHERE R_PersonID = ? AND Date = ?";
            ps = conn.prepareStatement(sql);
            ps.setFloat(1, review.getRating());
            ps.setString(2, review.getReviewContent());
            ps.setString(3, review.getR_RestaurantID());
            ps.setString(4, review.getR_PersonID());
            ps.setDate(5, review.getR_Date());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException s) {
            s.printStackTrace();
            return false;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }

    public static boolean deleteReviewByID(String R_PersonID, Date date) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "DELETE FROM review WHERE R_PersonID = ? AND Date = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, R_PersonID);
            ps.setDate(2, date);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException s) {
            s.printStackTrace();
            return false;
        } finally {
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
    }
}
