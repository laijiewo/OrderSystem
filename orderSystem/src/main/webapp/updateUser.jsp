<%--
  Created by IntelliJ IDEA.
  User: Majoie
  Date: 2024/5/31
  Time: 下午12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.setAttribute("userID", request.getParameter("userID"));
%>
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
</div>
<div class="jump-to-register-page">
    <div class="form">
        <form class="login-form" method="post" action="updateUserLogic.jsp">
            <p class="title">Please enter the following information:</p>
            <div class="flex-container">
                <div class="flex-item"><input type="text" placeholder="FirstName" name="FirstName" required/></div>
                <div class="flex-item"><input type="text" placeholder="LastName" name="LastName" required/></div>
                <div class="flex-item">
                    <label>
                        <select name="address" required>
                            <option value="">Select Address</option>
                            <option value="FIRST_TEACHING_BUILDING">First Teaching Building</option>
                            <option value="SECOND_TEACHING_BUILDING">Second Teaching Building</option>
                            <option value="THIRD_TEACHING_BUILDING">Third Teaching Building</option>
                            <option value="FOURTH_TEACHING_BUILDING">Fourth Teaching Building</option>
                            <option value="GYM">Gym</option>
                            <option value="LIBRARY">Library</option>
                        </select>
                    </label>
                </div>
                <div class="flex-item"><input type="text" placeholder="PhoneNumber" name="PhoneNumber" required/></div>
                <div class="flex-item"><input type="password" placeholder="Password" name="Password" required/></div>
            </div>
            <button type="submit">update</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>

</html>
