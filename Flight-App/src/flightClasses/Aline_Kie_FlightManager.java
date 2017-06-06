/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightClasses;
import java.util.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author kogiya
 */
public class Aline_Kie_FlightManager extends Aline_Kie_Flight {
    private final ArrayList<Aline_Kie_Flight> flightSchedule = new ArrayList<>();
    
    public Aline_Kie_FlightManager(){
        
    };
    
    public ArrayList<Aline_Kie_Flight> getFlightSchedule(){
        return flightSchedule;
    }
    
    public void AddFlight(String source, String airportSrc, String destination, String airportDest, String flightNum, int miles, double fare, Time flightTime){
        flightSchedule.add(new Aline_Kie_Flight(source, airportSrc, destination, airportDest, flightNum, miles, fare, flightTime));
    }
    
    public void getFlightInfo(){
        String src, dest, strDate;
        Date userInputDate = null; //initialize the variable date
        int flightScheduleLen = flightSchedule.size(); //size of flightSchedule array
        boolean invalidEntry; //for validation
        Aline_Kie_Flight curFlight; //current flight on the for loops
        ArrayList<Aline_Kie_Flight> foundFlights = new ArrayList<>();
                
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the city or Airport Code:\n(Calgary (YYC), Montreal (YUL), Ottawa (YOW), Toronto (YYZ) or Vancouver (YVR))");
        
        do {
            invalidEntry = true;
            System.out.print("From: ");
            src = input.next().toUpperCase();
            for(int i = 0; i < flightScheduleLen; i++) {
                curFlight = flightSchedule.get(i);
                if((src.equals(curFlight.getSource().toUpperCase()) || src.equals(curFlight.getAirportSource().toUpperCase())))
                {
                    invalidEntry = false;
                    break;
                }
            }
            if (invalidEntry)
                System.out.println("This is not a valid source. Choose a city or airport.");
        } while (invalidEntry);
        
        do {
            invalidEntry = true;
            System.out.print("To: ");
            dest = input.next().toUpperCase();
            for(int i = 0; i < flightScheduleLen; i++) {
                curFlight = flightSchedule.get(i);
                if(((dest.equals(curFlight.getDestination().toUpperCase()) || dest.equals(curFlight.getAirportDestination().toUpperCase()))) && (dest.equals(src) == false))
                {
                    invalidEntry = false;
                    break;
                    
                }   
            }
            if (invalidEntry)
                System.out.println("This is not a valid destination. Choose a city or airport."); 
        } while (invalidEntry);
        
        do {
            invalidEntry = false;
            System.out.print("Input flight date (DD/MM/YY): ");
            strDate = input.next();
           
            //convert the string strDate to Date type
            try {
                DateFormat format = new SimpleDateFormat("d/M/y", Locale.ENGLISH);
                format.setLenient(false);
                userInputDate = format.parse(strDate);
                if(userInputDate.before(new Date()))
                {
                   System.out.println("You cannot choose a date in the past.");
                   invalidEntry = true;
                }
                
                int noOfYears = 2; //i.e two weeks
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());            
                calendar.add(Calendar.YEAR, noOfYears); //add 2 years from today' date
                Date twoYearsFromNow = calendar.getTime();
                
                if(userInputDate.getTime() > twoYearsFromNow.getTime()) //comparison using epoch
                {
                    System.out.println("You cannot buy a ticket for more than 2 years from now.");
                    invalidEntry = true;
                }
            } catch (ParseException e) {
                System.out.println("This is not a valid date. Use the format DD/MM/YY");
                invalidEntry = true;
            }
        } while (invalidEntry);
        
        System.out.println("\n\n\t\t~~~~~~~ FLIGHTS ~~~~~~~");
        //Find the flights that match that search on the flightSchedule array
        for(int i = 0; i < flightScheduleLen; i++) {
            curFlight = flightSchedule.get(i);
            if((dest.equals(curFlight.getDestination().toUpperCase()) || dest.equals(curFlight.getAirportDestination().toUpperCase())) && (src.equals(curFlight.getSource().toUpperCase()) || src. equals(curFlight.getAirportSource().toUpperCase()))){
                //add to array that contains all the results of the search
                foundFlights.add(curFlight);
                System.out.println(curFlight.toString());
            }
        }
        
        do {
            invalidEntry = true;
            System.out.println("\n##############################");
            System.out.println("#  SEARCH AGAIN [Enter 1]    #");
            System.out.println("#  SELECT A FLIGHT [Enter 2] #");
            System.out.println("##############################");
        
            String choice = input.next();
         
            switch (choice) {
                case "1":
                    getFlightInfo();
                    invalidEntry = false;
                    break;
                case "2":
                    BuyTicket(userInputDate, foundFlights);
                    invalidEntry = false;
                    break;
                default:
                    invalidEntry = true;
                    break;
            }
        } while(invalidEntry);
        
        
    }
    
    public void BuyTicket(Date date, ArrayList<Aline_Kie_Flight> foundFlights){
        int foundFlightsLen = foundFlights.size();
        Scanner input = new Scanner(System.in);
        Aline_Kie_Flight curFlight;
        boolean invalidEntry;
        
            
        //look for the instance of Flight with the selected flight number
        do {
            invalidEntry = true;
            System.out.print("\nWhich flight do you want to select?\nEnter the flight number: ");
            String fliNum = input.next();
            for(int i = 0; i < foundFlightsLen; i++) {
                if (fliNum.equals(foundFlights.get(i).getFlightNumber())) {
                    //If the flight is found, create a new ticket
                    Aline_Kie_Ticket passengerTicket = new Aline_Kie_Ticket(foundFlights.get(i), date);
                    CreatePassenger(passengerTicket);
                    invalidEntry = false;
                    break;
                }
                else 
                    invalidEntry = true;
            }
            if (invalidEntry)
                System.out.print("This is not a valid flight number.");
        } while(invalidEntry);
    }

    public void CreatePassenger(Aline_Kie_Ticket ticket){
    //Create a new passenger/frequent flyer passing the ticket as a parameter
        boolean invalidEntry;
        Scanner input = new Scanner(System.in);
        
        do {
            invalidEntry = false;
            System.out.print("\nAre you part of our Frequent Flyer Program? (Y or N) ");
            String ff = input.next().toUpperCase();
            switch (ff) {
                case "Y":
                    {
                    do {
                        System.out.print("\nEnter your Frequent Flyer Number (7 digits): ");
                        String ffNumber;
                        while(!input.hasNextInt()) {
                            System.out.print("\nThis is not a valid Frequent Flyer number.\n"
                                    + "Enter your Frequent Flyer Number (7 digits): ");
                            input.next();
                        }
                        ffNumber = input.next();
                        if(ffNumber.length() == 7) {
                            Aline_Kie_FrequentFlyer passenger = new Aline_Kie_FrequentFlyer(ticket, ffNumber);
                            passenger.FinishPurchase();
                            invalidEntry = false;
                            break;
                        }
                        else{
                            invalidEntry = true;
                            System.out.println("This is not a valid Frequent Flyer number.");
                        }
                    }
                    while(invalidEntry);
                    break;
                    }
                case "N":
                    {
                        Aline_Kie_Passenger passenger = new Aline_Kie_Passenger(ticket);
                        passenger.FinishPurchase();
                        break;
                    }
                default:
                    {
                        System.out.print("This is not a valid entry.");
                        invalidEntry = true;
                        break;
                    }
                    
            }
        } while(invalidEntry);
        
        System.out.println();
        
        do {
            System.out.print("\nWould you like to buy another ticket? (Y or N) ");
            String anotherTicket = input.next().toUpperCase();
        
            invalidEntry = false;
            if(anotherTicket.equals("Y"))
                getFlightInfo();
            else if(anotherTicket.equals("N"))
                System.out.println("Thanks for flying with Air Banana!");
            else
            {
                System.out.println("This is not a valid entry. Try again.");
                invalidEntry = true;
            }
        } while(invalidEntry);
        
            
    }
}