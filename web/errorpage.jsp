<%@page import="Business.Patient"%>

<%--
    This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Error Page</title>       
        <style>
            table{border: 1px solid black;}
        </style>
    </head>
    <body>
       <form action ="PloginServlet" method="get">
            <h1>Patient Login</h1>  
             <h2>Sorry Sign in was unsuccessful due to incorrect credentials</h2>
             <h3 id="login"><a href="Plogin.jsp"> Try Again</a></h3>
        </form>
    </body>
</html>
