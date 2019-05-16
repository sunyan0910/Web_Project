<%-- 
    Document   : Errorpage
    Created on : Apr 12, 2019, 5:10:18 PM
    Author     : sunyan
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
        <h1>This is an error page!</h1></br>
        ${error}</br>
        <a href="welcome.htm">Go Back to Home Page</a>
    </body>
</html>
