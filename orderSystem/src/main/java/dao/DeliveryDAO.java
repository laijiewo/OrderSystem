package dao;

import module.Deliver;
import module.DeliveryPerson;
import module.enums.DeliveryStatus;
import module.enums.Gender;
import module.enums.OderStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
    private final String jdbcUser = "your_username";
    private final String jdbcPassword = "your_password";

    public List<Deliver> getAllDelivers() {
        List<Deliver> delivers = new ArrayList<>();

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // Create a statement
            Statement statement = connection.createStatement();
            // Execute SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

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
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // Create a prepared statement
            String sql = "UPDATE orders SET DeliveryStatus = ? WHERE OrderID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, status.name());
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

    public DeliveryPerson getAvailableDeliveryPerson(String orderArea) {
        DeliveryPerson deliveryPerson = null;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // Create a statement
            String sql = "SELECT p.*, dp.DeliveryArea FROM person AS p " +
                    "LEFT JOIN deliveryperson AS dp ON p.PersonID = dp.PersonID " +
                    "LEFT JOIN orders AS o ON dp.PersonID = o.Deli_PersonID " +
                    "WHERE o.Deli_PersonID IS NULL AND dp.DeliveryArea = ? " +
                    "LIMIT 1";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, orderArea);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String personId = resultSet.getString("PersonID");
                String lastName = resultSet.getString("lname");
                String firstName = resultSet.getString("fname");
                String phoneNumber = resultSet.getString("PhoneNumber");
                String password = resultSet.getString("password");
                Gender gender = Gender.valueOf(resultSet.getString("Gender").toUpperCase());
                String deliveryArea = resultSet.getString("DeliveryArea");
                DeliveryStatus status = DeliveryStatus.valueOf(resultSet.getString("status").toUpperCase());
                deliveryPerson = new DeliveryPerson(personId, lastName, firstName, phoneNumber, password, gender, deliveryArea, status);
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deliveryPerson;
    }

    public boolean assignOrderToDeliveryPerson(String orderId, String personId) {
        boolean assigned = false;

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // Create a prepared statement
            String sql = "UPDATE orders SET Deli_PersonID = ? WHERE OrderID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, personId);
            statement.setString(2, orderId);

            // Execute update
            int rowsUpdated = statement.executeUpdate();
            assigned = rowsUpdated > 0;

            // Close connections
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return assigned;
    }
}
