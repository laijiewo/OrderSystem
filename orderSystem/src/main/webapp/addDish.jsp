<%@ page import="module.randomString" %><%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/29
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String id = randomString.generateRandomDishID();
%>
<html>
<head>
    <title>Add Dish</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="registerStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Add Dish Page</h2>
    </div>
</div>
<div class="addDish">
    <div class="form">
        <form class="login-form" method="post" action="addDishLogic.jsp?id=<%= id %>">
            <p class="title">Please enter the following information:</p>
            <div class="flex-container">
                <div class="flex-item"><input type="text" placeholder="DishName" name="DishName" required/></div>
                <div class="flex-item"><input type="text" placeholder="Price" name="Price" required/></div>
                <label>
                    <select name="Is Available" required>
                        <option value="">Select Is Available</option>
                        <option value="True">True</option>
                        <option value="False">False</option>
                    </select>
                </label>
            </div>
            <button type="submit">register</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
