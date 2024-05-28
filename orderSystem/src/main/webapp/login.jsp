<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/23
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="dao.userDAO" %>
<%@ page import="module.User" %>


<%
    userDAO userDAO = new userDAO();
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    out.print(username);
    out.print(password);

    User u = userDAO.login(username, password);

    if(u==null){
        response.sendRedirect("index.jsp");
    }
    else{
        session.setAttribute("user", u);

    }

%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Waring</title>
</head>
<body>
Wrong password!!!!!!
</body>
</html>