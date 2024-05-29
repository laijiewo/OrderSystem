<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>
<%@ page import="module.enums.Gender" %>
<%@ page import="module.User" %>
<%@ page import="module.enums.DeliveryArea" %>

<%
        String personID = request.getParameter("PeronID");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String gender = request.getParameter("Gender");
        String FName = request.getParameter("First Name");
        String LName = request.getParameter("Last Name");
        DeliveryArea address = DeliveryArea.valueOf(request.getParameter("address"));

        out.print(personID);
        out.print(password);
        out.print(phoneNumber);
        out.print(gender);
        out.print(FName);
        out.print(LName);
        out.print(address);

        userDAO user = new userDAO();
        try {
                if (user.register(personID, LName, FName, password, phoneNumber, module.enums.Gender.valueOf(gender), address)) {
                        response.sendRedirect("index.jsp");
                } else {
                        response.sendRedirect("userRegister.jsp");
                }
        } catch (Exception e) {
                response.sendRedirect("userRegister.jsp");
        }
%>

<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
