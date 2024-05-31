<%@ page import="module.Order" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.enums.OderStatus" %>
<%@ page import="dao.DeliveryPersonDAO" %>
<%@ page import="module.enums.DeliveryStatus" %>
<%@ page import="module.DeliveryPerson" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/30
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String orderID = request.getParameter("orderID");
    DeliveryDAO deliveryDAO = new DeliveryDAO();
    String dpID = DeliveryDAO.getDeliverPersonID(orderID);
    deliveryDAO.updateDeliverStatus(orderID, OderStatus.ARRIVED);
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    deliveryPersonDAO.updateStatus(dpID, DeliveryStatus.WAITING);
    DeliveryPerson dp = (DeliveryPerson) session.getAttribute("deliveryPerson");
    dp.setDeliveryStatus(DeliveryStatus.WAITING);
    response.sendRedirect("Delivery.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
