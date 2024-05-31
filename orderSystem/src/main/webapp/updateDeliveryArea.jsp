<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/30
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delivery Area Update</title>
    <link rel="shortcut icon" href="photos/bitbug_favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="managerRegisterStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Delivery Area Update Page</h2>
    </div>
</div>
<div class="jump-to-register-page">
    <div class="form">
        <form class="login-form" method="post" action="updateDeliveryAreaLogic.jsp">
            <p class="title">Please enter the following information:</p>
            <div class="flex-container">
                <label>
                    <select name="DeliveryArea" required>
                        <option value="">Select Delivery Area</option>
                        <option value="FIRST_TEACHING_BUILDING">First Teaching Building</option>
                        <option value="SECOND_TEACHING_BUILDING">Second Teaching Building</option>
                        <option value="THIRD_TEACHING_BUILDING">Third Teaching Building</option>
                        <option value="FOURTH_TEACHING_BUILDING">Fourth Teaching Building</option>
                        <option value="GYM">Gym</option>
                        <option value="LIBRARY">Library</option>
                    </select>
                </label>
            </div>
            <button type="submit">update</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>

