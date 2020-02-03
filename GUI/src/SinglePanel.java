import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SinglePanel
{
   public static void main (String [] args)
   {
      EventQueue.invokeLater( new Runnable ( )  
      {
         public void run ( ) {
            JFrame frame = new PanelFrame ( );
            frame.setVisible (true); // PanelFrame now comes to life
         }
      } );
   }
}

class PanelFrame extends JFrame {

   public PanelFrame ()
   {
      // setting frame attributes ("look and feel")
      setTitle ("Foothill CS1B - Spring 2018");

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension dim = kit.getScreenSize ();
      int screenWidth = dim.width;
      int screenHeight = dim.height;

      setSize (screenWidth/2, screenHeight/2);
      setLocationRelativeTo (null);  

      // ****** new code added for JPanel in bold-face *********

      JPanel panel = new JPanel ();

      add(panel);       // go to BorderLayout.CENTER by default

      // or you can do:   add (panel,  BorderLayout.CENTER ) ;
      panel.setBackground (Color.pink);   


      addWindowListener (new WindowAdapter ( )
      {
         public void windowClosing (WindowEvent e) {
            System.exit(0);
         }            
      }
            );       
   }

} // end of class PanelsFrame