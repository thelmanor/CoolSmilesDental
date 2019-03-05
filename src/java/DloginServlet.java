 /**   This is a java program that allows patients and dentists to view appointments, as well as update their individual profile
    Patient is able to update existing appointments.
    Date : 12/03/2018
    Author: Thelma Nora
    * **/


import Business.Dentist;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tnora
 */
@WebServlet(urlPatterns = {"/DloginServlet"})
public class DloginServlet extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("Starting DloginServlet");
        PrintWriter out = response.getWriter();       
              
        try{
        //Step 1- Getting the Patid parameter from the HTML
            String Id=request.getParameter("didtb");
            System.out.println("Dentist id retireved =" +Id);
            String pw=request.getParameter("dpwtb");
            

        //I skipped Step 2 and got to step 3- Create the object needed to lookup customer

            Dentist d1=new Dentist();
            d1.selectDB(Id);
            System.out.println("First Name= "+d1.getFirstName());        
            String dpwtb=d1.getPassword();
            //String FirstName=p1.getFirstName();
            
        //Step 5-Put the Patient Object in a HTTP session
            HttpSession sess=request.getSession();
            sess.setAttribute("d1",d1);
            System.out.println("Dentist added to session");     

        //Step 4- Make a decision
            if (pw.equals(dpwtb)){
                System.out.println("login correct");
                //Step 6-Use Request Dispatcher to forward to accountlookup.jsp
                RequestDispatcher d= request.getRequestDispatcher("/Dwelcome.jsp");
                d.forward(request, response);
            }
            else  {
            System.out.println("login error");  
            RequestDispatcher d= request.getRequestDispatcher("/Derrorpage.jsp");
                d.forward(request, response);
            }

        }
        catch(IOException | ServletException e){
        System.out.println(e);
        }
        finally{
             System.out.println("DloginServlet ends...");
        out.close();}
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
