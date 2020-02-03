import java.util.*;

class Vehicle {

   private  int year ;

   private  String make;

   // constructors,  getters/setters ....

   public Vehicle() {
      year = 0;
      make = "selj";
   }
   public Vehicle(int yr, String make) {
      this.year = year;
      this.make = make;
   }

   public String getMake ( ) { return make; }
   public void sell()  {  
      //...
   }  
}

public class Final4 {
   public static void main (String[] args) {
    
    //1. 
      TreeMap<Integer, ArrayList<Vehicle>> inventory = new TreeMap<Integer, ArrayList<Vehicle>>();

      //2. 
      ArrayList<Vehicle> vehiclesIn2017 = new ArrayList<Vehicle>();
      vehiclesIn2017.add(new Vehicle());
      vehiclesIn2017.add(new Vehicle());

      inventory.put(2017, vehiclesIn2017);

      //3. 
      for ( Map.Entry < Integer, ArrayList<Vehicle>>  entry : inventory.entrySet ( ) ) {
         ListIterator vehicles = entry.getValue().listIterator();
         while (vehicles.hasNext())   {
            Vehicle vehicle = (Vehicle)vehicles.next();
            if(vehicle.getMake().equals("Ford")){
               vehicle.sell();
               entry.getValue().remove(vehicle);
               break;
            }
         }
      }
      
      
      
   }
}


