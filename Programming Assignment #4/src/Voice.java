// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  Voice.java

// Program purpose: this file constitutes a Voice message

// Revision history:
//     Date              Programmer        Change ID     Description
//     08/01/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class Voice{
      private double duration;
      private String format;

      public Voice () {
          duration = 0;
          format = "";
      }
      public Voice (double duration, String format) { 
          this.duration = duration; 
          this.format = format;
      }
      public String toString () {
           return new String ("\tVOICE: Duration:" + duration + " (sec), Format: " + format);
      }
}