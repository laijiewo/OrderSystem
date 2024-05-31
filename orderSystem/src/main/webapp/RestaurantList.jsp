<%--
  Created by IntelliJ IDEA.
  User: Majoie
  Date: 2024/5/28
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="dao.restaurantDAO" %>
<%@ page import="module.Restaurant" %>
<%@ page import="java.util.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.jsp.*" %>
<%@ page import="javax.swing.*" %>
<%@ page import="module.User" %>

<%
    User user = (User)session.getAttribute("user");
    int currentPage = 1;  // 修改变量名称
    int recordsPerPage = 6;
    String searchName = request.getParameter("searchName") != null ? request.getParameter("searchName") : "";

    if (request.getParameter("page") != null) {
        currentPage = Integer.parseInt(request.getParameter("page"));
    }

    restaurantDAO dao = new restaurantDAO();
    List<Restaurant> restaurantList = dao.getRestaurantsByName(searchName);
    int start = (currentPage - 1) * recordsPerPage;
    int end = Math.min(start + recordsPerPage, restaurantList.size());

    List<Restaurant> paginatedList = restaurantList.subList(start, end);
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="RestaurantStyle.css">
    <link rel="shortcut icon"  href="photos/bitbug_favicon.ico" type="image/x-icon" />
</head>
<body>
<%@ include file="exitButton.html" %>
<img src="<%= request.getContextPath() + "/photos/logo.png" %>" alt="logo">
<div class="header">
    <h1>Restaurants</h1>
    <form method="GET" action="RestaurantList.jsp">
        <input type="text" name="searchName" value="<%= searchName %>" placeholder="Search Restaurants">
        <button type="submit">Search</button>
    </form>
</div>
<div class="container">
    <div class="sidebar">
        <h2>User Information</h2>
        <div class="category">User: </div>
        <div class="category1"><%out.print(user.getFirsName() + " " + user.getLastName());%></div>
        <div class="category">Gender: </div>
        <div class="category1"><%out.print(user.getGender());%></div>
        <div class="category">phone number: </div>
        <div class="category1"><%out.print(user.getPhoneNumber());%></div>
        <div class="category">Address: </div>
        <div class="category1"><%out.print(user.getAddress());%></div>
        <div class="update">
            <button class="button" onclick="location.href='updateUser.jsp?userID=<%= user.getPersonID() %>'">Update User Information</button>
        </div>
    </div>
    <div class="content">
        <div class="main">
            <% for (Restaurant restaurant : paginatedList) { %>
            <button class="restaurant" onclick="location.href='Restaurant.jsp?restaurantID=<%=restaurant.getRestaurantID()%>'">
                <div class="product">
                    <div class="product-details">
                        <h3><%= restaurant.getRestaurantName() %></h3>
                        <p>Address: <%= restaurant.getRestaurantAddress() %></p>
                        <p class="information">Contact information: <%= restaurant.getContact_Information() %></p>
                    </div>
                </div>
            </button>
            <% } %>
        </div>
    </div>
    <div class="pagination">
        <%
            int noOfRecords = restaurantList.size();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            if (currentPage > 1) {
        %>
        <a href="RestaurantList.jsp?page=<%= currentPage - 1 %>&searchName=<%= searchName %>">&lt; Previous</a>
        <% } %>
        <% if (currentPage < noOfPages) { %>
        <a href="RestaurantList.jsp?page=<%= currentPage + 1 %>&searchName=<%= searchName %>">Next &gt;</a>
        <% } %>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>



