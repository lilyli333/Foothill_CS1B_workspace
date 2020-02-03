// -----------------------------------------------------------------------------

// @version1.1 07-14-2019

// @author  Jiayu Li

//  File name:  GroceryTransaction.java

//  Program purpose: this file constitutes a transaction from grocery stores

//  Disclaimer: this class extends Transaction and implements Rewardable 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation
//     06/14/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

public class GroceryTransaction extends Transaction implements Rewardable{

   private String storeName;

   public GroceryTransaction() {
      super();
      this.storeName = "null";
   }

   public GroceryTransaction(String storeName, String id, String date, double amount) {
      super(id, date, amount);
      this.storeName = storeName;
   }

   @Override
   public String list() {
      return getDate() + " Grocery             " 
            + " $" + getStringAmount();
   }

   public String toString() {
      return super.toString() + "; Store Name" + storeName;
   }

   public String getStoreName() { return storeName; }
   
   /*
    * checks the validity of the new store name before changing the field
    */
   public boolean setStoreName(String storeName) {
      if(!storeName.isBlank()) {
         this.storeName = storeName;
         return true;
      }
      return false;
   }

   public boolean equals(GroceryTransaction checkTrans) {
      return super.equals(checkTrans) 
            && checkTrans.getStoreName().equals(storeName);
   }

   @Override
   public int earnPoints() {
      int amount = (int)getAmount();
      return amount * 5;
   }
}
