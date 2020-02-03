/* 
 * -------------------------------------------------------------------------------------------------------------
 * @version 1.0 07-04-2019
 * @author  Lily (Jiayu) Li
 *  File name:  Vehicle.java
 *  Program purpose: This file is the blueprint for a vehicle, whose 
 *					attributes are listed. The Vehicle class implements 
 *					Comparable<T> in order to sort an array of Vehicles.
 *  Revision history:
 *   Date                  Programmer          Description
 *   07/4/19               Lily (Jiayu) Li     Initial implementation
 * -------------------------------------------------------------------------------------------------------------
 */
public class Vehicle implements Comparable<Vehicle>{

	private String make, model;
	private int year;
	private double price;

	public Vehicle() {
		this.make = "Subaru";
		this.model = "outback";
		this.year = 2019;
		this.price = 2999.99;
	}

	public Vehicle(String make, String model, int year, double price) {
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getMake() { return make; }

	public String getModel() { return model; }

	public int getYear() { return year; }

	public double getPrice() { return price; }

	public void changeMake(String make) { this.make = make; }

	public void changeModel(String model) { this.model = model; }

	public void changeYear(int year) { this.year = year; }

	public void changePrice(int price) { this.price = price; }

	public String toString() {
		return new String(make + " " + model + ";" + year + ";" + "$" + price);
	}
	/*
	 * The compareTo() method is overridden so that the year attribute is used
	 * to compare two Vehicles. This is to comply with extra credit #1, where 
	 * it asks to sort an array of Vehicles using the year.
	 */
	@Override
	public int compareTo(Vehicle compareVehicle) {
		String year = this.year + "";
		return year.compareTo(compareVehicle.getYear() + "");
		
	}

}
