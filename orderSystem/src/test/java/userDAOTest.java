import static org.junit.Assert.*;

import org.junit.Test;
import module.enums.*;
import dao.*;

public class userDAOTest {
    DeliveryPersonDAO userDAO = new DeliveryPersonDAO();
    @Test
    public void loginTest() {
        assertTrue(login("222222", "123456"));
        assertFalse(login("123456", "1234567"));
    }
    private boolean login(String username, String password) {
        try {
            return userDAO.login(username, password) != null;
        } catch (Exception e) {
            System.out.println("Can't login user: ");
            throw new RuntimeException(e);
        }

    }
    @Test
    public void registerTest() {
        try {
            assertTrue(userDAO.register("222222", "J", "D", "123456", "723857128", Gender.valueOf("MALE"), "a"));
        } catch (Exception e) {
            System.out.println("Can't register user: ");
        }
        assertTrue(login("222222", "123456"));
    }
    @Test
    public void phoneNumberTest() {
        userDAO.setPhoneNumber("133456", "1234567890");
        assertEquals("1234567890", userDAO.getPhoneNumber("133456"));
    }
    @Test
    public void genderTest() {
        assertEquals(Gender.valueOf("MALE"), userDAO.getGender("133456"));
    }
    @Test
    public void getNamesTest() {
        assertEquals("J D", userDAO.getName("133456"));
    }
}
