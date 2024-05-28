package dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class userDAOTest {
    @Test
    public void registerTest() {
        userDAO userdap = new userDAO();
        assertTrue(userdap.login("123456", "123456") != null);
    }

}