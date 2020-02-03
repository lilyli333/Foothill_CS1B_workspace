import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MultiPanel
{
   public static void main (String [] args)
   {
      EventQueue.invokeLater( new Runnable ( )   // create a GUI thread that displays the Frame
            {
         public void run ( ) {
            JFrame frame = new Frame ( );
            frame.setVisible (true); // AppFrame now comes to life
         }
            } );
   }
}


class Frame extends JFrame {

   public Frame ()
   {
      // setting frame attributes ("look and feel")
      setTitle ("Foothill CS1B - Spring 2018");

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension dim = kit.getScreenSize ();
      int screenWidth = dim.width;
      int screenHeight = dim.height;

      setSize (screenWidth/2, screenHeight/2);
      setLocationRelativeTo (null);  

      // New code below -  adding panels to the frame         
      addPanel (BorderLayout.NORTH, Color.green);
      addPanel (BorderLayout.SOUTH, Color.red);
      addPanel (BorderLayout.CENTER, Color.yellow);
      addPanel (BorderLayout.WEST, Color.blue);
      addPanel (BorderLayout.EAST, Color.pink);

      // adding UI components (labels) on JPanels then add JPanels to JFrame
      // THIS IS HOW YOU SHOULD DO IN DEVELOPING JAVA GUI   
      addLabelOnPanel (BorderLayout.SOUTH, Color.yellow, "SOUTH LABEL") ;
      addLabelOnPanel (BorderLayout.NORTH, Color.cyan, "NORTH LABEL") ;
      addLabelOnPanel (BorderLayout.CENTER, Color.green,"CENTER LABEL") ;
      addLabelOnPanel (BorderLayout.EAST, Color.pink, "EAST LABEL") ;
      addLabelOnPanel (BorderLayout.WEST, Color.white,"WEST LABEL") ;

      addWindowListener (new WindowAdapter ( )
      {
         public void windowClosing (WindowEvent e) {
            System.exit(0);
         }            
      }
            );        
   }

   public void addLabelOnPanel (String region, Color color, String caption ) {
      JPanel panel = new JPanel ();
      JLabel label = new JLabel (caption);

      panel.setBackground (color);
      panel.add (label) ;
      add (panel, region);
   }

   public void addPanel (String region, Color color ) {
      JPanel panel = new JPanel ();

      panel.setBackground (color);
      add (panel, region);
   }

} // end of class PanelsFrame

