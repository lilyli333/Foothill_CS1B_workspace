// -------------------------------------------------------------------------------------------------------------

// @version1.0 07-15-2018

// @author  TP@FH Computer Science Department

//  File name:  FoodOrderGUI.java

//  Program purpose: This program is to assist a FastFood store to take orders and calculating cost for customers.

//  Revision history:

//   Date                Programmer               Change ID       Description

//   04/30/18            John Doe                 1888           Initial implementation

// -------------------------------------------------------------------------------------------------------------

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FoodOrderGUI
{    
    public static void main (String [] args)
    {          
          EventQueue.invokeLater( new Runnable ()
             {
                 public void run () {
                     new FoodOrder ().setVisible(true);
                 }
          } );
        
    }
}

class FoodOrder extends JFrame {
    
    private String customerName;
    private String food;
    private String  deliveryChoice;
    private boolean VIP;
    private boolean promotion;
    private boolean coupon;
    
    // UI components
    private JTextField text;            // customer name
    private JComboBox<String> combo;    // food drop-down list
    private JRadioButton pickupRadio ;  // eating options
    private JRadioButton eatinRadio ;
    private JRadioButton deliveryRadio ;
    
    private JCheckBox couponCheckbox ;
    private JCheckBox promoCheckbox ;
    private JCheckBox vipCheckbox ;
    
    private JTextArea  textArea ;
    
    private JButton orderButton;
    
    // pricing calculation parameters
    private static double taxRate = .0925;
    private static double VIPDiscount = 1.00;
    private static double couponDiscount = 1.00; 
    private static double promoDiscount = 10; // 10%
    
    public FoodOrder ( )
    {
        // instance fields
        customerName ="";
        food = "";
        deliveryChoice ="";
        VIP = false;
        promotion = false;
        coupon = false ;
        
        // frame setup
        setTitle ("Food Order Counter");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dim = kit.getScreenSize ();
        int screenWidth = dim.width;
        int screenHeight = dim.height;

        setSize (screenWidth/2 - 350, screenHeight/2 - 200);
        setLocationRelativeTo (null);  
        
        // 1. Create panels    - all of them will have the default FlowLayout
        JPanel topPanel     = new JPanel ();  // contain customer order info
        JPanel displayPanel = new JPanel ();  // show customer's order with cost
        JPanel orderPanel   = new JPanel ();  // confirm the order for calculation
        
        
        // 2. Create individual UI components for the panels and add them to the panels
        
        // 2a. Top Panel - most complicated one
        
        String [] options = {"Select a food choice", "Fries $ 4.45", "Hamburger $ 9.25", "Pizza $ 8.95", "Spicy_Chicken $ 7.99", "Turkey_Sandwich $ 8.25" };        
        
        JLabel label = new JLabel ("Customer Name");
        text  = new JTextField (10);
        combo = new JComboBox<String> (options);
        
        // radio buttons must be grouped together and belong to a panel with GridLayout
        pickupRadio = new JRadioButton ("Pickup", true);  // pickup is the default option to be selected
        eatinRadio = new JRadioButton ("Eat-in");
        deliveryRadio = new JRadioButton ("Delivery");
        
          // group the three radio buttons into one group
            ButtonGroup buttonGroup = new ButtonGroup ();
                
            buttonGroup.add (pickupRadio) ;
            buttonGroup.add (eatinRadio) ;
            buttonGroup.add (deliveryRadio) ;
            
        // check boxes belong to a panel with GridLayout
        couponCheckbox = new JCheckBox ("Coupon");
        promoCheckbox = new JCheckBox ("Promotion");
        vipCheckbox = new JCheckBox ("VIP customer");
        
        // We need three child panels enclosed in the top panel
        // 1. Child panel 1 for the customer name and food choices (FlowLayout)
        // 2. Child panel 2 for radio buttons (GridLayout)
        // 3. Child panel 3 for check boxesT  (GridLayout)
        
        // Panel for customer name and food
        JPanel custFoodInfoPanel = new JPanel ( );
        custFoodInfoPanel.add(label);
        custFoodInfoPanel.add (text);
        custFoodInfoPanel.add (combo);
        // Panel for Radio buttons
        JPanel radioPanel = new JPanel ();
        radioPanel.setLayout(new GridLayout (3,1));   // 3 rows, 1 column
                            
        radioPanel.add (pickupRadio);
        radioPanel.add (eatinRadio);
        radioPanel.add (deliveryRadio);

        // Panel for check boxes
        JPanel checkboxPanel = new JPanel ();
        checkboxPanel.setLayout(new GridLayout (3,1));
        
        checkboxPanel.add (couponCheckbox); 
        checkboxPanel.add (promoCheckbox);
        checkboxPanel.add (vipCheckbox);
        
        // >>>>>> Now add the components to the "parent" panel  <<<<<<<<<<<<<
        topPanel.add(custFoodInfoPanel); // top panel contains child 1 panel
        topPanel.add(radioPanel);        // top panel contains child 2 panel
        topPanel.add (checkboxPanel);    // top panel contains child 3 panel
        // 2b. Display Panel - only contain the textArea
        
        textArea = new JTextArea ();
        textArea.setBorder (BorderFactory.createEtchedBorder());  // setting borders for the text area
        textArea.setColumns (30);
        textArea.setRows    (10);
            
        // >>>>>> Now add the components to the panel  <<<<<<<<<<<<<
        displayPanel.add (textArea);
        // 2c. Order Panel - only contain the Order Button
        
        orderButton = new JButton ("Order");    
        // >>>>>> Now add the components to the "parent" panel  <<<<<<<<<<<<<
        orderPanel.add (orderButton);
        
        // 3. Add Panels to the Frame
        add (topPanel,         BorderLayout.NORTH);
        add (displayPanel,     BorderLayout.CENTER);
        add (orderPanel,     BorderLayout.SOUTH);
        
        // 4. Provide Event Handlers for UI components
        
        // Food Selection
        combo.addActionListener ( new ActionListener ()
        {
            public void actionPerformed (ActionEvent e)
            {
                food = (String) ((JComboBox<String>) e.getSource ()).getSelectedItem ();
            }
        } );
            
        // Eating Options Selection
        pickupRadio.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                     deliveryChoice = "Pickup";
             }
        } );
        
        eatinRadio.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                 deliveryChoice = "Eat-in";
             }
        } );
        
        deliveryRadio.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                 deliveryChoice = "Delivery";
             }
        } );
        
        // Discounts    
        couponCheckbox.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                 JCheckBox cb =  (JCheckBox) e.getSource () ;
                 coupon = cb.isSelected() ;
             }
        }
        );
        
        promoCheckbox.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                 JCheckBox cb =  (JCheckBox) e.getSource () ;
                 promotion = cb.isSelected();                              
             }
        } );
        
        vipCheckbox.addActionListener( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e) {
                 JCheckBox cb =  (JCheckBox) e.getSource () ;
                 VIP = cb.isSelected();
             }
        } );
            
        // Order Confirm button
        
        orderButton.addActionListener ( new ActionListener ()
        {
             public void actionPerformed (ActionEvent e)
             {
               // No error checking has been considered for this method
               String [] foodString = food.split(" ");
               double price = Double.parseDouble (foodString[2]);  // potentially throw an exception if no food is chosen
                                                                   // place a try/catch block here to capture exception
                                                                  // then set "Please select a food!" to the TextArea
               double cost = price;
                     
               // add tax 
               cost += price * FoodOrder.taxRate; 
                     
               if (VIP)
                  cost -= FoodOrder.VIPDiscount;
               if (coupon)
                   cost -= FoodOrder.couponDiscount;
               if (promotion)
                    cost -= price * FoodOrder.promoDiscount/100;
                     
               String orderInfo ="";
                     
               customerName = text.getText ();                 
               orderInfo = "Customer:\t" + customerName;
               orderInfo += "\nOrder:\t" + food ;
               orderInfo += "\nDelivery option:\t" + deliveryChoice ;
               orderInfo += String.format("\nTotal cost (tax incl.): $ %.2f" , cost) ;
                     
               textArea.setText (orderInfo);         
              }
          } );
        
                    
        addWindowListener (new WindowAdapter ()
         {
            public void windowClosing (WindowEvent e) {
                 System.exit(0);
            }            
         }
        );
        
        
    } // end of constructor
} // end of class