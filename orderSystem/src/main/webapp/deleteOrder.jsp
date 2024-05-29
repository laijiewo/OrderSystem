<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.SQLException, dao.orderDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String orderId = request.getParameter("orderId");
  boolean success = false;
  try {
    success = orderDAO.deleteOrderByID(orderId);
  } catch (SQLException e) {
    e.printStackTrace();
  }

  if (success) {
    out.println("Order deleted successfully!");
  } else {
    out.println("Failed to delete order.");
  }
%>
<br>
<a href="OrderList.jsp">Back to Order List</a>

