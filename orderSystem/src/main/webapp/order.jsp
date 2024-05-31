<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.sql.SQLException, java.util.List, dao.orderDAO, module.Order" %>
<%@ page import="module.Dish" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="module.randomString" %>
<%@ page import="module.OrderList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String OrderID = request.getParameter("orderID");
    if (OrderID == null) {
        OrderID = randomString.generateRandomOrderID();
    }
    String DishID = request.getParameter("DishID");
    List<Dish> shoppingTrolley = (List<Dish>) session.getAttribute("ShoppingTrolley");
    if (DishID != null) {
        if (shoppingTrolley != null) {
            for (Dish dish : shoppingTrolley) {
                if (dish.getDishId().equals(DishID)) {
                    shoppingTrolley.remove(dish);
                    break;
                }
            }
            session.setAttribute("ShoppingTrolley", shoppingTrolley);
        }
    }else{
        if (shoppingTrolley == null) {
            shoppingTrolley = new ArrayList<>();
            session.setAttribute("ShoppingTrolley", shoppingTrolley);
        }
    }
    List<OrderList> newOrderList = new ArrayList<>();
    for (Dish dish : shoppingTrolley) {
        boolean newOrder = true;
        for (OrderList orderList:newOrderList){
            if(dish.getDishId().equals(orderList.getDishId())){
                orderList.increaseNumber();
                newOrder = false;
            }
        }
        OrderList orderList = new OrderList(OrderID, dish.getDishId(),"",1);
        if(newOrder){
            newOrderList.add(orderList);
        }
    }
%>
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
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            position: fixed;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Order List</h1>
</div>
<div class="container">
    <div class="content">
        <h2>Dishes</h2>
        <table>
            <tr>
                <th>Order ID</th>
                <th>Dish ID</th>
                <th>number</th>
                <th>Comments</th>
                <th>Actions</th>
            </tr>
            <% for (OrderList orderList:newOrderList){%>
            <tr>
                <td><%= orderList.getOrderId() %></td>
                <td><%= orderList.getDishId() %></td>
                <td><%= orderList.getNumber() %></td>
                <td></td>
                <td>
                    <form method="post" action="order.jsp?orderID=<%=OrderID%>" style="display: inline">
                        <input type="hidden" name="DishID" value="<%= orderList.getDishId() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <%}%>

        </table>
        <h2>Pay for the </h2>
        <form action="addOrder.jsp?orderID=<%=OrderID%>" method="post" name="PAY">
            <label for="comment">Comment:</label>
            <input type="text" id="comment" name="comment" required><br>
            <input type="submit" value="PAY">
        </form>
    </div>
</div>
<div class="footer">
    <p>&copy; 2024 Orders</p>
</div>
</body>
</html>

