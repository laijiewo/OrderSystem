<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant Manager Register</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="managerRegisterStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Restaurant Manager Register Page</h2>
    </div>
</div>
<div class="jump-to-register-page">
    <div class="form">
        <form class="login-form" method="post" action="restaurantManagerRegisterLogic.jsp">
            <p class="title">Please enter the following information:</p>
            <div class="flex-container">
                <div class="flex-item"><input type="text" placeholder="PeronID" name="PeronID" required/></div>
                <div class="flex-item"><input type="password" placeholder="password" name="password" required/></div>
                <div class="flex-item"><input type="text" placeholder="phoneNumber" name="phoneNumber" required/></div>
                <div class="flex-item"><label>
                    <select name="Gender" required>
                        <option value="">Select Gender</option>
                        <option value="MALE">MALE</option>
                        <option value="FEMALE">FEMALE</option>
                    </select>
                </label></div>
                <div class="flex-item"><input type="text" placeholder="First Name" name="First Name" required/></div>
                <div class="flex-item"><input type="text" placeholder="Last Name" name="Last Name" required/></div>
                <div class="flex-item"><input type="text" placeholder="RestaurantID" name="RestaurantID" required/></div>
                <div class="flex-item"><input type="password" placeholder="RestaurantName" name="RestaurantName" required/></div>
                <div class="flex-item"><input type="text" placeholder="Address" name="Address" required/></div>
                <div class="flex-item"><input type="text" placeholder="Contact Information" name="Contact Information" required/></div>
                <div class="flex-item"><input type="text" placeholder="Business Hours" name="Business Hours" required/></div>
            </div>
            <button type="submit">register</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
