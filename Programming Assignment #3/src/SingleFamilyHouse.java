// -----------------------------------------------------------------------------

// @version1.1 07-20-2019

// @author  Jiayu Li

//  File name:  SingleFamilyHouse.java

//  Program purpose: this file constitutes a single family house property 

//  Disclaimer: this class extends Property 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class SingleFamilyHouse extends Property {

   private int backyardSize;

   public SingleFamilyHouse() {
      super();
      backyardSize = 0;
   }

   public SingleFamilyHouse(String address, double offeredPrice, int yearBuilt, int backyardSize) {
      super(address, offeredPrice, yearBuilt);
      this.backyardSize = backyardSize;
   }
   
   public int getBackyardSize() { return backyardSize; }
   
   public boolean setBackyardSize(int backyardSize) {
      if(backyardSize > 0) {
         this.backyardSize = backyardSize;
         return true;
      }
      return false;
   }
   
   public String toString() {
      return super.toString() + String.format("%-5s(sqft)", backyardSize);
   }

}
