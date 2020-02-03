// -----------------------------------------------------------------------------

// @version1.1 07-20-2019

// @author  Jiayu Li

//  File name:  Condo.java

//  Program purpose: this file constitutes a condo property 

//  Disclaimer: this class extends Property 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class Condo extends Property{

   private double HOAfee;

   public Condo() {
      super();
      this.HOAfee = 100;
   }

   public Condo(String address, double offeredPrice, int yearBuilt, double HOAfee) {
      super(address, offeredPrice, yearBuilt);
      this.HOAfee = HOAfee;
   }

   public double getHOAFee() { return HOAfee; }

   public boolean setHOAFee(double HOAfee) {
      if(HOAfee > 0) {
         this.HOAfee = HOAfee;
         return true;
      }
      return false;
   }

   public String toString() {
      return super.toString() + String.format("HOA fee: $%1$,-6.2f", HOAfee);
   }

}