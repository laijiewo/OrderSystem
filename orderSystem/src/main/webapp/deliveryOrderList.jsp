<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: rgb(224, 210, 163);
            margin: 0;
            padding: 0;
        }
        .header {
            background-color: rgb(92, 147, 148);
            padding: 20px;
            text-align: center;
            color: #fff;
        }
        .header h1 {
            margin: 0;
        }
        .container {
            display: flex;
            margin: 20px;
        }
        .sidebar {
            width: 20%;
            background-color: #ffffff;
            padding: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .content {
            width: 80%;
            padding: 10px;
        }
        .category {
            margin-bottom: 10px;
        }
        .products {
            display: flex;
            flex-wrap: wrap;
        }
        .order {
            width: 30%;
            margin: 1%;
            background-color: #ffffff;
            padding: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }
        .order h3 {
            margin: 10px 0;
            color: rgb(70, 96, 117);
        }
        .order p {
            margin: 0 0 10px;
        }
        .order .price {
            color: rgb(92, 147, 148);
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Delivery Order List</h1>
</div>
<div class="container">
    <div class="sidebar">
        <h2>Classes</h2>
        <div class="category">Class1</div>
        <div class="category">Class2</div>
        <div class="category">Class3</div>
    </div>
    <div class="content">
        <h2>Order List</h2>
        <div class="products">
            <div class="order">
                <h3>Order1</h3>
                <p>description of restaurant1</p>
            </div>
            <div class="order">
                <h3>Order2</h3>
                <p>description of restaurant2</p>
            </div>
            <div class="order">
                <h3>Order3</h3>
                <p>description of restaurant3</p>
            </div>
        </div>
    </div>
</div>
<%@ include file="footer.html" %>>
</body>
</html>
