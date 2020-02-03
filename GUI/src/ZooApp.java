
/*
 * GUI application w/ text fields and buttons
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ZooApp
{
    public static void main (String [ ] args)
    {      
          EventQueue.invokeLater( new Runnable ( )
             {
                 public void run () {
                    new ZooFrame ().setVisible (true);
                 }
          } );
        
    }
}


class ZooFrame extends JFrame {

   // interactive UI components MUST BE defined as private instance fields
    private JTextField textField;
    private JButton tigerButton;
    private JButton elephantButton ;
    private JButton zebraButton ;
    
    
    public ZooFrame ( )  
    {
        setTitle ("My Zoo");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize ();
        int screenWidth = dim.width;
        int screenHeight = dim.height;

        setSize (screenWidth/5, screenHeight/9);
        setLocationRelativeTo (null);  
        
        // 1. create two panels - one for the text field and the other for the buttons
        JPanel textPanel = new JPanel ();
        JPanel buttonPanel = new JPanel ();  
              
        // 2. Now adding UI components onto each panel    
        // 2 a) text Panel - use default FlowLayout manager
        JLabel label = new JLabel ("Animal voice:");
        textField = new JTextField (15);
        
        textPanel.add(label );
        textPanel.add(textField);

        // 2 b) button Panel - use default FlowLayout manager
        
        tigerButton     = new JButton ("Tiger");
        elephantButton  = new JButton ("Elephant");
        zebraButton     = new JButton ("Zebra");
        
        buttonPanel.add (tigerButton);
        buttonPanel.add (elephantButton);
        buttonPanel.add (zebraButton);
        
        // 3. add paneles to the frame
        add (textPanel, BorderLayout.NORTH);
        add (buttonPanel, BorderLayout.CENTER);
        
        // 4. Now creating/registering listener for all three buttons
           
        ActionListener bListener = new ButtonListener ();
        
        tigerButton.addActionListener (bListener);
        elephantButton.addActionListener (bListener);
        zebraButton.addActionListener (bListener);
       
        // 5. add listener for the frame when closing the frame
        addWindowListener (new WindowAdapter ()
         {
            public void windowClosing (WindowEvent e) {
                 System.exit(0);
            }            
         }
        );
    }

    class ButtonListener implements ActionListener
    {   
        public void actionPerformed (ActionEvent e)    {
             
              JButton button = (JButton) e.getSource ();
              
              if (button == tigerButton)
                  textField.setText ("This is a TIGER !!!");
              else if (button == elephantButton)
                       textField.setText ("I am an ELEPHANT !!!");
              else if (button == zebraButton)
                          textField.setText ("Zebra World everyone !!!");
        }
    }
    
}