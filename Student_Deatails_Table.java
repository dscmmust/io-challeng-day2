package mmust2;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


/**
 *
 * @author Martin
 */
public class Student_Deatails_Table {

    
    //Declare the global variables
    static PrintWriter pr ;
    static String id,fname,lname,addressname,addressnumber,dobb;
    
    public static void main(String[] args) throws IOException {
        
        
        //Scanner to receive Inputs from keyboard
        Scanner scan = new Scanner(System.in);
        boolean save = true;
        
        //Create an object of Student_Deatails_Table.
        Student_Deatails_Table m2 = new Student_Deatails_Table();
        
        //Declare file
        File file = new File("Outputfile.txt");
        
        //If File does not exist, create one and create the Headings
        if(!file.exists()){
        FileWriter fr = new FileWriter(file);
        pr = new PrintWriter(fr);
        String[] titleRow = {"Student ID#","First Name","LastName","DOB","Address"};
        pr.print("Student ID#");
        m2.gap(15, titleRow[0].length());
        pr.print("First Name");
        m2.gap(15, titleRow[1].length());
        pr.print("LastName");
        m2.gap(15, titleRow[2].length());
        pr.print("DOB");
        m2.gap(15, titleRow[2].length());
        pr.print("Address");
        m2.gap(15, titleRow[2].length());
        pr.println();
        pr.close();
        }
        
        
        //Using Do Method to repeat this code untill the user is exhausted.
        do{
        System.out.println("Add students details.\n");
        
        //This boolean changes depending with whether the id from user is an integer or not
        boolean idIsvalid = true;
        do{
        System.out.println("Student ID Number");
        id  = scan.nextLine();
        try{
            Integer.parseInt(id);
            idIsvalid = true;
        }catch(Exception e){
            idIsvalid = false;
            System.out.println("ID should be an integer. Try again");
        }
        }while(!idIsvalid);
        
        System.out.println("First Name");
        fname  = scan.nextLine();
        System.out.println("Last Name");
        lname  = scan.nextLine();
        
        
        //Date from user is tested using the method isValidDate(date)
         boolean dateisokay = false;
         do{
        System.out.println("Date of Birth in the order YYYYMMDD without spacing");
        dobb  = scan.nextLine().trim();
        dateisokay = isValidDate(dobb);
        if(!dateisokay){
            System.out.println("Date entered is invalid. Try again");
        }
         }while(!dateisokay);
        
       
         //Make sure address number is integer
         boolean addressnumberIsvalid = true;
        do{
        System.out.println("Address Number");
        addressnumber  = scan.nextLine();
        try{
            Integer.parseInt(addressnumber);
            addressnumberIsvalid = true;
        }catch(Exception e){
            addressnumberIsvalid = false;
            System.out.println("ID shoukd be an integer. Try again");
        }
        }while(!addressnumberIsvalid);
        
        
        System.out.println("Address Name");
        addressname  = scan.nextLine();
        System.out.println("Saving to file");
        
        
        
        
        //SAVING TO FILE
        //The gap method is used to add spaces to create a tabular arrangement of data
        FileWriter fr = new FileWriter(file,true);
        pr = new PrintWriter(fr);
        pr.print(id);
        m2.gap(15, id.length());
        pr.print(fname);
        m2.gap(15, fname.length());
        pr.print(lname);
        m2.gap(15, lname.length());
        pr.print(dobb);
        m2.gap(15, String.valueOf(dobb).length());
        pr.print(addressnumber + " "+addressname);
        m2.gap(15, (addressnumber + " "+addressname).length());
        pr.println();
        pr.close();
        
        System.out.println("Student details added");
        System.out.println("Press 1 to register another student or any other key to exit");
        int option = scan.nextInt();
        scan.nextLine();
        
        switch(option){
            case 1:
                save = true;
                break;
            default:
                save = false;
                break;
        }
        
        }while(save);
        
      
    }
    
    public void gap(int a, int b){
        for(int i=b; i<=a; i++){
            pr.print(" ");
        }
    }
    
    public static boolean isValidDate(String inDate) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    dateFormat.setLenient(false);
    try {
      dateFormat.parse(inDate.trim());
    } catch (ParseException pe) {
      return false;
    }
    return true;
  }
}
