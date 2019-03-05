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
            Patient p1=(Patient)sess.getAttribute("p1");          
            p1.display();
            
         //Appointment a1=(Appointment)sess.getAttribute("a1");
        //a1.display();
        %>
    </head>
    <body>
       
        
            
        <h1>Welcome back 
                <%=p1.getFirstName()
                 %> 
        </h1>
        <h2> You have an upcoming appointment.</h2>        
        
     
        
          
             <% 
                Appointment a2=null;
                 for(int x=0; x< p1.alist.count ; x++){
                     if(p1.alist.count>0)
                     {
                     a2=p1.alist.aArray[0];
                 
                System.out.println("===================================");
                a2.display();
            %>
            
             
          
            <tr>
                <th>Appointment Information</th>
                <th>Dentist</th>
                <th>Procedure</th>
                
            </tr>
       
             <tr border="3">
                <td><%=a2.getapptDateTime()%></td>
                <td><%=a2.getDentId()%></td>
                <td><%=a2.getProcCode() %></td>
                
                
            
            </tr>
              <%  }   %>  
               <% else{
               System.out.println("=====NO APPT==============================");
                }   %> 
         
                
                 
        <input type="submit" name="logbtn" value ="Edit Appointment" />  
        
        
                
        <form action="PWelcomeServlet" method="post">
             
          
            <a href= ProfilePage.jsp  >
                   <%=
                       p1.getFirstName()
                    %>'s Profile
               </a>
           
                     
        </form>        
    </body>
</html>
