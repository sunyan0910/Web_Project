<%-- 
    Document   : BookDetailPage
    Created on : Apr 19, 2019, 7:24:32 PM
    Author     : sunyan
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
                function validator()
                {
                    var x=document.forms["add"]["price"].value;
                    var regex=/[0-9]/;
                    if(!x.match(regex))
                    {
//                        console.log("klllllll");
                        alert("Must input numbers");
                        return false;
                    }
                }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            h1{text-aligen:center}
            button:hover {opacity: 0.8;}
            button {background-color: #4CAF50;
                    color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;}
            input[type="text"]{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }
        </style>
        <title>Book</title>
    </head>
    <body>
        <c:set value="${from}" var="from"/>
        <c:set value="${thisbook}" var="thisbook"/>
        
        <c:if test="${from=='add'}">
            <h1><a href="home.htm">Add a book</a></h1>
        <form name="add" action="submitbook.htm" method="post" onsubmit="return validator()">
            Book Name:</br><input type="text" name="name" id="name" required="required"/></br>
            Author:</br><input type="text" name="author" id="author" required="required"/></br>
            Category:</br>
            
            <input type="radio" name="category" value="Computer">Computer</br>
            
            <input type="radio" name="category" value="Fiction">Fiction</br>
            
            <input type="radio" name="category" value="Math">Math</br>
            
            <input type="radio" name="category" value="English">English</br>
            
            <input type="radio" name="category" value="Chinese">Chinese</br></br>
            
            Description for this book:</br><input type="text" name="description" id="description" required="required"/></br>
            Price:</br><input type="text" name="price" id="price" required="required"/></br>
            <button type="submit" name="button" >Add</button>
        </form>
        </c:if>
        
        <c:if test="${from=='update'}">
            <h1><a href="home.htm">Update book information</a></h1>
        <form name="add" action="submitupdatebook.htm" method="post" onsubmit="return validator()">
            Book Name:</br><input type="text" name="name" id="name" required="required" value="${thisbook.getName()}"/></br>
            Author:</br><input type="text" name="author" id="author" required="required" value="${thisbook.getAuthor()}"/></br>
            Category:</br>
            <input type="radio" name="category" value="Computer" >Computer</br>
            
            <input type="radio" name="category" value="Fiction">Fiction</br>
            
            <input type="radio" name="category" value="Math">Math</br>
            
            <input type="radio" name="category" value="English">English</br>
            
            <input type="radio" name="category" value="Chinese">Chinese</br></br>
            
            Description for this book:</br><input type="text" name="description" id="description" value="${thisbook.getDescreption()}" required="required"/></br>
            Price:</br><input type="text" name="price" id="price" required="required" value="${thisbook.getPrice()}"/></br>
            <button type="submit" name="button">Update</button>
        </form>
        </c:if>
            
    </body>
</html>
