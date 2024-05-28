package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTool {

    public static Connection getConnection(String url, String dbname, String username, String password) {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+url+"/"+dbname, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
    public static Connection getConnection() {
        return JDBCTool.getConnection("localhost", "ordersystem", "root", "Ljw200411260011");
    }

}