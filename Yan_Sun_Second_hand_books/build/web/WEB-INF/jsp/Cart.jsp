<%-- 
    Document   : Cart
    Created on : Apr 19, 2019, 1:09:23 AM
    Author     : sunyan
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            a{
                color:#000;
                text-decoration: none;
                margin-top: 10px;
            }
            a:hover{
                font-style: italic;
                color:#DA0000;
            }
            button {
                background-color: #4CAF50;
                color: white;
                padding: 14px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 100%;
                margin-top: 500px;
            }

            button:hover {
                opacity: 0.8;
            }
        </style>
        <title>Cart</title>
    </head>
    <body>
        <h1>Shopping Cart of <a href="home.htm">${loginuser.getfName()}</a></h1>
        <table style="width:80%; text-align: left " >
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Category</th>
                <th>Description</th>
                <th>Price</th>
                <th>Owner Email</th>
                <th>Delete</th>
            </tr>
        <c:forEach items="${loginuser.getCart()}" var="book">
            <tr>
                <td>${book.getName()}</td>
                <td>${book.getAuthor()}</td> 
                <td>${book.getCategory()}</td> 
                <td>${book.getDescreption()}</td>
                <td>${book.getPrice()}</td> 
                <td>${book.getOwner().getEmail()}</td>
                <td>
                    <form action="deleteItem.htm" method="post">
                        <input type="hidden" name="bookid" value="${book.getBookId()}">
                        <input type="submit" name="button" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </table>
            <form action="checkout.htm" method="post">
                <button type="submit" name="button" value="Check out">Check out</button>
            </form>
    </body>
</html>
