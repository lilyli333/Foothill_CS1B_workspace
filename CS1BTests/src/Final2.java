
public class Final2 {

   public static void main(String[] args) {
      try {  
         System.out.println("1");
         try {     
            System.out.println("2");
            try  {        
               System.out.println("3");
               throw new TooColdException();
            }  catch (TooColdException e1) { 
               throw  new FreezingException ();
            }
         }    catch (FreezingException e3)  { 
            System.out.println("6");
            throw new ExceedTemperatureException ();
         } 


      }  catch (ExceedTemperatureException e3) { 
         System.out.println("G");
//         throw new MalFunctionException ();
         System.out.println("throw new MalFunctionException");
      }  finally {
         System.out.println("H");
      }
      System.out.println("J");
   }

}

class TooColdException extends Throwable{}
class FreezingException extends Throwable{}
class TooHotException extends Throwable{}
class ExceedTemperatureException extends Throwable{}
class MalFunctionException extends Throwable{}

