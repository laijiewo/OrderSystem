<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/31
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.orderListDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="dao.dishDAO" %>
<%@ page import="dao.orderDAO" %>
<%@ page import="dao.DeliveryDAO" %>
<%@ page import="module.enums.OderStatus" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="module.*" %>
<%
    RestaurantManager rm = (RestaurantManager) session.getAttribute("restaurantManager");
    String restaurantID = rm.getRestaurantID();
    List<Order> orders = orderDAO.getRestaurantOrderList(restaurantID);
    dishDAO dishDAO = new dishDAO();
    DeliveryDAO deliveryDAO = new DeliveryDAO();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RESTAURANT ORDERS</title>
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
    <h2>List of Orders</h2>
    <div class="products">
        <%
            double totalPrice = 0d;
            for (Order o : orders) {
                List<OrderList> dishes = orderListDAO.getOrderListByOrderID(o.getOrderId());
        %>
        <button type="submit" class="button">
            <div class="product">
                <div class="product-details">
                    <h3><%= o.getOrderId() %>
                    </h3>
                    <%
                        for (OrderList ol : dishes) {
                            Dish dish = dishDAO.getDishByID(ol.getDishId());
                            int number = ol.getNumber();
                            double price = dish.getDishPrice() * number;
                            totalPrice += price;
                    %>
                    <p>Dish Name: <%= dish.getDishName() + " count: " + number + "    comment: " + ol.getComment() + "    price: ￥" + price %>
                    </p>
                    <%
                        }
                    %>
                </div>
            </div>
            <p class="price">¥<%= totalPrice %>
            </p>
            <%
                if (deliveryDAO.getDeliverStatus(o.getOrderId()).equals(OderStatus.WAITING_FOR_DELIVERING  )) {
            %>
            <div class="review-button">
                <button class="review-button" onclick="location.href='assignDelivery.jsp?order=<%= o.getOrderId() %>'">Assign Delivery</button>
            </div>
            <%
                }
            %>
        </button>
        <%
                totalPrice = 0d;
            }
        %>
    </div>
</div>
<div class="footer">
    <p>&copy; 2024 Order System</p>
</div>
</body>
</html>

