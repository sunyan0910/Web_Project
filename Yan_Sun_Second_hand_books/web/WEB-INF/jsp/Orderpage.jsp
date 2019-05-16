<%-- 
    Document   : Orderpage
    Created on : Apr 24, 2019, 2:31:26 PM
    Author     : zsh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            button:hover {opacity: 0.8;}
            button {background-color: #4CAF50;
                    color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Order</title>
    </head>
    <body>
        <h1><a href="home.htm">Your Order</a></h1>
        Books:
        <table style="width:80%; text-align: left ">
            <tr>
                    <th>Name</th>
                    <th>Author</th> 
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Owner Email</th>
            </tr>
            <c:forEach items="${loginuser.getCart()}" var="book">
                <tr>
                    <c:set scope="session" value="${book}" var="thisbook"/>
                    <td>${book.getName()}</td>
                    <td>${book.getAuthor()}</td> 
                    <td>${book.getDescreption()}</td>
                    <td>${book.getCategory()}</td>
                    <td>${book.getPrice()}</td>
                    <td>${book.getOwner().getEmail()}</td>
                </tr>
            </c:forEach>
        </table>
        Total Price:$${total}
        <form action="place.htm" method="post">
            <button type="submit" name="button" value="Place order">Place order</button>
        </form>
        
    </body>
</html>
