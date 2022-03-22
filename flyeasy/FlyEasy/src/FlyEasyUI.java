import java.util.*;

public class FlyEasyUI {

    private static final String WELCOME_MESSAGE = "Welcome to FlyEasy";
	private String[] mainMenuOptions = {"Create Account", "Login", "Find Flight","Purchase Flight","Logout"};
	private Scanner scanner;
    private static FlightSearch searchingFlights = new FlightSearch();
	private FlyEasyApplication flyEasy;
   // private FlightSearch date;
	
	FlyEasyUI(){
		scanner = new Scanner(System.in);
		flyEasy = new FlyEasyApplication();
	}
	
	public void run() {
		System.out.println(WELCOME_MESSAGE);
		
		//Loop as long as we want to keep interacting with the library
		while(true) {
			displayMainMenu();
			
			int userCommand = getUserCommand(mainMenuOptions.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}
			
			//if they picked the last option then log them out
			if(userCommand == mainMenuOptions.length -1) {
				flyEasy.logout();
				break;
			}
		
			switch(userCommand) {
				case(0):
					createAccount();
					break;
				case(1):
					login();
					break;
				case(2):
					findFlight();
					break;
				case(3):
					purchase();
					break;
				
			}
		}
		
		System.out.println("Good bye, and have a nice day");
		
	}
	
	private void displayMainMenu() {
		System.out.println("\n************ Main Menu *************");
		for(int i=0; i< mainMenuOptions.length; i++) {
			System.out.println((i+1) + ". " + mainMenuOptions[i]);
		}
		System.out.println("\n");
	}
	
	//get the users command number, if it's not valid, return -1
	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}
	
	private void createAccount() {
		String userName = getField("Username");
		String firstName = getField("First Name");
		String lastName = getField("Last Name");
        String email = getField("Email");
		long cardNum = Integer.parseInt(getField("Card Number"));
		
		
		if(flyEasy.createAccount(userName, firstName, lastName, email, cardNum)) {
			System.out.println("You have successfully created an account");
		} else {
			System.out.println("Sorry an account with that username already exists");
		}
	}
	
	private void login() {
		String userName = getField("Username");
		
		if(flyEasy.login(userName)) {
			RegisteredUser currentUser = flyEasy.getCurrentUser();
			System.out.println("Welcome " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
		} else {
			System.out.println("Sorry, invalid username ");
		}
	}
	
	private String getField(String prompt) {
		System.out.print(prompt + ": ");
		return scanner.nextLine();
	}
	
	public void findFlight() {
        System.out.print("Enter Desired Flight date Name: \n");
        //String date = scanner.nextLine();
        //FlightSearch(date)
		
		while(true) {
			String date = scanner.next().trim().toLowerCase();
            searchingFlights.haveFlight(date);
            searchingFlights.getFlight(date);
            System.out.println("Enter Desired Flight Destination: ");
            String destination = scanner.next().trim().toLowerCase();
            searchingFlights.haveDestination(destination);
            //searchingFlights.getDestination();
           System.out.println("\n-----Searching for Flights Now-----"); 
            //searchingFlights.getAirline(airline);
            searchingFlights.getDestination(destination);

			//if(date.contentEquals("")) return date;
           // FlightSearch.searching = date;
           
            //if(destination.contentEquals("")) return destination;
            System.out.println("Flight Search Results:\n");	 
            System.out.println(searchingFlights.toString());
            FlightSearch a = new FlightSearch();
            a.getFlight(date);
            a.getDestination(destination);
            //System.out.print(a.toString());
        }   
            
		
		//if(flight == null)return;
		
		//if(!flyEasy.findItem(flight)) {
			//System.out.println("Sorry we couldn't find any Flights with those dates or destination\n");
			//return;
		//}
		
			
	}
	
	private void purchase() {
		System.out.println("\n-----Checking out your Plane Ticket-----");
		String flight = getUserFlight();
		
		if(flight == null)return;
		
		if(!flyEasy.purchase(flight)) {
			System.out.println("Sorry there was a problem, restart program\n");
			return;
		}
		System.out.println("Your Plane Ticket was successfully Comfirmed\n");
	}
    private String getUserFlight() {
		//System.out.print("Enter Desired Flight date Name: \n");
        //String date = scanner.nextLine();
        //FlightSearch(date)
		
		while(true) {
			String date = scanner.next().trim().toLowerCase();
            //System.out.println("Enter Desired Flight Destination: ");
            String destination = scanner.next().trim().toLowerCase();
            
			if(!date.contentEquals("")) return date;
           
           if(!destination.contentEquals("")) return destination;
            

			
			System.out.println("You need to actually enter content");
			//System.out.print("Would you like to enter item again (y) or return to main menu (n): ");
			//String command = scanner.nextLine().trim().toLowerCase();
			//if(command == "n") return null;
		}
	}


    public static void main(String[] args){

        FlyEasyUI flyEasyInterface = new FlyEasyUI();
		flyEasyInterface.run();



    }
}
