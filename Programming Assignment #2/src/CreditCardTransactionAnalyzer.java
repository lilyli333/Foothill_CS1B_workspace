// -----------------------------------------------------------------------------

// @version1.0 07-12-2019

// @author  Jiayu Li

//  File name:  CreditCardTransactionAnalyzer.java

//  Program purpose: this file runs the transaction analyzer 

//  Disclaimer: this is the only public class containing a main method

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------

public class CreditCardTransactionAnalyzer {

   public static void main(String[] args) {
      
      Customer customer = new Customer("Lily", "5102089600731080", 1000000, 0);
      customer.readTransactions("/Users/lily/Desktop/Workspace/"
            + "Programming Assignment #2/Transactions.txt");
      
      customer.reportTransactions();
      System.out.println();
      customer.reportCharges();
      System.out.println();
      customer.reportRewardSummary();
   }

}
