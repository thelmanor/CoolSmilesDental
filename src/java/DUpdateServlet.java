 /**   This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
    * **/

import Business.Dentist;
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
@WebServlet(urlPatterns = {"/DUpdateServlet"})
public class DUpdateServlet extends HttpServlet {

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
       System.out.println("Starting DUpdateServlet");
        PrintWriter out = response.getWriter();       
        String Id;        
   
        //Step 1- Getting the Patid parameter from the HTML
             
            String fn=request.getParameter("first");
            String ln=request.getParameter("last");            
            String e=request.getParameter("email");
            String p=request.getParameter("pw");
            String o=request.getParameter("office");
            
             
            //String pw=request.getParameter("pwtb");

        //I skipped Step 2 and got to step 3- Create the object needed to lookup customer

            HttpSession sess=request.getSession();           
            Dentist d1=(Dentist)sess.getAttribute("d1");  
            System.out.println("In DUpdateServlet==================================");
            d1.display();
            
            System.out.println("Dentist Data from Session==================================");
            d1.setFirstName(fn);
            d1.setLastName(ln);
            d1.setEmail(e);
            d1.setPassword(p);
            d1.setOffice(o);
            d1.updateDB();
            d1.display();
            System.out.println("Dentist data after changes from html form==================================");       
            
            
        //Step 5-Put the DentistObject in a HTTP session
            sess=request.getSession();
            sess.setAttribute("d1",d1);
            System.out.println("Dentist added to session");     

        //Step 4- Make a decision
           
                RequestDispatcher d= request.getRequestDispatcher("/DupdateProfile.jsp");
                d.forward(request, response);
            
            System.out.println("Update page complete");  
           
           
             
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
