/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightClasses;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 *
 * @author Owner
 */
public class Aline_Kie_Passenger {
    //attributes
    private String firstName;
    private String lastName;
    private int age;
    private Aline_Kie_Ticket ticket;
    
    //constructors
    public Aline_Kie_Passenger(){
    
    }
    public Aline_Kie_Passenger(Aline_Kie_Ticket selectedFlight){
        ticket = selectedFlight;
    }
    public Aline_Kie_Passenger(String fName, String lName, int age){
        firstName = fName;
        lastName = lName;
        this.age = age;
    }
    
    //set & get
    public void setFirstName(String fName){
        firstName = fName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lName){
        lastName = lName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setTicket(Aline_Kie_Ticket flight) {
        this.ticket = flight;
    }
    public Aline_Kie_Ticket getTicket() {
        return this.ticket;
    }
    //methods
    public void FinishPurchase(){
        Scanner input = new Scanner(System.in);
        boolean invalidEntry;
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        //Get first name
        do {
            invalidEntry = false;
            System.out.print("First Name: ");
            input.useDelimiter("\n");
            String fName = input.next();
            Matcher m = p.matcher(fName);
            if(!fName.equals("") && m.find())
                setFirstName(fName);    
            else {
                invalidEntry = true;
                System.out.println("This is not a valid first name.");
            }
        } while(invalidEntry);
        
        //Get last name
        do {
            invalidEntry = false;
            System.out.print("Last Name: ");
            String lName = input.next();

            Matcher m = p.matcher(lName);
            if(!lName.equals("") && m.find())
                setLastName(lName);
            else { 
                invalidEntry = true;
                System.out.println("This is not a valid last name.");
            }
        } while(invalidEntry);
        
        
        //Get age
        do {
            invalidEntry = false;
            int inputAge;
            System.out.print("Age: ");
                while(!input.hasNextInt()){
                    System.out.print("This is not a valid age.\nAge: ");
                    input.next();
                }
                inputAge = input.nextInt();
                if(inputAge < 0 || inputAge > 120){
                    invalidEntry = true;
                    System.out.println("Age must be greater than or equal to 0 and less than or equal to 120.");
                }
                else
                    setAge(inputAge);
        } while(invalidEntry);
        //show Ticket
        System.out.print(toString());    
    }
    
    //override toString() method
    @Override
    public String toString(){
        return String.format("============================\n\nPassenger Name: " +
                firstName + " " + lastName +
                "\nAge: \t\t" + age + "\n" + ticket.toString() + 
                "\n============================");
    }
}
