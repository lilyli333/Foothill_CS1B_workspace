// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  Item.java

// Program purpose: this file constitutes an Item

// Disclaimer: this class is the superclass for the Message class

// Revision history:
//     Date              Programmer        Change ID     Description
//     08/01/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class Item {
   //number of seconds after 1/1/1970
   private int time;
   private String from, to;
   private double charge;
   
   public Item() {
      this.time = 0;
      this.from = "000-000-0000";
      this.to = "000-000-0000";
      this.charge = 0;
   }
   
   public Item(int time, String from, String to, double charge) {
      this.time = time;
      this.from = from;
      this.to = to;
      this.charge = charge;
   }
   
   public String getSender() { return from; }
   
   public double getCharge() { return charge; }
     
   public String toString() {
      return "Time: " + time + "; From: " + from + "; To: " + to;
   }
}
