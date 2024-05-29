<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.sql.SQLException, java.util.List, dao.orderDAO, module.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgb(224, 210, 163);
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: rgb(92, 147, 148);
            padding: 20px;
            text-align: center;
            color: #fff;
        }
        .header h1 {
            margin: 0;
        }
        .container {
            display: flex;
            margin: 20px;
        }
        .content {
            width: 100%;
            padding: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .footer {
            background-color: rgb(92, 147, 148);
            padding: 20px;
            text-align: center;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Orders</h1>
</div>
<div class="container">
    <div class="content">
        <h2>Order List</h2>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Dish ID</th>
                <th>Comments</th>
                <th>Actions</th>
            </tr>
            <%
                List<Order> orders = null;
                try {
                    orders = orderDAO.getOrderList();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (orders != null) {
                    for (Order order : orders) {
            %>
            <tr>
                <td><%= order.getOrderId() %></td>
                <td><%= order.getU_PersonId() %></td>
                <td><%= order.getOrderDate() %></td>
                <td><%= order.isPaid() %></td>
                <td>
                    <form action="deleteOrder.jsp" method="post" style="display:inline;">
                        <input type="hidden" name="orderId" value="<%= order.getOrderId() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <h2>Add New Order</h2>
        <form action="addOrder.jsp" method="post">
            <label for="orderId">Order ID:</label>
            <input type="text" id="orderId" name="orderId" required><br>
            <label for="personId">Person ID:</label>
            <input type="text" id="personId" name="personId" required><br>
            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required><br>
            <label for="paymentStatus">Payment Status:</label>
            <select id="paymentStatus" name="paymentStatus" required>
                <option value="true">Paid</option>
                <option value="false">Unpaid</option>
            </select><br>
            <input type="submit" value="Add Order">
        </form>
    </div>
</div>
<div class="footer">
    <p>&copy; 2024 Orders</p>
</div>
</body>
</html>

