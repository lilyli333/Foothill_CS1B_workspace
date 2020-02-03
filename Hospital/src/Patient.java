
public class Patient {
	private String name;
	private int id;
	private double temperature;
	private static double ALARM_TEMP = 103.5;

	public Patient(String name, int id, double temperature) throws Exception {
		if(name.length() <= 40 && name.length() >= 2)
			this.name = name;
		else
			throw new Exception("name not valid"); 
		if(id > 0 && id <= 9999)
			this.id = id;
		else
			throw new Exception("id not valid"); 
		if(temperature >= 88 && temperature <= 111)
			this.temperature = temperature;
		else
			throw new Exception("temperature not valid"); 
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public void display() {
		System.out.println("name: " + name + "\nid: " + id + "\ntemperature: " + temperature);
	}
}
