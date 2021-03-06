 /**   This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
    * **/

import Business.Appointment;
import Business.AppointmentList;
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

/**
 *
 * @author tnora
 */
@WebServlet(urlPatterns = {"/PapptUpdateServlet"})
public class PapptUpdateServlet extends HttpServlet {

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
       System.out.println("Starting PapptUpdateServlet");
           PrintWriter out = response.getWriter();
        String PatId;
        
        try{
        PatId=request.getParameter("idtb");
        String apt= request.getParameter("appointment");
        String dent= request.getParameter("dentist");
        String pro= request.getParameter("procedure");
        
        HttpSession sess=request.getSession(); 
        AppointmentList alist=(AppointmentList)sess.getAttribute("a1");
        Patient p1=(Patient)sess.getAttribute("p1");  
        System.out.println("In Patient WelcomeServlet=========================================");      
        p1.selectDB(PatId);
        p1.display();
        
        
      
        //System.out.println("patient added to session Welcome.jsp");
        
        RequestDispatcher dispatcher= request.getRequestDispatcher("/UpdateAppt.jsp");
        dispatcher.forward(request, response);        
        
        }
        catch(  IOException | ServletException e)
        {
        System.out.println(e);
        }
        
        finally{
        System.out.println("PWelcomeServlet ends...");
        out.close();
    }
            
        
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
