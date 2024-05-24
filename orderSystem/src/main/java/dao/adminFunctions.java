package dao;

import JDBC.JDBCTool;
import module.Dish;
import module.Order;
import module.Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class adminFunctions {

    // Restaurant management methods
    public static List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM restaurant");

            while (rs.next()) {
                int restaurantID = rs.getInt("RestaurantID");
                String restaurantName = rs.getString("RestaurantName");
                String restaurantAddress = rs.getString("RestaurantAddress");
                String contactInformation = rs.getString("Contact_Information");
                String businessHours = rs.getString("Business_Hours");
                int mPersonID = rs.getInt("M_PersonID");
                Restaurant restaurant = new Restaurant(restaurantID, restaurantName, restaurantAddress, contactInformation, businessHours, mPersonID);
                restaurants.add(restaurant);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    public static Restaurant getRestaurantByID(int restaurantID) {
        Restaurant restaurant = null;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "SELECT * FROM restaurant WHERE RestaurantID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, restaurantID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String restaurantName = rs.getString("RestaurantName");
                String restaurantAddress = rs.getString("RestaurantAddress");
                String contactInformation = rs.getString("Contact_Information");
                String businessHours = rs.getString("Business_Hours");
                int mPersonID = rs.getInt("M_PersonID");
                restaurant = new Restaurant(restaurantID, restaurantName, restaurantAddress, contactInformation, businessHours, mPersonID);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurant;
    }

    public static boolean deleteRestaurantByID(int restaurantID) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "DELETE FROM restaurant WHERE RestaurantID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, restaurantID);
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean updateRestaurant(Restaurant restaurant) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "UPDATE restaurant SET RestaurantName = ?, RestaurantAddress = ?, Contact_Information = ?, Business_Hours = ?, M_PersonID = ? WHERE RestaurantID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, restaurant.getRestaurantName());
            pst.setString(2, restaurant.getRestaurantAddress());
            pst.setString(3, restaurant.getContact_Information());
            pst.setString(4, restaurant.getBusiness_Hours());
            pst.setInt(5, restaurant.getM_PersonID());
            pst.setInt(6, restaurant.getRestaurantID());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean insertRestaurant(Restaurant restaurant) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "INSERT INTO restaurant (RestaurantName, RestaurantAddress, Contact_Information, Business_Hours, M_PersonID) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, restaurant.getRestaurantName());
            pst.setString(2, restaurant.getRestaurantAddress());
            pst.setString(3, restaurant.getContact_Information());
            pst.setString(4, restaurant.getBusiness_Hours());
            pst.setInt(5, restaurant.getM_PersonID());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Dish management methods
    public static List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM dish");

            while (rs.next()) {
                int dishId = rs.getInt("DishId");
                String dishName = rs.getString("DishName");
                double dishPrice = rs.getDouble("DishPrice");
                boolean dishAvailability = rs.getBoolean("DishAvailability");
                int dRestaurantId = rs.getInt("D_RestaurantId");
                Dish dish = new Dish(dishId, dishName, dishPrice, dishAvailability, dRestaurantId);
                dishes.add(dish);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dishes;
    }

    public static Dish getDishByID(int dishId) {
        Dish dish = null;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "SELECT * FROM dish WHERE DishId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, dishId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String dishName = rs.getString("DishName");
                double dishPrice = rs.getDouble("DishPrice");
                boolean dishAvailability = rs.getBoolean("DishAvailability");
                int dRestaurantId = rs.getInt("D_RestaurantId");
                dish = new Dish(dishId, dishName, dishPrice, dishAvailability, dRestaurantId);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dish;
    }

    public static boolean deleteDishByID(int dishId) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "DELETE FROM dish WHERE DishId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, dishId);
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean updateDish(Dish dish) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "UPDATE dish SET DishName = ?, DishPrice = ?, DishAvailability = ? WHERE DishId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, dish.getDishName());
            pst.setDouble(2, dish.getDishPrice());
            pst.setBoolean(3, dish.isDishAvailability());
            pst.setInt(4, dish.getDishId());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean insertDish(Dish dish) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "INSERT INTO dish (DishName, DishPrice, DishAvailability, D_RestaurantId) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, dish.getDishName());
            pst.setDouble(2, dish.getDishPrice());
            pst.setBoolean(3, dish.isDishAvailability());
            pst.setInt(4, dish.getD_RestaurantId());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Order management methods
    public static List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();

        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `order`");

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                Date orderDate = rs.getDate("orderDate");
                boolean isPaid = rs.getBoolean("isPaid");
                int uPersonId = rs.getInt("uPersonId");
                Order order = new Order(orderId, orderDate, isPaid, uPersonId);
                orders.add(order);
            }

            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static Order getOrderByID(int orderId) {
        Order order = null;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "SELECT * FROM `order` WHERE orderId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, orderId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Date orderDate = rs.getDate("orderDate");
                boolean isPaid = rs.getBoolean("isPaid");
                int uPersonId = rs.getInt("uPersonId");
                order = new Order(orderId, orderDate, isPaid, uPersonId);
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }

    public static boolean deleteOrderByID(int orderId) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "DELETE FROM `order` WHERE orderId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, orderId);
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean updateOrder(Order order) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "UPDATE `order` SET isPaid = ? WHERE orderId = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setBoolean(1, order.isPaid());
            pst.setInt(2, order.getOrderId());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean insertOrder(Order order) {
        boolean result = false;

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "INSERT INTO `order` (orderDate, isPaid, uPersonId) VALUES (?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            pst.setBoolean(2, order.isPaid());
            pst.setInt(3, order.getU_PersonId());
            int rowsAffected = pst.executeUpdate();
            result = rowsAffected > 0;

            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
