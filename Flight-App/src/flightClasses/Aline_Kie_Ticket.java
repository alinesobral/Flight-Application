/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightClasses;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author aline
 */
public class Aline_Kie_Ticket extends Aline_Kie_Flight {
    private Aline_Kie_Flight selectedFlight;
    private Date flightDate;
    private double totalFare;
    
    //constructors
    public Aline_Kie_Ticket(){}
    
    public Aline_Kie_Ticket(Aline_Kie_Flight selFlight, Date date) {
        selectedFlight = selFlight;
        flightDate = date;
    }
    
    //properties
    public void setSelectedFlight(Aline_Kie_Flight fli){
        selectedFlight = fli;
    }
    public Aline_Kie_Flight getSelectedFlight(){
        return selectedFlight;
    }
    public void setDate(Date date){
        flightDate = date;
    }
    public Date getDate(){
        return flightDate;
    }
    public void setTotalFare(double fare) {
        totalFare = fare;
    }
    public double getTotalFare(){
        return totalFare;
    }
    
    public String CalculateTotalFare(){
        totalFare = selectedFlight.getFare() * 1.13;
        DecimalFormat twoDecimalPlaces = new DecimalFormat("#000.00");
        return twoDecimalPlaces.format(totalFare);
    }
    
    //Override toString() method
    @Override
    public String toString(){
        return String.format("----------------------------\n" +
                "Flight Number: \t" + selectedFlight.getFlightNumber() + 
                "\nSource: \t" + selectedFlight.getSource() + " (" + selectedFlight.getAirportSource() + ")\n" + 
                "Destination: \t" + selectedFlight.getDestination() + " (" + selectedFlight.getAirportDestination() + ")\n" +
                "Time: \t\t" + selectedFlight.getFlightTime() +
                "\nFare: \t\t" + Currency.getInstance(Locale.CANADA) + CalculateTotalFare() +
                "\nDate: \t\t" + new SimpleDateFormat("dd-MM-yyyy").format(flightDate) + 
                "\n----------------------------"); 
    }
    
    
}
