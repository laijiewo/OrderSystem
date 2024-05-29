<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, java.sql.SQLException, dao.reviewDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String personId = request.getParameter("personId");
    Date date = Date.valueOf(request.getParameter("date"));
    boolean success = false;
    try {
        success = reviewDAO.deleteReviewByID(personId, date);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (success) {
        out.println("Review deleted successfully!");
    } else {
        out.println("Failed to delete review.");
    }
%>
<br>
<a href="ReviewList.jsp">Back to Review List</a>
