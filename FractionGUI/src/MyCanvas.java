import javax.swing.*;
import java.awt.*;

// MyCanvas class -------------------------------------
class MyCanvas extends JPanel
{
   private RationalNumber rationalNum;
 
   public void set(RationalNumber num)
   {
      // impossible to get bad data so no filter needed
      rationalNum = num; 
   }
   
   public void paintComponent( Graphics g )
   {
      super.paintComponent(g);
      Dimension d;
      FontMetrics metrics;
      int mid, left, right, numWidth, pixelsFromMid, ht;
      String numStr, denStr;
      
      // set up metrics for drawing a large fraction
      g.setColor(Color.white);
      g.setFont( new Font("SansSerif", Font.BOLD, 25) );
      d = getSize();
      mid = d.height/2;
      left = (int)(d.width * .2);
      right = d.width-left;
      
      // draw the division line
      g.fillRect(left,mid-3, right-left, 6);
      
      // draw the numerator
      numStr = String.valueOf(rationalNum.getNum());
      metrics = g.getFontMetrics();
      numWidth = metrics.charWidth('4');
      pixelsFromMid = (int)( (numStr.length()/2.) * numWidth );
      g.drawString(numStr, d.width/2 - pixelsFromMid, mid - 12);
      
      // draw the denominator
      denStr = String.valueOf(rationalNum.getDen());
      pixelsFromMid = (int)( (denStr.length()/2.) * numWidth );
      ht = metrics.getHeight();
      g.drawString(denStr, d.width/2 - pixelsFromMid, mid + 1 + ht);
   }
} 
