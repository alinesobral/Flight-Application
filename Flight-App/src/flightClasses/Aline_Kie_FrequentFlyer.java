/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flightClasses;

/**
 *
 * @author Owner
 */
public class Aline_Kie_FrequentFlyer extends Aline_Kie_Passenger {
    //data field
    private String frequentFlyerNum;
    private int mile;
    
    //constructor
    public Aline_Kie_FrequentFlyer(){
        
    }
    /*public Aline_Kie_FrequentFlyer(String fName, String lName, int age, String ffNum, int mile){
        setFirstName(fName);
        setLastName(lName);
        setAge(age);
        frequentFlyerNum = ffNum;
        this.mile = mile;  
    }*/
    public Aline_Kie_FrequentFlyer(Aline_Kie_Ticket selectedFlight, String ffNum){
        super.setTicket(selectedFlight);
        frequentFlyerNum = ffNum;
    }
    
    //setter & getter
    public void setFrequentFlyerNum(String ffNum){
        frequentFlyerNum = ffNum;
    }
    public String getFrequentFlyerNum(){
        return frequentFlyerNum;
    }
    public void setMile(int mile){
        this.mile = mile;
    }
    public int getMile(){
        return mile;
    }
    
    @Override
    public String toString(){
        return String.format("============================\n\nPassenger Name: " +
                super.getFirstName() + " " + super.getLastName() +
                "\nAge: \t\t" + super.getAge() +
                "\nFrequent Flyer Number: " + frequentFlyerNum +
                "\nTotal Miles: " + super.getTicket().getSelectedFlight().getMiles() + "\n" +
                super.getTicket().toString() +
                "\n============================");
    }
}
