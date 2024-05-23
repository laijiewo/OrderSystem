package dao;

import JDBC.JDBCTool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDAO {
    public static void main(String[] args) throws SQLException {
        Connection conn = JDBCTool.getConnection();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM user";
        ResultSet rs = stmt.executeQuery(sql);

        if (rs.next()) {
            System.out.println(rs.getString("PersonID"));
        } else {
            System.out.println("No data found.");
        }
    }
}
