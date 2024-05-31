package module;

import JDBC.JDBCTool;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class randomString {
    public static String generateRandomOrderID() throws SQLException {
        String randomID = randomStringNumber(8);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM `order`");
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                if(Objects.equals(OrderID, randomID)){
                    return generateRandomOrderID();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return randomID;
    }
    public static String generateRandomRestaurantID() throws SQLException {
        String randomID = randomStringNumber(7);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM restaurant");
            while (rs.next()) {
                String RestaurantID = rs.getString("RestaurantID");
                if(Objects.equals(RestaurantID, randomID)){
                    return generateRandomRestaurantID();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return randomID;
    }
    public static String generateRandomPersonID() throws SQLException {
        String randomID = randomStringNumber(6);

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM person");
            while (rs.next()) {
                String PersonID = rs.getString("PersonID");
                if(Objects.equals(PersonID, randomID)){
                    return generateRandomPersonID();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return randomID;
    }
    public static String generateRandomDishID() throws SQLException {
        String randomID = randomStringNumber(4);

        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM `order`");
            while (rs.next()) {
                String DishID = rs.getString("DishID");
                if(Objects.equals(DishID, randomID)){
                    return generateRandomDishID();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return randomID;
    }
    private static String randomStringNumber(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }
        SecureRandom secureRandom = new SecureRandom() ;
        String digits = "0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(digits.length());
            sb.append(digits.charAt(randomIndex));
        }

        return sb.toString();
    }
}
