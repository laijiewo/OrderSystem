package dao;

import JDBC.JDBCTool;
import module.*;
import module.enums.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class DeliveryPersonDAO extends personDAO {
    @Override
    public DeliveryPerson login(String username, String password) throws Exception {
        Connection conn = null;

        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person AS p " +
                    "RIGHT JOIN deliveryperson AS dp ON p.PersonID = dp.PersonID " +
                    "WHERE p.PersonID=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pid = rs.getString("PersonID");
                String p = rs.getString("password");
                String lName = rs.getString("lname");
                String fName = rs.getString("fname");
                String phone = rs.getString("PhoneNumber");
                Gender gender = Gender.valueOf(rs.getString("Gender").toUpperCase(Locale.ROOT));
                DeliveryArea deliveryArea = DeliveryArea.valueOf(rs.getString("deliveryArea"));
                DeliveryStatus status = DeliveryStatus.valueOf(rs.getString("status").toUpperCase(Locale.ROOT));
                return new DeliveryPerson(pid, lName, fName, phone, p, gender, deliveryArea, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    public boolean register(String PersonID, String LastName, String FirsName, String password, String PhoneNumber, Gender Gender, DeliveryArea deliveryArea) throws Exception {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "INSERT INTO person (PersonID, fname, lname, password, PhoneNumber, gender) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, FirsName);
            ps.setString(3, LastName);
            ps.setString(4, password);
            ps.setString(5, PhoneNumber);
            ps.setString(6, Gender.toString());
            ps.executeUpdate();

            query = "INSERT INTO deliveryperson (PersonID, DeliveryArea, Status) VALUES (?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, deliveryArea.toString());
            ps.setString(3, DeliveryStatus.WAITING.toString());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean updateDeliveryArea(String PersonID, DeliveryArea deliveryArea) throws Exception {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "UPDATE user SET DeliveryArea=? WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, deliveryArea.toString());
            ps.setString(2, PersonID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean updateStatus(String PersonID, DeliveryStatus status) throws Exception {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "UPDATE user SET Status=? WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, status.toString());
            ps.setString(2, PersonID);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
