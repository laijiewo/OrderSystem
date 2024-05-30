<%@ page import="module.Order" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.enums.OderStatus" %><%--
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
    System.out.println(orderID);
    deliveryDAO.updateDeliverStatus(orderID, OderStatus.ARRIVED);
    response.sendRedirect("Delivery.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
