/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author tnora
 */
public class AppointmentList {
    public int count=0;
    public Appointment aArray[]=new Appointment[10];
    
      /***********************add appointment method a ***********/
        
    public void addAppointment(Appointment a){
        aArray[count]=a;
        count++;
    }
    
     /***********************remove appointment method a ***********/
    public void removeAppointment(Appointment r){
        aArray[count-1]=r;
        count++;
    }
    
     /***********************display appointment method a ***********/
    public void display(){
        for (int i=0;i<count; i++){
        aArray[i].display();
        }
    }
    
    public static void main(String []arg) {
        AppointmentList alist=new AppointmentList();
        alist.addAppointment(new Appointment ("May 1, 2018, 12pm", "A911", "D203", "P650"));                
        alist.display();            
    }   
    
}
