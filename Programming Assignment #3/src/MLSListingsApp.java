// -----------------------------------------------------------------------------

// @version1.1 07-20-2019

// @author  Jiayu Li

//  File name:  MLSListingsApp.java

//  Program purpose: this file houses the main method for the program 

//  Disclaimer: this class is the start of the program

//  Revision history:
//     Date              Programmer        Change ID     Description
//     06/20/19          Jiayu Li          1111          initial implementation

// -----------------------------------------------------------------------------
import java.awt.EventQueue;

public class MLSListingsApp {
   public static void main(String[] args) {
      
      PropertyList propertyList = new PropertyList();
      propertyList.initialize();
      
      EventQueue.invokeLater(new Runnable() 
      {
         public void run() {
            MLSListingView mlsView = new MLSListingView();
            mlsView.setProperties(propertyList);
            mlsView.setVisible(true);
            
         }
      });

   }

}
