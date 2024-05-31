<%--
  Created by IntelliJ IDEA.
  User: Majoie
  Date: 2024/5/31
  Time: 下午12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="dao.*" %>
<%@ page import="module.Restaurant" %>
<%@ page import="module.User" %>
<%@ page import="java.util.List" %>
<%
    User user =(User) session.getAttribute("user");
    String FirstName = request.getParameter("FirstName");
    String LastName = request.getParameter("LastName");
    String Address = request.getParameter("Address");
    String PhoneNumber = request.getParameter("PhoneNumber");



    out.print(user.getPersonID());
    out.print(FirstName);
    out.print(LastName);
    out.print(Address);
    out.print(PhoneNumber);

    userDAO UserDAO = new userDAO();
    String personID = RestaurantManagerDAO.getManagerID(RestaurantID);
    Restaurant rest = new Restaurant(RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, personID);
    restDAO.updateRestaurant(rest);
    response.sendRedirect("RestaurantList.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
