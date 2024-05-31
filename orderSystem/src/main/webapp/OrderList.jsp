<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.orderListDAO" %>
<%@ page import="module.OrderList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: #007bff;
            padding: 20px;
            text-align: center;
            color: #fff;
        }
        .header h1 {
            margin: 0;
        }
        .container {
            padding: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .footer {
            background-color: #007bff;
            padding: 10px;
            text-align: center;
            color: #fff;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Order List</h1>
</div>
<div class="container">
    <h2>List of Orders</h2>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Dish ID</th>
            <th>Comments</th>
        </tr>
        <%
            List<OrderList> orderLists = null;
            try {
                orderLists = orderListDAO.getOrderList();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (orderLists != null) {
                for (OrderList order : orderLists) {
                    out.println("<tr>");
                    out.println("<td>" + order.getOrderId() + "</td>");
                    out.println("<td>" + order.getDishId() + "</td>");
                    out.println("<td>" + order.getComment() + "</td>");
                    out.println("</tr>");
                }
            }
        %>
    </table>
</div>
<div class="footer">
    <p>&copy; 2024 Order System</p>
</div>
</body>
</html>
