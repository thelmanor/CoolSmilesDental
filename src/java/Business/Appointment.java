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
public class Appointment {
    private String apptDateTime;
    private String PatId;
    private String DentId;
    private String ProcCode;
    
    
    public Appointment(){
        setapptDateTime("");
        setPatId("");
        setDentId("");
        setProcCode("");
      
    }
    public Appointment(String adt, String pi, String di, String p){
        setapptDateTime(adt);
        setPatId(pi);
        setDentId(di);
        setProcCode(p);
    }
    public void setapptDateTime(String adt) {apptDateTime=adt;}
    public String getapptDateTime(){return apptDateTime;}
    
    public void setPatId(String pi) {PatId=pi;}
    public String getPatId(){return PatId;}

    public void setDentId(String di) {DentId=di;}
    public String getDentId(){return DentId;}

    public void setProcCode(String p) {ProcCode=p;}
    public String getProcCode(){return ProcCode;}      

      /***********************This method is used to select   the appointment  data ***********/
         //update  data  method
    public void selectDB(String Pid){
        setPatId(Pid);
        try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/DentistOfficeMDB.mdb");            
            Statement s=c.createStatement();
            String sql="select * from Appointments where PatId='"+ PatId+"'";
            System.out.println(sql);
            ResultSet r=s.executeQuery(sql);
            r.next();
                setapptDateTime(r.getString(1));
                setDentId(r.getString(3));
                setProcCode(r.getString(4));                
                          
            c.close();
        }
        catch(SQLException e){
        System.out.println(e);
        }   
        catch (ClassNotFoundException ex) {
                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
            }
        //getAccounts();
    }
      /***********************This method is used to update  the appointment data ***********/
         //update  data  method
    
     public void updateDB(){
    try{				
        System.out.println("Loading driver ");	
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
        Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/DentistOfficeMDB.mdb");            
        Statement s=c.createStatement();
        String sql;
        sql = "update Appointments set apptDateTime='"+apptDateTime+"' where PatId='"+PatId+"'";
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
         //insert data  method
     public void insertDB( String apptDateTime, String PatId, String DentId, String ProCode){
        try{				
            System.out.println("Loading driver ");	
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");				
            Connection c= DriverManager.getConnection("jdbc:ucanaccess://C:/Users/thelma/Desktop/Java1/ChattBankMDB.mdb");            
            Statement s=c.createStatement();
            String sql="insert into Appointments values ('"+apptDateTime+"','"+PatId+"','"+DentId+"',"+ProCode+")";
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
     
       /***********************This method is used to display  the dentist data ***********/
         //display  data  method
    
    public void display(){
            System.out.println(" Appointment Date Time=" + getapptDateTime());
            System.out.println("Patient Id=" + getPatId());
            System.out.println("Dentist Id  =" + getDentId());
            System.out.println("Procedure Code =" + getProcCode());
            }

    /**
     *
     * @param arg
     */
//    public static void main(String arg[]){
//    Appointment apt1=new Appointment();
//    apt1.selectDB("A903");
//    apt1.display();
//    }

   
    
}
