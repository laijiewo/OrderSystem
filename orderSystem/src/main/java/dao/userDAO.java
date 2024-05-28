package dao;

import JDBC.JDBCTool;
import module.enums.Gender;
import module.User;

import java.sql.*;

public class userDAO {
    public User login(String username, String password) {
        Connection conn = null;

        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person AS p " +
                    "LEFT JOIN user AS u ON p.PersonID = u.PersonID " +
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
                Gender gender = Gender.valueOf(rs.getString("gender").toUpperCase());
                String address = rs.getString("address");
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
    public boolean register(String PersonID, String LastName, String FirsName, String password, String PhoneNumber, Gender Gender, String address) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "INSERT INTO person (PersonID, lname, fname, password, PhoneNumber, gender) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, LastName);
            ps.setString(3, FirsName);
            ps.setString(4, password);
            ps.setString(5, PhoneNumber);
            ps.setString(6, Gender.toString());
            ps.executeUpdate();

            query = "INSERT INTO user (PersonID, address) VALUES (?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, address);
            ps.executeUpdate();
            return true;
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
    public void setAddress(String PersonID, String address) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "UPDATE user SET address=? WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, address);
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
    public String getAddress(String PersonID) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT address FROM user WHERE PersonID=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("address");
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
                return Gender.valueOf(rs.getString("gender"));
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
