package dao;

import JDBC.JDBCTool;

import module.enums.DeliveryArea;
import module.enums.Gender;
import module.User;

import java.sql.*;
import java.util.Locale;

public class userDAO extends personDAO {
    @Override
    public User login(String username, String password) throws Exception {
        Connection conn = null;

        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person AS p " +
                    "RIGHT JOIN user AS u ON p.PersonID = u.PersonID " +
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
                DeliveryArea address = DeliveryArea.valueOf(rs.getString("address"));
                return new User(pid, lName, fName, phone, p, gender, address);
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
    public boolean register(String PersonID, String LastName, String FirsName, String password, String PhoneNumber, Gender Gender, DeliveryArea address) throws Exception {
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

            query = "INSERT INTO user (PersonID, address) VALUES (?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, address.toString());
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
    public void setAddress(String PersonID, DeliveryArea address) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "UPDATE user SET address=? WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, address.toString());
            ps.setString(2, PersonID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public DeliveryArea getAddress(String PersonID) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT address FROM user WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return DeliveryArea.valueOf(rs.getString("address"));
            }
        } catch (SQLException e) {
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
        return null;
    }
}
