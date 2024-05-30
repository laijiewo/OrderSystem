package dao;

import JDBC.JDBCTool;
import module.Deliver;
import module.DeliveryPerson;
import module.enums.DeliveryArea;
import module.enums.DeliveryStatus;
import module.enums.Gender;
import module.enums.OderStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
    public List<Deliver> getAllDelivers() {
        List<Deliver> delivers = new ArrayList<>();

        try {
            // Establish database connection
            Connection connection = JDBCTool.getConnection();
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `order`");

            // Process the result set
            while (resultSet.next()) {
                String orderID = resultSet.getString("OrderID");
                String deliPersonID = resultSet.getString("Deli_PersonID");
                OderStatus status = OderStatus.valueOf(resultSet.getString("DeliveryStatus"));
                delivers.add(new Deliver(orderID, deliPersonID, status));
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return delivers;
    }

    public boolean updateDeliverStatus(String orderId, OderStatus status) {
        boolean updated = false;

        try {
            // Establish database connection
            Connection connection = JDBCTool.getConnection();
            // Create a prepared statement
            String sql = "UPDATE deliver SET DeliveryStatus = ? WHERE OrderID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, status.toString());
            statement.setString(2, orderId);

            // Execute update
            int rowsUpdated = statement.executeUpdate();
            updated = rowsUpdated > 0;

            // Close connections
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    public OderStatus getDeliverStatus(String orderId) {
        OderStatus status = null;

        try {
            // Establish database connection
            Connection connection = JDBCTool.getConnection();
            // Create a prepared statement
            String sql = "SELECT * FROM deliver WHERE OrderID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderId);
            // Execute query
            ResultSet resultSet = statement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                status = OderStatus.valueOf(resultSet.getString("DeliveryStatus"));
            }

            // Close connections
            statement.close();
            connection.close();
            resultSet.close();
            return status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
