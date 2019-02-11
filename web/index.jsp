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
        <link href="https://fonts.googleapis.com/css?family=Frank+Ruhl+Libre|Open+Sans" rel="stylesheet">
        <title>Home Page</title>
        <link rel="stylesheet" href="design.css">
    </head>
    <body>
        <form action="PloginServlet" method="get">
      
        <main>
            <div class="box">
                <header> 
                    <h1 style=align-content:>
                        Cool Smiles Dental Clinic</h1>
                    <h2 style=align-content: >
                        Experience State of the art dental services.</h2>
            </header>
            <section class="mainbuttons">
                <a type="button" href="about.jsp" class="button">About</a>
                <a type="button" href="Plogin.jsp" class="button">Patient Login</a>
                <a type="button" href="Dlogin.jsp" class="button">Dentist Login</a>                
            </section>
            </div>
        </main>
        </form>
    </body>
</html>
