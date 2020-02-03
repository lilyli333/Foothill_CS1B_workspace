// -----------------------------------------------------------------------------

// @version1.1 07-14-2019

// @author  Jiayu Li

//  File name:  BankingTransaction.java

//  Program purpose: this file constitutes a banking transaction 

//  Disclaimer: this class extends Transaction 

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/12/19          Jiayu Li          1111          initial implementation
//     06/14/19          Jiayu Li          2222          debug & documentation

// -----------------------------------------------------------------------------

import java.text.NumberFormat;
import java.util.Locale;

public class BankingTransaction extends Transaction{

   private String type;
   private double charge;

   public BankingTransaction() {
      super();
      this.type = "null";
      this.charge = 0;
   }

   public BankingTransaction(String type, double charge, String id, String date, double amount) {
      super(id, date, amount);
      this.type = type;
      this.charge = charge;
   }

   @Override
   public String list() { return getDate() + " Banking             " 
         + " $" + getStringAmount() + "     " + type + " withdraw"; }

   public String toString() { return super.toString() + "; Type: " 
         + type + "; Charge: " + charge; }

   public boolean equals(BankingTransaction checkTrans) {
      return(super.equals(checkTrans) 
            && checkTrans.getType().equals(type) 
            && checkTrans.getCharge() == charge);
   }

   public double getCharge() { return charge;}

   public String getType() {return type; }

   /*
    * to format the monetary value of the transaction 
    * and the subsequent charge to 2 decimal places
    */
   public String getStringAmount() {
      NumberFormat numFormat = NumberFormat.getInstance(Locale.US);
      numFormat.setMaximumFractionDigits(2);
      numFormat.setMinimumFractionDigits(2);

      return numFormat.format(super.getAmount() + charge);
   }
   public double getAmount() { return super.getAmount() + charge; }

}
