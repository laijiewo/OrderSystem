<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>
<%@ page import="module.User" %>
<%@ page import="module.enums.DeliveryArea" %>
<%@ page import="module.DeliveryPerson" %>
<%
    DeliveryPerson dp = (DeliveryPerson) session.getAttribute("deliveryPerson");
    String FirstName = request.getParameter("FirstName");
    String LastName = request.getParameter("LastName");
    String PhoneNumber = request.getParameter("PhoneNumber");
    String password = request.getParameter("Password");



    out.print(dp.getPersonID());
    out.print(FirstName);
    out.print(LastName);
    out.print(PhoneNumber);

    dp.setFirstName(FirstName);
    dp.setLastName(LastName);
    dp.setPhoneNumber(PhoneNumber);
    dp.setPassword(password);
    personDAO personDAO = new personDAO();
    personDAO.updateInformation(dp);
    response.sendRedirect("Delivery.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
