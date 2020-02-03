//Class StackNode  ----------------------------------
public class StackNode
{
   // data (protected allows only certain other classes to access "next" directly)
   protected StackNode next;
    
   // constructor
   public StackNode()
   {
      next = null;
   }
   
   // console display
   public void show()
   {
      System.out.print( "(generic node) ");
   }
}