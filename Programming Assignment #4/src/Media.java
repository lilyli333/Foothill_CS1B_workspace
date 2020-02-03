// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  Media.java

// Program purpose: this file constitutes a Media message

// Revision history:
//     Date              Programmer        Change ID     Description
//     08/01/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class Media {
     private double size ;
     private String format;

     public Media () { 
        size = 0; 
        format = ""; 
     }
     public Media (double size, String format) { 
          this.size = size; 
          this.format = format;
     }
    public String toString () {
           return new String ("\tMEDIA: Size:" + size + " MB, Format: " + format);
      }
}