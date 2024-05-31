<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>User Information Update</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="registerStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>User Information Update Page</h2>
    </div>
    <div class="jump-to-register-page">
        <div class="form">
            <form class="login-form" method="post" action="updateDeliveryPersonInformationLogic.jsp">
                <p class="title">Please enter the following information:</p>
                <div class="flex-container">
                    <div class="flex-item"><input type="text" placeholder="FirstName" name="FirstName" required/></div>
                    <div class="flex-item"><input type="text" placeholder="LastName" name="LastName" required/></div>
                    <div class="flex-item"><input type="text" placeholder="PhoneNumber" name="PhoneNumber" required/></div>
                    <div class="flex-item"><input type="password" placeholder="Password" name="Password" required/></div>
                </div>
                <button type="submit">update</button>
            </form>
        </div>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>