<%@ page import="java.util.List" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.Deliver" %>
<%@ page import="module.enums.OderStatus" %>
<%
    // Create an instance of DeliveryDAO
    DeliveryDAO deliveryDAO = new DeliveryDAO();
    // Get all delivers
    List<Deliver> delivers = deliveryDAO.getAllDelivers();
%>
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
            width: calc(50% - 10px);
            height: 200px;
            background-color: #ffffff;
            padding: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
            display: flex;
            flex-direction: column;
            justify-content: space-between;
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
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "updateOrderStatus", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("status-" + orderId).innerText = "Status: " + newStatus;
                } else if (xhr.readyState == 4) {
                    alert("Failed to update order status.");
                }
            };

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
            <%
                for (Deliver deliver : delivers) {
            %>
            <div class="order-detail">
                <h3>Order <%= deliver.getOrderID() %></h3>
                <p>Delivery Person ID: <%= deliver.getDeli_PersonID() %></p>
                <p id="status-<%= deliver.getOrderID() %>" class="status">Status: <%= deliver.getStatus() %></p>
                <div class="update-buttons">
                    <button class="update-button" onclick="updateOrderStatus('<%= deliver.getOrderID() %>', 'NOT_DELIVERED')">Mark as Not Delivered</button>
                    <button class="update-button" onclick="updateOrderStatus('<%= deliver.getOrderID() %>', 'DELIVERING')">Mark as Delivering</button>
                    <button class="update-button" onclick="updateOrderStatus('<%= deliver.getOrderID() %>', 'DELIVERED')">Mark as Delivered</button>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
