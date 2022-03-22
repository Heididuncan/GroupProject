//import java.util.ArrayList;
//import javafx.util.converter.DateStringConverter;

public class FlyEasyApplication {

    //public static final String date = null;
	private FlightSearch flightSearch;
    private UserList users;
    private RegisteredUser currentUser;

    public FlyEasyApplication(){
        flightSearch = FlightSearch.getInstance();
        users = UserList.getInstance();
    }
	/** 
	public ArrayList<FlightSearch> findFlights() {
        return FlightSearch.haveFlight();
        
    }
    public ArrayList<FlightSearch> findFlights(String keyword) {
        return flight.haveFlight(keyword);
        
    }
	*/
    //creates a new user account
	public boolean createAccount(String userName, String firstName, String lastName, String email, long cardNum)
	{
		return users.addUser(userName,  firstName,  lastName, email, cardNum);
	}
	
	public boolean login(String userName) {
		if(!users.haveUser(userName))return false;
		
		currentUser = users.getUser(userName);
		return true;
	}
	
	public RegisteredUser getCurrentUser() {
		return currentUser;
	}
	
	//Returns true if item is found, and false otherwise
	public boolean findItem(String date) {
		return flightSearch.getFlight(date) != null;
	}
	public boolean purchase(String flightName) {
		if(!findItem(flightName))return false;
		
		//checkout the item
		//need a user then have them checkout an item
		return true;
	}
	public void logout() {
		users.saveUsers();
	}
    
}
