package module;

import JDBC.JDBCTool;

import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class randomString {
    public static String generateRandomOrderID(int length) throws SQLException {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero.");
        }
        SecureRandom secureRandom = new SecureRandom() ;
        String digits = "0123456789";
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(digits.length());
            sb.append(digits.charAt(randomIndex));
        }
        String randomID = sb.toString();

        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JDBCTool.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM `order`");
            while (rs.next()) {
                String OrderID = rs.getString("OrderID");
                if(Objects.equals(OrderID, randomID)){
                    return generateRandomOrderID(length);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (conn != null) conn.close();
        }

        return randomID;
    }
}
