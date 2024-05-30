<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, dao.orderDAO, module.Order" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String orderId = request.getParameter("orderId");
    String personId = request.getParameter("personId");
    Date date = Date.valueOf(request.getParameter("date"));
    boolean paymentStatus = Boolean.parseBoolean(request.getParameter("paymentStatus"));

    Order order = new Order(orderId, date, personId);
    boolean success = false;
    try {
        success = orderDAO.insertOrder(order);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (success) {
        out.println("Order added successfully!");
    } else {
        out.println("Failed to add order.");
    }
%>
<br>
<a href="OrderList.jsp">Back to Order List</a>
