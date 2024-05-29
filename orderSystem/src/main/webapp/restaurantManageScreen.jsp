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
    String restaurantName = restaurant.getRestaurantName();
    Date startDate = restaurantManager.getStartManagementDate();
    dishDAO dishDAO = new dishDAO();
    List<Dish> dishList = null;
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
<div class="header">
    <h1><% out.println(restaurantName); %></h1>
</div>
<div class="container">
    <div class="sidebar">
        <h2>Restaurant Information</h2>
        <div class="category">Restaurant Manager: <%out.print("\n");%><%out.print(restaurantManager.getFirsName() + " " + restaurantManager.getLastName());%><%out.print("\n");%></div>
        <div class="category">Start Management Date: <%out.print("\n");%><%out.print(startDate);%><%out.print("\n");%></div>
        <div class="category">Contact Information: <%out.print("\n");%><%out.print(restaurant.getContact_Information());%><%out.print("\n");%></div>
        <div class="category">Restaurant Address: <%out.print("\n");%><%out.print(restaurant.getRestaurantAddress());%><%out.print("\n");%></div>
        <div class="category">Business hours: <%out.print("\n");%><%out.print(restaurant.getBusiness_Hours());%><%out.print("\n");%></div>
    </div>
    <button class="button" onclick="location.href='addDish.jsp'">Add Dish</button>
    <div class="content">
        <h2>DISHES</h2>
        <div class="products">
            <%
                for (Dish dish : dishList) {
            %>
            <div class="product">
                <img src="photos/头像.jpg" alt="产品图片">
                <div class="product-details">
                    <h3><%= dish.getDishName() %></h3>
                    <p>DishID: <%= dish.getDishId() %></p>
                    <p class="price">￥<%= dish.getDishPrice() %></p>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</div>
<div class="footer">
    <p>&copy; 2024 Restaurants</p>
</div>
</body>
</html>
