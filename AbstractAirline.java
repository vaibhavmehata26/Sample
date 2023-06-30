package airlineManagementSystem;

abstract public class AbstractAirline implements AirlineOperations{
	@Override
	public void login(String username, String password)
	{
		if(username.equals("admin") && password.equals("admin"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Please enter correct username and password");
		}
	}
	@Override
	public void logout()
	{
		System.out.println("Thank You....  Please visit us again....");
	}
	/*public abstract void sortFlightList();
	abstract void getFirstFlight();
	abstract void getLastFlight();
	*/
}


