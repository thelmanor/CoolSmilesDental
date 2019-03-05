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
        <title>Dentist Login Page</title>
        <style>
            table{border: 1px solid black;}
        </style>
    </head>
    <body>
       <form action ="DloginServlet" method="get">
            <h1>Dentist Login</h1>
            <table>                
            <tr>
                <td>User ID:</td>
                <td><input type=" text" name="didtb"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="dpwtb"/></td>
            </tr>
            <tr>
                <td><input type="submit" name="logbtn" value ="Login" /></td>
                <td><input type="reset" name="resetbtn" value ="Clear" /></td>
            </tr>
            </table>  
        </form>
    </body>
</html>
