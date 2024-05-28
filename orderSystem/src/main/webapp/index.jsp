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
            background-color: rgb(224, 210, 163);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            max-width: 1400px;
            margin-top: 0;
            height: 130px;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            background-color: rgb(92, 147, 148);
            font-size: 30px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            position: absolute;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
        }
        img {
            margin-right: 20px; /* 调整图片和文本之间的间距 */
            max-width: 250px;
            position: absolute;
            top: 20px;
            left: 130px;
            transform: translateX(-50%);
        }

        .login-page {
            width: 450px;
            padding: 8% 0 0;
            margin: 0 auto;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
            position: absolute;
            top: 340px;
            left: 50%;
            transform: translate(-50%, -50%);
        }

        .form {
            position: relative;
            z-index: 1;
            background: rgb(139, 166, 147);
            max-width: 500px;
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
            background: rgb(70, 96, 117);
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
            <input type="text" placeholder="username" name="username" required/>
            <input type="password" placeholder="password" name="password" required/>
            <button type="submit">login</button>
        </form>
    </div>
</div>

<%@ include file="footer.html" %>
</body>
</html>
