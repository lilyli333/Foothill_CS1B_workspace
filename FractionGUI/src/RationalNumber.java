// RationalNumber class ---------------------------
class RationalNumber
{
   private long num;
   private long den;

   // constructor method ----
   RationalNumber(long n, long d) throws ZeroDenominatorException {
      num = n; 
      setDen(d);
   }

   //  reduce method ----
   public void reduce()
   {
      long gcd = gcd();
      if (gcd != 0)
      {
         num /= gcd;
         den /= gcd;
      }
      if (den<0)
      {
         den = -den;
         num = -num;
      }
   }

   private long gcd() // returns the gcd of num and den
   {
      long temp, n, d;
      for ( n = num,  d = den; d != 0;  )
      {
         temp = n % d;
         n = d;
         d = temp;
      }
      return n;
   }

   public long  getNum() // returns the numerator
   {
      return num;
   }

   public long  getDen() // returns the denominator
   {
      return den;
   }

   public void  setNum(long n) // sets the numerator
   {
      num = n;
      reduce();
   }

   public void  setDen(long d) throws ZeroDenominatorException// sets the denominator
   {
      if (d == 0)
         throw new ZeroDenominatorException();
      den = d;
      reduce();
   } 
}