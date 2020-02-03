// -----------------------------------------------------------------------------

// @version1.1 08-07-2019

// @author  Jiayu Li

// File name:  Text.java

// Program purpose: this file constitutes a Text message

// Revision history:
//     Date              Programmer        Change ID     Description
//     08/01/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
public class Text {
   private String content;

   public Text () { content = ""; }
   public Text (String text) { content = text; }

   public String toString () {
            return "\tTEXT: " + content;
    }
}