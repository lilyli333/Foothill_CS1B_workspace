import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.*;

public class SampleExercise
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
      setTitle ("Santa Clara County");

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension dim = kit.getScreenSize ();
      int screenWidth = dim.width;
      int screenHeight = dim.height;

      setSize (screenWidth/2, screenHeight/2);
      setLocationRelativeTo (null);  
      
//      setLayout(new FlowLayout());

      
      JPanel propertyPanel = new JPanel();
      add(propertyPanel, BorderLayout.NORTH);
      propertyPanel.setLayout(new BorderLayout());
      propertyPanel.setLayout(new FlowLayout());
      propertyPanel.setBorder(new TitledBorder("Property Information"));
      propertyPanel.add(new JLabel("address"));
      propertyPanel.add(new JTextField(15));
      propertyPanel.add(new JLabel("address"));
      propertyPanel.add(new JTextField(15));
      
      JPanel payPanel = new JPanel();
      add(payPanel, BorderLayout.CENTER);
      payPanel.setLayout(new FlowLayout());
      payPanel.setBorder(new TitledBorder("Payment Information"));
      payPanel.add(new JLabel("payment!!!!!!!!!!!!!!!!!!"));
      payPanel.add(new JTextField(15));
      
      JPanel infoPanel = new JPanel();
      add(infoPanel, BorderLayout.SOUTH);
      infoPanel.setLayout(new FlowLayout());
      infoPanel.setBorder(new TitledBorder("Payment Information"));
      infoPanel.add(new JLabel("pay"));
      infoPanel.add(new JTextField(15));

      infoPanel.add(new JTextField(15));
      


      
      

      addWindowListener (new WindowAdapter ( )
      {
         public void windowClosing (WindowEvent e) {
            System.exit(0);
         }            
      }
            );        
   }

  
     

} 

