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

    try {
        if (personDAO.login(username, password) == null) {
            response.sendRedirect("index.jsp");
            return;
        }
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }

    if (select.equals("User")) {
        try {
            userDAO userDAO = new userDAO();
            User u = userDAO.login(username, password);
            if (u == null) {
                response.sendRedirect("index.jsp");
                return;
            }
            session.setAttribute("user", u);
            response.sendRedirect("RestaurantList.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    } else if (select.equals("RestaurantManager")) {
        try {
            RestaurantManagerDAO restaurantManagerDAO = new RestaurantManagerDAO();
            RestaurantManager rm = restaurantManagerDAO.login(username, password);
            if (rm == null) {
                response.sendRedirect("index.jsp");
                return;
            }
            session.setAttribute("restaurantManager", rm);
            response.sendRedirect("restaurantManageScreen.jsp");
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    } else if (select.equals("DeliveryPerson")) {
        try {
            DeliveryPersonDAO deliveryPersonDAO = new DeliveryPersonDAO();
            DeliveryPerson dp = deliveryPersonDAO.login(username, password);
            if (dp == null) {
                response.sendRedirect("index.jsp");
                return;
            }
            session.setAttribute("deliveryPerson", dp);
            response.sendRedirect("Delivery.jsp");
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