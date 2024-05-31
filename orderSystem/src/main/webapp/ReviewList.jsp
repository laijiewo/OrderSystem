<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: Majoie
  Date: 2024/5/28
  Time: 上午11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.util.List, dao.reviewDAO, module.Review" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="module.User" %>
<%@ page import="module.Order" %>
<%@ page import="module.Restaurant" %>
<%@ page import="dao.restaurantDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review List</title>
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
            display: flex;
            margin: 20px;
        }
        .content {
            width: 100%;
            padding: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        .footer {
            background-color: rgb(92, 147, 148);
            padding: 20px;
            text-align: center;
            color: #fff;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>Reviews</h1>
</div>
<div class="container">
    <div class="content">
        <h2>Review List</h2>
        <table>
            <tr>
                <th>Date</th>
                <th>Rating</th>
                <th>Review Content</th>
                <th>Restaurant ID</th>
                <th>Restaurant Name</th>
            </tr>
            <%
                List<Review> reviews = null;
                try {
                    reviews = reviewDAO.getReviewList();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (reviews != null) {
                    for (Review review : reviews) {
            %>
            <tr>
                <%
                    Restaurant restaurant = restaurantDAO.getRestaurantByID(review.getR_RestaurantID());
                %>
                <td><%= review.getR_Date() %></td>
                <td><%= review.getRating() %></td>
                <td><%= review.getReviewContent() %></td>
                <td><%= review.getR_RestaurantID() %></td>
                <td><%= restaurant.getRestaurantName() %></td>
                <td>
                    <form action="deleteReview.jsp" method="post" style="display:inline;">
                        <input type="hidden" name="personId" value="<%= review.getR_PersonID() %>">
                        <input type="hidden" name="date" value="<%= review.getR_Date() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
            <%
                    }
                }
            %>
        </table>
        <h2>Add New Review</h2>
        <form action="addReview.jsp?orderID=<%= request.getParameter("order") %>" method="post">
            <label for="rating">Rating:</label>
            <input type="number" step="0.1" id="rating" name="rating" required><br>
            <label for="reviewContent">Review Content:</label>
            <input type="text" id="reviewContent" name="reviewContent" required><br>
            <input type="submit" value="Add Review">
        </form>
    </div>
</div>
<%@ include file="footer.html" %>
</body>
</html>
