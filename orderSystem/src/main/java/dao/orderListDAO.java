package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JDBC.JDBCTool;
import module.OrderList;

public class orderListDAO {

    public static List<OrderList> getOrderList() throws SQLException {
        List<OrderList> orderLists = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM orderlist");
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String DishID = rs.getString("DishID");
                String Comments = rs.getString("Comments");
                OrderList r = new OrderList(OrderID, DishID, Comments);
                orderLists.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }
        return orderLists;
    }

    public static OrderList getOrderByID(String OrderID) throws SQLException {
        OrderList orderList = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM orderlist WHERE OrderID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, OrderID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String DishID = rs.getString("DishID");
                String Comments = rs.getString("Comments");
                orderList = new OrderList(OrderID, DishID, Comments);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return orderList;
    }

    public static List<OrderList> getOrdersByDishID(String DishID) throws SQLException {
        List<OrderList> orderLists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM orderlist WHERE DishID LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + DishID + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                String dishIDFetched = rs.getString("DishID");
                String Comments = rs.getString("Comments");
                OrderList o = new OrderList(OrderID, dishIDFetched, Comments);
                orderLists.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        }
        return orderLists;
    }

    public static boolean insertOrderList(OrderList o) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "INSERT INTO orderlist (OrderID, DishID, Comments) VALUES (?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getDishId());
            ps.setString(3, o.getComments());
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

    public static boolean updateOrderList(OrderList o) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "UPDATE orderlist SET DishID = ?, Comments = ? WHERE OrderID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, o.getDishId());
            ps.setString(2, o.getComments());
            ps.setString(3, o.getOrderId());
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

    public static boolean deleteOrderListByID(String OrderID) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JDBCTool.getConnection();
            String sql = "DELETE FROM orderlist WHERE OrderID = ?";
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

