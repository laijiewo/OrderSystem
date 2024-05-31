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
<%@ page import="module.enums.DeliveryArea" %>
<%
    User user =(User) session.getAttribute("user");
    String FirstName = request.getParameter("FirstName");
    String LastName = request.getParameter("LastName");
    String Address = request.getParameter("address");
    String PhoneNumber = request.getParameter("PhoneNumber");
    String password = request.getParameter("Password");



    out.print(user.getPersonID());
    out.print(FirstName);
    out.print(LastName);
    out.print(Address);
    out.print(PhoneNumber);

    user.setFirstName(FirstName);
    user.setLastName(LastName);
    user.setAddress(DeliveryArea.valueOf(Address));
    user.setPhoneNumber(PhoneNumber);
    user.setPassword(password);
    userDAO UserDAO = new userDAO();
    UserDAO.setAddress(user.getPersonID(), DeliveryArea.valueOf(Address));
    personDAO personDAO = new personDAO();
    personDAO.updateInformation(user);
    response.sendRedirect("RestaurantList.jsp");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
