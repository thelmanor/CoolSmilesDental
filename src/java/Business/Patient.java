
package Business;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**************************************************************************
 * This class contains the database for accessing Patient table
 * 
 * 
 **************************************************************************/
public class Patient {
    private String PatId;
    private String Password;
    private String FirstName;
    private String LastName;
    private String Address;	
    private String Email;
    private String Insurance;
    public AppointmentList alist=new AppointmentList();
 
    
    public Patient(){
        setPatId("");
        setPassword("");
        setFirstName("");
        setLastName("");
        setAddress("");
        setEmail("");
        setInsurance("");
    }
    public Patient(String pi, String pw, String fn, String ln, String a, String e, String i){
        setPatId(pi);
        setPassword(pw);
        setFirstName(fn);
        setLastName(ln);
        setAddress(a);
        setEmail(e);
        setInsurance(i);
    }
    public void setPatId(String pi) {PatId=pi;}
    public String getPatId(){return PatId;}
    
    public void setPassword(String pw) {Password=pw;}
    public String getPassword(){return Password;}

    public void setFirstName(String fn) {FirstName=fn;}
    public String getFirstName(){return FirstName;}

    public void setLastName(String ln) {LastName=ln;}
    public String getLastName(){return LastName;}   

    public void setAddress(String a) {Address=a;}
    public String getAddress(){return Address;}

    public void setEmail(String e) {Email=e;}
    public String getEmail(){return Email;}
    
    public void setInsurance(String i) {Insurance=i;}
    public String getInsurance(){return Insurance;}
       /***********************This method is used to select the patient data ***********/
         //select dentist  data  method
    
    public void selectDB( String PatId){
        setPatId(PatId);
        try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();
            String sql="select * from Patients where PatId='"+ PatId+"'";
            System.out.println(sql);
            ResultSet r=s.executeQuery(sql);
            r.next();
                setPassword(r.getString(2));
                setFirstName(r.getString(3));
                setLastName(r.getString(4));
                setAddress(r.getString(5));                
                setEmail(r.getString(6));
                setInsurance(r.getString(7));                
            c.close();
        }
        catch(SQLException e){
        System.out.println(e);
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
        getAppointments();
} /***********************This method is used to get patient appointments the dentist data ***********/
         //get patient appointments data  method
    public void getAppointments(){
     try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();
            String sql="select * from Appointments where PatId='"+ PatId+"'";
            System.out.println(sql);
            ResultSet r=s.executeQuery(sql);
            String an;
            Appointment a2;
              
            
            while(r.next()){
                an=r.getString(2);
            //String p=r.getString(2);
            a2=new Appointment();        
            a2.selectDB(an);
            alist.addAppointment(a2);  
            }
                            
            c.close();
        }
        catch(SQLException e){
        System.out.println(e);
        }   catch (ClassNotFoundException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
      /***********************This method is used to update  the patient data ***********/
         //update  data  method
    public void updateDB(){
    try{				
        System.out.println("Loading driver ");	
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
        Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/DentistOfficeMDB.mdb");            
        Statement s=c.createStatement();
        String sql;
        sql = "update Patients set firstName='"+FirstName+"', lastName='"+LastName+"',addr='"+Address+"',email='"+Email+"',passwd='"+Password+"', insCo='"+Insurance+"' where PatId='"+PatId+"'";
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
    catch(Exception e){
        System.out.println(e);
    }
}
      /***********************This method is used to insert  the dentist data ***********/
         //insert  data  method
    
    public void insertDB( String PatId,String Password, String FirstName, String LastName, String Address, String Email,  String Insurance){
        try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelm/Desktop/Java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();
            String sql="insert  into Patients values ('"+PatId+"','"+Password+"','"+FirstName+"','"+LastName+"','"+Address+"','"+Email+"','"+Insurance+"',)";
            System.out.println(sql);
            int n=s.executeUpdate(sql);
                if (n>=1){
                 System.out.println(n + " "+"new record(s) have been added to the database successfully");
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
    
//public void deleteDB(){
//    setPatId(PatId);
//    try{				
//        System.out.println("Loading driver ");	
//        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
//        Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/tnora/Desktop/java/DentistOfficeMDB.mdb");            
//        Statement s=c.createStatement();
//        String sql="delete * from Appointments where PatId=" + PatId;
//        System.out.println(sql);
//        int n=s.executeUpdate(sql);
//            if (n>=1){
//            System.out.println(n + " "+" record(s) has been deleted from the database successfully");
//            }
//            else{
//            System.out.println("An error occured while attempting to update database");
//            }         
//        c.close();
//    }
//    catch(ClassNotFoundException | SQLException e){
//        System.out.println(e);
//    }
//}     
    
      /***********************This method is used to display  the dentist data ***********/
         //display   data  method
 public void display(){
            System.out.println(" Patient ID =" + getPatId());
            System.out.println("Password=" + getPassword());
            System.out.println("First Name  =" + getFirstName());
            System.out.println("Last Name=" + getLastName());
            System.out.println("Address=" + getAddress());
            System.out.println("Email  =" + getEmail());
            System.out.println("Insurance =" + getInsurance());
            alist.display();
            }
        public static void main(String arg[]){
        Patient p1= new Patient();
        p1.selectDB("A901");
//        p1.setFirstName("Thelma");
//        p1.setLastName("Nora");
       // p1.setAddress("XXXXXXXXXXXXXXXXXXXXXXXXXXX");
        //p1.updateDB();
        p1.display();
        }
}

   

    
     

