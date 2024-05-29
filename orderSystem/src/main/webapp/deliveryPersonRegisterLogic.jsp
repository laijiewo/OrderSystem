<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>

<%@ page import="module.enums.*" %>

<%
    String personID = request.getParameter("PeronID");
    String password = request.getParameter("password");
    String phoneNumber = request.getParameter("phoneNumber");
    String gender = request.getParameter("Gender");
    String FName = request.getParameter("First Name");
    String LName = request.getParameter("Last Name");
    DeliveryArea deliveryArea = DeliveryArea.valueOf(request.getParameter("Delivery Area"));

    out.print(personID);
    out.print(password);
    out.print(phoneNumber);
    out.print(gender);
    out.print(FName);
    out.print(LName);
    out.print(deliveryArea);

    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    try {
        if (deliveryPersonDAO.register(personID, LName, FName, password, phoneNumber, Gender.valueOf(gender), deliveryArea)) {
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("wrong input");
            response.sendRedirect("deliveryPersonRegister.jsp");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("deliveryPersonRegister.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
