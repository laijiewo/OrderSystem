<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>

<body style="background-color: green;">
<h2>Login Page</h2>
<p style="text-align: center;">Please enter your username and password:</p>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="login.jsp">
            <input type="text" placeholder="username" name="username"/>
            <input type="text" placeholder="password" name="password"/>
            <button>login</button>
        </form>
    </div>
</div>
</body>
</html>
