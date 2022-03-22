
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FlightSearch {
    public static String searching;
    public String date;
    private String destination;
    private String airline;
    private static FlightSearch flights;
    private ArrayList<Flight> flightList;

    //private ArrayList<Airline> airlines;
    //public ArrayList<Flight> departureAirport;
    //public ArrayList<Flight> arrivalAirport;

    public String[] airlines = {"American Airlines", "Delta", "Southwest", "JetBlue", "Spirit"};
    List<String> airlineList = Arrays.asList(airlines);


    FlightSearch(){
        flightList = Database.getFLights();
    }

    public static FlightSearch getInstance(){
        if(flights == null){
            flights = new FlightSearch();
        }
        return flights;
    }
    public String getAirline(String airline){
        Random r = new Random();
        int randAirline = r.nextInt(airlineList.size());
        String randomAirline = airlineList.get(randAirline);
        return randomAirline;
    }
    // wassnt sure it should be public Flight or FlightSearch
    //public static FlightSearch addFlight(String date, String destination){
        //flightList.(date.length(), destination);

   // }
    /** 
    public static FlightSearch addFlight(String date, String destination){
        int index = 1;
        int indexTwo = 2;
        int indexThree = 3;
        flights.getAirline(airline);
        flights.date = FlyEasyApplication.date;
        flightList.add(index, getFlight(date));
        flightList.add(indexTwo, getDestination(destination));
        flightList.add(indexThree, getDestination(destination));
        flightList.ensureCapacity(4);
        return new FlightSearch();

    }
    */
    public boolean haveFlight(String date){
        return date != null;
    }
    public boolean haveDestination(String destination){
        return destination != null;
    }
    public Flight getDestination(String destination){
        if(haveDestination(destination)) 
        return new Flight(date, destination);
        //return new Flight(date, destination);
        return getDestination(destination);
    }
    public Flight getFlight(String date){
        if(haveFlight(date))
        return new Flight(date, destination);
        //return null;
        return getFlight(date);
    }
    // my other idea for add flight
    //public Flight addFlight(){
        
        // while loop here - while new Flight(date, destination) outputs for search
        // is less then 4 results keep adding a flight including a random airline
        // for each result.  
        // might just make it to run 4 times so it prints a "list" of search results
        // then each instance can get saved to the Flight arraylist (maybe)
        //return null;
   // }
    public String toString(){
        return "Date: "+this.date+" Destination: "+this.destination+"Airlines: "+airline;
    }

    //After the search present option to purchase, if no then close the program or start over.

}
