package dao;

import JDBC.JDBCTool;
import module.Gender;
import module.User;

import java.sql.*;

public class userDAO {
    public static void main(String[] args) {
        User u = login("123456", "123456");
        if (u == null) {
            System.out.println("Login failed");
        } else {
            System.out.println("Login success");
        }
    }
    public static User login(String username, String password) {
        Connection conn = null;

        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person WHERE PersonID=? AND password=?";
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
                Gender gender = Gender.valueOf(rs.getString("gender"));

                String userQuery = "SELECT * FROM user WHERE PersonID=?";
                PreparedStatement ps1 = conn.prepareStatement(userQuery);
                ps1.setString(1, username);

                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    String address = rs1.getString("address");
                    User u = new User(pid, lName, fName, phone, p, gender, address);
                    return u;
                }
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
}
