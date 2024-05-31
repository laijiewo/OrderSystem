<%@ page import="module.DeliveryPerson" %>
<%@ page import="dao.DeliveryPersonDAO" %>
<%@ page import="module.enums.DeliveryStatus" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/30
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DeliveryPerson deliveryPerson = (DeliveryPerson) session.getAttribute("deliveryPerson");
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    DeliveryStatus status = null;
    String del_status = request.getParameter("DeliveryStatus");
    if (del_status.equals("DELIVERING")) {
        status = DeliveryStatus.DELIVERING;
    } else if (del_status.equals("WAITING")) {
        status = DeliveryStatus.WAITING;
    } else if (del_status.equals("RESTING")) {
        status = DeliveryStatus.RESTING;
    }
    try {
        deliveryPersonDAO.updateStatus(deliveryPerson.getPersonID(), status);
        deliveryPerson.setDeliveryStatus(status);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    response.sendRedirect("Delivery.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
