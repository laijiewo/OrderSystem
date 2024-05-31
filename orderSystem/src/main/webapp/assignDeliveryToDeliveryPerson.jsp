<%@ page import="module.DeliveryPerson" %>
<%@ page import="module.Order" %>
<%@ page import="dao.orderDAO" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.enums.OderStatus" %>
<%@ page import="dao.DeliveryPersonDAO" %>
<%@ page import="module.enums.DeliveryStatus" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String orderId = (String) session.getAttribute("orderID");
    String deliveryPersonId = request.getParameter("personID");
    DeliveryDAO.addDeliver(orderId, deliveryPersonId);
    DeliveryDAO.updateDeliverStatus(orderId, OderStatus.DELIVERING);
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    deliveryPersonDAO.updateStatus(deliveryPersonId, DeliveryStatus.DELIVERING);
    response.sendRedirect("restaurantOrder.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
