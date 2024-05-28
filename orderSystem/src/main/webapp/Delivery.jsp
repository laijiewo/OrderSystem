<%-- Created by IntelliJ IDEA. User: 牛奕欣 Date: 2024/5/28 Time: 21:05 To change this template use File | Settings | File Templates. --%>
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
      background-color: rgb(139, 166, 147);
      padding: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    .content {
      width: 80%;
      padding: 10px;
    }
    .profile {
      margin-bottom: 20px;
    }
    .profile h2 {
      margin-bottom: 10px;
    }
    .profile p {
      margin: 5px 0;
    }
    .order-list {
      display: flex;
      flex-wrap: wrap;
      gap: 1%;
    }
    .order-detail {
      width: 30%; /* Adjusted to fit two items per row */
      background-color: #ffffff;
      padding: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      border-radius: 10px;
      margin-bottom: 20px;
    }
    .order-detail h3 {
      margin: 10px 0;
      color: rgb(70, 96, 117);
    }
    .order-detail p {
      margin: 0 0 10px;
    }
    .order-detail .status {
      color: rgb(92, 147, 148);
      font-weight: bold;
    }
    .update-buttons {
      display: flex;
      flex-direction: column;
      gap: 5px;
    }
    .update-button {
      padding: 10px;
      background-color: rgb(92, 147, 148);
      color: #fff;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-align: center;
    }
    .update-button:hover {
      background-color: rgb(70, 96, 117);
    }
  </style>
  <script>
    function updateOrderStatus(orderId, newStatus) {
      // Create an AJAX request
      var xhr = new XMLHttpRequest();
      xhr.open("POST", "updateOrderStatus", true);
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

      // Define the callback function
      xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {
          // Update the status on the page
          document.getElementById("status-" + orderId).innerText = "Status: " + newStatus;
        } else if (xhr.readyState == 4) {
          alert("Failed to update order status.");
        }
      };

      // Send the request with the orderId and newStatus
      xhr.send("orderId=" + orderId + "&newStatus=" + newStatus);
    }
  </script>
</head>
<body>
<div class="header">
  <h1>Delivery Personnel Dashboard</h1>
</div>
<div class="container">
  <div class="sidebar">
    <div class="profile">
      <h2>Profile</h2>
      <p>Name: John Doe</p>
      <p>Email: johndoe@example.com</p>
      <p>Phone: 123-456-7890</p>
    </div>
  </div>
  <div class="content">
    <h2>Active Orders</h2>
    <div class="order-list">
      <div class="order-detail">
        <h3>Order1</h3>
        <p>Restaurant: Restaurant1</p>
        <p>Address: Address1</p>
        <p id="status-1" class="status">Status: In Progress</p>
        <div class="update-buttons">
          <button class="update-button" onclick="updateOrderStatus(1, 'Pending')">Mark as Pending</button>
          <button class="update-button" onclick="updateOrderStatus(1, 'In Progress')">Mark as In Progress</button>
          <button class="update-button" onclick="updateOrderStatus(1, 'Completed')">Mark as Completed</button>
        </div>
      </div>
      <div class="order-detail">
        <h3>Order2</h3>
        <p>Restaurant: Restaurant2</p>
        <p>Address: Address2</p>
        <p id="status-2" class="status">Status: Pending</p>
        <div class="update-buttons">
          <button class="update-button" onclick="updateOrderStatus(2, 'Pending')">Mark as Pending</button>
          <button class="update-button" onclick="updateOrderStatus(2, 'In Progress')">Mark as In Progress</button>
          <button class="update-button" onclick="updateOrderStatus(2, 'Completed')">Mark as Completed</button>
        </div>
      </div>
      <div class="order-detail">
        <h3>Order3</h3>
        <p>Restaurant: Restaurant3</p>
        <p>Address: Address3</p>
        <p id="status-3" class="status">Status: Completed</p>
        <div class="update-buttons">
          <button class="update-button" onclick="updateOrderStatus(3, 'Pending')">Mark as Pending</button>
          <button class="update-button" onclick="updateOrderStatus(3, 'In Progress')">Mark as In Progress</button>
          <button class="update-button" onclick="updateOrderStatus(3, 'Completed')">Mark as Completed</button>
        </div>
      </div>
    </div>
  </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
