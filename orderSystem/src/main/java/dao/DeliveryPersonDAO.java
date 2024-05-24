package dao;

import JDBC.JDBCTool;
import module.*;
import module.Gender;
import module.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryPersonDAO {
    public static DeliveryPerson login(String username, String password) {
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

                String userQuery = "SELECT * FROM deliveryperson WHERE PersonID=?";
                PreparedStatement ps1 = conn.prepareStatement(userQuery);
                ps1.setString(1, username);

                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    String deliveryArea = rs1.getString("DeliveryArea");
                    DeliveryStatus status = DeliveryStatus.valueOf(rs1.getString("DeliveryStatus"));
                    DeliveryPerson del_u = new DeliveryPerson(pid, lName, fName, phone, p, gender, deliveryArea, status);
                    return del_u;
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
