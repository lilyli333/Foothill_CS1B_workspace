// -----------------------------------------------------------------------------

// @version1.0 07-12-2019

// @author  Jiayu Li

//  File name:  Rewardable.java

//  Program purpose: this file outlines the Transaction abstract class

//  Disclaimer: this is an abstract class that also implements Comparable

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Transaction implements Comparable<Transaction>{

   private String id;
   protected String date;
   protected double amount;

   public Transaction() {
      this.id = "0000";
      this.date = "00/00/00";
      this.amount = 0.0;
   }

   public Transaction(String id, String date, double amount) {
      this.id = id;
      this.date = date;
      this.amount = amount;
   }

   public abstract String list();

   public String toString() {
      return "Transaction Id: " + id + "; Transaction Date: " + date 
            + "; Transaction Amount: " + getStringAmount();
   }

   public boolean equals(Transaction checkTrans) {
      return (id.equals(checkTrans.id) && date.equals(checkTrans.date) 
            && amount == amount);
   }

   public String getId() {
      return id;
   }

   public String getDate() {
      return date;
   }
   
   /*
    * to format the monetary value of the transaction (2 decimal places)
    */
   public String getStringAmount() {
      NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
      numFormat.setMaximumFractionDigits(2);
      numFormat.setMinimumFractionDigits(2);

      return numFormat.format(amount);
   }
   
   public double getAmount() {
      return amount;
   }
   
   /*
    * checks the validity of the id before switching
    */
   public boolean setId(String id) {
      if(id.length() == 4){
         this.id = id;
         return true;
      }
      return false;
   }
   
   /*
    * checks the validity of the date and its format before switching
    * must be in the following format: mm/dd/yy
    */
   public boolean setDate(String date) {
      if(date.length() == 8 & date.indexOf("/") == 2 
            && date.lastIndexOf("/") == 5){
         this.date = date;
         return true;
      }
      return false;
   }

   /*
    * ensures that the new amount is not negative before switching
    */
   public boolean changeAmount(double amount) {
      if(amount > 0) {
         this.amount = amount;
         return true;
      }
      return false;
   }
   
   /* 
    * written to fulfill the extra credit requirement
    * the amount of the transaction is used to determine the order
    */
   public int compareTo(Transaction trans) {
      double amount = getAmount();
      double compareAmount = trans.getAmount();
      return (int) (amount - compareAmount);
   }
}
