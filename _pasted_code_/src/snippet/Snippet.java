package snippet;

public class Snippet {
   static <E extends Comparable<E>> 
      E findLargestOfThree(E x, E y, E z)
      {
         if (x.compareTo(y) > 0)
            return (x.compareTo(z) > 0) ? x : z;
         else
            return (y.compareTo(z) > 0) ? y : z; 
      }
}

