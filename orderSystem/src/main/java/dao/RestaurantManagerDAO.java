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

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

    public class RestaurantManagerDAO {

        // Login method
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
                    Person.Gender gender = Gender.valueOf(rs.getString("gender"));
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

        // Registration method
        public boolean register(String PersonID, String LastName, String FirstName, String password, String PhoneNumber, Gender Gender, String address) {
            Connection conn = null;
            try {
                conn = JDBCTool.getConnection();
                String query = "INSERT INTO person (PersonID, lname, fname, password, PhoneNumber, gender) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, PersonID);
                ps.setString(2, LastName);
                ps.setString(3, FirstName);
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

        // Get managed restaurants by manager ID
        public static List<String> getManagedRestaurants(int managerID) {
            List<String> restaurants = new ArrayList<>();
            try {
                Connection conn = JDBCTool.getConnection();
                String query = "SELECT RestaurantID FROM restaurant_manager WHERE ManagerID = ?";
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
                String query = "SELECT dateOfStartManage FROM restaurant_manager WHERE ManagerID = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setInt(1, managerID);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    startDate = rs.getDate("dateOfStartManage");
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


