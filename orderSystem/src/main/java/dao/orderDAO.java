package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCTool;
import module.Order;
import module.Restaurant;

public class orderDAO {

    public static List<Order> getRestaurantOrderList(String RestaurantID) throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            String sql = "SELECT DISTINCT o.OrderID, Date, PersonID FROM `order` as o " +
                    "LEFT JOIN orderlist as ol ON o.OrderID = ol.OrderID " +
                    "LEFT JOIN dish as d ON ol.DishID = d.DishID " +
                    "LEFT JOIN restaurant as r ON d.D_RestaurantID = r.RestaurantID " +
                    "         WHERE r.RestaurantID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, RestaurantID);
            rs = ps.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String PersonID = rs.getString("PersonID");
                Date date = rs.getDate("Date");
                Order r = new Order(OrderID, date, PersonID);
                orders.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }
        return orders;
    }

    public static Order getOrderByID(String OrderID) throws SQLException {
        Order order = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM `order` WHERE OrderID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, OrderID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String PersonID = rs.getString("PersonID");
                Date date = rs.getDate("Date");
                order = new Order(OrderID, date, PersonID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return order;
    }
    public static Restaurant getRestaurantByOrderID(String OrderID) {
        try {
            String sql = "SELECT * FROM `order` as o LEFT JOIN orderlist as ol ON o.OrderID = ol.OrderID " +
                    "LEFT JOIN dish as d ON ol.DishID = d.DishID WHERE o.OrderID = ?";
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, OrderID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String RestaurantID = rs.getString("D_RestaurantID");
                restaurantDAO rdao = new restaurantDAO();
                Restaurant r = rdao.getRestaurantByID(RestaurantID);
                return r;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Order> getOrdersByPersonID(String PersonID) throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM `order` WHERE PersonID LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + PersonID + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String PersonIDFetched = rs.getString("PersonID");
                Date date = rs.getDate("Date");
                Order o = new Order(OrderID, date, PersonIDFetched);
                orders.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return orders;
    }

    public static boolean insertOrder(Order o) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "INSERT INTO `order` (OrderID, PersonID, Date) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getU_PersonId());
            ps.setDate(3, o.getOrderDate());
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

    public static boolean deleteOrderByID(String OrderID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "DELETE FROM `order` WHERE OrderID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, OrderID);
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


