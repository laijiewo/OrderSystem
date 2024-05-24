package dao;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import JDBC.JDBCTool;
import module.*;

public class orderDAO {


    public static List<Order> getOrderList() throws SQLException {
        List<Order> orders = new ArrayList<Order>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM order");

            while(rs.next()) {

                String OrderID = rs.getString("OrderID");
                String U_PersonID = rs.getString("U_PersonID");
                Date date = rs.getDate("date");
                Boolean PaymentStatus = rs.getBoolean("PaymentStatus");
                Order r = new Order(OrderID,date,PaymentStatus,U_PersonID);

                orders.add(r);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public Order getOrderByID(String OrderID) throws SQLException {
        List<Order> orders = getOrderList();
        Order order = null;
        for(Order o : orders) {
            if(o.getOrderId().equals(OrderID)) {
                order = o;
            }
        }
        return order;
    }
    public List<Order> getOrdersByU_PersonID(String PersonID) throws SQLException{
        List<Order> orders = new ArrayList<Order>();
        try {
            Connection conn = JDBCTool.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM order WHERE U_PersonID LIKE %ID%");
            while(rs.next()) {

                String OrderID = rs.getString("OrderID");
                String U_PersonID = rs.getString("U_PersonID");
                Date date = rs.getDate("date");
                Boolean PaymentStatus = rs.getBoolean("PaymentStatus");
                Order o = new Order(OrderID,date,PaymentStatus,U_PersonID);
                orders.add(o);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    public boolean insertOrder(Order o) throws SQLException {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO order VALUES (?,?,?,?)");
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getU_PersonId());
            ps.setDate(3, o.getOrderDate());
            ps.setBoolean(4, o.isPaid());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean updateOrder(Order o)  {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("update Order set U_PersonID=?," +
                    "Data=?,PaymentStatus=?,BusinessHours=? where OrderID = ?");
            ps.setString(1, o.getOrderId());
            ps.setString(2, o.getU_PersonId());
            ps.setDate(3, o.getOrderDate());
            ps.setBoolean(4, o.isPaid());
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }
    }

    public boolean deleteOrderByID(String OrderID) {
        try {
            Connection conn = JDBCTool.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM order WHERE OrderID = ?");
            ps.setString(1,OrderID);
            return ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
            return false;
        }



    }

}
