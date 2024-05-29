<%--
  Created by IntelliJ IDEA.
  User: Majoie
  Date: 2024/5/29
  Time: 上午12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.dishDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="module.Dish" %>
<%@ page import="java.util.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.jsp.*" %>
<%@ page import="dao.restaurantDAO" %>


<%
    String RestaurantID = "1234560";
    restaurantDAO restaurantDAO = new restaurantDAO();
    String restaurantName = restaurantDAO.getRestaurantByID(RestaurantID).getRestaurantName();
    dishDAO dishDAO = new dishDAO();
    List<Dish> dishList = dishDAO.getDishesByRestaurantID(RestaurantID);

%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><% out.println(restaurantName); %></title>
    <link rel="stylesheet" href="RestaurantStyle.css">
</head>
<body>
<div class="header">
    <h1><% out.println(restaurantName); %></h1>
</div>
<div class="container">
    <div class="sidebar">
        <h2>Classes</h2>
        <div class="category">Class1</div>
        <div class="category">Class2</div>
        <div class="category">Class3</div>
    </div>
    <div class="content">
        <h2>HOT DISHES</h2>
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



