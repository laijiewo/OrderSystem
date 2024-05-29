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

<%
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
    <link rel="stylesheet" href="RestaurantListStyle.css">
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Restaurants</h1>
        <form method="GET" action="RestaurantList.jsp">
            <input type="text" name="searchName" value="<%= searchName %>" placeholder="Search Restaurants">
            <button type="submit">Search</button>
        </form>
    </div>
    <div class="content">
        <div class="sidebar">
            <h2>Classes</h2>
            <ul>
                <li>Class1</li>
                <li>Class2</li>
                <li>Class3</li>
            </ul>
        </div>
        <div class="main">
            <% for (Restaurant restaurant : paginatedList) { %>
            <div class="card">
                <h2><%= restaurant.getRestaurantName() %></h2>
            </div>
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



