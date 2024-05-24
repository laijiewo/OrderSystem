package dao;

import JDBC.JDBCTool;
import module.Gender;
import module.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            Statement st = conn.createStatement();
            String pid = null;
            String p = null;
            String lName = null;
            String fName = null;
            String phone = null;
            Gender gender = null;
            ResultSet rs = st.executeQuery("SELECT * FROM person WHERE PersonID='"+username+"' AND password='"+password+"'");

            System.out.println("SELECT * FROM user WHERE PersonID='"+username+"' AND password='"+password+"'");
            if(rs.next()) {
                pid = rs.getString("PersonID");
                p = rs.getString("password");
                lName = rs.getString("lname");
                fName = rs.getString("fname");
                phone = rs.getString("PhoneNumber");
                gender = Gender.valueOf(rs.getString("gender"));


            }
            ResultSet rs1 = st.executeQuery("SELECT * FROM user WHERE PersonID='"+username+"'");
            if(rs1.next()) {
                String address = rs1.getString("address");
                User u = new User(pid,lName,fName,phone, p, gender, address);
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn!=null)
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }

        return null;
    }
}
