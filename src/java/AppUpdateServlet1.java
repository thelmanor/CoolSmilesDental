/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Appointment;
import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


 /**   This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
    * **/

@WebServlet(urlPatterns = {"/AppUpdateServlet1"})
public class AppUpdateServlet1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       System.out.println("Starting AppUpdateServlet1");
        PrintWriter out = response.getWriter();       
           
   
        //Step 1- Getting the Patid parameter from the HTML
             
            String apt=request.getParameter("appointment");
           
             Appointment a1=new Appointment();
             
            //String pw=request.getParameter("pwtb");

        //I skipped Step 2 and got to step 3- Create the object needed to lookup customer

            HttpSession sess=request.getSession();           
            Patient p1=(Patient)sess.getAttribute("p1"); 
            
            
            
            System.out.println("In apptUpdateServlet==================================");
            p1.display();
            
            System.out.println("Patient appointment Data from Session==================================");
           
           
//            a1.setapptDateTime(apt); 
//            a1.setDentId();
//            a1.setProcCode();
            a1.updateDB();
            a1.display();
            System.out.println("Patient appointmentdata after changes from html form==================================");       
            
            
        //Step 5-Put the Patient Object in a HTTP session
            sess=request.getSession();
            sess.setAttribute("a1",a1);
            System.out.println("Patient appointment added to session");     

        //Step 4- Make a decision
           
                RequestDispatcher d= request.getRequestDispatcher("/UpdateAppt.jsp");
                d.forward(request, response);
            System.out.println("Appointment update  complete");  
           
           
             
}   


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
