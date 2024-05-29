<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/29
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.dishDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="module.Dish" %>
<%@ page import="dao.restaurantDAO" %>
<%@ page import="module.RestaurantManager" %>
<%@ page import="java.sql.Date" %>
<%@ page import="module.Restaurant" %>
<%@ page import="java.sql.SQLException" %>


<%
    RestaurantManager restaurantManager = (RestaurantManager) session.getAttribute("restaurantManager");
    String RestaurantID = restaurantManager.getRestaurantID();
    restaurantDAO restaurantDAO = new restaurantDAO();
    Restaurant restaurant;
    try {
        restaurant = restaurantDAO.getRestaurantByID(RestaurantID);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    session.setAttribute("restaurant", restaurant);
    String restaurantName = restaurant.getRestaurantName();
    Date startDate = restaurantManager.getStartManagementDate();
    dishDAO dishDAO = new dishDAO();
    List<Dish> dishList;
    try {
        dishList = dishDAO.getDishesByRestaurantID(RestaurantID);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><% out.println(restaurantName); %></title>
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="RestaurantStyle.css">
</head>
<body>
<%@ include file="exitButton.html" %>
<div class="header">
    <h1 style="font: 50px hold"><% out.println(restaurantName); %></h1>
    <img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
</div>
<div class="container">
    <div class="sidebar">
        <h2 style="color: rgb(70, 96, 117)">Restaurant Information:</h2>
        <div class="category">Restaurant Manager: </div>
        <div class="category1"><%out.print(restaurantManager.getFirsName() + " " + restaurantManager.getLastName());%></div>
        <div class="category">Start Management Date: </div>
        <div class="category1"><%out.print(startDate);%></div>
        <div class="category">Contact Information: </div>
        <div class="category1">Phone: <%out.print(restaurant.getContact_Information());%></div>
        <div class="category">Restaurant Address: </div>
        <div class="category1"><%out.print(restaurant.getRestaurantAddress());%></div>
        <div class="category">Business hours: </div>
        <div class="category1"><%out.print(restaurant.getBusiness_Hours());%></div>
        <div>
            <button class="update-button" onclick="location.href='updateRestaurant.jsp?restaurantID=<%= RestaurantID %>'">Update Restaurant Information</button>
        </div>
    </div>
    <div class="content">
        <b><h2 style="font: 35px hold">DISHES:</h2></b>
        <div class="products">
            <%
                for (Dish dish : dishList) {
            %>
            <div class="product">
                <div class="product-details">
                    <h3><%= dish.getDishName() %></h3>
                    <p>DishID: <%= dish.getDishId() %></p>
                    <p>Is Dish Available: <%= dish.isDishAvailability() %></p>
                    <p class="price">￥<%= dish.getDishPrice() %></p>
                </div>
                <div class="product-button-container">
                    <button class="product-button" onclick="location.href='updateDish.jsp?dishID=<%= dish.getDishId() %>'">Update Dish</button>
                    <button class="product-button" onclick="location.href='deleteDish.jsp?dishID=<%= dish.getDishId() %>'">Delete</button>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<div class="button-container">
    <button class="button" onclick="location.href='addDish.jsp'">Add Dish</button>
    <button class="button" onclick="location.href='orders.jsp'">Orders</button>
</div>
<%@ include file="footer.html" %>
</body>
</html>
