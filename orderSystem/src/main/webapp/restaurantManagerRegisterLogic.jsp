<%--
  Created by IntelliJ IDEA.
  User: 李京旺
  Date: 2024/5/28
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.*" %>
<%@ page import="module.enums.Gender" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    String personID = request.getParameter("PeronID");
    String password = request.getParameter("password");
    String phoneNumber = request.getParameter("phoneNumber");
    String gender = request.getParameter("Gender");
    String FName = request.getParameter("First Name");
    String LName = request.getParameter("Last Name");
    String RestaurantID = request.getParameter("RestaurantID");
    String RestaurantName = request.getParameter("RestaurantName");
    String Address = request.getParameter("Address");
    String ContactInformation = request.getParameter("Contact Information");
    String BusinessHours = request.getParameter("Business Hours");
    String DeliveryArea = request.getParameter("Delivery Area");

    out.print(personID);
    out.print(password);
    out.print(phoneNumber);
    out.print(gender);
    out.print(FName);
    out.print(LName);
    out.print(RestaurantID);
    out.print(RestaurantName);
    out.print(Address);
    out.print(ContactInformation);
    out.print(BusinessHours);
    out.print(DeliveryArea);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String dateStr = sdf.format(new Date());

    RestaurantManagerDAO restaurantManagerDAO = new RestaurantManagerDAO();
    try {
        if (restaurantManagerDAO.register(personID, LName, FName, password, phoneNumber, module.enums.Gender.valueOf(gender), RestaurantID, RestaurantName, Address, ContactInformation, BusinessHours, java.sql.Date.valueOf(dateStr))) {
            response.sendRedirect("index.jsp");
        } else {
            System.out.println("wrong input");
            response.sendRedirect("restaurantManagerRegister.jsp");
        }
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("restaurantManagerRegister.jsp");
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
