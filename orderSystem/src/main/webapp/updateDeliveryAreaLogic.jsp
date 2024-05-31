<%@ page import="module.DeliveryPerson" %>
<%@ page import="dao.DeliveryPersonDAO" %>
<%@ page import="module.enums.DeliveryStatus" %>
<%@ page import="module.enums.DeliveryArea" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/30
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DeliveryPerson deliveryPerson = (DeliveryPerson) session.getAttribute("deliveryPerson");
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    DeliveryArea area = null;
    String deliveryArea = request.getParameter("DeliveryArea");
    if (deliveryArea.equals("FIRST_TEACHING_BUILDING")) {
        area = DeliveryArea.FIRST_TEACHING_BUILDING;
    } else if (deliveryArea.equals("SECOND_TEACHING_BUILDING")) {
        area = DeliveryArea.SECOND_TEACHING_BUILDING;
    } else if (deliveryArea.equals("THIRD_TEACHING_BUILDING")) {
        area = DeliveryArea.THIRD_TEACHING_BUILDING;
    } else if (deliveryArea.equals("FOURTH_TEACHING_BUILDING")) {
        area = DeliveryArea.FOURTH_TEACHING_BUILDING;
    } else if (deliveryArea.equals("GYM")) {
        area = DeliveryArea.GYM;
    } else if (deliveryArea.equals("LIBRARY")) {
        area = DeliveryArea.LIBRARY;
    }
    try {
        deliveryPersonDAO.updateDeliveryArea(deliveryPerson.getPersonID(), area);
        deliveryPerson.setDeliveryArea(area);
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
