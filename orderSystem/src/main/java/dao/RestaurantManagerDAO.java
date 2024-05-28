package dao;

/** TODO: 1. 登录
 *         2. 注册
 *         3. get管理的餐厅
 *         4. get上任日期
 */

import JDBC.JDBCTool;
import module.Person;
import module.RestaurantManager;
import module.User;
import module.enums.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantManagerDAO {

    // Login method
    public RestaurantManager login(String username, String password) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "SELECT * FROM person AS p " +
                    "LEFT JOIN restaurantmanager AS r ON p.PersonID = r.PersonID " +
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
                Gender gender = Gender.valueOf(rs.getString("Gender"));
                int address = rs.getInt("address");
                Date dateOfStartManager = rs.getDate("DateOfStartManager");
                return new RestaurantManager(pid, lName, fName, phone, p, gender, address, dateOfStartManager);
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

    // Registration method
    public boolean register(String PersonID, String LastName, String FirstName, String PhoneNumber, String password, Gender Gender, String restaurantID, String restaurantName, String address, String contactInformation, String businessHours, Date dateOfStartManager) {
        Connection conn = null;
        try {
            conn = JDBCTool.getConnection();
            String query = "INSERT INTO person (PersonID, fname, lname, password, PhoneNumber, Gender) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, PersonID);
            ps.setString(2, FirstName);
            ps.setString(3, LastName);
            ps.setString(4, password);
            ps.setString(5, PhoneNumber);
            ps.setString(6, Gender.toString());
            ps.executeUpdate();

            query = "INSERT INTO restaurantmanager (PersonID, DateOfStartManager, RestaurantID) VALUES (?,?,?)";
            PreparedStatement ps1 = conn.prepareStatement(query);
            ps1.setString(1, PersonID);
            ps1.setDate(2, dateOfStartManager);
            ps1.setString(3, restaurantID);
            ps1.executeUpdate();

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


    // Get managed restaurants by manager ID
    public static List<String> getManagedRestaurants(int managerID) {
        List<String> restaurants = new ArrayList<>();

        try {
            Connection conn = JDBCTool.getConnection();
            String query = "SELECT RestaurantID FROM restaurantmanager WHERE PersonID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, managerID);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                restaurants.add(rs.getString("RestaurantID"));
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return restaurants;
    }

    // Get start date of management by manager ID
    public static java.sql.Date getStartDate(int managerID) {
        java.sql.Date startDate = null;
        try {
            Connection conn = JDBCTool.getConnection();
            String query = "SELECT DateOfStartManager FROM restaurantmanager WHERE PersonID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setInt(1, managerID);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                startDate = rs.getDate("DateOfStartManager");
            }

            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return startDate;
    }
}
