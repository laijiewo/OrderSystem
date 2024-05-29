<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/29
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>
<%@ page import="module.Restaurant" %>
<%@ page import="module.Dish" %>
<%@ page import="java.sql.SQLException" %>
<%
    String dishID = request.getParameter("DishID");
    String dishName = request.getParameter("DishName");
    double dishPrice = Double.parseDouble(request.getParameter("Price"));
    boolean isAvailable = Boolean.parseBoolean(request.getParameter("Is Available"));
    Restaurant restaurant = (Restaurant) session.getAttribute("restaurant");

    out.print(dishID);
    out.print(dishName);
    out.print(dishPrice);
    out.print(isAvailable);

    Dish dish = new Dish(dishID, dishName, dishPrice, isAvailable, restaurant.getRestaurantID());
    dishDAO dishDao = new dishDAO();
    try {
        dishDao.insertDish(dish);
        response.sendRedirect("restaurantManageScreen.jsp");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
