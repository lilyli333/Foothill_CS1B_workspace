import java.util.Scanner;

enum Days {monday, tuesday, wednesday, thursday, friday, saturday, sunday}
 
public class Tester {
	
	public static Patient newPatient() throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("name: ");
		String name = input.next();
		
		System.out.println("id: ");
		int id = input.nextInt();
		
		System.out.println("temperature: ");
		double temperature = input.nextDouble();
		
		return new Patient(name, id, temperature);
	}
	
	public static void displayPatients(Patient patientOne, Patient patientTwo) {
		double temp1 = patientOne.getTemperature();
		double temp2 = patientTwo.getTemperature();
		
		if(temp1 > temp2) {
			System.out.println(patientOne.getName() + ", " + patientTwo.getName());
		}
		else {
			System.out.println(patientTwo.getName() + ", " + patientOne.getName());

		}
	}

	public static void main(String[] args) throws Exception {
		

		   // later, in some method ...
		   System.out.println ( Days.values()[2] );
		Patient patient1 = newPatient();
		Patient patient2 = newPatient();
		
		displayPatients(patient1, patient2);
	}

}
