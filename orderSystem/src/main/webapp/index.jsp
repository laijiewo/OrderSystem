<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: green;
        .container {
        max-width: 100%;
        margin: 0 auto;
        height: 400px;
        display: flex;
        justify-content: center;
        text-align: center;
        background-color: #72A8CEFF;
        font-size: 30px;
        }
    }

   .login-page {
        width: 360px;
        padding: 8% 0 0;
        margin: 0 auto;
       height: 50px;
       display: flex;
       justify-content: center;
       align-items: center;
       text-align: center;
    }

   .form {
        position: relative;
        z-index: 1;
        background: #FFFFFF;
        max-width: 360px;
        margin: 0 auto 10px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }

   .form input {
        font-family: Arial, sans-serif;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 15px;
        padding: 15px;
        box-sizing: border-box;
        font-size: 14px;
    }

   .form button {
        font-family: Arial, sans-serif;
        text-transform: uppercase;
        outline: 0;
        background: #4CAF50;
        width: 100%;
        border: 0;
        padding: 15px;
        color: #FFFFFF;
        font-size: 14px;

        cursor: pointer;
    }

   .form button:hover,.form button:active,.form button:focus {
        background: #43A047;
    }
</style>
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Login Page</h2>
    </div>
</div>
<body style="background-color: #72A8CEFF;">
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="login.jsp">
            <p style="text-align: center;"> Please enter your username and password:</p>
            <input type="text" placeholder="username" name="username"/>
            <input type="text" placeholder="password" name="password"/>
            <button>login</button>
        </form>
    </div>
</div>
</body>
</html>
