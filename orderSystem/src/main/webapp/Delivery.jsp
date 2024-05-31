<%@ page import="java.util.List" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.DeliveryPerson" %>
<%@ page import="module.Order" %>
<%@ page import="dao.DeliveryPersonDAO" %>
<%@ page import="dao.userDAO" %>
<%@ page import="module.enums.DeliveryArea" %>
<%@ page import="module.enums.OderStatus" %>
<%
    // Create an instance of DeliveryDAO
    DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
    // Get all delivers
    DeliveryPerson dp = (DeliveryPerson) session.getAttribute("deliveryPerson");
    List<Order> orders;
    try {
        orders = deliveryPersonDAO.getOrders(dp.getPersonID());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delivery Personnel Dashboard</title>
    <link rel="stylesheet" href="delivery.css">
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="exitButton.html" %>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="header">
    <h1>Delivery Personnel Dashboard</h1>
</div>
<div class="container">
    <div class="sidebar">
        <%
            DeliveryPerson deliveryPerson = (DeliveryPerson) session.getAttribute("deliveryPerson");
        %>
        <div class="profile">
            <h2 style="color: rgb(70, 96, 117)">Delivery Personal Information:</h2>
            <div class="category">Delivery Person: </div>
            <div class="category1"><%out.print(deliveryPerson.getFirsName() + " " + deliveryPerson.getLastName());%></div>
            <div class="category">Delivery Area: </div>
            <div class="category1"><%out.print(deliveryPerson.getDeliveryArea());%></div>
            <button class="update-button" onclick="location.href='updateDeliveryArea.jsp?deliveryPersonID=<%= deliveryPerson.getPersonID() %>'">Update Delivery Area</button>
            <div class="category">Phone Number: </div>
            <div class="category1">Phone: <%out.print(deliveryPerson.getPhoneNumber());%></div>
            <div class="category">Delivery Status: </div>
            <div class="category1"><%out.print(deliveryPerson.getDeliveryStatus());%></div>
            <button class="update-button" onclick="location.href='updateDeliveryStatus.jsp?restaurant=<%=dp%>'">Update Delivery Status</button>
        </div>
    </div>
    <div class="content">
        <h2>Orders</h2>
        <div class="products">
            <%
                for (Order order : orders) {
                    String orderID = order.getOrderId();
            %>
            <div class="product">
                <div class="product-details">
                    <h3> <% out.print("Order " + orderID);%></h3>
                    <p> Delivery Person ID: <% out.print(order.getU_PersonId());%></p>
                    <%
                        userDAO userDAO = new userDAO();
                        DeliveryArea deliveryArea = userDAO.getAddress(order.getU_PersonId());
                        String phoneNumber = userDAO.getPhoneNumber(order.getU_PersonId());
                        DeliveryDAO deliveryDAO = new DeliveryDAO();
                    %>
                    <p> Address: <% out.print(deliveryArea);%></p>
                    <p> Customer Phone Number: <% out.print(phoneNumber);%></p>
                    <p> Order Status: <% out.print(deliveryDAO.getDeliverStatus(orderID));%></p>
                </div>
                <%
                    if (deliveryDAO.getDeliverStatus(orderID) != OderStatus.ARRIVED) {
                %>
                <div class="product-button-container">
                    <button class="update-button" onclick="location.href='updateOrderStatus.jsp?orderID=<%= orderID %>'">Arrived</button>
                </div>
                <%
                    }
                %>
            </div>
            <%
                }
            %>
        </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
