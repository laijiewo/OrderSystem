<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="module.enums.OderStatus" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="module.*" %>
<%@ page import="dao.*" %>
<%@ page import="module.enums.DeliveryArea" %>
<%@ page import="module.enums.DeliveryStatus" %>
<%
    String orderID = request.getParameter("order");
    session.setAttribute("orderID", orderID);
    orderDAO orderDao = new orderDAO();
    Order order = orderDao.getOrderByID(orderID);
    userDAO userDAO = new userDAO();
    DeliveryArea deliveryArea = userDAO.getAddress(order.getU_PersonId());
    List<DeliveryPerson> deliveryPersons = DeliveryPersonDAO.getAllDeliveryPersonsDeliveryTo(deliveryArea);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assign Delivery To Delivery Person</title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
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
            padding: 20px;
        }

        .products {
            display: flex;
            flex-flow: column wrap;
            align-items: stretch;
            align-content: space-between;
        }
        .product {
            display: flex;
            flex-direction: row;
            align-items: center;
            color: rgb(92, 147, 148);
            gap: 20px;
            width: 800px;
            background-color: white;
            padding: 0px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
            transition: transform 0.3s ease;
        }
        .product-button{
            border-radius: 10px;
        }
        .product-button:hover {
            transform: scale(1.05);
        }
        .product-details {
            margin-left: 20px;
            display: flex;
            flex-direction: column;
            flex-grow: 1;

        }
        .product h3 {
            align-self: flex-start;
            margin: 10px 0;
            color: rgb(70, 96, 117);
        }
        .product p {
            align-self: flex-start;
            margin: 0 0 10px;
        }
        .product .number{align-self: flex-end;
            color: royalblue;
            font-weight: bold;
            margin-right: 10px;
        }


        .product .price {
            align-self: flex-end;
            color: rgb(70, 96, 117);
            font-weight: bold;
            margin-right: 10px;
        }

        .button:hover {
            transform: scale(1.05);
        }
        .review-button {
            color: rgb(70, 96, 117);
            transition: transform 0.3s ease;

        }
        .review-button:hover {
            transform: scale(1.05);
        }

        .footer {
            background-color: rgb(92, 147, 148);
            padding: 10px;
            text-align: center;
            color: #fff;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Order List</h1>
    <button class="button" onclick="location.href='restaurantManageScreen.jsp'">Back</button>
</div>
<div class="container">
    <h2>List of Delivery Persons</h2>
    <div class="products">
        <%
            for (DeliveryPerson dp : deliveryPersons) {
        %>
        <button type="submit" class="button">
            <div class="product">
                <div class="product-details">
                    <h3><%= dp.getPersonID() %>
                    </h3>
                    <p> Delivery Person Name: <%= dp.getFirsName() + " " + dp.getLastName() %>
                    </p>
                    <p>Gender: <%= dp.getGender() %>
                    </p>
                    <p>Phone Number: <%= dp.getPhoneNumber() %>
                    </p>
                    <p>Delivery Status: <%= dp.getDeliveryStatus() %>
                    </p>
                    <p>Delivery Area: <%= deliveryArea.toString() %>
                    </p>
                </div>
            </div>
            <%
                if (dp.getDeliveryStatus().equals(DeliveryStatus.WAITING)) {
            %>
            <div class="review-button">
                <button class="review-button" onclick="location.href='assignDeliveryToDeliveryPerson.jsp?personID=<%= dp.getPersonID() %>&orderID=<%= orderID %>'">Assign Delivery To This Person</button>
            </div>
            <%
                }
            %>
        </button>
        <%
            }
        %>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>


