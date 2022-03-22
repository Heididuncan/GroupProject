import java.util.Calendar;

public class Flight {
    private String flightDates;
    private String destination;

    public Flight(){
        //this.flightDates = Calendar.ALL_STYLES;
        this.flightDates = "none";
        this.destination = "none";
    }
    public Flight(String aFlightDate, String aDestination) {
        this.setDestingation(aDestination);
        this.setFlightDate(aFlightDate);
        //this.flightDates = flightDates;
        //this.destination = destination;
    }

    public String getFlightDates(){
        // for loop - for flight date (take in from user)
        return this.flightDates;
    }
    public void setFlightDate(String aFlightDate){
        if(aFlightDate != null)
        this.flightDates = aFlightDate;
        else
        this.flightDates = "none";
    }
    public void setDestingation(String aDestination){
        if(aDestination != null)
        this.destination = aDestination;
        else
        this.destination = "none";
    }
    public String getDestination(){
        return this.destination;
    }

   public String toString(){
       return "Date: "+this.flightDates+" Destination: "+this.destination;
   }
}
