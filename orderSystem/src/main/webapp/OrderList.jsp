<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.orderListDAO" %>
<%@ page import="module.OrderList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="module.User" %>
<%
    User user =(User) session.getAttribute("user");
    String userID = user.getPersonID();
    List<OrderList> orderList=orderListDAO.getOrderListByPersonID(userID);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My ORDERS</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
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
            background-color: rgb(92, 147, 148);
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
    <div>
        <button class="product-button" onclick="location.href='ReviewList.jsp'">show review List</button>
    </div>
    <table>
        <tr>
            <th>Order ID</th>
            <th>Dish ID</th>
            <th>Comments</th>
            <th>Number</th>
        </tr>
        <%
            if (orderList != null) {
                for (OrderList orderlist : orderList) {
                    System.out.println(orderlist.getDishId());
                    System.out.println("show orderlist");
                    out.println("<tr>");
                    out.println("<td>" + orderlist.getOrderId() + "</td>");
                    out.println("<td>" + orderlist.getDishId() + "</td>");
                    out.println("<td>" + orderlist.getComment() + "</td>");
                    out.println("<td>" + orderlist.getNumber() + "</td>");
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
