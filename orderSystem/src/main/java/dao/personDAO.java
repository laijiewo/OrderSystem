package dao;

import JDBC.JDBCTool;
import module.Person;
import module.User;
import module.enums.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class personDAO {
    public Person login(String username, String password) throws Exception {
        Connection conn = null;

        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person AS p " +
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
                return new Person(pid, lName, fName, phone, p, gender);
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
    public void setPhoneNumber(String PersonID, String PhoneNumber) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "UPDATE person SET PhoneNumber=? WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PhoneNumber);
            ps.setString(2, PersonID);
            ps.executeUpdate();
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
    }
    public String getPhoneNumber(String PersonID) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT PhoneNumber FROM person WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("PhoneNumber");
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
    public String getName(String PersonID) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT lname, fname FROM person WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("lname") + " " + rs.getString("fname");
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
    public Gender getGender(String PersonID) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT gender FROM person WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Gender.valueOf(rs.getString("gender").toUpperCase(Locale.ROOT));
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
