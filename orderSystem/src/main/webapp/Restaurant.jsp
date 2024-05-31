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
<%@ page import="dao.restaurantDAO" %>
<%@ page import="module.randomString" %>
<%@ page import="module.Restaurant" %>
<%@ page import="dao.RestaurantManagerDAO" %>
<%@ page import="module.RestaurantManager" %>
<%@ page import="java.util.ArrayList" %>


<%
    String RestaurantID = request.getParameter("restaurantID");
    restaurantDAO restaurantDAO = new restaurantDAO();
    Restaurant restaurant = restaurantDAO.getRestaurantByID(RestaurantID);
    RestaurantManagerDAO restaurantManagerDAO = new RestaurantManagerDAO();
    String restaurantManagerID = restaurantDAO.getRestaurantManagerID(RestaurantID);
    RestaurantManager restaurantManager = restaurantManagerDAO.getManager(restaurantManagerID);
    String restaurantName = restaurant.getRestaurantName();
    dishDAO dishDAO = new dishDAO();
    List<Dish> dishList = dishDAO.getDishesByRestaurantID(RestaurantID);


    List<Dish> shoppingTrolley = (List<Dish>) session.getAttribute("ShoppingTrolley");
    if (shoppingTrolley == null) {
        shoppingTrolley = new ArrayList<>();
        session.setAttribute("ShoppingTrolley", shoppingTrolley);
    }

    String dishID = request.getParameter("DishID");
    Dish newdish;
    if (dishID!=null) {
        if(!dishID.isEmpty()) {
            newdish = dishDAO.getDishByID(dishID);
            shoppingTrolley.add(newdish);
        }
    }
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
<%@ include file="exitButton.html" %>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="header">
    <h1><% out.println(restaurantName); %></h1>
</div>
<div class="container">
    <div class="sidebar">
        <h2 style="color: rgb(70, 96, 117)">Restaurant Information:</h2>
        <div class="category">Restaurant Manager: </div>
        <div class="category1"><%out.print(restaurantManager.getFirsName() + " " + restaurantManager.getLastName());%></div>
        <div class="category">Start Management Date: </div>
        <div class="category1"><%out.print(restaurantManager.getStartManagementDate());%></div>
        <div class="category">Contact Information: </div>
        <div class="category1">Phone: <%out.print(restaurant.getContact_Information());%></div>
        <div class="category">Restaurant Address: </div>
        <div class="category1"><%out.print(restaurant.getRestaurantAddress());%></div>
        <div class="category">Business hours: </div>
        <div class="category1"><%out.print(restaurant.getBusiness_Hours());%></div>
    </div>
    <div class="content">
        <h2>HOT DISHES</h2>
        <div class="place">
            <button name="place an order" class="button" type="button" onclick="location.href='order.jsp?' +
                    'orderID=<%=randomString.generateRandomOrderID()%>'">place an order</button>
        </div>
        <div class="products">
            <%
                for (Dish dish : dishList) {
            %>
            <form method="post" action="Restaurant.jsp?restaurantID=<%=RestaurantID%>">
                <button type="submit" class="button">
                    <div class="product">
                        <div class="product-details">
                            <h3><%= dish.getDishName() %></h3>
                            <p>DishID: <%= dish.getDishId() %></p>
                            <p class="number"><%= dish.number_of_dishes(shoppingTrolley) %></p>
                            <p class="price">¥<%= dish.getDishPrice() %></p>
                        </div>
                    </div>
                </button>
                <input type="hidden" name="DishID" value="<%= dish.getDishId() %>">
            </form>
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



