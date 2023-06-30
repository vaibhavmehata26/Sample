package airlineManagementSystem;

import java.util.Scanner;

public class AirlineDriver{
	private static final Scanner scan = new Scanner(System.in);
	private static final AbstractAirline airline = new Airline();
		
	static void showMenu()
	{
		System.out.println("Press 1 to login");
		System.out.println("Press 2 to add flight in system");
		System.out.println("Press 3 to display all flights");
		System.out.println("Press 4 to search flight by id");
		System.out.println("Press 5 to delete flight by flightcode");
		System.out.println("Press 6 to update flight details");	
		System.out.println("Press 7 to delete all flight records");
		System.out.println("Press 8 to sort all flights according to flightcode");
		System.out.println("Press 9 to get first flight");
		System.out.println("Press 10 to get last flight");
		System.out.println("Press 11 to logout");
		System.out.println("Press 12 to exit");
	}
	
	public static void main(String args[])
	{
		showMenu();
		
		int option;
		String username;
		String password;
		do
		{
			System.out.println("Enter your option");
			option = scan.nextInt();
			
			switch(option)
			{
			case 1:
			{
				System.out.println("Please login to Airline System");
				System.out.println("Enter your username");
				username = scan.next();
				System.out.println("Enter your password");
				password = scan.next();
				airline.login(username, password);
				break;
			}
			
			case 2:
			{
				System.out.println("Add flight in records");
				System.out.println("Enter Destination");
				String destination = scan.next();
				System.out.println("Enter Departure");
				String departure = scan.next();
				System.out.println("Enter Cost");
				int cost = scan.nextInt();
				System.out.println("Enter Company Name");
				String companyName = scan.next();
				System.out.println("Enter Flight Code");
				int flightCode = scan.nextInt();
				airline.toAddFlight(destination, departure, cost, companyName, flightCode);
				break;
			}
			
			case 3:
			{
				System.out.println("Display all flight records");
				airline.toDisplayAllFlights();
				break;
			}
			
			case 4:
			{
				System.out.println("Search flight by flightcode");
				System.out.println("Enter flight code to search flight");
				int flightcode = scan.nextInt();
				airline.toSearchFlight(flightcode);
				break;
			}
			
			case 5:
			{
				System.out.println("Delete flight by flightcode");
				System.out.println("Enter fliht code to delete");
				int flightCode = scan.nextInt();
				airline.toDeleteFlightById(flightCode);
				break;
			}
			
			case 6:
			{
				System.out.println("Update flight record");
				System.out.println("Enter flight code to update record");
				int flightCode = scan.nextInt();
				airline.toUpdateFlight(flightCode);
				break;
			}
			
			case 7:
			{
				System.out.println("Delete all flight records");
				airline.toDeleteFlights();
				break;
			}
			
			case 8:
			{
				System.out.println("Sorted flight record");
				airline.sortFlightList();
				break;
			}
			
			case 9:
			{
				System.out.println("First flight in records");
				airline.getFirstFlight();
				break;
			}
			
			case 10:
			{
				System.out.println("Last flight in records");
				airline.getLastFlight();
				break;
			}
			case 11:
			{
				System.out.println("Logout from system");
				airline.logout();
			}
			
			case 12:
			{
				System.exit(1);
			}
						
			default :
			{
				if(option != 13)
				{
					System.out.println("Enter proper option");
				}
				}
			}

		}while(option != 12);
	}
}
