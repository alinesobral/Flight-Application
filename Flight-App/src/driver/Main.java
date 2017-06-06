/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
import flightClasses.*;
import java.sql.Time;
/**
 *
 * @author Owner
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(" d88888b");
        System.out.println("888    888");
        System.out.println("888    888");
        System.out.println("888888888888888b");
        System.out.println("888    888    888");
        System.out.println("888    888    888");
        System.out.println("888    88888888P");
        System.out.println("---- Air Banana ---");
        
        Aline_Kie_FlightManager FM = new Aline_Kie_FlightManager();
        PopulateDatabase(FM);
        FM.getFlightInfo();
    }
    
    public static void PopulateDatabase(Aline_Kie_FlightManager FM){
        FM.AddFlight("Calgary", "YYC", "Montreal", "YUL", "144", 410, 409.93, new Time(10,21,00));
        FM.AddFlight("Calgary", "YYC", "Montreal", "YUL", "160", 490, 489.75, new Time(07,05,00));
        FM.AddFlight("Calgary", "YYC", "Ottawa", "YOW", "118", 375, 375.00, new Time(15,34,00));
        FM.AddFlight("Calgary", "YYC", "Ottawa", "YOW", "124", 399, 398.68, new Time(20,45,00));
        FM.AddFlight("Calgary", "YYC", "Toronto", "YYZ", "164", 359, 358.18, new Time(06,00,00));
        FM.AddFlight("Calgary", "YYC", "Toronto", "YYZ", "174", 404, 403.18, new Time(15,55,00));
        FM.AddFlight("Calgary", "YYC", "Vancouver", "YVR", "201", 153, 152.25, new Time(19,20,00));
        FM.AddFlight("Calgary", "YYC", "Vancouver", "YVR", "223", 168, 168.00, new Time(18,15,00));
        FM.AddFlight("Calgary", "YYC", "Vancouver", "YVR", "205", 209, 208.50, new Time(21,00,00));
        FM.AddFlight("Montreal", "YUL", "Calgary", "YYC", "155", 295, 294.25, new Time(22,30,00));
        FM.AddFlight("Montreal", "YUL", "Calgary", "YYC", "165", 320, 441.28, new Time(04,40,00));
        FM.AddFlight("Montreal", "YUL", "Ottawa", "YOW", "8968", 252, 251.44, new Time(17,32,00));
        FM.AddFlight("Montreal", "YUL", "Ottawa", "YOW", "8975", 308, 307.75, new Time(23,00,00));
        FM.AddFlight("Montreal", "YUL", "Toronto", "YYZ", "407", 101, 100.79, new Time(8,15,00));
        FM.AddFlight("Montreal", "YUL", "Toronto", "YYZ", "7565", 121, 120.34, new Time(14,34,00));
        FM.AddFlight("Montreal", "YUL", "Toronto", "YYZ", "7561", 166, 165.69, new Time(3,37,00));
        FM.AddFlight("Montreal", "YUL", "Vancouver", "YVR", "111", 358, 358.00, new Time(11,30,00));
        FM.AddFlight("Montreal", "YUL", "Vancouver", "YVR", "183", 509, 508.59, new Time(16,25,00));
        FM.AddFlight("Ottawa", "YOW", "Calgary", "YYC", "133", 281, 280.66, new Time(14,20,00));
        FM.AddFlight("Ottawa", "YOW", "Calgary", "YYC", "167", 281, 280.66, new Time(20,30,00));
        FM.AddFlight("Ottawa", "YOW", "Montreal", "YUL", "8980", 246, 245.77, new Time(02,05,00));
        FM.AddFlight("Ottawa", "YOW", "Montreal", "YUL", "8976", 246, 245.77, new Time(12,10,00));
        FM.AddFlight("Ottawa", "YOW", "Montreal", "YUL", "8988", 246, 245.77, new Time(21,04,00));
        FM.AddFlight("Ottawa", "YOW", "Toronto", "YYZ", "447", 104, 103.55, new Time(1,24,00));
        FM.AddFlight("Ottawa", "YOW", "Toronto", "YYZ", "459", 121, 120.40, new Time(22,55,00));
        FM.AddFlight("Ottawa", "YOW", "Toronto", "YYZ", "455", 151, 150.54, new Time(17,31,00));
        FM.AddFlight("Ottawa", "YOW", "Vancouver", "YVR", "163", 353, 352.99, new Time(9,38,00));
        FM.AddFlight("Ottawa", "YOW", "Vancouver", "YVR", "189", 386, 385.50, new Time(13,20,00));
        FM.AddFlight("Ottawa", "YOW", "Vancouver", "YVR", "321", 519, 518.11, new Time(11,38,00));
        FM.AddFlight("Toronto", "YYZ", "Calgary", "YYC", "119", 321, 270.40, new Time(9,44,00));
        FM.AddFlight("Toronto", "YYZ", "Calgary", "YYC", "173", 428, 427.04, new Time(22,40,00));
        FM.AddFlight("Toronto", "YYZ", "Montreal", "YUL", "7564", 100, 99.28, new Time(14,02,00));
        FM.AddFlight("Toronto", "YYZ", "Montreal", "YUL", "7566", 164, 163.13, new Time(13,06,00));
        FM.AddFlight("Toronto", "YYZ", "Ottawa", "YOW", "446", 106, 105.25, new Time(21,42,00));
        FM.AddFlight("Toronto", "YYZ", "Ottawa", "YOW", "7550", 123, 122.13, new Time(8,30,00));
        FM.AddFlight("Toronto", "YYZ", "Vancouver", "YVR", "137", 309, 308.93, new Time(9,28,00));
        FM.AddFlight("Toronto", "YYZ", "Vancouver", "YVR", "33", 348, 347.48, new Time(13,06,00));
        FM.AddFlight("Toronto", "YYZ", "Vancouver", "YVR", "161", 441, 440.27, new Time(22,18,00));
        FM.AddFlight("Vancouver", "YVR", "Calgary", "YYC", "230", 145, 144.30, new Time(11,46,00));
        FM.AddFlight("Vancouver", "YVR", "Calgary", "YYC", "222", 161, 160.03, new Time(22,55,00));
        FM.AddFlight("Vancouver", "YVR", "Calgary", "YYC", "8695", 201, 200.53, new Time(05,00,00));
        FM.AddFlight("Vancouver", "YVR", "Montreal", "YUL", "333", 464, 463.76, new Time(10,00,00));
        FM.AddFlight("Vancouver", "YVR", "Montreal", "YUL", "182", 494, 193.06, new Time(13,06,00));
        FM.AddFlight("Vancouver", "YVR", "Ottawa", "YOW", "188", 302, 301.85, new Time(16,20,00));
        FM.AddFlight("Vancouver", "YVR", "Ottawa", "YOW", "189", 453, 452.57, new Time(12,9,00));
        FM.AddFlight("Vancouver", "YVR", "Ottawa", "YOW", "166", 512, 511.06, new Time(19,10,00));
        FM.AddFlight("Vancouver", "YVR", "Toronto", "YYZ", "190", 405, 404.63, new Time(15,04,00));
        FM.AddFlight("Vancouver", "YVR", "Toronto", "YYZ", "102", 408, 407.53, new Time(02,13,00));
        FM.AddFlight("Vancouver", "YVR", "Toronto", "YYZ", "1176", 461, 460.40, new Time(22,16,00));
    }
}
