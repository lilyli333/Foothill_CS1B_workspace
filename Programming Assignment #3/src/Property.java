// -----------------------------------------------------------------------------

// @version1.1 07-25-2019

// @author  Jiayu Li

//  File name:  Condo.java

//  Program purpose: this file constitutes a property object

//  Disclaimer: this class is the super class to Condo and SingleFamilyHouse

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation
//     06/25/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

public class Property {
   private String address;
   private double offeredPrice;
   private int yearBuilt;
   private Property next;

   public Property() {
      this.address = "nowhere";
      this.offeredPrice = 0;
      this.yearBuilt = 0;
      this.next = null;
   }

   public Property(String address, double offeredPrice, int yearBuilt) {
      this.address = address;
      this.offeredPrice = offeredPrice;
      this.yearBuilt = yearBuilt;
      this.next = null;
   }

   public String getAddress() { return address; }

   public double getOfferedPrice() { return offeredPrice; }

   public int getYearBuilt() { return yearBuilt; }

   public Property getNext() { return next; };

   public boolean setAddress(String newAddress) {
      if(!newAddress.isBlank() && newAddress.length() > 1) {
         this.address = newAddress;
         return true;
      }
      return false;
   }

   public boolean setOfferedPrice(double newPrice) {
      if(newPrice > 0) {
         this.offeredPrice = newPrice;
         return true;
      }
      return false;
   }

   public boolean setYearBuilt(int yearBuilt) {
      if(yearBuilt > 0) {
         this.yearBuilt = yearBuilt;
         return true;
      }
      return false;
   }

   public void setNext(Property next) { this.next = next; }

   public String toString() {
      return String.format("%-50s", address) + String.format("$%1$,-16.2f", 
            offeredPrice) + String.format("%1$-15d", yearBuilt);
   }
   
   /*
    * uses short circuit evaluation to determine whether the parameter is a 
    * Property object before checking for equality
    */
   public boolean equals(Object checkProperty) {
      if(checkProperty instanceof Property 
            && ((Property)checkProperty).getYearBuilt() == yearBuilt 
            && ((Property)checkProperty).getAddress().equalsIgnoreCase(address))
         return true;
      return false;
   }
}