import java.awt.Color;

public class MidTerm1 {

   public static void main(String[] args) {
      int[][] arr = new int[][] {{90,  100,  90,   100},  
                                 {70,   80,   70, 80},
                                  {92,   93,    92,    93}};
     double[] avg = Course.computeAverage(arr);
     for(double a : avg) {
        System.out.println(a);
     }

   }

}

class  Course  {
   public static double[] computeAverage(int[][] studentScores) {
      double[] averages = new double[studentScores.length];
      for(int student = 0; student < studentScores.length; student++) {
         double average = 0;
         for(int score = 0;score < studentScores[student].length; score++) {
            average += studentScores[student][score];
         }
         average /= studentScores[student].length;
         averages[student] = average;
      }
      return averages;
   }
}