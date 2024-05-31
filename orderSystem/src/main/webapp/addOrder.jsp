<%--
  Created by IntelliJ IDEA.
  User: 22832
  Date: 2024/5/28
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Date, dao.orderDAO, module.Order" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="module.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="module.OrderList" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dao.orderListDAO" %>
<%@ page import="java.time.ZonedDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = (String) session.getAttribute("username");
    List<Dish> shoppingTrolley = (List<Dish>) session.getAttribute("ShoppingTrolley");
    List<OrderList> newOrderList = new ArrayList<>();
    String OrderID = request.getParameter("orderID");
    String comment = request.getParameter("comment");

    java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    out.println("Order added successfully!");
    Order order = new Order(OrderID,sqlDate, username );
    orderDAO.insertOrder(order);


    for (Dish dish : shoppingTrolley) {
        boolean newOrder = true;
        for (OrderList orderList:newOrderList){
            if(dish.getDishId().equals(orderList.getDishId())){
                orderList.increaseNumber();
                newOrder = false;
            }
        }
        OrderList  orderList = new OrderList(OrderID, dish.getDishId(),"",1);
        if(newOrder){
            newOrderList.add(orderList);
        }
    }
    for (OrderList orderList:newOrderList) {
        orderList.setComments(comment);
        orderListDAO.insertOrderList(orderList);
    }

%>
<br>
<a href="RestaurantList.jsp">Back to Restaurant List</a>
