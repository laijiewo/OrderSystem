<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.sql.SQLException, dao.reviewDAO, module.Review" %>
<%@ page import="module.Order" %>
<%@ page import="module.Restaurant" %>
<%@ page import="dao.orderDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String orderId = request.getParameter("orderID");
    System.out.println(orderId);
    Order order = orderDAO.getOrderByID(orderId);
    String personId = order.getU_PersonId();
    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    float rating = Float.parseFloat(request.getParameter("rating"));
    String reviewContent = request.getParameter("reviewContent");
    Restaurant restaurant = orderDAO.getRestaurantByOrderID(order.getOrderId());
    String restaurantId = restaurant.getRestaurantID();

    Review review = new Review(personId, sqlDate, rating, reviewContent, restaurantId);
    boolean success = false;
    try {
        success = reviewDAO.insertReview(review);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (success) {
        out.println("Review added successfully!");
    } else {
        out.println("Failed to add review.");
    }
%>
<br>
<a href="ReviewList.jsp">Back to Review List</a>
