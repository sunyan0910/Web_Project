<%-- 
    Document   : Registerpage
    Created on : Apr 12, 2019, 4:59:45 PM
    Author     : sunyan
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
                function validator()
                {
                    var x=document.forms["add"]["email"].value;
                    var regex=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
                    if(!x.match(regex))
                    {
//                        console.log("klllllll");
                        alert("Must input valid e-mail address");
                        return false;
                    }
                }
        </script>
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}
            input{width: 100%;
                   padding: 12px 20px;
                   margin: 8px 0;
                   display: inline-block;
                   border: 1px solid #ccc;
                   box-sizing: border-box;}
            h1{text-aligen:center}
            button {background-color: #4CAF50;
                    color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;}
            button:hover {opacity: 0.8;}
        </style>
        <title>Register Now</title>
    </head>
    <body>
        <h1>Register Now!</h1>
        <form name="add" action="adduser.htm" method="post" onsubmit="return validator()">
            First Name:<input type="text" name="fName" required="required"/></br>
            Last Name:<input type="text" name="lName" required="required"/></br>
            E-mail:<input type="text" name="email" id="email" required="required"/></br>
            Password:<input type="password" name="pwd" id="password" required="required"/></br>
<!--            Upload image:<input type="file" name="photo"/></br>-->
            <button type="submit" name="button" value="Submit">Submit</button>
        </form>
    </body>
</html>
