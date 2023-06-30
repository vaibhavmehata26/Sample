package airlineManagementSystem;

public interface AirlineOperations {
	/* It is Interface and has Abstract methods
	 * 
	 */
	void toAddFlight(String destination, String departure, int cost, String companyName, int flightCode); 
	void toDisplayAllFlights(); 
	void toSearchFlight(int flyCode); 
	void toDeleteFlightById(int flyCode); 
	void toUpdateFlight(int flyCode); 
	void toDeleteFlights(); 
	void login(String username, String password);
	void sortFlightList();
	void getFirstFlight();
	void getLastFlight();
	void logout();
	
	default void securityMessage()
	{
		System.out.println("Please follow all the COVID guidelines provided by the authorities.");
	}
}
