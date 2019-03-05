/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tnora
 */
public class Dentist {
   
    private String Id;
    private String Password;
    private String FirstName;
    private String LastName;	
    private String Email;
    private String Office;
    public AppointmentList alist=new AppointmentList();
  
    
    public Dentist(){
        setId("");
        setPassword("");
        setFirstName("");
        setLastName("");
        setEmail("");
        setOffice("");
      
    }
    public Dentist(String id, String pw, String fn, String ln, String e, String o){
        setId(id);
        setPassword(pw);
        setFirstName(fn);
        setLastName(ln);
        setEmail(e);       
        setOffice(o);
    }
    public void setId(String pi) {Id=pi;}
    public String getId(){return Id;}
    
    public void setPassword(String pw) {Password=pw;}
    public String getPassword(){return Password;}

    public void setFirstName(String fn) {FirstName=fn;}
    public String getFirstName(){return FirstName;}

    public void setLastName(String ln) {LastName=ln;}
    public String getLastName(){return LastName;}      

    public void setEmail(String e) {Email=e;}
    public String getEmail(){return Email;}
    
    public void setOffice(String o) {Office=o;}
    public String getOffice(){return Office;}
    
      /***********************This method is used to select the dentist data ***********/
         //select dentist  data  method
    
    public void selectDB( String Id){
        setId(Id);
        try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();
            String sql="select * from Dentists where Id='"+ Id+"'";
            System.out.println(sql);
            ResultSet r=s.executeQuery(sql);
            r.next();
                setPassword(r.getString(2));
                setFirstName(r.getString(3));
                setLastName(r.getString(4));
                setEmail(r.getString(5));                
                setOffice(r.getString(6));
                          
            c.close();
        }
        catch(SQLException e){
        System.out.println(e);
        }   
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
        getAppointments();
        //getdentAppointments();
    }
           /***********************This method is used to get dentist appointments the dentist data ***********/
         //get dentist appointments data  method
    public void getAppointments()
    {
        try{System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();            
            String sql1="select PatId from Appointments where dentId='"+getId()+"'";
             System.out.println(sql1);
            ResultSet rs=s.executeQuery(sql1);
        String Pid;
        Appointment a2;
            while (rs.next())  {
                Pid=rs.getString(1);
                a2=new Appointment();        
                a2.selectDB(Pid);
                alist.addAppointment(a2);

            }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
       /***********************This method is used to update  the dentist data ***********/
         //update  data  method
     public void updateDB(){
    try{				
        System.out.println("Loading driver ");	
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
        Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/DentistOfficeMDB.mdb");            
        Statement s=c.createStatement();
        String sql;
        sql = "update Dentists set firstName='"+FirstName+"', lastName='"+LastName+"', passwd='"+Password+"',  email='"+Email+"',office='"+Office+"' where Id='"+Id+"'";
        System.out.println(sql);
        int n=s.executeUpdate(sql);
            if (n>=1){
            System.out.println(n + " "+" record(s) has been updated in the database successfully");
            }
            else{
            System.out.println("An error occured while attempting to update database");
            }         
        c.close();
    }
    catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
    }
}
     /***********************This method is used to display the dentist data ***********/
         //display data  method
        public void display(){
            System.out.println(" Dentist ID =" + getId());
            System.out.println("Password=" + getPassword());
            System.out.println("First Name  =" + getFirstName());
            System.out.println("Last Name=" + getLastName());
            System.out.println("Email  =" + getEmail());
            System.out.println("Office=" + getOffice());
            alist.display();
            }
//        public static void main(String arg[]){
//        Dentist d1= new Dentist();
//        d1.selectDB("D203");
//        d1.display();
//        }

}
