<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/29
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="dao.*" %>
<%@ page import="module.Restaurant" %>
<%
    String RestaurantID = session.getAttribute("restaurantID").toString();
    String RestaurantName = request.getParameter("RestaurantName");
    String Address = request.getParameter("Address");
    String ContactInformation = request.getParameter("Contact Information");
    String BusinessHours = request.getParameter("Business Hours");


    out.print(RestaurantID);
    out.print(RestaurantName);
    out.print(Address);
    out.print(ContactInformation);
    out.print(BusinessHours);

    restaurantDAO restDAO = new restaurantDAO();
    String personID = RestaurantManagerDAO.getManagerID(RestaurantID);
    Restaurant rest = new Restaurant(RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, personID);
    restDAO.updateRestaurant(rest);
    response.sendRedirect("restaurantManageScreen.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
