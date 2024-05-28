<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="loginStyle.css">
</head>
<body>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>User Login Page</h2>
    </div>
</div>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="login.jsp">
            <p style="text-align: center;">Please enter your username and password:</p>
            <label>
                <select name="role" required>
                    <option value="">Select Role</option>
                    <option value="User">User</option>
                    <option value="RestaurantManager">Restaurant Manager</option>
                    <option value="DeliveryPerson">Delivery Person</option>
                </select>
            </label>
            <input type="text" placeholder="username" name="username" required/>
            <input type="password" placeholder="password" name="password" required/>
            <button type="submit">login</button>
            <div class="jump-to-register"><a href="register.jsp">Haven't registered yet? Go to Register Page!</a></div>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
