package dao;

import JDBC.JDBCTool;
import module.Person;
import org.junit.jupiter.api.*;
import module.enums.Gender;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantManagerDAOTest {

    private RestaurantManagerDAO restaurantManagerDAO;

    @BeforeEach
    public void setUp() {
        restaurantManagerDAO = new RestaurantManagerDAO();
        clearTestData();
    }
    private void clearTestData() {
        try (Connection conn = JDBCTool.getConnection()) {
            String deletePersonQuery = "DELETE FROM person WHERE PersonID = 'testID'";
            String deleteUserQuery = "DELETE FROM user WHERE PersonID = 'testID'";
            try (PreparedStatement psPerson = conn.prepareStatement(deletePersonQuery);
                 PreparedStatement psUser = conn.prepareStatement(deleteUserQuery)) {
                psUser.executeUpdate();
                psPerson.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testLogin() {
        Person manager = restaurantManagerDAO.login("111111", "password");
        assertNotNull(manager);
        assertEquals("111111", manager.getPersonID());
        assertEquals("password", manager.getPassword());
        // Add more assertions as necessary
    }

    @Test
    public void testRegister() {
        boolean result = restaurantManagerDAO.register("111111", "LastName","FirstName", "1314233445","password", Gender.MALE,"1234",  "Delicious", "Street1", "235666868","24",Date.valueOf("2004-04-22"));
        assertTrue(result);

        Person user = restaurantManagerDAO.login("111111", "password");
        assertNotNull(user);
        assertEquals("111111", user.getPersonID());
        assertEquals("password", user.getPassword());
        // Add more assertions as necessary
    }

    @Test
    public void testGetManagedRestaurants() {
        List<String> restaurants = RestaurantManagerDAO.getManagedRestaurants(1);
        assertNotNull(restaurants);
        assertFalse(restaurants.isEmpty());
        // Add more assertions as necessary
    }

    @Test
    public void testGetStartDate() {
        Date startDate = RestaurantManagerDAO.getStartDate(1);
        assertNotNull(startDate);
        // Add more assertions as necessary
    }

    @AfterEach
    public void tearDown() {
        clearTestData();
        // Cleanup code if necessary
    }
}
