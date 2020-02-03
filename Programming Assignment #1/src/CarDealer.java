// -------------------------------------------------------------------------------------------------------------
// @version 1.0 07-04-2019
// @author  Lily (Jiayu) Li
//  File name:  CarDealer.java
//  Program purpose: This file is to house the CarDealer class, which virtually
//					stores an array of vehicles and accompanying methods 
//					that display the program on the console and outputs
//					according to user input.
//  Revision history:
//   Date                  Programmer          Description
//   07/4/19               Lily (Jiayu) Li     Initial implementation
// -------------------------------------------------------------------------------------------------------------

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CarDealer{

	private Vehicle[] vehicles = null;
	private String location;
	private int numVehicles;
	private ArrayList<Vehicle> reservedVehicles = new ArrayList<Vehicle>();

	private static String DEALERSHIP_BRAND = "Foothill Car Dealership";
	private static int MAX_CAPACITY = 1024;

	public CarDealer() {
		this.vehicles = new Vehicle[MAX_CAPACITY];
		this.numVehicles = 0;
		this.location = "Lost City";
	}
	
	/*
	 * A non-default constructor is provided that utilizes the default 
	 * constructor but specifically sets the location.
	 */
	public CarDealer(String location) {
		this();
		this.location = location;
	}

	public static String getDealershipBrand() {
		return DEALERSHIP_BRAND;
	}
	public static int getMaxCapacity() {
		return MAX_CAPACITY;
	}
	/*
	 * If the location parameter is invalid, the operation to reset the 
	 * location is not completed and false is returned.
	 */
	public boolean changeLocation(String location) {
		if(!location.isBlank() && !location.isEmpty()) {
			this.location = location;
			return true;
		}
		return false;
	}
	/*
	 * If the numVehicles parameter is invalid, the operation to reset the 
	 * number of vehicles is not completed and false is returned.
	 */
	public boolean changeNumVehicles(int numVehicles) {
		if(numVehicles >= 0) {
			this.numVehicles = numVehicles;
			return true;
		}
		return false;
	}

	public Vehicle[] getVehicles() {
		return vehicles;
	}

	public int getNumVehicles() {
		return numVehicles;
	}

	public String toString() {
		String inventory = "";

		for(int i = 0; i < numVehicles; i++) {
			inventory += vehicles[i] + "\n";
		}
		return inventory;
	}
	/*
	 * Uses the make and model to search for vehicles that match the given
	 * criteria. Vehicles that are reserved are omitted from the search, and 
	 * an array of vehicles is returned.
	 */
	private Vehicle[] searchMatch(String make, String model) {
		int matchNumber = 0;
		Vehicle[] matchVehicles = new Vehicle[numVehicles];

		for(int i = 0; i < numVehicles; i++) {
			if(vehicles[i].getMake().equalsIgnoreCase(make) && vehicles[i].getModel().equalsIgnoreCase(model)) {
				boolean isReserved = false;
				for(Vehicle vehicle : reservedVehicles) {
					if(vehicles[i].equals(vehicle)) {
						isReserved = true;
					}
				}
				if(!isReserved) {
					matchVehicles[matchNumber] = vehicles[i];
					matchNumber++;
				}
			}
		}
		Vehicle[] finalMatchVehicles = new Vehicle[matchNumber];
		for(int i = 0; i < matchNumber; i ++) {
			finalMatchVehicles[i] = matchVehicles[i];
		}
		return finalMatchVehicles;
	}

	private boolean isReserved(Vehicle searchVehicle) {
		boolean isReserved = false;
		for(Vehicle vehicle : reservedVehicles) {
			if(searchVehicle.equals(vehicle)) {
				isReserved = true;
			}
		}
		return isReserved;
	}
	/*
	 * Sorts an array of vehicles given the number of vehicles in the actual 
	 * array. The actualNumVehicles parameter is needed because the vehicles
	 * array is initiated with MAX_CAPACITY, of which many locations are 
	 * empty.
	 */
	public Vehicle[] sort(Vehicle[] sortVehicles, int actualNumVehicles) {
		Vehicle[] vehicles = new Vehicle[actualNumVehicles];
		for(int i = 0; i < actualNumVehicles; i ++) {
			vehicles[i] = sortVehicles[i];
		}
		Arrays.sort(vehicles);
		for(int i = 0; i < actualNumVehicles; i ++) {
			sortVehicles[i] = vehicles[i];
		}
		return vehicles;
	}

	public void reserveVehicle(Vehicle vehicle) {
		reservedVehicles.add(vehicle);
	}
	/*
	 * Since an ArrayList of type Vehicle is used to store reserved vehicles,
	 * it must be converted into an array in order to use the sort() method.
	 */
	public void showReservedVehicle() {
		Vehicle[] vehiclesArray = new Vehicle[reservedVehicles.size()];

		for(int i = 0; i < vehiclesArray.length; i++) {
			vehiclesArray[i] = reservedVehicles.get(i);
		}
		vehiclesArray = sort(vehiclesArray, vehiclesArray.length);

		System.out.println("| RESERVED VEHICLES |");
		if(vehiclesArray.length == 0) {
			System.out.println("**No results**");
		}
		for(Vehicle vehicle : vehiclesArray) {
			System.out.println(vehicle);
		}
	}

	/*
	 * A Scanner object is used to read user input from the console. Exceptions
	 * are caught in case an invalid input is given by the user. When this 
	 * occurs, the user is prompted to try again and the previous input 
	 * is disregarded.
	 */
	public void init(){
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to" + DEALERSHIP_BRAND + " at " + location +"... Loading vehicles from DB ... Please wait ...\n" + 
				"\n" );

		System.out.println("Enter Make; Model;Year;Price [Ford; Taurus;2014;14578.99] or [END;] to quit: ");
		String userInput = scanner.nextLine();

		while(!userInput.equalsIgnoreCase("END")){
			try {
				String make, model;
				int year;
				double price;
				String dataSplit[]= userInput.split(";");

				if(dataSplit.length != 4)
					throw new IllegalArgumentException();

				make = dataSplit[0];
				model = dataSplit[1];
				year = Integer.parseInt(dataSplit[2]);
				price = Double.parseDouble(dataSplit[3]);

				vehicles[numVehicles] = new Vehicle(make, model, year, price);
				numVehicles++;
			}
			catch (NumberFormatException e )  { 
				System.out.println("**Unable to parse data. Please try again**");
			}
			catch (StringIndexOutOfBoundsException e) {
				System.out.println("**Unable to parse data. Please try again**");
			}
			catch (IllegalArgumentException e) {
				System.out.println("**Unmatched Format. Please try again**");

			}			
			System.out.println("Enter Make; Model;Year;Price [Ford; Taurus;2014;14578.99] or [END;] to quit: ");
			userInput = scanner.nextLine();
		}
	}
	/*
	 * Prints the smart search menu in the console. Extra credit #2 and #3 are
	 * included as options #3 and #4.
	 */
	public void menu() {
		System.out.println("--------------------------------------------\n" + 
				"|               SMART SEARCH               |\n" + 
				"--------------------------------------------\n" +
				"1.View Vehicle Inventory\n" + 
				"2.Search by make and model\n" + 
				"3.Reserve a vehicle\n" + 
				"4.Show reserved vehicles\n" + 
				"5.Quit \n" + 
				"Enter your chioce: ");
	}
	/*
	 * Every vehicle that has been parsed and is not reserved is displayed in
	 * the console.
	 */
	public void viewInventory() {
		System.out.println("| VEHICLE INVENTORY |\n" + 
				"\n" +
				"MAKE & MODEL;YEAR;PRICE\n" + 
				"--------------------------------------------\n");
		Vehicle[] sortedVehicles = sort(this.vehicles, numVehicles);
		for(int i = 0; i < numVehicles; i++) {
			if(!isReserved(sortedVehicles[i]))
				System.out.println(sortedVehicles[i]);
		}
	}
	/*
	 * The user is prompted to enter the desired make and model and a list is
	 * displayed, from which the user can select the specific car. A
	 * NullPointerException is caught when the input is invalid.
	 */
	public void searchMakeModel() {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter vehicle make: ");
			String vehicleMake = scanner.next();

			System.out.println("Enter vehicle model: ");
			String vehicleModel = scanner.next();

			Vehicle[] matchVehicles = searchMatch(vehicleMake, vehicleModel);
			matchVehicles = sort(matchVehicles, matchVehicles.length);
			System.out.println("| RESULTS |");
			if(matchVehicles.length > 0) {
				for(Vehicle vehicle : matchVehicles){
					System.out.println(vehicle);
				}
			}
			else {
				System.out.println("**No results**");
			}
		}
		catch(NullPointerException e) {
			System.out.println("**Please try again**");
		}
	}
	/*
	 * The make and model of the desired vehicle is asked of the user. From 
	 * there, a list of available vehicles is displayed, from which the user
	 * can select one. When selecting the specific car, the user will be 
	 * prompted to enter in a number until a valid one is entered. This means 
	 * if there are only 2 available cars, and the user enters '3' or not an
	 * integer, they will be prompted to select again.
	 */
	public boolean reserveVehicle() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter vehicle make: ");
		String vehicleMake = scanner.next();

		System.out.println("Enter vehicle model: ");
		String vehicleModel = scanner.next();

		Vehicle[] matchVehicles = searchMatch(vehicleMake, vehicleModel);

		System.out.println("| RESULTS |");

		if(matchVehicles.length > 0) {
			for(int i = 0; i < matchVehicles.length; i ++){
				System.out.println((i+1) + ". " + matchVehicles[i]);
			}
		}
		else {
			System.out.println("**No results**");
			return false;
		}
		int vehicleNum = -1;

		do {
			System.out.println("Select the number of the vehicle you wish to reserve: ");
			vehicleNum = scanner.nextInt();
			if(vehicleNum <= matchVehicles.length) {
				reservedVehicles.add(matchVehicles[vehicleNum-1]);
			}
			else {
				System.out.println("**Invalid number, try again**");
				System.out.println("inputted number: " + vehicleNum);
			}
		}while(vehicleNum > matchVehicles.length && vehicleNum != -1);
		return true;
	}
	//taken from https://learn-java-by-example.com/java/check-java-string-integer/
	//to check if a string input is a valid integer
	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try
		{
			Integer.parseInt(s);
			isValidInteger = true;
		}
		catch (NumberFormatException ex)
		{

		}

		return isValidInteger;
	}
	/*
	 * uses a do-while loop and switch statements to help the user navigate 
	 * the smart search menu.
	 */
	public void run() {
		Scanner scanner = new Scanner(System.in);
		menu();
		String userInput = scanner.next();
		int intInput = -1;
		if(isInteger(userInput))
			intInput = Integer.parseInt(userInput);
		do {	
			switch(userInput) {
			case "1":
				viewInventory();
				break;
			case "2":
				searchMakeModel();
				break;
			case "3":
				reserveVehicle();
				break;
			case "4":
				showReservedVehicle();
				break;
			default:
				System.out.println("**Please input 1, 2, 3, 4, or 5**");
			}
			menu();
			userInput = scanner.next();
			if(isInteger(userInput))
				intInput = Integer.parseInt(userInput);
		} while(!(intInput == 5));

		System.out.println("Thanks for using " + DEALERSHIP_BRAND + " at location.");
		scanner.close();
	}
}
