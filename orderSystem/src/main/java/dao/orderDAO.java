package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCTool;
import module.Order;

public class orderDAO {

    public static List<Order> getOrderList() throws SQLException {
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM `order`");
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String PersonID = rs.getString("PersonID");
                Date date = rs.getDate("Date");
                Boolean PaymentStatus = rs.getBoolean("PaymentStatus");
                Order r = new Order(OrderID, date, PaymentStatus, PersonID);
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
                Boolean PaymentStatus = rs.getBoolean("PaymentStatus");
                order = new Order(OrderID, date, PaymentStatus, PersonID);
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
                Boolean PaymentStatus = rs.getBoolean("PaymentStatus");
                Order o = new Order(OrderID, date, PaymentStatus, PersonIDFetched);
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
            String sql = "INSERT INTO `order` (OrderID, PersonID, Date, PaymentStatus) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getU_PersonId());
            ps.setDate(3, o.getOrderDate());
            ps.setBoolean(4, o.isPaid());
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

    public static boolean updateOrder(Order o) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "UPDATE `order` SET PersonID = ?, Date = ?, PaymentStatus = ? WHERE OrderID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, o.getU_PersonId());
            ps.setDate(2, o.getOrderDate());
            ps.setBoolean(3, o.isPaid());
            ps.setString(4, o.getOrderId());
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


