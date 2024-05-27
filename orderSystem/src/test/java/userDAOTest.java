import static org.junit.Assert.*;

import module.Gender;
import org.junit.Test;
import dao.*;

public class userDAOTest {
    userDAO userDAO = new userDAO();
    @Test
    public void loginTest() {
        assertTrue(login("133456", "123456"));
        assertFalse(login("123456", "1234567"));
    }
    private boolean login(String username, String password) {
        return userDAO.login(username, password) != null;
    }
    @Test
    public void registerTest() {
        assertTrue(userDAO.register("133456", "J", "D", "123456", "723857128", Gender.valueOf("male"), "a"));
        assertTrue(login("133456", "123456"));
    }
}
