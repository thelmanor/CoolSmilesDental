 /**   This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
    * **/


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
 * @author thelma
 */
@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
       System.out.println("Starting ProfileServlet");
        PrintWriter out = response.getWriter();       
        String PatId;        
   
        //Step 1- Getting the Patid parameter from the HTML
            PatId=request.getParameter("idtb");
            System.out.println("Patient id retireved =" +PatId);
            //String pw=request.getParameter("pwtb");
            //String pw=request.getParameter("pwtb");

        //I skipped Step 2 and got to step 3- Create the object needed to lookup customer

         
            
        //Step 5-Put the Patient Object in a HTTP session
            HttpSession sess=request.getSession();           
            Patient p1=(Patient)sess.getAttribute("p1");  
            System.out.println("In ProfilePageServlet=========================================");
            p1.selectDB(PatId);
            p1.display();
         

        //Step 4- Make a decision
           
                RequestDispatcher d= request.getRequestDispatcher("/ProfilePage.jsp");
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
