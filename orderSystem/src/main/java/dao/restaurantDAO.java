package dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCTool;
import module.*;

public class restaurantDAO {


    public static List<Restaurant> getRestaurantList() throws SQLException {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM restaurant");

            while(rs.next()) {

                String RestaurantID = rs.getString("RestaurantID");
                String RestaurantName = rs.getString("RestaurantName");
                String Address = rs.getString("Address");
                String ContactInformation = rs.getString("ContactInformation");
                String BusinessHours = rs.getString("BusinessHours");
                String M_PersonID = rs.getString("M_PersonID");
                Restaurant r = new Restaurant(RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, M_PersonID);

                restaurants.add(r);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    public Restaurant getRestaurantByID(String RestaurantID) throws SQLException {
        List<Restaurant> restaurants = getRestaurantList();
        Restaurant restaurant = null;
        for(Restaurant r : restaurants) {
            if(r.getRestaurantID().equals(RestaurantID)) {
                restaurant = r;
            }
        }
        return restaurant;
    }
    public List<Restaurant> getRestaurantsByName(String name) throws SQLException {
        if(name == null || name.equals("")) {
            return getRestaurantList();
        }
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM restaurant WHERE RestaurantName LIKE ?";

        try (Connection conn = JDBCTool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String restaurantID = rs.getString("RestaurantID");
                    String restaurantName = rs.getString("RestaurantName");
                    String address = rs.getString("Address");
                    String contactInformation = rs.getString("ContactInformation");
                    String businessHours = rs.getString("BusinessHours");
                    String m_PersonID = rs.getString("M_PersonID");

                    Restaurant restaurant = new Restaurant(restaurantID, restaurantName, address, contactInformation, businessHours, m_PersonID);
                    restaurants.add(restaurant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    // Add a new restaurant
    public static boolean addRestaurant(String restaurantID, String restaurantName, String Address, String contactInformation, String businessHours, String M_PersonID) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "INSERT INTO restaurant (RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, M_PersonID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, restaurantID);
            pst.setString(2, restaurantName);
            pst.setString(3, Address);
            pst.setString(4, contactInformation);
            pst.setString(5, businessHours);
            pst.setString(6, M_PersonID);
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    // Update restaurant name
    public static boolean updateRestaurantName(String restaurantID, String restaurantName) {
        return updateRestaurantField(restaurantID, "RestaurantName", restaurantName);
    }

    // Update restaurant address
    public static boolean updateRestaurantAddress(String restaurantID, String restaurantAddress) {
        return updateRestaurantField(restaurantID, "Address", restaurantAddress);
    }

    // Update restaurant contact information
    public static boolean updateContactInformation(String restaurantID, String contactInformation) {
        return updateRestaurantField(restaurantID, "ContactInformation", contactInformation);
    }

    // Update restaurant business hours
    public static boolean updateBusinessHours(String restaurantID, String businessHours) {
        return updateRestaurantField(restaurantID, "BusinessHours", businessHours);
    }

    // Update restaurant manager person ID
    public static boolean updateManagerPersonID(String restaurantID, String managerPersonID) {
        return updateRestaurantField(restaurantID, "M_PersonID", managerPersonID);
    }

    // Helper method to update a specific field
    private static boolean updateRestaurantField(String restaurantID, String fieldName, String fieldValue) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "UPDATE restaurant SET " + fieldName + " = ? WHERE RestaurantID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, fieldValue);
            pst.setString(2, restaurantID);
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean deleteOwnRestaurant(String restaurantID, String userID) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();

            // Check if the user is the owner of the restaurant
            String checkQuery = "SELECT COUNT(*) FROM restaurant WHERE RestaurantID = ? AND M_PersonID = ?";
            PreparedStatement checkPst = conn.prepareStatement(checkQuery);
            checkPst.setString(1, restaurantID);
            checkPst.setString(2, userID);
            ResultSet rs = checkPst.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                // User is the owner, proceed with deletion
                String deleteQuery = "DELETE FROM restaurant WHERE RestaurantID = ?";
                PreparedStatement deletePst = conn.prepareStatement(deleteQuery);
                deletePst.setString(1, restaurantID);
                int rowsAffected = deletePst.executeUpdate();
                result = rowsAffected > 0;

                deletePst.close();
            }

            rs.close();
            checkPst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

}
