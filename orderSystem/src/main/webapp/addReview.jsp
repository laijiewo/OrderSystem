<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.sql.SQLException, dao.reviewDAO, module.Review" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String personId = request.getParameter("personId");
    Date date = Date.valueOf(request.getParameter("date"));
    float rating = Float.parseFloat(request.getParameter("rating"));
    String reviewContent = request.getParameter("reviewContent");
    String restaurantId = request.getParameter("restaurantId");

    Review review = new Review(personId, date, rating, reviewContent, restaurantId);
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
