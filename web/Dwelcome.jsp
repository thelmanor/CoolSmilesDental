<%@page import="java.util.ArrayList"%>
<%@page import="Business.Patient"%>
<%@page import="Business.AppointmentList"%>
<%@page import="Business.Appointment"%>
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
        <title>Welcome Page</title>
       <% 
            HttpSession sess=request.getSession();            
            Dentist d1=(Dentist)sess.getAttribute("d1");          
            d1.display();
            
            Appointment a1=(Appointment)sess.getAttribute("a1");
            
        %>
    </head>
    <body>
        <form action="DWelcomeServlet" method="post">
        <h1>Welcome back 
                <%= 
                d1.getFirstName()
                 %> 
        </h1>
        <h2> You have (x) upcoming appointment.</h2>
        <table border="3">
                        
             <%
                Appointment a2=null;
                for(int x=0; x< d1.alist.count ; x++){               
                a2=d1.alist.aArray[x];
                System.out.println("===================================");
                            
                %>
            <tr>
                <th>Appointment Information</th>
                <th>Patient</th>
                <th>Procedure</th>
                <th>Cost</th>
            </tr>
             <tr>
                <td><%=a2.getapptDateTime()%></td>
                <td><%=a2.getPatId()%></td>
                <td><%=a2.getProcCode() %></td>
                <td>Cost $0.00</td>
            </tr>
            <%  }   %>   
            
        </table>    
                
                <%--
            <a href= ProfilePage.jsp  >
                   <%=
                       p1.getFirstName()
                    %>'s Profile
               </a>
                --%>
                
                 <input type="submit" name="logbtn" value ="Profile" />  
        
        </form>
    </body>
</html>
