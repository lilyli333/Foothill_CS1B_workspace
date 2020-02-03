// -----------------------------------------------------------------------------

// @version1.1 07-14-2019

// @author  Jiayu Li

//  File name:  Customer.java

//  Program purpose: this file constitutes a customer object

//  Disclaimer: this class handles all of the analytical methods in the program

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation
//     06/14/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Customer {

   private String name, cardNum;
   private double totBalance;
   private int rewardBalance;
   private Transaction[] transactions = null;
   private Rewardable[] rewards = null;
   /*
    * numTrans and numRewards are used to internally count the number of 
    * objects present in the array
    * 
    *  this helps when adding new objects to the array because each object 
    *  will be one after the other, with all null objects at the end
    *  
    *  this also helps to solve any bugs that might arise if the file being
    *  parsed has less than 16 items
    */
   private int numTrans, numRewards;

   public Customer() {
      this.name = "null";
      this.cardNum = "0000000000000000";
      this.transactions = new Transaction[16];
      this.rewards = new Rewardable[16];
      this.totBalance = 0.0;
      this.rewardBalance = 1000;
      this.numTrans = 0;
      this.numRewards = 0;
   }

   public Customer(String name, String cardNum, double totBalance, int rewardBalance) {
      this();
      this.name = name;
      this.cardNum = cardNum;
      this.totBalance = totBalance;
      this.rewardBalance = rewardBalance;
   }

   public double getBalance() { return totBalance; }

   public String getName() { return name; }

   public String getCardNum() { return cardNum; }

   /*
    * checks the validity of the new balance before changing the field
    */
   public boolean setBalance(double totBalance) {
      if(totBalance > 0) {
         this.totBalance = totBalance;
         return true;
      }
      return false;
   }

   /*
    * helper method written to add a transaction to the array
    */
   private void addTransaction(Transaction trans) {
      transactions[numTrans] = trans;
      numTrans++;
   }

   /*
    * helper method written to add a rewardable transaction to the array
    */
   private void addRewardableTrans(Rewardable trans) {
      rewards[numRewards] = trans;
      numRewards++;
   }

   /*
    * ensures the validity of the string being passed in before altering
    * the field
    */
   public boolean setName(String name) {
      if(!name.isBlank()) {
         this.name = name;
         return true;
      }
      return false;
   }

   /*
    * reads from the file path being passed in
    * and the data is manually parsed by splitting the line
    * 
    * if the transaction type cannot be parsed, 
    * an IOException is thrown and caught
    */
   public void readTransactions (String inputFileLocation) {

      Path inputFilePath = Paths.get(inputFileLocation);           

      BufferedReader reader = null;

      String line = null;

      try {
         reader =  Files.newBufferedReader(inputFilePath, StandardCharsets.US_ASCII);

         while ( (line = reader.readLine ()) != null ) {
            Transaction newTrans;
            String[] transactionAspects = line.split("~");
            String type = transactionAspects[0];
            if(type.equalsIgnoreCase("DS")) {
               newTrans = 
                     new DepartmentStoreTransaction(
                           transactionAspects[4], 
                           Integer.parseInt(transactionAspects[5]), 
                           transactionAspects[2], 
                           transactionAspects[1],
                           Double.parseDouble(transactionAspects[3]));
            }
            else if(type.equalsIgnoreCase("BK")){
               newTrans = new BankingTransaction(
                     transactionAspects[4], 
                     Double.parseDouble(transactionAspects[5]),
                     transactionAspects[2],
                     transactionAspects[1], 
                     Double.parseDouble(transactionAspects[3]));
            }
            else if(type.equalsIgnoreCase("GR")){
               newTrans = new GroceryTransaction(transactionAspects[4], 
                     transactionAspects[2], 
                     transactionAspects[1], 
                     Double.parseDouble(transactionAspects[3]));
            }
            else {
               throw new IOException();
            } 

            addTransaction(newTrans);

            totBalance -= newTrans.getAmount();

            if(newTrans instanceof Rewardable)
               addRewardableTrans((Rewardable)newTrans);
         }
         reader.close ();

      } catch (IOException e )  {   
         System.out.println("Unable to parse transaction type");
         e.printStackTrace ();
      }
   }

   public void reportTransactions() {
      sortTransactions();
      System.out.println("---------------------- TRANSACTION LISTING REPORT ----------------------");
      System.out.println("Date     Transaction type     "
            + "Amount     Specific info about transaction"
            + "\n----------------------------------------------"
            + "--------------------------" );
      for(Transaction trans : transactions) {
         //checks to make sure that the object is not null 
         //(if there are less than 16 transactions in the file)
         if(trans instanceof Transaction)
            System.out.println(trans.list());
      }
   }

   public void reportCharges() {
      double totCharge = 0;
      for(Transaction trans : transactions) {
         if(trans instanceof BankingTransaction)
            totCharge += ((BankingTransaction) trans).getCharge();
      }
      System.out.println("TOTAL CHARGES: $" + totCharge);
   }

   public void reportRewardSummary() {
      System.out.println("-------------------- REWARDS SUMMARY FOR: " +  name + " " 
            + cardNum.substring(cardNum.length() - 4)
            + " --------------------"
            + "\n----------------------------------------------"
            + "--------------------------" );
      System.out.println("Previous points balance: " + rewardBalance);

      int deptRewards = 0;
      int groceryRewards = 0;
      for(Transaction trans : transactions) {
         if(trans instanceof Rewardable) {
            if(trans instanceof DepartmentStoreTransaction) {
               deptRewards += ((DepartmentStoreTransaction) trans).earnPoints();
            }
            else if(trans instanceof GroceryTransaction) {
               groceryRewards += ((GroceryTransaction) trans).earnPoints();

            }
         }
      }
      System.out.println("+ Points earned on Department store purchases: " 
            + deptRewards + "\n+ Points earned on Grocery store "
            + "purchases: " + groceryRewards 
            + "\n----------------------------------------------"
            + "--------------------------" 
            + "\n=  Total points available for redemption: " 
            + (deptRewards + groceryRewards + rewardBalance));
   }

   /*
    * written to fulfill the extra credit requirement
    * sorts the array of transactions by creating a new placeholder array
    * of the exact size
    * 
    * a placeholder array is used to avoid run-time errors that arise from
    * having null objects in the original array
    */
   private void sortTransactions() {
      Transaction[] transactions = new Transaction[numTrans];
      for(int i = 0; i < numTrans; i++) {
         transactions[i] = this.transactions[i];
      }
      Arrays.sort(transactions);
      for(int i = 0; i < this.transactions.length; i++) {
         this.transactions[i] = transactions[i];
      }
   }

}
