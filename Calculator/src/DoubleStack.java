import java.text.NumberFormat;
import java.util.Locale;

public class DoubleStack extends Stack
{
   public static final float STACK_EMPTY = Float.MIN_VALUE;

   public void pushFloat(float x)
   {
      // don't allow pushing of STACK_EMPTY 
      if (x == STACK_EMPTY)
         return;    // could throw an exception when we learn how
      // create a new FloatNode
      DoubleNode fp = new DoubleNode(x);
   
      // push the StackNode onto the stack (base class call)
      super.push(fp);
   }

   public double popFloat()
   {
      // pop a node
      DoubleNode fp = (DoubleNode)pop();
      if (fp == null)
         return STACK_EMPTY;
      else
         return fp.getData();
    }
}