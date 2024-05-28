<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/23
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="module.User" %>
<%@ page import="module.Person" %>
<%@ page import="module.enums.personEnum" %>
<%@ page import="module.DeliveryPerson" %>
<%@ page import="module.RestaurantManager" %>


<%
    String select = request.getParameter("role");
    personDAO personDAO = new personDAO();
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    out.print(username);
    out.print(password);

    Person p = personDAO.login(username, password);

    if (select.equals("User")) {
        try {
            userDAO userDAO = new userDAO();
            User u = userDAO.login(username, password);
            response.sendRedirect("RestaurantList.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    } else if (select.equals("RestaurantManager")) {
        try {
            RestaurantManagerDAO restaurantManagerDAO = new RestaurantManagerDAO();
            RestaurantManager rm = restaurantManagerDAO.login(username, password);
            response.sendRedirect("RestaurantList.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    } else if (select.equals("DeliveryPerson")) {
        try {
            DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
            DeliveryPerson dp = deliveryPersonDAO.login(username, password);
            response.sendRedirect("RestaurantList.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }


%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Waring</title>
</head>
<body>
Wrong password!!!!!!
</body>
</html>