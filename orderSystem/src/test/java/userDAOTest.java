import static org.junit.Assert.*;
import org.junit.Test;
import dao.*;

public class userDAOTest {
    userDAO userDAO = new userDAO();
    @Test
    public void loginTest() {
        assertTrue(login("123456", "123456"));
    }
    private boolean login(String username, String password) {
        return userDAO.login(username, password) != null;
    }
}
