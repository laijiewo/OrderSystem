package dao;

import module.Deliver;
import module.DeliveryPerson;
import module.enums.DeliveryStatus;
import module.enums.OderStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import static org.junit.Assert.*;

public class DeliveryDAOTest {
    private DeliveryDAO deliveryDAO;

    @Before
    public void setUp() throws Exception {
        deliveryDAO = new DeliveryDAO();

        // Initialize database and insert test data
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_test_database", "your_username", "your_password");
        Statement statement = connection.createStatement();

        // Create tables
        statement.execute("CREATE TABLE IF NOT EXISTS person (PersonID CHAR(8) PRIMARY KEY, fname VARCHAR(50), lname VARCHAR(50), password VARCHAR(50), PhoneNumber VARCHAR(20), Gender VARCHAR(10))");
        statement.execute("CREATE TABLE IF NOT EXISTS deliveryperson (PersonID CHAR(8) PRIMARY KEY, DeliveryArea VARCHAR(50), Status VARCHAR(20))");
        statement.execute("CREATE TABLE IF NOT EXISTS orders (OrderID CHAR(8) PRIMARY KEY, Deli_PersonID CHAR(8), DeliveryStatus VARCHAR(20))");

        // Insert test data
        statement.execute("INSERT INTO person (PersonID, fname, lname, password, PhoneNumber, Gender) VALUES ('P0001', 'John', 'Doe', 'password', '1234567890', 'MALE')");
        statement.execute("INSERT INTO deliveryperson (PersonID, DeliveryArea, Status) VALUES ('P0001', 'Area1', 'WAITING')");
        statement.execute("INSERT INTO orders (OrderID, Deli_PersonID, DeliveryStatus) VALUES ('O0001', 'P0001', 'NOT_DELIVERED')");

        statement.close();
        connection.close();
    }

    @After
    public void tearDown() throws Exception {
        // Clean up the test data
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_test_database", "your_username", "your_password");
        Statement statement = connection.createStatement();

        // Drop tables
        statement.execute("DROP TABLE IF EXISTS orders");
        statement.execute("DROP TABLE IF EXISTS deliveryperson");
        statement.execute("DROP TABLE IF EXISTS person");

        statement.close();
        connection.close();
    }

    @Test
    public void testGetAllDelivers() {
        List<Deliver> delivers = deliveryDAO.getAllDelivers();
        assertNotNull(delivers);
        assertEquals(1, delivers.size());
        Deliver deliver = delivers.get(0);
        assertEquals("O0001", deliver.getOrderID());
        assertEquals("P0001", deliver.getDeli_PersonID());
        assertEquals(OderStatus.NOT_DELIVERED, deliver.getStatus());
    }

    @Test
    public void testUpdateDeliverStatus() {
        boolean updated = deliveryDAO.updateDeliverStatus("O0001", OderStatus.DELIVERING);
        assertTrue(updated);

        // Verify the status was updated
        List<Deliver> delivers = deliveryDAO.getAllDelivers();
        Deliver deliver = delivers.get(0);
        assertEquals(OderStatus.DELIVERING, deliver.getStatus());
    }

    @Test
    public void testGetAvailableDeliveryPerson() {
        DeliveryPerson deliveryPerson = deliveryDAO.getAvailableDeliveryPerson("Area1");
        assertNotNull(deliveryPerson);
        assertEquals("P0001", deliveryPerson.getPersonID());
    }

    @Test
    public void testAssignOrderToDeliveryPerson() {
        boolean assigned = deliveryDAO.assignOrderToDeliveryPerson("O0001", "P0001");
        assertTrue(assigned);

        // Verify the order was assigned
        List<Deliver> delivers = deliveryDAO.getAllDelivers();
        Deliver deliver = delivers.get(0);
        assertEquals("P0001", deliver.getDeli_PersonID());
    }
}
