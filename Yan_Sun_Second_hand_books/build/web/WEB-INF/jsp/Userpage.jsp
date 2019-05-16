<%-- 
    Document   : Userpage
    Created on : Apr 23, 2019, 3:27:32 PM
    Author     : sunyan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
}
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello,<a href="home.htm">${loginuser.getfName()}! </a></h1>
            <h2>My Books</h2>
            <table style="width:80%; text-align: left " >
                <tr>
                    <th>Name</th>
                    <th>Author</th> 
                    <th>Description</th>
                    <th>Category</th>
                    <th>Upload Date</th>
                    <th>Price</th>
                    <th>Status</th>
                </tr>
            <c:forEach items="${mybooks}" var="book">
                <tr>
                    <c:set scope="session" value="${book}" var="thisbook"/>
                    <td><a href="updatebook.htm">${book.getName()}</a></td>
                    <td>${book.getAuthor()}</td> 
                    <td>${book.getDescreption()}</td>
                    <td>${book.getCategory()}</td>
                    <td>${book.getDate()}</td> 
                    <td>${book.getPrice()}</td>
                    <td>${book.getStatus()}</td>
                </tr>
            </c:forEach>
            
            </table>
    </body>
</html>
