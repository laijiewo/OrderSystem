<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>User Register</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="loginStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>User Register Page</h2>
    </div>
</div>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="login.jsp">
            <p style="text-align: center;">Please enter the following information:</p>
            <input type="PeronID" placeholder="PeronID" name="PeronID" required/>
            <input type="password" placeholder="password" name="password" required/>
            <input type="phoneNumber" placeholder="phoneNumber" name="phoneNumber" required/>
            <label>
                <select name="Gender" required>
                    <option value="">Select Gender</option>
                    <option value="MALE">MALE</option>
                    <option value="FEMALE">FEMALE</option>
                </select>
            </label>
            <input type="First Name" placeholder="First Name" name="First Name" required/>
            <input type="Last Name" placeholder="Last Name" name="Last Name" required/>
            <input type="address" placeholder="address" name="address" required/>
            <button type="submit">register</button>
            <button type="submit">login</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
