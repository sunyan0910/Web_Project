<%-- 
    Document   : Homepage
    Created on : Apr 12, 2019, 3:53:14 PM
    Author     : sunyan
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <style>
            .grid-container {
            display: grid;
            grid-template-columns: auto auto auto auto;
            padding-top: 30px;
/*            text-align: center;*/
            }
            .book {
            background-color: rgba(255, 255, 255, 1);
            padding: 20px;
            /*font-size: 30px;*/
            /*text-align: center;*/
            }
            .hello
            {
               grid-column-start: 1;
               grid-column-end: 2;
               background-color: rgba(255, 255, 255, 1);
               padding: 20px;
               font-size: 30px;
/*               text-align: center;*/
            }
            .add{grid-column-start: 2;
               grid-column-end: 3;
               background-color: rgba(255, 255, 255, 1);
               padding: 20px;
               font-size: 30px;
/*               text-align: center;*/
            }
            .cart{
               grid-column-start: 3;
               grid-column-end: 4;
               background-color: rgba(255, 255, 255, 1);
               padding: 20px;
               font-size: 30px;
/*               text-align: center;*/
            }
            .logout{
               grid-column-start: 4;
               grid-column-end: 5;
               background-color: rgba(255, 255, 255, 1);
               padding: 20px;
               font-size: 30px;
/*               text-align: center;*/
            }
            a{
                color:#000;
                text-decoration: none;
                margin-top: 10px;
            }
            a:hover{
                font-style: italic;
                color:#DA0000;
            }
            
</style>
    </head>
    <body>
        <h1>Second-hand books</h1></br>${added}</br>
        <div class="grid-container">
        <div class="hello">
            <a href="userpage.htm">Hello,${loginuser.getfName()}!</a>
        </div>
        <div class="add">
            <a href="addbook.htm">Add a book</a>
        </div>
        <div class="cart">
            <a href="tocart.htm">My cart</a>              
        </div>
        <div class="logout">
            <a href="welcome.htm">Log out</a>              
        </div>
        
            <%--<c:set scope="request" value="6" var="i"/>--%>
        <c:forEach items="${bookList}" var="book">
            <c:if test="${loginuser.getUserID()!=book.getOwner().getUserID()}" >
                <c:if test="${book.getStatus()=='Available'}">
                    <div class="book">
                        <ul>
                            <li>Book Name:  ${book.getName()}</li>
                            <li>Author:     ${book.getAuthor()}</li>
                            <li>Description:${book.getDescreption()}</li>
                            <li>Category:   ${book.getCategory()}</li>
                            <li>Upload Date:${book.getDate()}</li>
                            <li>Price:      $${book.getPrice()}</li>
                            <form action="addcart.htm" method="post">
                                <input type="hidden"name="bookid" value="${book.getBookId()}"/>
                                <input type="hidden"name="bookname" value="${book.getName()}"/>
                                <input type="submit" name="button" value="Add to cart"/>
                            </form>
                        </ul>
                    </div>
                </c:if>
            </c:if>
        </c:forEach>
        </div>

    </body>
</html>
