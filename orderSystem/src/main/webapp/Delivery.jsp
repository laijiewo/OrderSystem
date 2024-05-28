<%--
  Created by IntelliJ IDEA.
  User: 牛奕欣
  Date: 2024/5/28
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Delivery Personnel Dashboard</title>
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
    .category, .order-status {
      margin-bottom: 10px;
    }
    .orders, .order-list {
      display: flex;
      flex-wrap: wrap;
    }
    .order, .order-detail {
      width: 30%;
      margin: 1%;
      background-color: #ffffff;
      padding: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      border-radius: 10px;
    }
    .order h3, .order-detail h3 {
      margin: 10px 0;
      color: rgb(70, 96, 117);
    }
    .order p, .order-detail p {
      margin: 0 0 10px;
    }
    .order .price, .order-detail .status {
      color: rgb(92, 147, 148);
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="header">
  <h1>Delivery Personnel Dashboard</h1>
</div>
<div class="container">
  <div class="sidebar">
    <h2>Navigation</h2>
    <div class="category">Dashboard</div>
    <div class="category">Orders</div>
    <div class="category">Profile</div>
  </div>
  <div class="content">
    <h2>Active Orders</h2>
    <div class="order-list">
      <div class="order-detail">
        <h3>Order1</h3>
        <p>Restaurant: Restaurant1</p>
        <p>Address: Address1</p>
        <p class="status">Status: In Progress</p>
      </div>
      <div class="order-detail">
        <h3>Order2</h3>
        <p>Restaurant: Restaurant2</p>
        <p>Address: Address2</p>
        <p class="status">Status: Pending</p>
      </div>
      <div class="order-detail">
        <h3>Order3</h3>
        <p>Restaurant: Restaurant3</p>
        <p>Address: Address3</p>
        <p class="status">Status: Completed</p>
      </div>
    </div>
  </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
