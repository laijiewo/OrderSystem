<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="loginStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Register Page</h2>
    </div>
</div>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="registerLogic.jsp">
            <p style="text-align: center;">Please choose the role you want to register as:</p>
            <label>
                <select name="role" required>
                    <option value="">Select Role</option>
                    <option value="User">User</option>
                    <option value="RestaurantManager">Restaurant Manager</option>
                    <option value="DeliveryPerson">Delivery Person</option>
                </select>
            </label>
            <button type="submit">register</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
