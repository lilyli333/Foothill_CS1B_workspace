// -------------------------------------------------------------------------------------------------------------
// @version 1.0 07-04-2019
// @author  Lily (Jiayu) Li
//  File name:  CarDealerApp.java
//  Program purpose: This file is to initiate the entire program by creating a 
//		new dealership.
//  Revision history:
//   Date                  Programmer          Description
//   07/4/19               Lily (Jiayu) Li     Initial implementation
// -------------------------------------------------------------------------------------------------------------

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarDealerApp {
	public static void main(String[] args) {
		CarDealer dealer = new CarDealer("Atlantis");
		
		dealer.init();
		dealer.run();
	}

}
