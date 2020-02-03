// #1
interface Sealable{
   public boolean transfer(String origOwner, String newOwner);
   public double price();
}

// #2

class House implements Sealable{
   private int year;
   private double soldPrice;
   private String ownerName;

   public House() {
      this.year = 0;
      this.soldPrice = 0;
      this.ownerName = "noName";
   }

   public House(int year, double soldPrice, String ownerName) {
      this.year = year;
      this.soldPrice = soldPrice;
      this.ownerName = ownerName;
   }

   public void upgradeKitchenCabinets(double cost) {
      soldPrice += cost;
   }

   @Override
   public boolean transfer(String origOwner, String newOwner) {
      if(ownerName.equalsIgnoreCase(origOwner)) {
         ownerName = newOwner;
         return true;
      }
      return false;
   }

   @Override
   public double price() {
      int yearDifference = Math.abs(year - 2019);
      return yearDifference * 1.04 + soldPrice;
   }
}

public class MidTerm3{
   public static void main (String [] args)  {
      Sealable sealedObj;

      sealedObj = new House(2014, 800000, "John Done");

      double price = sealedObj.price(); //output: 800005.2
      sealedObj.transfer("John Doe", "Jane Doe"); //output: false

      ((House)sealedObj).upgradeKitchenCabinets(10000);
      double newPrice = sealedObj.price(); //output: 810005.2

   }
}
