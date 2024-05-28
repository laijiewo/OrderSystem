package dao;

import JDBC.JDBCTool;
import module.Person;
import module.enums.Gender;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public abstract class personDAO {
    public abstract Person login(String username, String password);
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
