<%@ page import="dao.DeliveryPersonDAO" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = request.getParameter("deliveryPersonID");
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    try {
        deliveryPersonDAO.deleteDeliveryPerson(id);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    response.sendRedirect("index.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
