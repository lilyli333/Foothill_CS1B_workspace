// -----------------------------------------------------------------------------

// @version1.1 07-14-2019

// @author  Jiayu Li

//  File name:  DepartmentStoreTransaction.java

//  Program purpose: this file constitutes a transaction from department stores

//  Disclaimer: this class extends Transaction and implements Rewardable 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation
//     06/14/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

public class DepartmentStoreTransaction extends Transaction implements Rewardable{

   private String storeName;
   private int returnPolicy;

   public DepartmentStoreTransaction() {
      super();
      this.storeName = "null";
      this.returnPolicy = 0;
   }

   public DepartmentStoreTransaction(String storeName, int returnPolicy, String id, String date, double amount) {
      super(id, date, amount);
      this.storeName = storeName;
      this.returnPolicy = returnPolicy;
   }

   @Override
   public String list() { return getDate() 
         + " Department Store    " + " $" + getStringAmount() 
         + "     return in " + returnPolicy + " days"; }


   public String toString() { return super.toString() 
         + "; Store Name: " + storeName 
         + "; Return Policy: " + returnPolicy + " days"; }

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

   public int getReturnPolicy() { return returnPolicy; }
   
   /*
    * checks the validy of the new return policy (not a negative number)
    * before changing the field
    */
   public boolean setReturnPolicy(int returnPolicy) {
      if(returnPolicy >= 0) {
         this.returnPolicy = returnPolicy;
         return true;
      }
      return false;
   }

   public boolean equals(DepartmentStoreTransaction checkTrans) { 
      return super.equals(checkTrans) 
            && checkTrans.getStoreName().equals(storeName) 
            && checkTrans.getReturnPolicy() == returnPolicy; 
   }

   @Override
   public int earnPoints() {
      int amount = (int)getAmount();
      return amount * 3;
   }


}
