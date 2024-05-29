<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/29
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.dishDAO" %>
<%
    String dishId = request.getParameter("dishID");
    dishDAO dishDAO = new dishDAO();
    dishDAO.deleteDishByID(dishId);
    response.sendRedirect("restaurantManageScreen.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
