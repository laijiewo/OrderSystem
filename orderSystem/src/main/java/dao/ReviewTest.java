package dao;

import module.Review;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import JDBC.JDBCTool; // 确保导入 JDBCTool

public class ReviewTest {

    private reviewDAO dao;

    @BeforeEach
    public void setUp() {
        dao = new reviewDAO();
        // 添加必要的前置数据
        try {
            // 插入一个测试用户和餐馆
            String personSql = "INSERT INTO person (PersonID, Fname, Lname, password, PhoneNumber, Gender) " +
                    "VALUES ('PER001', 'John', 'Doe', 'password', '12345678901', 'male')";
            String restaurantSql = "INSERT INTO restaurant (RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, M_PersonID) " +
                    "VALUES ('RES001', 'Test Restaurant', '123 Test St', '1234567890', '9 AM - 9 PM', 'PER001')";
            executeUpdate(personSql);
            executeUpdate(restaurantSql);
            // 插入一个测试评论
            dao.insertReview(new Review("PER001", new Date(System.currentTimeMillis()), 4.5f, "Good service", "RES001"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        // 清理数据库
        try {
            dao.deleteReviewByID("PER001", new Date(System.currentTimeMillis()));
            String personSql = "DELETE FROM person WHERE PersonID = 'PER001'";
            String restaurantSql = "DELETE FROM restaurant WHERE RestaurantID = 'RES001'";
            executeUpdate(personSql);
            executeUpdate(restaurantSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetReviewList() throws SQLException {
        List<Review> reviews = dao.getReviewList();
        assertNotNull(reviews, "Review list should not be null");
        assertFalse(reviews.isEmpty(), "Review list should not be empty");
    }

    @Test
    public void testGetReviewByID() throws SQLException {
        Review review = dao.getReviewByID("PER001", new Date(System.currentTimeMillis()));
        assertNotNull(review, "Review should not be null for existing ID and date");
        assertEquals("PER001", review.getR_PersonID(), "Review person ID should match");
    }

    @Test
    public void testGetReviewsByDate() throws SQLException {
        List<Review> reviews = dao.getReviewsByDate(new Date(System.currentTimeMillis()));
        assertNotNull(reviews, "Reviews list should not be null");
        assertFalse(reviews.isEmpty(), "Reviews list should not be empty for existing date");
    }

    @Test
    public void testInsertReview() throws SQLException {
        Review newReview = new Review("PER002", new Date(System.currentTimeMillis()), 3.5f, "Average", "RES001");
        boolean result = dao.insertReview(newReview);
        assertTrue(result, "Review insertion should return true");
        // Verify insertion
        Review insertedReview = dao.getReviewByID("PER002", new Date(System.currentTimeMillis()));
        assertNotNull(insertedReview, "Inserted review should not be null");
        assertEquals("PER002", insertedReview.getR_PersonID(), "Review person ID should match");
        // 清理插入的数据
        dao.deleteReviewByID("PER002", new Date(System.currentTimeMillis()));
    }

    @Test
    public void testUpdateReview() throws SQLException {
        // 获取现有评论进行更新测试
        Review review = dao.getReviewByID("PER001", new Date(System.currentTimeMillis()));
        review.setRating(5.0f); // 修改评分
        boolean result = dao.updateReview(review);
        assertTrue(result, "Review update should return true");
        // Verify update
        Review updatedReview = dao.getReviewByID("PER001", new Date(System.currentTimeMillis()));
        assertNotNull(updatedReview, "Updated review should not be null");
        assertEquals(5.0f, updatedReview.getRating(), "Rating should be updated");
    }

    @Test
    public void testDeleteReviewByID() throws SQLException {
        // 先插入一个评论以进行删除测试
        Review review = new Review("PER003", new Date(System.currentTimeMillis()), 2.0f, "Not good", "RES001");
        dao.insertReview(review);
        // 删除评论
        boolean result = dao.deleteReviewByID("PER003", new Date(System.currentTimeMillis()));
        assertTrue(result, "Review deletion should return true");
        // Verify deletion
        Review deletedReview = dao.getReviewByID("PER003", new Date(System.currentTimeMillis()));
        assertNull(deletedReview, "Deleted review should be null");
    }

    // 辅助方法用于执行更新语句
    private void executeUpdate(String sql) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCTool.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } finally {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
}
