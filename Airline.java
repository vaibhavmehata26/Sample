package airlineManagementSystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class Airline extends AbstractAirline implements Comparable<Airline>{
	private String username;
	private String password;
	private int flightCode;
	private String destination;
	private String departure;
	private int cost;
	private String companyName;
	private List<Airline> airlineList = new ArrayList<Airline>();

	private static final Scanner scan = new Scanner(System.in);
	public Airline(String destination, String departure, int cost, String companyName)
	{
		this.destination = destination;
		this.departure = departure;
		this.cost = cost;
		this.companyName = companyName;
	}

	public Airline(String destination, String departure, int cost, String companyName, int flightCode)
	{
		this(destination, departure, cost, companyName);
		this.flightCode = flightCode; 
	}

	public Airline() {

	}

	public int getFlightCode()
	{
		return flightCode;
	}

	public void toAddFlight(String destination, String departure, int cost, String companyName, int flightCode)
	{
		//System.out.println("Destination Departure Cost CompanyName FlightCode");
		airlineList.add(new Airline(destination, departure, cost, companyName, flightCode));
	}

	public void toDisplayAllFlights()
	{
		Iterator<Airline> airList = airlineList.iterator();
		while(airList.hasNext())
		{
			System.out.println(airList.next());
		}		
	}

	public String toString()
	{
		return destination + " " + departure + " " + cost + " " + companyName + " " + flightCode;
	}

	public void toSearchFlight(int flyCode)
	{
		Iterator<Airline> airList = airlineList.iterator();
		boolean flag = false;
		while(airList.hasNext())
		{
			Airline airline = airList.next();
			if(airline.getFlightCode() == flyCode)
			{
				flag = true;
				System.out.println("Flight found");
				System.out.println(airline);
				break;
			}
		}
		if(flag == false)
		{
			System.out.println("Flight not found");
		}
	}

	public void toDeleteFlightById(int flyCode)
	{
		Iterator<Airline> airList = airlineList.iterator();
		boolean flag = false;
		int index = -1;
		while(airList.hasNext())
		{
			index++;
			Airline airline = airList.next();
			if(airline.getFlightCode() == flyCode)
			{
				flag = true;
				airlineList.remove(index);
				System.out.println("Flight record deleted");
				break;
			}
		}
		if(flag == false)
		{
			System.out.println("Flight not found");
		}
	}

	public void toUpdateFlight(int flyCode)
	{
		Iterator<Airline> airList = airlineList.iterator();
		boolean flag = false;
		int index = -1;
		while(airList.hasNext())
		{
			index++;
			Airline airline = airList.next();
			if(airline.getFlightCode() == flyCode)
			{
				flag = true;
				System.out.println("Enter new destination");
				String newDestination = scan.next();
				System.out.println("Enter new departure");
				String newDeparture = scan.next();
				System.out.println("Enter new cost");
				int newCost = scan.nextInt();
				System.out.println("Enter new company name");
				String newCompanyName = scan.next();
				int newFlyCode = flyCode;
				airlineList.set(index, new Airline(newDestination, newDeparture, newCost, newCompanyName, newFlyCode));
				System.out.println("Flight record updated");
				break;
			}
		}
		if(flag == false)
		{
			System.out.println("Flight not found");
		}
	}

	public void toDeleteFlights()
	{
		System.out.println("Do you really want to delete all flight records? Y/N");
		String userinput = scan.next();
		if(userinput.equalsIgnoreCase("Y"))
		{
			airlineList.clear();
		}
	}

	public void sortFlightList()
	{
		Collections.sort(airlineList);
		toDisplayAllFlights();
	}

	public void getFirstFlight()
	{
		if(airlineList.isEmpty())
		{
			System.out.println("Records are empty");
		}
		else
		{
			System.out.println(airlineList.get(0));
		}
	}

	public void getLastFlight()
	{
		if(airlineList.isEmpty())
		{
			System.out.println("Records are empty");
		}
		else
		{
			System.out.println(airlineList.get(airlineList.size()-1));
		}
	}

	@Override
	public int compareTo(Airline obj) {
		int flyCode = obj.getFlightCode();
		return this.flightCode - flyCode;
	}
}
