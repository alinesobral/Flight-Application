/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightClasses;
import java.sql.Time;
import java.util.Currency;
import java.util.Locale;
/**
 *
 * @author Owner
 */
public class Aline_Kie_Flight {
    //attributes
    private String source;
    private String airportSource;
    private String destination;
    private String airportDestination;
    private String flightNumber;
    private Time flightTime;
    private double fare;
    private int mile;
    
    
    
    //constructor
    public Aline_Kie_Flight(){ 
        
    }
    
    public Aline_Kie_Flight(String src, String arprtSrc, String dest, String arprtDest, String fliNum, int mil, double price, Time fliTime){
        source = src;
        airportSource = arprtSrc;
        destination = dest;
        airportDestination = arprtDest;
        flightNumber = fliNum;
        mile = mil;
        fare = price; 
        flightTime = fliTime;
        
    }
    
    //setter & getter
    public void setFlightNumber(String fliNum){
        flightNumber = fliNum;
    }
    public String getFlightNumber(){
        return flightNumber;
    }
    public void setSource(String src){
        source = src;
    }
    public String getSource(){
        return source;
    }
    public void setAirportSource(String airportSrc){
        airportSource = airportSrc;
    }
    public String getAirportSource(){
        return airportSource;
    }
    public void setAirportDestination(String airportDest){
        airportDestination = airportDest;
    }
    public String getAirportDestination(){
        return airportDestination;
    }
    public void setDestination(String dest){
        destination = dest;
    }
    public String getDestination(){
        return destination;
    }
    public void setFare(double fare){
        this.fare = fare;
    }
    public double getFare(){
        return this.fare;
    }
    public void setFlightTime(Time fliTime){
        flightTime = fliTime;
    }
    public Time getFlightTime(){
        return flightTime;
    }
    public void setMiles(int mileage){
        mile = mileage;
    }
    public int getMiles(){
        return mile;
    }
    //Override toString() method
    @Override
    public String toString(){
        return String.format("-----------------------------------------\n" +
                source.toUpperCase() + " (" + airportSource + ")" + 
                " to " + destination.toUpperCase() + " (" + airportDestination + ") at " + flightTime +
                "\nFlight Number:\t" + flightNumber + 
                "\nMiles: \t\t" + mile +
                "\nFare: \t\t" + Currency.getInstance(Locale.CANADA) + fare +
                "\n-----------------------------------------"); 
    }
}
