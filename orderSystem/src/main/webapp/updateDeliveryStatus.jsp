<%@ page import="module.DeliveryPerson" %>
<%@ page import="dao.DeliveryPersonDAO" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/30
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DeliveryPerson deliveryPerson = (DeliveryPerson) session.getAttribute("deliveryPerson");
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
%>
<style>

</style>
<html>
<head>
    <title>Update Delivery Status</title>
</head>
<body>
<div class="container">
    <h1>Update Delivery Status</h1>

</div>

</body>
</html>
