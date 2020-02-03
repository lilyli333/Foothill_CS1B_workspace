import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class EmptyWindow {
   public static void main (String[] args) {
      /*
       * use EDT to start GUI (must be done bc Swing is not thread-safe)
       */
      EventQueue.invokeLater(new Runnable()
      {
         public void run() {
            JFrame frame = new EmptyFrame();
            frame.setVisible(true);
         }
      });
   }
}

class EmptyFrame extends JFrame{
   /*
    * frame size must be defined
    */
   public EmptyFrame() {
      setTitle("Empty Frame");

      //get computer dimension and set Frame size to 1/2 of it
      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension dim = kit.getScreenSize();
      int screenWidth = dim.width;
      int screenHeight = dim.height;

      setSize(screenWidth/2, screenHeight/2);

      //position frame to center of screen
      setLocationRelativeTo(null);

      //add GUI component

      //set frame behavior when user closes Frame
      addWindowListener(new WindowAdapter () {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
   }
}
