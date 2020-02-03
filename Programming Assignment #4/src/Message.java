// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  Message.java

// Program purpose: this file constitutes a Message

// Disclaimer: this class is a subclass of Item, and is a generic class that 
// takes in either a Media, Text, or Voice object

// Revision history:
//     Date              Programmer        Change ID     Description
//     08/01/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------

public class Message<T> extends Item{
   private T data;
   
   public Message() {
      super();
      data = null;
   }
   public Message(T data, int time, String from, String to, double charge) {
      super(time, from, to, charge);
      this.data = data;
   }
   
   public T getMessage() {
      return data;
   }
   public void setMessage(T data) {
      this.data = data;
   }
      
   public String toString() {
      return data.toString() + ", " + super.toString();
   }
}
