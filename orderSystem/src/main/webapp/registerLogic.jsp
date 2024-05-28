<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String select = request.getParameter("role");

    out.print(select);
    if (select.equals("User")) {
        response.sendRedirect("userRegister.jsp");
    } else if (select.equals("RestaurantManager")) {
        response.sendRedirect("deliveryPersonRegister.jsp");
    } else {
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
