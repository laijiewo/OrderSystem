package dao;

import module.Order;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import JDBC.JDBCTool; // 确保导入 JDBCTool

public class orderTest {

    private orderDAO dao;

    @BeforeEach
    public void setUp() {
        dao = new orderDAO();
        // 添加必要的前置数据
        try {
            // 插入一个测试用户
            String personSql = "INSERT INTO person (PersonID, Fname, Lname, password, PhoneNumber, Gender) " +
                    "VALUES ('PER001', 'John', 'Doe', 'password', '12345678901', 'male')";
            executeUpdate(personSql);
            // 插入一个测试订单
            dao.insertOrder(new Order("ORD001", new Date(System.currentTimeMillis()), true, "PER001"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        // 清理数据库
        try {
            dao.deleteOrderByID("ORD001");
            String personSql = "DELETE FROM person WHERE PersonID = 'PER001'";
            executeUpdate(personSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetOrderList() throws SQLException {
        List<Order> orders = dao.getOrderList();
        assertNotNull(orders, "Order list should not be null");
        assertFalse(orders.isEmpty(), "Order list should not be empty");
    }

    @Test
    public void testGetOrderByID() throws SQLException {
        Order order = dao.getOrderByID("ORD001");
        assertNotNull(order, "Order should not be null for existing ID");
        assertEquals("ORD001", order.getOrderId(), "Order ID should match");
    }

    @Test
    public void testGetOrdersByPersonID() throws SQLException {
        List<Order> orders = dao.getOrdersByPersonID("PER001");
        assertNotNull(orders, "Orders list should not be null");
        assertFalse(orders.isEmpty(), "Orders list should not be empty for existing person ID");
    }

    @Test
    public void testInsertOrder() throws SQLException {
        Order newOrder = new Order("ORD002", new Date(System.currentTimeMillis()), true, "PER001");
        boolean result = dao.insertOrder(newOrder);
        assertTrue(result, "Order insertion should return true");
        // Verify insertion
        Order insertedOrder = dao.getOrderByID("ORD002");
        assertNotNull(insertedOrder, "Inserted order should not be null");
        assertEquals("ORD002", insertedOrder.getOrderId(), "Order ID should match");
        // 清理插入的数据
        dao.deleteOrderByID("ORD002");
    }

    @Test
    public void testUpdateOrder() throws SQLException {
        // 获取现有订单进行更新测试
        Order order = dao.getOrderByID("ORD001");
        order.setPaid(false); // 修改订单支付状态
        boolean result = dao.updateOrder(order);
        assertTrue(result, "Order update should return true");
        // Verify update
        Order updatedOrder = dao.getOrderByID("ORD001");
        assertNotNull(updatedOrder, "Updated order should not be null");
        assertFalse(updatedOrder.isPaid(), "Payment status should be updated");
    }

    @Test
    public void testDeleteOrderByID() throws SQLException {
        // 先插入一个订单以进行删除测试
        Order order = new Order("ORD003", new Date(System.currentTimeMillis()), true, "PER001");
        dao.insertOrder(order);
        // 删除订单
        boolean result = dao.deleteOrderByID("ORD003");
        assertTrue(result, "Order deletion should return true");
        // Verify deletion
        Order deletedOrder = dao.getOrderByID("ORD003");
        assertNull(deletedOrder, "Deleted order should be null");
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
