<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #A4c97c;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            max-width: 100%;
            margin: 0 auto;
            height: 400px;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            background-color: #308192;
            font-size: 30px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }

        .login-page {
            width: 360px;
            padding: 8% 0 0;
            margin: 0 auto;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .form {
            position: relative;
            z-index: 1;
            background: #F1cc74;
            max-width: 360px;
            margin: 0 auto 10px;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
            border-radius: 10px;
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
            border-radius: 5px;
        }

        .form button {
            font-family: Arial, sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #E38D62;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            cursor: pointer;
            border-radius: 5px;
            transition: background 0.3s ease;
        }

        .form button:hover, .form button:active, .form button:focus {
            background: #43A047;
        }

        .info h2 {
            margin: 0;
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="info">
        <h2>COMP2004J Group 14 Order System</h2>
        <h2>Login Page</h2>
    </div>
</div>
<div class="login-page">
    <div class="form">
        <form class="login-form" method="post" action="login.jsp">
            <p style="text-align: center;">Please enter your username and password:</p>
            <input type="text" placeholder="username" name="username" required/>
            <input type="password" placeholder="password" name="password" required/>
            <button type="submit">login</button>
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
