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
    public List<Restaurant> getRestaurantsByName(String Name) throws SQLException{
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM restaurant WHERE RestaurantName LIKE %Name%");
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

    public boolean insertRestaurant(Restaurant r) throws SQLException {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO restaurant VALUES (?,?,?,?,?,?)");
            ps.setString(1, r.getRestaurantID());
            ps.setString(2, r.getRestaurantName());
            ps.setString(3,r.getRestaurantAddress());
            ps.setString(4,r.getContact_Information());
            ps.setString(5,r.getBusiness_Hours());
            ps.setString(6,r.getM_PersonID());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean updateRestaurant(Restaurant r)  {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("update restaurant set RestaurantName=?," +
                    "Address=?,ContactInformation=?,BusinessHours=?,M_PersonID=? where RestaurantID = ?");
            ps.setString(1, r.getRestaurantName());
            ps.setString(2,r.getRestaurantAddress());
            ps.setString(3,r.getContact_Information());
            ps.setString(4,r.getBusiness_Hours());
            ps.setString(5,r.getM_PersonID());
            ps.setString(6,r.getRestaurantID());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean deleteRestaurantByID(String RestaurantID) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM restaurant WHERE RestaurantID = ?");
            ps.setString(1,RestaurantID);
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }



    }

}
