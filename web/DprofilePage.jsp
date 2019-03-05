<%@page import="Business.Dentist"%>
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
        <title> Profile Page</title>
         <% 
            HttpSession sess=request.getSession();           
            Dentist d1=(Dentist)sess.getAttribute("d1");  
            System.out.println("In DupdateProfileJSP==================================");
            d1.display();
        %>
        <style>
        body {
            font-family: Arial, Helvetica, sans-serif;

        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;           
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .savebtn {
            background-color: #4CAF50;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .savebtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
        </style>
    </head>
    <body>
        <form action="DUpdateServlet" method="post">
            <h1>My Profile</h1>

            <div class="container">
                <%=
                    d1.getFirstName()%>
                <hr>
                
                <label ><b>First Name</b></label>
                <input type="text" name="first" value="<%=d1.getFirstName()%>">

                <label ><b>Last Name</b></label>
                <input type="text" name="last" value="<%=d1.getLastName()%>">

                <label ><b>Email</b></label>
                <input type="text" name="email" value="<%=d1.getEmail()%>">

                <label><b>Password</b></label>
                <input type="text" name="pw" value="<%=d1.getPassword()%>">
                    
               <label><b>Office</b></label>
                <input type="text" name="office" value="<%=d1.getOffice()%>">

                <hr>            
                <button type="submit" class="savebtn">Save</button>

            </div>
        </form>
    </body>
</html>
