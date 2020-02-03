import java.text.NumberFormat;
import java.util.Locale;

public class DoubleNode extends StackNode
{
   // additional data for subclass
   private double data;
   
   // constructor
   public DoubleNode(double x)
   {
      super();  // constructor call to base class
      data = x;
   }
   
   // accessor
   public double getData()
   {
      return data;
   }

   // overriding show()
   public void show()
   {
      NumberFormat tidy = NumberFormat.getInstance(Locale.US);
      tidy.setMaximumFractionDigits(4);
      
      System.out.print("[" + tidy.format(data) + "] ");
   }
}
